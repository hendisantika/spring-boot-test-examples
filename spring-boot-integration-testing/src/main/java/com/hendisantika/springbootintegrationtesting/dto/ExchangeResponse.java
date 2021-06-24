package com.hendisantika.springbootintegrationtesting.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-test-examples
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 24/06/21
 * Time: 07.36
 */
@Data
public class ExchangeResponse {
    @JsonAlias("conversion_rate")
    private BigDecimal conversionRate;
    private String result;
    @JsonAlias("error-type")
    private String errorType;
}
