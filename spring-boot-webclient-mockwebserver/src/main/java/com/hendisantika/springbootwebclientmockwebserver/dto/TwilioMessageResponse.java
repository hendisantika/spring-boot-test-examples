package com.hendisantika.springbootwebclientmockwebserver.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-test-examples
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 20/06/21
 * Time: 16.50
 */
@Data
@NoArgsConstructor
public class TwilioMessageResponse {
    @JsonAlias("error_code")
    private String errorCode;
    @JsonAlias("error_message")
    private String errorMessage;
}
