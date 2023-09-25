package com.server.cloud.main.controller;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.server.cloud.alarm.service.AlarmService;
import com.server.cloud.command.CsVO;
import com.server.cloud.command.CusVO;
import com.server.cloud.command.EmailVO;
import com.server.cloud.command.EngineerVO;
import com.server.cloud.command.NoticeCommentVO;
import com.server.cloud.command.NoticeVO;
import com.server.cloud.command.SearchVO;
import com.server.cloud.command.ServerVO;
import com.server.cloud.command.UserVO;
import com.server.cloud.main.service.CusService;
import com.server.cloud.main.service.EmailService;
import com.server.cloud.pagenation.Criteria;
import com.server.cloud.s3.FileVO;
import com.server.cloud.security.JWTService;
import com.server.cloud.security.MyUserDetails;
import com.server.cloud.security.MyUserDetailsService;
import com.server.cloud.security.UserMapper;

import lombok.Builder;
import software.amazon.awssdk.services.transcribe.model.VocabularyFilterInfo;

@RestController
public class MainController {

   private MainConfig mainConfig;
   @Autowired
   public MainController(MainConfig mainConfig) {
      this.mainConfig = mainConfig;
   }
   private String emailNum; 
   @Autowired
   private CusService userService;

   private Criteria cri=new Criteria();
   @Autowired
   private BCryptPasswordEncoder bCryptPasswordEncoder;

   @Autowired
   private AuthenticationManager authenticationManager;

   @Autowired
   private MyUserDetailsService myUserDetailsService;

   @Autowired
   private EmailService emailService;

   @Autowired
   @Qualifier("alarmService")
   private AlarmService alarmService;

   @Autowired
   private UserMapper userMapper;

   @PostMapping("/api/main/sing-up")
   public ResponseEntity<? > singUp(@Valid @RequestBody CusVO vo,BindingResult bindingResult) {//회원가입
      String pw=bCryptPasswordEncoder.encode(vo.getCus_pw());
      vo.setCus_pw(pw);
      CusVO result = userService.idCheck(vo.getCus_id());

      if(result==null) {

         Map<String, String> errM=new HashMap<>();

         if(bindingResult.hasErrors()) {
            List<FieldError>list=bindingResult.getFieldErrors();
            for(FieldError err:list) {

               System.out.println(err.getField());
               errM.put(err.getField(), err.getDefaultMessage());
            }



            System.out.println(errM.toString());
            return new ResponseEntity<>(errM,HttpStatus.OK);
         }
         FileVO file=new FileVO().builder()
               .user_id(vo.getCus_id())
               .build();
         System.out.println(file.toString());
         userService.singIn(vo);

         userService.setPoto(file);


         return new ResponseEntity<>("로그인 성공",HttpStatus.OK);
      }
      return new ResponseEntity<>("잘못된 접근 입니다.",HttpStatus.OK);
   }

   @PostMapping("/api/main/passwordReset")
   public ResponseEntity<?>passwordReset(@RequestBody CusVO vo){



      if (!isValidUserPw(((String)vo.getCus_pw()))) {
         return new ResponseEntity<>("최소 8자, 특수문자 소문자 숫자 최소 1회 포함",HttpStatus.BAD_REQUEST);
      }
      String pw=bCryptPasswordEncoder.encode(vo.getCus_pw());
      vo.setCus_pw(pw);

      userService.resetPw(vo);


      return  new ResponseEntity<>("ok",HttpStatus.OK);
   }
   private boolean isValidUserPw(String userPw) {

      return userPw.matches("^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,15}$");
   }
   @PostMapping("/api/main/pw_check")
   public ResponseEntity<Map<String, String> > pw_check(@RequestBody Map<String,Object>ch) {//비밀번호 중복검사

      Map<String, String> errM=new HashMap<>();

      if(ch.get("cus_pw").equals(ch.get("cus_pw_check"))) {
         errM.put("pw_check","");
         return new ResponseEntity<>(errM,HttpStatus.OK);
      }
      errM.put("pw_check","비밀번호가 일치하지 않습니다");
      return new ResponseEntity<>(errM,HttpStatus.OK);
   }

   @PostMapping("/api/main/idCheck")
   public ResponseEntity<Map<String, String> > idCheck(@RequestBody Map<String,Object> userId) {//아이디 중복 검사
      System.out.println(userId);
      Map<String, String> response = new HashMap<>();

      if (((String)userId.get("cus_id")).isEmpty()) {
         response.put("error", "userId는 비어있을 수 없습니다.");
         return new ResponseEntity<>(response,HttpStatus.OK);
      }

      // 여기서 userId를 사용하여 추가적인 유효성 검사를 수행합니다.
      if (!isValidUserId(((String)userId.get("cus_id")))) {
         response.put("error", "아이디는 영문자와 숫자로 구성되어야 하고 4자 이상이어야 합니다.");
         return new ResponseEntity<>(response,HttpStatus.OK);
      }

      CusVO result = userService.idCheck(((String)userId.get("cus_id")));

      if(result==null) {
         response.put("message", "아이디 사용 가능");
         return new ResponseEntity<>(response,HttpStatus.OK);

      }else {
         response.put("error", "중복된 아이디 입니다");
         return new ResponseEntity<>(response,HttpStatus.OK);
      }
      // 성공적인 응답
   }
   @PostMapping("/api/main/EmailCheck")
   public ResponseEntity<?> EmailCheck(@RequestBody Map<String,Object> emailCheck) {//이메일 중복 검사



      if (((String)emailCheck.get("cus_email")).isEmpty()) {

         return new ResponseEntity<>("이메일을 입력해주세요",HttpStatus.BAD_REQUEST);
      }

      if (!isEmailValid(((String)emailCheck.get("cus_email")))) {
         return new ResponseEntity<>("이메일 형식으로 작성해주세요",HttpStatus.BAD_REQUEST);
      }

      CusVO result = userService.emailCheck(((String)emailCheck.get("cus_email")));

      if(result==null) {
         return new ResponseEntity<>("",HttpStatus.OK);

      }else {
         return new ResponseEntity<>("중복된 이메일 입니다",HttpStatus.BAD_REQUEST);
      }
      // 성공적인 응답
   }

   private boolean isValidUserId(String userId) {

      return userId.matches("^(?=.*[a-z])(?=.*[0-9])[a-zA-Z0-9]{4,}$");
   }

   private boolean isEmailValid(String eamil) {
      return eamil.matches("^[A-Za-z0-9+_.-]+@(.+)$");
   }

   @PostMapping("/api/main/businessCheck")
   public ResponseEntity<Map<String, String>> validateBusinessRegistrationNumber//사업자 번호 검사
   (@RequestBody Map<String,Object> registrationNumber) {
      System.out.println(registrationNumber);
      Map<String, String> response = new HashMap<>();
      String cleanedRegistrationNumber = ((String)registrationNumber.get("cus_business_id")).replaceAll("-", "");
      if (isValidBusinessRegistrationNumber(cleanedRegistrationNumber)) {
         response.put("message", "인증 완료");
         System.out.println(response.toString());
         return new ResponseEntity<>(response,HttpStatus.OK);
      }else {

         System.out.println(cleanedRegistrationNumber);
         response.put("error", "유요하지 않은 사업자 번호입니다");
         return new ResponseEntity<>(response,HttpStatus.OK);
      }




   }
   private final static int[] LOGIC_NUM = {1, 3, 7, 1, 3, 7, 1, 3, 5, 1};
   public boolean isValidBusinessRegistrationNumber(String number) {
      if (!isNumeric(number) || number.length() != 10)
         return false;

      int sum = 0;
      int j = -1;
      for (int i = 0; i < 9; i++) {
         j = Character.getNumericValue(number.charAt(i));
         sum += j * LOGIC_NUM[i];
      }

      sum += (int) (Character.getNumericValue(number.charAt(8)) * 5 /10);

      int checkNum = (10 - sum % 10) % 10 ;
      return (checkNum == Character.getNumericValue(number.charAt(9)));
   }

   public boolean isNumeric(String str) {
      if (str == null) {
         return false;
      }
      int sz = str.length();
      for (int i = 0; i < sz; i++) {
         if (Character.isDigit(str.charAt(i)) == false) {
            return false;
         }



      }
      return true;
   }

   @PostMapping("/api/main/emailCheck")
   public ResponseEntity<?>emailCheck(@RequestBody CusVO id){

      String getId=userService.getId(id);
      if(getId==null) {
         return new ResponseEntity<>("가입된 이메일이 없습니다",HttpStatus.BAD_REQUEST);
      }else {
         return new ResponseEntity<>("ok",HttpStatus.OK);
      }
   }
   @PostMapping("/api/main/emailPwCheck")
   public ResponseEntity<?>emailPwCheck(@RequestBody CusVO id){

      String getId=userService.getIdPw(id);
      if(getId==null) {
         return new ResponseEntity<>("가입된 이메일이 없습니다",HttpStatus.BAD_REQUEST);
      }else {
         return new ResponseEntity<>("ok",HttpStatus.OK);
      }
   }
   @GetMapping("/api/main/getInfoEng")
   public ResponseEntity<?> getInfo2(@RequestParam("eng_id") String eng_id){

      EngineerVO vo= userService.idCheckEng(eng_id);

      System.out.println(1);

      return new ResponseEntity<>(vo,HttpStatus.OK);

   }
   @PostMapping("/api/main/emailSend")
   public ResponseEntity<?>emailSend(@RequestBody EmailVO request){
      String email=request.getEmail();
      System.out.println(email);
      emailNum = mainConfig.generateVerificationCode();
      System.out.println(emailNum);
      try {
         emailService.sendVerificationEmail(email, emailNum);
         return new ResponseEntity<>("인증번호가 발송되었습니다.",HttpStatus.OK);
      }catch (Exception e) {
         e.printStackTrace();
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send email");
      }
   }



   @PostMapping("/api/main/idGet")
   public ResponseEntity<?>idGet(@RequestBody EmailVO request){//아이디 찾기
      if(request.getEmailNum().equals(emailNum)) {

         CusVO id=new CusVO();
         id.setCus_email(request.getCus_email());
         id.setCus_managet_name(request.getCus_managet_name());

         String getId=userService.getId(id);
         return new ResponseEntity<>("귀하의 아이디는 "+getId+"입니다!",HttpStatus.OK);
      }else {
         return new ResponseEntity<>("인증번호가 일치하지 않습니다",HttpStatus.BAD_REQUEST);
      }
   }
   @PostMapping("/api/main/PwReset")
   public ResponseEntity<?>PwReset(@RequestBody EmailVO request){//비밀번호 재설정
      if(request.getEmailNum().equals(emailNum)) {
         return new ResponseEntity<>("ok",HttpStatus.OK);
      }else {
         return new ResponseEntity<>("인증번호가 일치하지 않습니다",HttpStatus.BAD_REQUEST);
      }
   }
   @RequestMapping(value = "/api/main/login", method = RequestMethod.POST)
   public ResponseEntity<?> createAuthenticationToken(@RequestBody UserVO authenticationRequest) throws Exception {//로그인

      System.out.println("1231231231");
      CusVO result = userService.idCheck(authenticationRequest.getUsername());
      if(result==null) {//아이디가 없을경우
         return new ResponseEntity<>("아이디 또는 비밀번호를 확인하세요", HttpStatus.BAD_REQUEST);
      }else {

         String role = userMapper.login(authenticationRequest.getUsername()).getRole();
         System.out.println(role);
         if(role.equals("ROLE_ENGINEER")) {
            int a = alarmService.todayAlarmCheck(authenticationRequest.getUsername());
            if(a>0) alarmService.todayAlarmEng(authenticationRequest.getUsername());
         }else if(role.equals("ROLE_USER")) {
            int b = alarmService.todayAlarmCheck2(authenticationRequest.getUsername());
            if(b>0)alarmService.todayAlarmCus(authenticationRequest.getUsername());
         }
         System.out.println("아이디 비밀번호"+result.toString());


         if(bCryptPasswordEncoder.matches(authenticationRequest.getPassword(),result.getCus_pw())){


            MyUserDetails userDetails= myUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());


            if (bCryptPasswordEncoder.matches(authenticationRequest.getPassword(), userDetails.getPassword())) {
               try {
                  String token = JWTService.createToken(userDetails);
                  //               Authentication authentication =authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                  //                     userDetails.getUsername(),
                  //                     userDetails.getPassword())
                  //                  );
                  //                  SecurityContextHolder.getContext().setAuthentication(authentication);
                  return new ResponseEntity<>(token,HttpStatus.OK);
               } catch (BadCredentialsException e) {
                  return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect username or password");
               }
            } else {
               return new ResponseEntity<>("아이디 또는 비밀번호를 확인해주세요",HttpStatus.OK);
            }
         }else {
            return new ResponseEntity<>("아이디 또는 비밀번호를 확인하세요", HttpStatus.BAD_REQUEST);
         }

      }
   }
   @GetMapping("/api/main/getInfo")
   public ResponseEntity<?> getInfo(@RequestParam("cus_id") String cus_id){//정보 불러오기(유저)

      CusVO vo= userService.idCheck(cus_id);

      System.out.println(1);

      return new ResponseEntity<>(vo,HttpStatus.OK);

   }

   @GetMapping("/api/main/SearchInfo")
   public ResponseEntity<?>SearchInfo(SearchVO vo){//검색 목록 불러오기
      System.out.println(vo.toString());

      List<Map<String,String>>list= userService.SearchInfo(vo);
      //         String count = userService.searchCount(vo);
      //         Map<String, String>map=new HashMap<>();
      //         map.put("count", count);
      //         list.add(map);
      return new ResponseEntity<>(list,HttpStatus.OK);
   }

   @GetMapping("/api/main/getComment")
   public ResponseEntity<?>getComment(@RequestParam("notice_num")String notice_num){//댓글 불러오기


      List<NoticeCommentVO>notice=userService.getComment(notice_num);
      return new ResponseEntity<>(notice,HttpStatus.OK);
   }
   @PostMapping("/api/main/CreateComments")
   public ResponseEntity<?>CreateComments(@RequestBody NoticeCommentVO vo){//댓글 생성하고 목록 가져오기
      userService.CreateComments(vo);
      List<NoticeCommentVO>notice=userService.getComment(vo.getNotice_num());//목록 다시 불러오기
      return new ResponseEntity<>(notice,HttpStatus.OK);
   }
   @GetMapping("/api/main/commentDel")
   public ResponseEntity<?>commentDel(NoticeCommentVO vo){
      System.out.println(vo.toString());
      userService.commentDel(vo);
      List<NoticeCommentVO>notice=userService.getComment(vo.getNotice_num());//목록 다시 불러오기
      return new ResponseEntity<>(notice,HttpStatus.OK);
   }
   @GetMapping("/api/main/commentUp")
   public ResponseEntity<?>commentUp(NoticeCommentVO vo){
      System.out.println(vo.toString());
      userService.commentUp(vo);
      List<NoticeCommentVO>notice=userService.getComment(vo.getNotice_num());//목록 다시 불러오기
      return new ResponseEntity<>(notice,HttpStatus.OK);
   }

   @GetMapping("/api/main/user/getServerList")//프로젝트 id로 서버 리스트 가져오기
   public ResponseEntity<?>getServerList(@RequestParam("pro_id")String pro_id){

      List<ServerVO> vo=userService.getServerList( pro_id);

      return new ResponseEntity<>(vo,HttpStatus.OK);
   }
   @PostMapping("/api/main/user/quryeWrite")//문의사항 쓰기
   public ResponseEntity<?>quryeWrite(@RequestBody CsVO csVo){

      userService.quryeWrite(csVo);

      return new ResponseEntity<>("성공",HttpStatus.OK);
   }


}

