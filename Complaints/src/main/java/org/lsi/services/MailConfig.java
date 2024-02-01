package org.lsi.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("your-smtp-host"); // Set your SMTP host
        mailSender.setPort(587); // Set your SMTP port
        mailSender.setUsername("your-email@example.com"); // Set your email address
        mailSender.setPassword("your-email-password"); // Set your email password

        return mailSender;
    }
}
