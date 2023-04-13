package com.ProyectoIntegrador.ProyectoIntegrador.emailService;//package com.ProyectoIntegrador.ProyectoIntegrador.emailService;
//
//import jakarta.mail.Authenticator;
//import jakarta.mail.Session;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
//import org.springframework.mail.javamail.MimeMailMessage;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//
//@RestController
//@CrossOrigin("*")
//public class EnviarMail {
//    @Autowired
//    private JavaMailSender javaMailSender;
//
//
//    @PostMapping("/enviarCorreo")
//    public ResponseEntity<?> enviarMail(@RequestBody EmailTemplate emailTemplate){
//
//
//        SimpleMailMessage email = new SimpleMailMessage();
//
//        email.setTo(emailTemplate.getDestinatario());
//        email.setFrom(emailTemplate.getRemitente());
//        email.setSubject(emailTemplate.getAsunto());
//        email.setText(emailTemplate.getContenido());
//
//        javaMailSender.send(email);
//
//        return new ResponseEntity<>(true, HttpStatus.OK);
//    }
//
//}



import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.Properties;

@RestController
@CrossOrigin("*")
public class SendHtmlEmail {

    @PostMapping("/enviarCorreo")
    public void enviarMail(@RequestBody EmailTemplate emailTemplate){
        // Configuración del servidor SMTP
        String host = "smtp.gmail.com";
        String user = "grupo1.digitalbooking@gmail.com";
        String password = "cthnopzsngyfgycg";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        // Autenticación
        Session session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user, password);
                    }
                });

        try {
            // Creación del mensaje
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(emailTemplate.getDestinatario()));
            message.setSubject(emailTemplate.getAsunto());

            // Contenido HTML
            String htmlContent = emailTemplate.getContenido();

            // Configuración del mensaje como HTML
            message.setContent(htmlContent, "text/html");

            // Envío del mensaje
            Transport.send(message);

            System.out.println("Mensaje enviado correctamente");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}