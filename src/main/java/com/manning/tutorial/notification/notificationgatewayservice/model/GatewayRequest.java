package com.manning.tutorial.notification.notificationgatewayservice.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class GatewayRequest {

    String customerId;
    String notificationMode;
    String notificationContent;
    String emailAddress;
    String emailSubject;
    String phoneNumber;

    @JsonCreator
    public GatewayRequest(@JsonProperty("customerId") String customerId,
                          @JsonProperty("notificationMode") String notificationMode,
                          @JsonProperty("notificationContent") String notificationContent,
                          @JsonProperty("emailAddress") String emailAddress,
                          @JsonProperty("emailSubject") String emailSubject,
                          @JsonProperty("phoneNumber") String phoneNumber) {
        this.customerId = customerId;
        this.notificationMode = notificationMode;
        this.notificationContent = notificationContent;
        this.emailAddress = emailAddress;
        this.emailSubject = emailSubject;
        this.phoneNumber = phoneNumber;
    }
}
