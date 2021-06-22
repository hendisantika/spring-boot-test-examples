package com.hendisantika.controller;

import com.hendisantika.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-test-examples
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 22/06/21
 * Time: 07.00
 */
@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
}
