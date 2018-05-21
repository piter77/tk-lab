package pl.edu.agh.tk.visualisation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Random;

public class RabbitSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private DirectExchange exchange;

    @Value("${rabbit.topic}")
    private String topic;

    private ObjectMapper mapper = new ObjectMapper();

    private int idx1 = 0;
    private int idx2 = 0;


    @Scheduled(fixedDelay = 1000, initialDelay = 1000)
    public void sendIsland1() {
        String computationId = "island_1";
        AlgoMessageDTO algoMessageDTO = new AlgoMessageDTO(computationId, idx1++, new Random().nextInt(100));

        try {
            rabbitTemplate.convertAndSend(exchange.getName(), topic, mapper.writeValueAsString(algoMessageDTO));
            System.out.println(" [1] Sent " + algoMessageDTO.toString() + " to " + topic);

        } catch (JsonProcessingException e) {
            System.out.print("ERROR" + e.getMessage());
        }
    }

    @Scheduled(fixedDelay = 1300, initialDelay = 1000)
    public void sendIsland2() {
        String computationId = "island_2";
        AlgoMessageDTO algoMessageDTO = new AlgoMessageDTO(computationId, idx2++, new Random().nextInt(100));

        try {
            rabbitTemplate.convertAndSend(exchange.getName(), topic, mapper.writeValueAsString(algoMessageDTO));
            System.out.println(" [2] Sent " + algoMessageDTO.toString() + " to " + topic);

        } catch (JsonProcessingException e) {
            System.out.print("ERROR" + e.getMessage());
        }
    }

}

