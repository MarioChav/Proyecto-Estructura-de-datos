
package proyecto.pkg2023_ed;

/**
 *
 * @author Joel Lopez
 */
public class SuperAuto {
    private int motorDeportivo;
    private int carroceria;

    public SuperAuto() {
    }

    public SuperAuto(int motorDeportivo, int carroceria) {
        this.motorDeportivo = motorDeportivo;
        this.carroceria = carroceria;
    }

    public int getMotorDeportivo() {
        return motorDeportivo;
    }

    public void setMotorDeportivo(int motorDeportivo) {
        this.motorDeportivo = motorDeportivo;
    }

    public int getCarroceria() {
        return carroceria;
    }

    public void setCarroceria(int carroceria) {
        this.carroceria = carroceria;
    }

    @Override
    public String toString() {
        return "SuperAuto{" + "motorDeportivo=" + motorDeportivo + ", carroceria=" + carroceria + '}';
    }
    
}
