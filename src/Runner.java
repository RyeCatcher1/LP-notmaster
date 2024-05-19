public class Runner extends Enemigo implements Visible{
    

    // Constructor
    public Runner(){
        this.set_vida(10);
        this.set_atk(20);
        this.set_prob_cabeza(0.2f); //la f marca que es float, pues los decimales literales por defecto son doubles
        this.set_prob_pierna(0.4f);
        this.set_prob_torso(0.8f);
    }

    public char getRepresentacion(){
        return 'R';
    }
}
