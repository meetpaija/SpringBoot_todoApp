package com.meetpaija.toDo;

import java.io.Console;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ToDoApplication {

	public static void main(String[] args) {
		 java.util.Date dt = new java.util.Date();
			
		 java.text.SimpleDateFormat sdf =
		 new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		 String currentTime = sdf.format(dt);
		 System.out.println(currentTime);
		SpringApplication.run(ToDoApplication.class, args);
	}
}
