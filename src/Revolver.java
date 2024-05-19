public class Revolver extends Arma{

    public Revolver() {
        this.set_dano(10);
        this.set_precision(5);
    }
    
    public Revolver(int dano, int precision) {
        this.set_dano(dano);
        this.set_precision(precision);
    }
}
