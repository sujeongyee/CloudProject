package com.server.cloud.main.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ServerVO {
	
	private int id;
	private String name;
	private double cpuUsage;
    private double memoryUsage;
    private double ramUsage;
    
	public ServerVO(int id, String name, double cpuUsage) {
		super();
		this.id = id;
		this.name = name;
		this.cpuUsage = cpuUsage;
	}
    
    
}
