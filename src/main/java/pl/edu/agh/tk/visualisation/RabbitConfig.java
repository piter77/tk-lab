package pl.edu.agh.tk.visualisation;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class RabbitConfig {

    @Value("${rabbit.topic}")
    private String topic;

    @Value("${rabbit.exchange}")
    private String exchangeName;


    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(exchangeName);
    }


    @Bean
    public Queue queue() {
        return new Queue("queue");
    }


    @Bean
    public Binding binding(DirectExchange exchange, Queue queue) {
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with(topic);
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
