package cg.example.Assignment8;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cg.example.Assignment8.Controller.EmployeeController;

@SpringBootApplication
public class Assignment71Application {


		
		@Autowired
		EmployeeController traineeController; 

		public static void main(String[] args) {
			System.out.println("Application Context is Loaded!!!");
			SpringApplication.run(Assignment71Application.class, args);
		}
	}


