package com.hendisantika.springbootintegrationtesting.dto;

import lombok.Data;

import javax.money.MonetaryAmount;
import java.time.LocalDateTime;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-test-examples
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 24/06/21
 * Time: 07.22
 */
@Data
public class Receipt {
    private final LocalDateTime date;
    private final String creditCardNumber;
    private final MonetaryAmount amount;
}
