public class CarClass {
    private String m_make;
    private String m_model;
    private double m_fuelCapacity;
    private double m_currentFuel;
    private double m_mpg;

    public CarClass(String make, String model, double fuelCapacity, double mpg) {
        m_make = make;
        m_model = model;
        m_fuelCapacity = fuelCapacity;
        m_mpg = mpg;
        m_currentFuel = fuelCapacity;
    }

    public String getMake() {
        return m_make;
    }
    public String getModel() {
        return m_model;
    }
    public double getCurrentFuel() {
        return m_currentFuel;
    }

    private void updateFuel(double fuelUsed) {
        m_currentFuel -= fuelUsed;
        
        if(m_currentFuel < 0) {
            m_currentFuel = 0;
        } else if(m_currentFuel > m_fuelCapacity) {
            m_currentFuel = m_fuelCapacity;
        }
    }

    private void drive(double miles) {
        double fuelUsed = miles / m_mpg;
        
        if(fuelUsed > m_currentFuel) {
            fuelUsed = m_currentFuel;
        }

        updateFuel(-fuelUsed);

        System.out.println(m_make + " " + m_model + " drove " + fuelUsed * m_mpg + " miles.");
    }

    private void refuel(double fuel) {
        fuel += m_currentFuel;
        
        updateFuel(fuel);

        System.out.println(m_make + " " + m_model + " refueled. Current fuel: " + fuel + " gallons");
    }

    public static void main(String[] args) {
        CarClass car1 = new CarClass("Toyota", "Camry", 14, 32);
        CarClass car2 = new CarClass("Ford", "F-150", 26, 20);

        car1.drive(200);
        car1.refuel(5);

        car2.drive(150);
        System.out.println(car2.getMake() + " " + car2.getModel() + " has " + car2.getCurrentFuel() + " gallons left.");

    }
}

