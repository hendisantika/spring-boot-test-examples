package com.hendisantika.springbootwebclientmockwebserver.client;

import com.hendisantika.springbootwebclientmockwebserver.config.TwilioClientProperties;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.json.BasicJsonTester;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-test-examples
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 21/06/21
 * Time: 08.15
 */
class TwilioClientTest {
    private final BasicJsonTester json = new BasicJsonTester(this.getClass());
    private MockWebServer mockWebServer;
    private TwilioClient twilioClient;

    @BeforeEach
    void setupMockWebServer() {
        mockWebServer = new MockWebServer();

        TwilioClientProperties properties = new TwilioClientProperties();
        properties.setBaseUrl(mockWebServer.url("/").url().toString());
        properties.setAccountSid("ACd936ed6dc1504dd79530f19f57b9c008");

        twilioClient = new TwilioClient(WebClient.create(), properties);
    }

    @Test
    void makesTheCorrectRequest() throws InterruptedException {
        mockWebServer.enqueue(
                new MockResponse().setResponseCode(200)
                        .setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .setBody(getJson("message-response.json"))
        );

        twilioClient.sendSms("+123456", "+234567", "test message");

        RecordedRequest request = mockWebServer.takeRequest();

        assertThat(request.getMethod()).isEqualTo("POST");
        assertThat(request.getPath()).isEqualTo("/Accounts/ACd936ed6dc1504dd79530f19f57b9c008/Messages.json");
    }

}
