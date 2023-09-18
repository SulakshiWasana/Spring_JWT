package com.example.userservice;

import com.example.userservice.domain.Role;
import com.example.userservice.domain.Users;
import com.example.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(null,"ROLE_USER"));
			userService.saveRole(new Role(null,"ROLE_MANAGER"));
			userService.saveRole(new Role(null,"ROLE_ADMIN"));
			userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));

			userService.saveUser(new Users(null,"John Travolta","john","1234", new ArrayList<>()));
			userService.saveUser(new Users(null,"Will Smith","will","1234", new ArrayList<>()));
			userService.saveUser(new Users(null,"Jim Carry","jim","1234", new ArrayList<>()));
			userService.saveUser(new Users(null,"Arnold Schwarzenegger","arnold","1234", new ArrayList<>()));

			userService.addRoleToUSer("john","ROLE_USER");
			userService.addRoleToUSer("john","ROLE_MANAGER");
			userService.addRoleToUSer("will","ROLE_MANAGER");
			userService.addRoleToUSer("jim","ROLE_ADMIN");
			userService.addRoleToUSer("arnold","ROLE_SUPER_ADMIN");
			userService.addRoleToUSer("arnold","ROLE_ADMIN");
			userService.addRoleToUSer("arnold","ROLE_USER");
		};

	}

}
