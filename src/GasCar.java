import java.io.Serializable;

public class GasCar extends Vehicle implements Serializable {
    public GasCar(int year, String make, String model, double price, int mpg) {
        super(year, make, model, price);
        this.mpg = mpg;
    }
    private int mpg;

    public int getMpg() {
        return mpg;
    }

    public void setMpg(int mpg) {
        this.mpg = mpg;
    }

    @Override
    public String toString() {
        return "GasCar[" +
                year +
                ", " + make +
                ", " + model +
                ", $" + price +
                ", " + mpg + " MPG" +
                ']';
    }
}
