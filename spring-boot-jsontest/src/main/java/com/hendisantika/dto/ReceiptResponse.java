package com.hendisantika.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.money.MonetaryAmount;
import java.time.LocalDateTime;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-test-examples
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 22/06/21
 * Time: 06.53
 */
@Getter
@AllArgsConstructor
public class ReceiptResponse {
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm")
    private final LocalDateTime date;
    private final String creditCardNumber;
    private final MonetaryAmount amount;
}
