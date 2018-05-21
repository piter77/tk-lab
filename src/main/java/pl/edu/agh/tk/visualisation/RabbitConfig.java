package pl.edu.agh.tk.visualisation;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class RabbitConfig {


    @Bean
    public DirectExchange fanout() {
        return new DirectExchange("techniki.komponentowe");
    }

    @Bean
    public Queue queue1() {
        return new Queue("queue1");
    }

    @Bean
    public Queue queue2() {
        return new Queue("queue2");
    }

    @Bean
    public Binding binding1(DirectExchange fanout,
                            Queue queue1) {
        return BindingBuilder
                .bind(queue1)
                .to(fanout)
                .with("algo.1");
    }

    @Bean
    public Binding binding2(DirectExchange fanout,
                            Queue queue2) {
        return BindingBuilder
                .bind(queue2)
                .to(fanout)
                .with("algo.2");
    }

    @Profile("receiver")
    @Bean
    public RabbitReceiver receiver() {

        return new RabbitReceiver();
    }

    @Profile("sender")
    @Bean
    public RabbitSender sender() {
        return new RabbitSender();
    }
}
