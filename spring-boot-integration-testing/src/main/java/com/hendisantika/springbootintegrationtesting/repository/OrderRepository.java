package com.hendisantika.springbootintegrationtesting.repository;

import com.hendisantika.springbootintegrationtesting.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-test-examples
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 24/06/21
 * Time: 07.30
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
}
