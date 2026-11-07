package com.hendisantika.dto;

import org.springframework.boot.jackson.JacksonComponent;
import tools.jackson.core.JsonGenerator;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.deser.std.StdDeserializer;
import tools.jackson.databind.ser.std.StdSerializer;

import javax.money.MonetaryAmount;
import javax.money.format.MonetaryAmountFormat;
import javax.money.format.MonetaryFormats;
import java.util.Locale;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-test-examples
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 22/06/21
 * Time: 06.53
 */
@JacksonComponent
public class MoneySerialization {

    private static final MonetaryAmountFormat monetaryAmountFormat;

    static {
        monetaryAmountFormat = MonetaryFormats.getAmountFormat(Locale.US);
    }

    static class MonetaryAmountSerializer extends StdSerializer<MonetaryAmount> {

        public MonetaryAmountSerializer() {
            super(MonetaryAmount.class);
        }

        @Override
        public void serialize(
                MonetaryAmount value,
                JsonGenerator generator,
                SerializationContext context) {

            generator.writeString(monetaryAmountFormat.format(value));
        }
    }

    static class MonetaryAmountDeserializer extends StdDeserializer<MonetaryAmount> {

        public MonetaryAmountDeserializer() {
            super(MonetaryAmount.class);
        }

        @Override
        public MonetaryAmount deserialize(
                JsonParser parser,
                DeserializationContext context) {

            return monetaryAmountFormat.parse(parser.getValueAsString());
        }
    }
}
