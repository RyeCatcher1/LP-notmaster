public class Husk extends Enemigo implements Visible {
    
    // Constructor
    public Husk(){
        this.set_vida(20);
        this.set_atk(10);
        this.set_prob_cabeza(0.3f); //la f marca que es float, pues los decimales literales por defecto son doubles
        this.set_prob_pierna(0.5f);
        this.set_prob_torso(0.9f);
    }


    public char getRepresentacion(){
        return 'H';
    }
}
