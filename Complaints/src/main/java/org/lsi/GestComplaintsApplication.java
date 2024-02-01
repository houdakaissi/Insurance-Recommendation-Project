package org.lsi;

import javax.mail.MessagingException;

import org.lsi.services.EmailSenderServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

@ComponentScan(basePackages = "org.lsi.repositories")
@ComponentScan(basePackages = "org.lsi.services")
public class GestComplaintsApplication {
	public static void main(String[] args) {
		SpringApplication.run(GestComplaintsApplication.class, args);
	}
}
