package com.hendisantika.springbootwebclientmockwebserver.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-test-examples
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 20/06/21
 * Time: 16.44
 */
@Data
public class ExchangeResponse {
    @JsonAlias("conversion_rate")
    private BigDecimal conversionRate;
    private String result;
    @JsonAlias("error-type")
    private String errorType;
}
