package com.wildcodeschool.doctor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@Controller
//@SpringBootApplication
public class DoctorWhoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctorWhoApplication.class, args);
	}

	@RequestMapping("/doctor/1")
	@ResponseBody
	public String doctor1() {
		return "William Hartnell";
	}

	@RequestMapping("/doctor/2")
	@ResponseBody
	public String doctor2() {
		return "Patrick Troughton";
	}

	@RequestMapping("/doctor/3")
	@ResponseBody
	public String doctor3() {
		return "Jon Pertwee";
	}

	@RequestMapping("/doctor/4")
	@ResponseBody
	public String doctor4() {
		return "Tom Baker";
	}

	@RequestMapping("/")
	@ResponseBody
	public String doctors() {
		return "<ul>"
				+ "<li><a href=\"/doctor/1\">/doctor/1</a>"
				+ "<li><a href=\"/doctor/2\">/doctor/2</a>"
				+ "<li><a href=\"/doctor/3\">/doctor/3</a>"
				+ "<li><a href=\"/doctor/4\">/doctor/4</a>"
				+ "</ul/>";
	}
}
