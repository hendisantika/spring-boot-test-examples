package com.hendisantika.entity;

import lombok.Data;

import javax.money.MonetaryAmount;
import java.time.LocalDateTime;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-test-examples
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 22/06/21
 * Time: 06.50
 */
@Data
public class Receipt {
    private final LocalDateTime date;
    private final String creditCardNumber;
    private final MonetaryAmount amount;
}
