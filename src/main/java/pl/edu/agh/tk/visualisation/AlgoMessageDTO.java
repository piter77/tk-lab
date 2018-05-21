package pl.edu.agh.tk.visualisation;

public class AlgoMessageDTO {

    private String computationId;
    private Integer iterationNumber;
    private Integer computationBestFitness;

    public AlgoMessageDTO() {
    }

    public AlgoMessageDTO(String computationId, Integer iterationNumber, Integer computationBestFitness) {
        this.computationId = computationId;
        this.iterationNumber = iterationNumber;
        this.computationBestFitness = computationBestFitness;
    }

    public String getComputationId() {
        return computationId;
    }

    public void setComputationId(String computationId) {
        this.computationId = computationId;
    }

    public Integer getIterationNumber() {
        return iterationNumber;
    }

    public void setIterationNumber(Integer iterationNumber) {
        this.iterationNumber = iterationNumber;
    }

    public Integer getComputationBestFitness() {
        return computationBestFitness;
    }

    public void setComputationBestFitness(Integer computationBestFitness) {
        this.computationBestFitness = computationBestFitness;
    }

    @Override
    public String toString() {
        return "AlgoMessageDTO{" +
                "computationId='" + computationId + '\'' +
                ", iterationNumber=" + iterationNumber +
                ", computationBestFitness=" + computationBestFitness +
                '}';
    }
}
