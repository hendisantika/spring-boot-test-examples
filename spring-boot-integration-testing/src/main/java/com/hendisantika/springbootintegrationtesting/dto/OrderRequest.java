package com.hendisantika.springbootintegrationtesting.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.money.MonetaryAmount;
import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-test-examples
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 24/06/21
 * Time: 07.45
 */
@Data
@NoArgsConstructor
public class OrderRequest {
    @NotNull
    private MonetaryAmount amount;
}
