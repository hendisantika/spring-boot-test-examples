package com.hendisantika.springbootwebclientmockwebserver.client;

import com.hendisantika.springbootwebclientmockwebserver.config.ExchangeClientProperties;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-test-examples
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 21/06/21
 * Time: 08.10
 */
class ExchangeRateClientTest {
    private MockWebServer mockWebServer;
    private ExchangeRateClient exchangeRateClient;

    @BeforeEach
    void setupMockWebServer() {
        mockWebServer = new MockWebServer();

        ExchangeClientProperties properties = new ExchangeClientProperties();
        properties.setBaseUrl(mockWebServer.url("/").url().toString());
        properties.setApiKey("029db72cee377e4bfa1fa413");

        exchangeRateClient = new ExchangeRateClient(WebClient.create(), properties);
    }
}
