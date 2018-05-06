package pl.edu.agh.tk.visualisation;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AlgoController {

    @GetMapping("/resolve")
    @ResponseBody
    public String sayHello(@RequestParam(name = "time", required = false) Integer time) {
        try {
            Thread.sleep(1000 * time);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return String.format("Encountered error: %s", e.getMessage());
        }
        return String.format("Proceeded algorithm in aprox. %d seconds", time);
    }

}

