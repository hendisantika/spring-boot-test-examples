package com.hendisantika.springbootintegrationtesting.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-test-examples
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 24/06/21
 * Time: 07.32
 */
@Component
@RequiredArgsConstructor
public class ExchangeRateClient {
    private final WebClient webClient;
    private final ExchangeClientProperties properties;
}
