package pl.edu.agh.tk.visualisation;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

public class RabbitReceiver {

    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private RealTimeDataResource realTimeDataResource;

    @RabbitListener(queues = "#{queue.name}")
    public void receive(String msg) throws Exception {
        System.out.println(" [x] Received " + msg);

        AlgoMessageDTO messageObject = mapper.readValue(msg, AlgoMessageDTO.class);

        realTimeDataResource.addBestFitnessData(
                messageObject.getComputationId(),
                messageObject);
    }
}
