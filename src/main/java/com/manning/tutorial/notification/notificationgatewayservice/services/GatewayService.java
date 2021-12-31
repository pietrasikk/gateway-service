package com.manning.tutorial.notification.notificationgatewayservice.services;

import com.manning.tutorial.notification.notificationgatewayservice.model.GatewayRequest;
import com.manning.tutorial.notification.notificationgatewayservice.model.GatewayResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GatewayService {

    private final EmailService emailService;
    private final SmsService smsService;

    public GatewayResponse send(GatewayRequest gatewayRequest) {
        switch (gatewayRequest.getNotificationMode()) {
            case "EMAIL":
                return emailService.send(gatewayRequest);
            case "SMS":
                return smsService.send(gatewayRequest);
            default:
                return prepareErrorResponse();
        }
    }

    private GatewayResponse prepareErrorResponse() {
        return new GatewayResponse("ERROR", "Wrong notification mode");
    }
}
