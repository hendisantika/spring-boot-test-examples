package com.hendisantika.springbootwebclientmockwebserver.dto;

import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-test-examples
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 20/06/21
 * Time: 16.49
 */
@Data
public class TwilioMessageRequest {
    private final String to;
    private final String from;
    private final String body;
}
