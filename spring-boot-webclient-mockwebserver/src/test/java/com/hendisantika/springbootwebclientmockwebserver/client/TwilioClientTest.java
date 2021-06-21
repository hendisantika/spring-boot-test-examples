package com.hendisantika.springbootwebclientmockwebserver.client;

import okhttp3.mockwebserver.MockWebServer;
import org.springframework.boot.test.json.BasicJsonTester;

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

}
