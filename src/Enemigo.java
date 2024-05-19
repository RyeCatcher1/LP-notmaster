public abstract class Enemigo{
    private int vida;
    private int atk;
    private float prob_torso;
    private float prob_pierna;
    private float prob_cabeza;


    //No estoy seguro si este metodo deberia implementarse aqui... creo que no?
    //public char getRepresentacion(){
    //    return 'E';
    //}

    public int get_vida(){
        return this.vida;
    }

    public void set_vida(int vida){
        this.vida=vida;

    }

    public int get_atk(){
        return this.atk;
    }

    public void set_atk(int atk){
        this.atk=atk;

    }
    public float get_prob_torso(){
        return this.prob_torso;
    }

    public void set_prob_torso(float prob_torso){
        this.prob_torso=prob_torso;

    }


    public float get_prob_pierna(){
        return this.prob_pierna;
    }

    public void set_prob_pierna(float prob_pierna){
        this.prob_pierna=prob_pierna;

    }

    public float get_prob_cabeza(){
        return this.prob_cabeza;
    }

    public void set_prob_cabeza(float prob_cabeza){
        this.prob_cabeza=prob_cabeza;

    }
}
