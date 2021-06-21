package com.hendisantika.springbootdatajpatest.controller;

import com.hendisantika.springbootdatajpatest.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-test-examples
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 21/06/21
 * Time: 09.14
 */
@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
}
