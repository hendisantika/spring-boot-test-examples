package com.hendisantika.springbootwebmvctest.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-test-examples
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 23/06/21
 * Time: 06.05
 */
@Data
public class Receipt {
    private final LocalDateTime date;
    private final String creditCardNumber;
    private final Double amount;
}
