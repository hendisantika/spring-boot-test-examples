package com.hendisantika;

import com.hendisantika.controller.OrderController;
import com.hendisantika.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

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

}
