package pl.edu.agh.tk.visualisation;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/real-time-data")
public class RealTimeDataResource {

    private Map<String, List<ChartDataDTO>> bestFitness;
    private DataProducer dataProducer;

    public RealTimeDataResource() {
        bestFitness = new HashMap<>();
        dataProducer = new DataProducer(this);
    }

    public void addBestFitnessData(String islandName, ChartDataDTO chartPoint){
        if(!bestFitness.containsKey(islandName))
            bestFitness.put(islandName, new ArrayList<>());
        bestFitness.get(islandName).add(chartPoint);
    }

    @RequestMapping(value = "/data", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getData() {
        return ResponseEntity.ok(bestFitness);
    }
}
