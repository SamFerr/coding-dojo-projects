class Vehicle {
    private int numberOfWheels;
    private String color;

    public Vehicle(String color) {
        // setting the color attribute to the value from the color parameter
        this.color = color;
    }

    // getter
    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    // setter
    public void setNumberOfWheels(int number) {
        numberOfWheels = number;
    }

    // getter
    public String getColor() {
        return color;
    }

    // setter
    public void setColor(String color) {
        this.color = color; // 1
    }
}