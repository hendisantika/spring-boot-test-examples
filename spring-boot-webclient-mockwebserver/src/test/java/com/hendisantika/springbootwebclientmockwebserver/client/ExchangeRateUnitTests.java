package com.hendisantika.springbootwebclientmockwebserver.client;

import com.hendisantika.springbootwebclientmockwebserver.config.ExchangeClientProperties;
import com.hendisantika.springbootwebclientmockwebserver.dto.ExchangeResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-test-examples
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 21/06/21
 * Time: 08.14
 */
public class ExchangeRateUnitTests {
    private WebClient.RequestHeadersUriSpec requestHeadersUriMock;
    private WebClient.RequestBodySpec requestBodyMock;
    private WebClient.ResponseSpec responseMock;
    private WebClient webClientMock;

    @BeforeEach
    void mockWebClient() {
        requestHeadersUriMock = mock(WebClient.RequestHeadersUriSpec.class);
        requestBodyMock = mock(WebClient.RequestBodySpec.class);
        responseMock = mock(WebClient.ResponseSpec.class);
        webClientMock = mock(WebClient.class);
    }

    @Test
    void exchangeCurrency() {
        ExchangeClientProperties properties = new ExchangeClientProperties();
        properties.setApiKey("apiKey");
        properties.setBaseUrl("http://localhost");

        ExchangeRateClient client = new ExchangeRateClient(webClientMock, properties);

        ExchangeResponse response = new ExchangeResponse();
        response.setConversionRate(BigDecimal.valueOf(0.748));

        CurrencyUnit eur = Monetary.getCurrency("EUR");
        CurrencyUnit usd = Monetary.getCurrency("USD");

        String expectedUri = "http://localhost/v6/{apiKey}/pair/{from}/{to}";
        when(webClientMock.get()).thenReturn(requestHeadersUriMock);
        when(requestHeadersUriMock.uri(expectedUri, "apiKey", eur, usd)).thenReturn(requestBodyMock);
        when(requestBodyMock.retrieve()).thenReturn(responseMock);
        when(responseMock.bodyToMono(ExchangeResponse.class)).thenReturn(Mono.just(response));

        BigDecimal rate = client.getExchangeRate(eur, usd);

        assertThat(rate.doubleValue()).isEqualTo(0.748);
    }
}
