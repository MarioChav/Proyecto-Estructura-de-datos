
package proyecto.pkg2023_ed;

/**
 *
 * @author Joel Lopez
 */
public class CarroCarga {
    private int id;
    private int motorCarga;
    private int carroceria;

    public CarroCarga() {
    }

    public CarroCarga(int id, int motorCarga, int carroceria) {
        this.id = 1;
        this.motorCarga = motorCarga;
        this.carroceria = carroceria;
    }

    public int getMotorCarga() {
        return motorCarga;
    }

    public void setMotorCarga(int motorCarga) {
        this.motorCarga = motorCarga;
    }

    public int getCarroceria() {
        return carroceria;
    }

    public void setCarroceria(int carroceria) {
        this.carroceria = carroceria;
    }

    @Override
    public String toString() {
        return "CarroCarga{" + "motorCarga=" + motorCarga + ", carroceria=" + carroceria + '}';
    }
    
}
