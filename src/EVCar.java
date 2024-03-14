import java.io.Serializable;

public class EVCar extends Vehicle implements Serializable {
    public EVCar(int year, String make, String model, double price, int mpgE) {
        super(year, make, model, price);
        this.mpgE = mpgE;
    }
    private int mpgE;

    public int getMpgE() {
        return mpgE;
    }

    public void setMpgE(int mpgE) {
        this.mpgE = mpgE;
    }

    @Override
    public String toString() {
        return "EVCar[" +
                year +
                ", " + make +
                ", " + model +
                ", $" + price +
                ", " + mpgE + " MPGe" +
                ']';
    }
}
