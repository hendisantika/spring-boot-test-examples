package com.hendisantika.springbootwebmvctest;

import javax.validation.Validation;
import javax.validation.Validator;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-test-examples
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 23/06/21
 * Time: 06.17
 */
public class PaymentRequestTests {
    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

}
