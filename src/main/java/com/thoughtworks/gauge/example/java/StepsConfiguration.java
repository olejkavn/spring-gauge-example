package com.thoughtworks.gauge.example.java;

import com.thoughtworks.gauge.example.AnotherTestSteps;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StepsConfiguration {

    @Bean
    public DebitCard debitCard(){
        return new DebitCard();
    }

    @Bean
    public DebitCardProcessor paypalDebitCardProcessor() {
        return new PaypalDebitCardProcessor();
    }

    @Bean
    public PaymentService paymentService(DebitCardProcessor debitCardProcessor) {
        return new PaymentService(debitCardProcessor);
    }

    @Bean
    public AnotherTestSteps anotherTestSteps() {
        return new AnotherTestSteps();
    }
}
