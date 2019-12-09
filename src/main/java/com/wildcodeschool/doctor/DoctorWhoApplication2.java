package com.wildcodeschool.doctor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@Controller
@SpringBootApplication
public class DoctorWhoApplication2 {

	public static void main(String[] args) {
		SpringApplication.run(DoctorWhoApplication2.class, args);
	}

	@RequestMapping("/doctor/{incarnationNumber}")
	@ResponseBody
	public String doctor(@PathVariable("incarnationNumber") int incarnationNumber) {
		if (incarnationNumber >= 1 && incarnationNumber <= 8) {
			throw new ResponseStatusException(HttpStatus.MOVED_PERMANENTLY);
		}
		
		if (incarnationNumber < 1 || incarnationNumber > 13) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Impossible to retrieve the incarnation " + incarnationNumber);
		}
		
		switch (incarnationNumber) {
		case 9:
			return "{\"number\": " + incarnationNumber + ", \"name\": \"Christopher Eccleston\"}";
		case 10:
			return "{\"number\": " + incarnationNumber + ", \"name\": \"David Tennant\"}";
		case 11:
			return "{\"number\": " + incarnationNumber + ", \"name\": \"Matt Smith\"}";
		case 12:
			return "{\"number\": " + incarnationNumber + ", \"name\": \"Peter Capaldi\"}";
		case 13:
			return "{\"number\": " + incarnationNumber + ", \"name\": \"Jodie Whittaker\"}";
		}
		return "William Hartnell";
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
