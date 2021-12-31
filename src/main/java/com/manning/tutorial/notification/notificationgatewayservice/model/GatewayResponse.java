package com.manning.tutorial.notification.notificationgatewayservice.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class GatewayResponse {

    String status;
    String statusDescription;

    @JsonCreator
    public GatewayResponse(@JsonProperty("status") String status,
                           @JsonProperty("statusDescription") String statusDescription) {
        this.status = status;
        this.statusDescription = statusDescription;
    }
}
