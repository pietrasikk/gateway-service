package com.manning.tutorial.notification.notificationgatewayservice.services;

import com.manning.tutorial.notification.notificationgatewayservice.model.GatewayRequest;
import com.manning.tutorial.notification.notificationgatewayservice.model.GatewayResponse;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;

public class SmsService {

    @Value("${twilio.username}")
    private String accountSid;

    @Value("${twilio.password}")
    private String authToken;

    @Value("${twilio.twilio.number}")
    private String twilioNumber;

    public GatewayResponse send(GatewayRequest gatewayRequest) {
        Twilio.init(accountSid, authToken);
        Message.creator(new PhoneNumber(gatewayRequest.getPhoneNumber()),
                        new PhoneNumber(twilioNumber),
                        gatewayRequest.getNotificationContent())
                .create();
        return prepareResponse();
    }

    private GatewayResponse prepareResponse() {
        return new GatewayResponse("SUCCESS", "Notification Received Successfully");
    }
}
