package com.server.cloud.main.controller;


import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.server.cloud.command.UserVO;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;

@RestController
public class LoginController {

    private static final String AES_SECRET_KEY_HEX = "A792C3A57A024CE3479B879360FFA50B";

    @PostMapping("/api/main/test")
    public ResponseEntity<String> test(@RequestBody UserVO request) {
        try {
            // 16진수 문자열을 바이트 배열로 변환
            byte[] keyBytes = hexStringToByteArray(AES_SECRET_KEY_HEX);
            // AES 암호화 알고리즘을 사용하여 복호화할 때 사용하는 객체 생성
            SecretKey secretKey = new SecretKeySpec(keyBytes, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

            // Base64로 인코딩된 암호문을 디코딩
            byte[] encryptedBytes = Base64.getDecoder().decode(request.getPassword());
            System.out.println(encryptedBytes);

            // 복호화 수행
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

            // 복호화된 바이트 배열을 문자열로 변환
            String decryptedPassword = new String(decryptedBytes, StandardCharsets.UTF_8);
            System.out.println(decryptedPassword);
            // 복호화된 비밀번호를 사용하거나 반환
            return ResponseEntity.ok("복호화된 비밀번호: " + decryptedPassword);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    private static byte[] hexStringToByteArray(String hexString) {
        int len = hexString.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hexString.charAt(i), 16) << 4)
                    + Character.digit(hexString.charAt(i + 1), 16));
        }
        return data;
    }
}
