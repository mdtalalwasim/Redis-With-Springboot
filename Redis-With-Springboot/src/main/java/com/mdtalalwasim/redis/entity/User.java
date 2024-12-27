package com.mdtalalwasim.redis.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class User implements Serializable{

	private String userId;
	private String name;
	private String email;
	private String phone;
	
}
