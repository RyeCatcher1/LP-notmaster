public class Tanker extends Enemigo implements Visible{
    
    // Constructor
    public Tanker(){
        this.set_vida(30);
        this.set_atk(5);
        this.set_prob_cabeza(0.4f); //la f marca que es float, pues los decimales literales por defecto son doubles
        this.set_prob_pierna(0.6f);
        this.set_prob_torso(1.0f);
    }

    public char getRepresentacion(){
        return 'K';
    }
}
