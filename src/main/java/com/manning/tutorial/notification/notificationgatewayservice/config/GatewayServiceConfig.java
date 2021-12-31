package com.manning.tutorial.notification.notificationgatewayservice.config;

import com.manning.tutorial.notification.notificationgatewayservice.services.EmailService;
import com.manning.tutorial.notification.notificationgatewayservice.services.GatewayService;
import com.manning.tutorial.notification.notificationgatewayservice.services.SmsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
class GatewayServiceConfig {

    @Bean
    EmailService emailService(JavaMailSender javaMailSender) {
        return new EmailService(javaMailSender);
    }

    @Bean
    SmsService smsService() {
        return new SmsService();
    }

    @Bean
    GatewayService gatewayService(EmailService emailService, SmsService smsService) {
        return new GatewayService(emailService, smsService);
    }
}
