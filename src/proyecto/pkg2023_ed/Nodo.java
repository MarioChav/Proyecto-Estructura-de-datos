
package proyecto.pkg2023_ed;

/**
 *
 * @author Joel Lopez
 */
public class Nodo {
    private CarroCarga carCarga;
    private MaquinariaPesada maqPesada;
    private SuperAuto sAuto;
    private Nodo next;

    public Nodo(CarroCarga carCarga, MaquinariaPesada maqPesada, SuperAuto sAuto) {
        this.carCarga = carCarga;
        this.maqPesada = maqPesada;
        this.sAuto = sAuto;
    }

    public CarroCarga getCarCarga() {
        return carCarga;
    }

    public void setCarCarga(CarroCarga carCarga) {
        this.carCarga = carCarga;
    }

    public MaquinariaPesada getMaqPesada() {
        return maqPesada;
    }

    public void setMaqPesada(MaquinariaPesada maqPesada) {
        this.maqPesada = maqPesada;
    }

    public SuperAuto getsAuto() {
        return sAuto;
    }

    public void setsAuto(SuperAuto sAuto) {
        this.sAuto = sAuto;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Nodo{" + "carCarga=" + carCarga + ", maqPesada=" + maqPesada + ", sAuto=" + sAuto + ", next=" + next + '}';
    }
    
}
