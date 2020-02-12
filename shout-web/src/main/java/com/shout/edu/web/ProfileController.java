package com.shout.edu.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ProfileController {
	private final Environment env;
	
	@GetMapping("/profile")
	public String profile() {
		List<String> profiles = Arrays.asList(env.getActiveProfiles());
		
		for(String profile : profiles) {
			System.out.println(profile);
		}
		
		List<String> realProfiles = Arrays.asList("real", "real1", "real2");
		
		String defaultProfile = profiles.isEmpty() ? "default" : profiles.get(0);
		
		return profiles.stream().filter(x -> realProfiles.contains(x)).findAny().orElse(defaultProfile);
	}
}
