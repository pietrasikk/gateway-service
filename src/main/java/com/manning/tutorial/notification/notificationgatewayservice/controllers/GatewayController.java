package com.manning.tutorial.notification.notificationgatewayservice.controllers;

import com.manning.tutorial.notification.notificationgatewayservice.model.GatewayRequest;
import com.manning.tutorial.notification.notificationgatewayservice.model.GatewayResponse;
import com.manning.tutorial.notification.notificationgatewayservice.services.GatewayService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class GatewayController {

    private final GatewayService gatewayService;

    @PostMapping(path = "/notifications/send",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public GatewayResponse getNotificationTemplate(@RequestBody GatewayRequest gatewayRequest) {
        return gatewayService.send(gatewayRequest);
    }
}
