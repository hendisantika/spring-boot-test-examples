package com.hendisantika.springbootdatajpatest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-test-examples
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 21/06/21
 * Time: 09.05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequest {
    @NotNull
    @CreditCardNumber
    private String creditCardNumber;
}
