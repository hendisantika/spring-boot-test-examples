package com.hendisantika.springbootwebclientmockwebserver.client;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.web.reactive.function.client.WebClient;

import static org.mockito.Mockito.mock;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-test-examples
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 21/06/21
 * Time: 08.18
 */
public class TwilioClientUnitTests {
    private WebClient.RequestBodyUriSpec requestBodyUriMock;
    private WebClient.RequestHeadersSpec requestHeadersMock;
    private WebClient.RequestBodySpec requestBodyMock;
    private WebClient.ResponseSpec responseMock;
    private WebClient webClientMock;

    @BeforeEach
    void mockWebClient() {
        requestBodyUriMock = mock(WebClient.RequestBodyUriSpec.class);
        requestHeadersMock = mock(WebClient.RequestHeadersSpec.class);
        requestBodyMock = mock(WebClient.RequestBodySpec.class);
        responseMock = mock(WebClient.ResponseSpec.class);
        webClientMock = mock(WebClient.class);
    }
}
