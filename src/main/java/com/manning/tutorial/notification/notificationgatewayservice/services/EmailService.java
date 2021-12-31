package com.manning.tutorial.notification.notificationgatewayservice.services;

import com.manning.tutorial.notification.notificationgatewayservice.model.GatewayRequest;
import com.manning.tutorial.notification.notificationgatewayservice.model.GatewayResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@RequiredArgsConstructor
public class EmailService {

    @Value("${email.from}")
    private String from;
    private final JavaMailSender javaMailSender;

    public GatewayResponse send(GatewayRequest gatewayRequest) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(gatewayRequest.getEmailAddress());
        message.setSubject(gatewayRequest.getEmailSubject());
        message.setText(gatewayRequest.getNotificationContent());
        javaMailSender.send(message);
        return prepareResponse();
    }

    private GatewayResponse prepareResponse() {
        return new GatewayResponse("SUCCESS", "Notification Received Successfully");
    }
}
