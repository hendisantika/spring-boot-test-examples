package com.hendisantika.springbootwebclientmockwebserver.entity;

import lombok.Data;

import javax.money.MonetaryAmount;
import java.time.LocalDateTime;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-test-examples
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 20/06/21
 * Time: 16.34
 */
@Data
public class Receipt {
    private final LocalDateTime date;
    private final String creditCardNumber;
    private final MonetaryAmount amount;
}
