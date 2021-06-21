package com.hendisantika.springbootdatajpatest.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-test-examples
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 21/06/21
 * Time: 09.04
 */
@Data
public class Receipt {
    private final LocalDateTime date;
    private final String creditCardNumber;
    private final BigDecimal amount;
}
