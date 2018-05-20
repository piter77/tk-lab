package pl.edu.agh.tk.visualisation;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class DataProducer {

    RealTimeDataResource resource;
    int idx;

    public DataProducer(RealTimeDataResource resource){
        this.resource = resource;
        idx = 0;

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                resource.addBestFitnessData("TestIsland", new ChartDataDTO(idx++, new Random().nextInt(100)));
            }
        }, 0, 5000);
    }



}
