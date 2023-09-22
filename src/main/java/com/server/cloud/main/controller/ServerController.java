package com.server.cloud.main.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/main/servers")
public class ServerController {
	 
	@GetMapping
	    public List<ServerVO> getServers() {
	        List<ServerVO> servers = new ArrayList<>();
	        servers.add(new ServerVO(1, "cpu 사용량", Math.floor(Math.random() * 30) + 1, Math.floor(Math.random() * 41) + 50, Math.floor(Math.random() * 41) + 50));
	        
	        
	        
	        return servers;
	    }
}
