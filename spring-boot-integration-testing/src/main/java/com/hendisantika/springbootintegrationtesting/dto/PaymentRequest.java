package com.hendisantika.springbootintegrationtesting.dto;

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
 * Date: 24/06/21
 * Time: 07.27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequest {
    @NotNull
    @CreditCardNumber
    private String creditCardNumber;
}
