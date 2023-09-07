package vn.techmaster.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {
    @Autowired
    public JavaMailSender javaMailSender;
    @PostMapping("/send-mail-simple")
    public ResponseEntity<?> sendMailSimple(){
        // Create a Simple MailMessage.
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo("abc@gmail.com");
        message.setSubject("Duy Anh Email");
        message.setText("Hello World");

        // Send Message!
        javaMailSender.send(message);

        return ResponseEntity.ok("Send mail success");
    }
}
