package com.hendisantika.springbootwebclientmockwebserver.client;

import com.hendisantika.springbootwebclientmockwebserver.config.TwilioClientProperties;
import com.hendisantika.springbootwebclientmockwebserver.dto.TwilioMessageRequest;
import com.hendisantika.springbootwebclientmockwebserver.dto.TwilioMessageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-test-examples
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 20/06/21
 * Time: 16.46
 */
@Component
@RequiredArgsConstructor
public class TwilioClient {
    private final WebClient webClient;
    private final TwilioClientProperties properties;

    public void sendSms(String from, String to, String message) {
        String baseUrl = properties.getBaseUrl();
        String accountSid = properties.getAccountSid();

        TwilioMessageRequest request = new TwilioMessageRequest(to, from, message);

        webClient.post()
                .uri(baseUrl + "/Accounts/{AccountSid}/Messages.json", accountSid)
                .bodyValue(request)
                .retrieve()
                .bodyToMono(TwilioMessageResponse.class)
                .blockOptional()
                .orElseThrow();
    }
}
