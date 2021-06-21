package com.hendisantika.springbootdatajpatest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-test-examples
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 21/06/21
 * Time: 09.06
 */
@Data
@AllArgsConstructor
public class PaymentResponse {
    private final Long orderId;
    private final String creditCardNumber;
}
