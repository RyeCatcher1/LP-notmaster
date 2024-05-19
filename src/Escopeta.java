public class Escopeta extends Arma{
    int perdigones = 5;

    public Escopeta() {
        this.set_dano(10);
        this.set_precision(5);
    }

    public Escopeta(int dano, int precision) {
        this.set_dano(dano);
        this.set_precision(precision);
    }


    public int get_perdigones(){
        return this.perdigones;
    }

    public void set_health(int perdigones){
        this.perdigones=perdigones;

    }
}