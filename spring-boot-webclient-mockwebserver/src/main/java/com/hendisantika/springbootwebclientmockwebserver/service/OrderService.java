package com.hendisantika.springbootwebclientmockwebserver.service;

import com.hendisantika.springbootwebclientmockwebserver.client.ExchangeRateClient;
import com.hendisantika.springbootwebclientmockwebserver.repository.OrderRepository;
import com.hendisantika.springbootwebclientmockwebserver.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-test-examples
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 20/06/21
 * Time: 16.53
 */
@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final PaymentRepository paymentRepository;
    private final ExchangeRateClient exchangeRateClient;

}
