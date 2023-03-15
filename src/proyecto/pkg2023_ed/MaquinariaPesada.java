
package proyecto.pkg2023_ed;

/**
 *
 * @author Joel Lopez
 */
public class MaquinariaPesada {
    private int id;
    private int motorCarga;
    private int carroceriaEspecial;
    private int llantasUnicas;

    public MaquinariaPesada() {
    }

    public MaquinariaPesada(int motorCarga, int carroceriaEspecial, int llantasUnicas) {
        this.id = 2;
        this.motorCarga = motorCarga;
        this.carroceriaEspecial = carroceriaEspecial;
        this.llantasUnicas = llantasUnicas;
    }

    public int getMotorCarga() {
        return motorCarga;
    }

    public void setMotorCarga(int motorCarga) {
        this.motorCarga = motorCarga;
    }

    public int getCarroceriaEspecial() {
        return carroceriaEspecial;
    }

    public void setCarroceriaEspecial(int carroceriaEspecial) {
        this.carroceriaEspecial = carroceriaEspecial;
    }

    public int getLlantasUnicas() {
        return llantasUnicas;
    }

    public void setLlantasUnicas(int llantasUnicas) {
        this.llantasUnicas = llantasUnicas;
    }

    @Override
    public String toString() {
        return "CarroCarga{" + "motorCarga=" + motorCarga + ", carroceriaEspecial=" + carroceriaEspecial + ", llantasUnicas=" + llantasUnicas + '}';
    }
}
