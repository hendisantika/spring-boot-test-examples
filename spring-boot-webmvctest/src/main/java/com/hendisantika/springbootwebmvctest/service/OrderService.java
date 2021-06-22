package com.hendisantika.springbootwebmvctest.service;

import com.hendisantika.springbootwebmvctest.dto.Receipt;
import com.hendisantika.springbootwebmvctest.entity.Order;
import com.hendisantika.springbootwebmvctest.entity.Payment;
import com.hendisantika.springbootwebmvctest.exception.OrderAlreadyPaid;
import com.hendisantika.springbootwebmvctest.repository.OrderRepository;
import com.hendisantika.springbootwebmvctest.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-test-examples
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 23/06/21
 * Time: 06.09
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

    public Receipt getReceipt(Long orderId) {
        Payment payment = paymentRepository.findByOrderId(orderId).orElseThrow(EntityNotFoundException::new);
        return new Receipt(payment.getOrder().getDate(), payment.getCreditCardNumber(), payment.getOrder().getAmount());
    }
}
