package pl.edu.agh.tk.visualisation;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Component
@RequestMapping("/real-time-data")
public class RealTimeDataResource {

    private Map<String, List<ChartDataDTO>> bestFitness;

    public RealTimeDataResource() {
        bestFitness = new HashMap<>();
    }

    public void addBestFitnessData(String islandName, ChartDataDTO chartPoint) {
        if (!bestFitness.containsKey(islandName))
            bestFitness.put(islandName, new ArrayList<>());
        bestFitness.get(islandName).add(chartPoint);
    }

    @RequestMapping(value = "/data", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getData() {
        return ResponseEntity.ok(bestFitness);
    }
}
