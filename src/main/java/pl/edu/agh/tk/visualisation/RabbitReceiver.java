package pl.edu.agh.tk.visualisation;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

public class RabbitReceiver {

    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private RealTimeDataResource realTimeDataResource;

    @RabbitListener(queues = "#{queue1.name}")
    public void receive1(String msg) throws Exception {
        System.out.println(" [1] Received " + msg);

        ChartDataDTO data = mapper.readValue(msg, ChartDataDTO.class);

        realTimeDataResource.addBestFitnessData("TestIsland_1", data);
    }


    @RabbitListener(queues = "#{queue2.name}")
    public void receive2(String msg) throws Exception {
        System.out.println(" [2] Received " + msg);

        ChartDataDTO data = mapper.readValue(msg, ChartDataDTO.class);

        realTimeDataResource.addBestFitnessData("TestIsland_2", data);
    }
}
