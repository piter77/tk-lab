package pl.edu.agh.tk.visualisation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Random;

public class RabbitSender {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private DirectExchange exchange;

    private int idx1 = 0;
    private int idx2 = 0;

    private ObjectMapper mapper = new ObjectMapper();


    @Scheduled(fixedDelay = 1000, initialDelay = 1000)
    public void send1() {

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        ChartDataDTO data = new ChartDataDTO(idx1++, new Random().nextInt(100));
        try {
            this.template.convertAndSend(exchange.getName(), "algo.1", mapper.writeValueAsString(data));

            System.out.println(" [1] Sent " + data.toString());

        } catch (JsonProcessingException e) {
            System.out.print("ERROR" + e.getMessage());
        }
    }

    @Scheduled(fixedDelay = 1300, initialDelay = 1000)
    public void send2() {

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        ChartDataDTO data = new ChartDataDTO(idx2++, new Random().nextInt(100));
        try {
            this.template.convertAndSend(exchange.getName(), "algo.2", mapper.writeValueAsString(data));

            System.out.println(" [2] Sent " + data.toString());

        } catch (JsonProcessingException e) {
            System.out.print("ERROR" + e.getMessage());
        }
    }

}

