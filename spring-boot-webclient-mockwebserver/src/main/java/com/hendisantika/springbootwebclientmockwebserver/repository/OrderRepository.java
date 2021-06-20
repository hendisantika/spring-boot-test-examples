package com.hendisantika.springbootwebclientmockwebserver.repository;

import com.hendisantika.springbootwebclientmockwebserver.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-test-examples
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 20/06/21
 * Time: 16.38
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
}
