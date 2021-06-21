package com.hendisantika.springbootdatajpatest.service;

import com.hendisantika.springbootdatajpatest.entity.Order;
import com.hendisantika.springbootdatajpatest.entity.Payment;
import com.hendisantika.springbootdatajpatest.exception.OrderAlreadyPaid;
import com.hendisantika.springbootdatajpatest.repository.OrderRepository;
import com.hendisantika.springbootdatajpatest.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-test-examples
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 21/06/21
 * Time: 09.12
 */
@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final PaymentRepository paymentRepository;

    public Payment pay(Long orderId, String creditCardNumber) {
        Order order = orderRepository.findById(orderId).orElseThrow(EntityNotFoundException::new);

        if (order.isPaid()) {
            throw new OrderAlreadyPaid();
        }

        orderRepository.save(order.markPaid());
        return paymentRepository.save(new Payment(order, creditCardNumber));
    }
}
