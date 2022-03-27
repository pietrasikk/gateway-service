package com.manning.tutorial.notification.notificationgatewayservice.services;

import com.manning.tutorial.notification.notificationgatewayservice.model.GatewayRequest;
import com.manning.tutorial.notification.notificationgatewayservice.model.GatewayResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequiredArgsConstructor
public class GatewayService {

    private final EmailService emailService;
    private final SmsService smsService;
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    public GatewayResponse send(GatewayRequest gatewayRequest) {
        logger.info("In the Notification Gateway API Class");
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
