package com.pb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class AppInfoController {

	@GetMapping("/isActive")
	public String isACtive() {
		return "ACTIVE";
	}

}
