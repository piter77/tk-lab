package pl.edu.agh.tk.visualisation;

public class ChartDataDTO {

    private Long xAxis;
    private Integer yAxis;

    public ChartDataDTO(long xAxis, int yAxis) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public Long getxAxis() {
        return xAxis;
    }

    public Integer getyAxis() {
        return yAxis;
    }
}
