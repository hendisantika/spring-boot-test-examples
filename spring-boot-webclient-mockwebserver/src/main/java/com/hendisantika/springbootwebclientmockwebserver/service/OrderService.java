package com.hendisantika.springbootwebclientmockwebserver.service;

import com.hendisantika.springbootwebclientmockwebserver.client.ExchangeRateClient;
import com.hendisantika.springbootwebclientmockwebserver.entity.Order;
import com.hendisantika.springbootwebclientmockwebserver.entity.Payment;
import com.hendisantika.springbootwebclientmockwebserver.exception.OrderAlreadyPaid;
import com.hendisantika.springbootwebclientmockwebserver.repository.OrderRepository;
import com.hendisantika.springbootwebclientmockwebserver.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.money.MonetaryAmount;
import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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

    public Order createOrder(MonetaryAmount amount) {
        Order order = new Order(LocalDateTime.now(), amount.getNumber().numberValue(BigDecimal.class), false);
        return orderRepository.save(order);
    }

    public Order getOrder(Long orderId) {
        return orderRepository.findById(orderId).orElseThrow(EntityNotFoundException::new);
    }

    public Payment pay(Long orderId, String creditCardNumber) {
        Order order = orderRepository.findById(orderId).orElseThrow(EntityNotFoundException::new);

        if (order.isPaid()) {
            throw new OrderAlreadyPaid();
        }

        orderRepository.save(order.markPaid());
        return paymentRepository.save(new Payment(order, creditCardNumber));
    }
}
