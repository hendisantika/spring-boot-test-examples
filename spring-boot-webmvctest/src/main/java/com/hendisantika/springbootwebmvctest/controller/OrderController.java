package com.hendisantika.springbootwebmvctest.controller;

import com.hendisantika.springbootwebmvctest.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-test-examples
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 23/06/21
 * Time: 06.10
 */
@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
}
