package com.hendisantika;

import com.hendisantika.controller.OrderController;
import com.hendisantika.entity.Receipt;
import com.hendisantika.service.OrderService;
import org.javamoney.moneta.Money;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import javax.money.Monetary;
import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-test-examples
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 22/06/21
 * Time: 07.16
 */
@WebMvcTest(OrderController.class)
class OrderControllerTests {
    @MockBean
    private OrderService orderService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getReceiptForOrder() throws Exception {
        givenOrderIsPaid(1L);

        mockMvc.perform(get("/order/{id}/receipt", 1L))
                .andExpect(jsonPath("$.date").isNotEmpty())
                .andExpect(jsonPath("$.creditCardNumber").isNotEmpty())
                .andExpect(jsonPath("$.amount").isNotEmpty());
    }

    private void givenOrderIsPaid(Long orderId) {
        Receipt receipt = new Receipt(
                LocalDateTime.now(),
                "4532756279624064",
                Money.of(100.0, Monetary.getCurrency("EUR")));
        when(orderService.getReceipt(eq(orderId))).thenReturn(receipt);
    }
}
