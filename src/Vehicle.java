import java.io.Serializable;
import java.util.Objects;

public abstract class Vehicle implements Serializable
{
    protected int year;
    protected String make;
    protected String model;
    protected double price;

    protected Vehicle(int year, String make, String model, double price) {
        this.year = year;
        this.make = make;
        this.model = model;
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return year == vehicle.year && Double.compare(price, vehicle.price) == 0 && Objects.equals(make, vehicle.make) && Objects.equals(model, vehicle.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, make, model, price);
    }
}
