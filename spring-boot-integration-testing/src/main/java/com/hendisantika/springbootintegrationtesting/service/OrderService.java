package com.hendisantika.springbootintegrationtesting.service;

import com.hendisantika.springbootintegrationtesting.client.ExchangeRateClient;
import com.hendisantika.springbootintegrationtesting.repository.OrderRepository;
import com.hendisantika.springbootintegrationtesting.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-test-examples
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 24/06/21
 * Time: 07.31
 */
@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final PaymentRepository paymentRepository;
    private final ExchangeRateClient exchangeRateClient;
}
