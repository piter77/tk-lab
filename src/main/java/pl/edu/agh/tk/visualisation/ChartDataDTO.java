package pl.edu.agh.tk.visualisation;

public class ChartDataDTO {

    private Long xAxis;
    private Integer yAxis;

    public ChartDataDTO() {
    }

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

    public void setxAxis(Long xAxis) {
        this.xAxis = xAxis;
    }

    public void setyAxis(Integer yAxis) {
        this.yAxis = yAxis;
    }

    @Override
    public String toString() {
        return "ChartDataDTO{" +
                "xAxis=" + xAxis +
                ", yAxis=" + yAxis +
                '}';
    }
}
