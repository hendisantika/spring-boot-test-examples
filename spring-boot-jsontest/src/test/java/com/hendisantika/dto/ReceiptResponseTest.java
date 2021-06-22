package com.hendisantika.dto;

import org.javamoney.moneta.Money;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;

import javax.money.Monetary;
import java.io.IOException;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-test-examples
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 22/06/21
 * Time: 07.08
 */
@JsonTest
class ReceiptResponseTest {
    @Autowired
    private JacksonTester<ReceiptResponse> jacksonTester;

    @Test
    void serializeInCorrectFormat() throws IOException {
        ReceiptResponse receipt = new ReceiptResponse(
                LocalDateTime.of(2021, 5, 9, 16, 0),
                "4532756279624064",
                Money.of(50.0, Monetary.getCurrency("USD")));

        JsonContent<ReceiptResponse> json = jacksonTester.write(receipt);

        assertThat(json).extractingJsonPathStringValue("$.date").isEqualTo("09.05.2021 16:00");
        assertThat(json).extractingJsonPathStringValue("$.amount").isEqualTo("USD50.00");
    }
}
