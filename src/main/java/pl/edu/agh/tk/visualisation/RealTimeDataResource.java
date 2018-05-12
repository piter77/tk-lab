package pl.edu.agh.tk.visualisation;

import pl.edu.agh.tk.visualisation.ChartDataDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/real-time-data")
public class RealTimeDataResource {

    private int idx = 0;
    private Map<String, List<ChartDataDTO>> bestFitness;

    public RealTimeDataResource() {
        bestFitness = new HashMap<>();
        bestFitness.put("TestIsland", new ArrayList<>());
    }

    @RequestMapping(value = "/data", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getData() {
        bestFitness.get("TestIsland").add(new ChartDataDTO(idx++, new Random().nextInt(100)));
        return ResponseEntity.ok(bestFitness);
    }
}
