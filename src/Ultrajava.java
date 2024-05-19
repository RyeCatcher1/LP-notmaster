import java.util.ArrayList; // or LinkedList, Vector, etc.
import java.util.List;
import java.util.Scanner;

public class Ultrajava {
    public static void main(String[] args) {
        int numero_de_rondas = 3;
        int tamano = 15;
        Arena arenita = new Arena(0, tamano);

        Terminal terminalcita = new Terminal();
        Jugador jugadorcito = new Jugador(100,3,0);

        Visible[] mapita = arenita.get_mapa();

        mapita[7] = jugadorcito;
        mapita[8] = terminalcita;
        arenita.set_mapa(mapita);

        arenita.nuevaRonda();
        arenita.mostrar();

        int mult=1; //factor daño enemigos (ver hechizo Disociar)
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        int dmg=0;
        //int vid=0;
        boolean avanzar = true;
        while(flag){
            avanzar = true;
            //crear lista con los strings que quiero printear
            List<String> imprimir = new ArrayList<>();
            imprimir.add("Ver estadística");

            int pos = arenita.buscar_jugador();
            System.out.print("Elige una opción:\n");
            if(true){
            imprimir.add("Mover izquierda");
            }
            if(true){
                imprimir.add("Mover derecha");
            }
            if(pos>0 && mapita[pos-1] instanceof Terminal){
                imprimir.add("Interactuar terminal izquierda");
            }
            else if(pos>0 && mapita[pos-1] instanceof Enemigo){
                imprimir.add("Atacar enemigo izquierda");
            }
            if(pos<14 && mapita[pos+1] instanceof Terminal){ //usamos el cortocircuito para no tener problemas con salir del mapa
                imprimir.add("Interactuar terminal derecha");
            }
            else if(pos <14 && mapita[pos+1] instanceof Enemigo){
                imprimir.add("Atacar enemigo derecha");
            }
            //imprimir.add("Interactuar terminal");
            imprimir.add("Hechizos");
            imprimir.add("Mostrar mapa");
            imprimir.add("Salir del juego");


            for (int i = 0; i < imprimir.size(); i++) {
                System.out.println(i+1 + "- " + imprimir.get(i));
            }


            int number = scanner.nextInt();

            //System.out.println("You entered: " + number);
            String option = imprimir.get(number-1);

            if(option=="Ver estadística"){ //Por el momento ver estadistica da tiempo a los enemigos de efectuar daño
                System.out.println("vida es: " + jugadorcito.get_vida());
                System.out.println("P_points es: " + jugadorcito.get_P_points());
                System.out.println("energía es: " + jugadorcito.get_energia());
                System.out.println("lista de armas es:");
                for(Arma item: jugadorcito.get_Armas()){
                    System.out.println("-" + item.getClass().getName());
                    System.out.println(" -" + "Daño:" + item.get_dano());
                    System.out.println(" -" + "Precisión:" + item.get_precision());
                    if(item instanceof Escopeta){
                        System.out.println(" -" + "Perdigones:" + ((Escopeta)item).get_perdigones());
                    }
                }
                avanzar = false;
    
            }
            else if(option=="Mover izquierda"){
                arenita.mover_jugador_izq();
            }
            else if(option=="Mover derecha"){
                arenita.mover_jugador_der();
            }
            else if(option=="Salir del juego"){
                flag = false;
            }
            else if(option == "Atacar enemigo derecha"){

                dmg = (int)jugadorcito.Disparar((Enemigo)(mapita[pos+1]));
                System.out.println("Se efectuó " + dmg +" daño al enemigo derecho");
                if(dmg>0){
                    jugadorcito.set_P_Points(jugadorcito.get_P_points()+10);
                }
            }
            else if(option == "Atacar enemigo izquierda"){
                //vid = ((Enemigo)(mapita[pos-1])).get_vida();
                dmg = (int)jugadorcito.Disparar((Enemigo)(mapita[pos-1]));
                //System.out.println("Se efectuó " + dmg +" daño al enemigo izquierdo (pasó de " + vid + " de vida a " + ((Enemigo)(mapita[pos-1])).get_vida() + " de vida");
                if(dmg>0){
                    jugadorcito.set_P_Points((int)(jugadorcito.get_P_points()+jugadorcito.Disparar((Enemigo)(mapita[pos-1]))));
                }
            }
            else if(option == "Interactuar terminal"){

            }
            else if(option == "Interactuar terminal"){

            }
            else if(option == "Hechizos"){
                System.out.println("Lista de hechizos (2 de energía cada uno):");
            System.out.println(1 +"- Cenizas: 10 de daño global.");
            System.out.println(2  +"- Disociar: Pierde la mitad de la vida restante, pero los enemigos causan la mitad de daño por el resto de la partida");
            System.out.println(3  +"- if(false): No hace nada... ¿o sí?");
            System.out.println(4 + "- Salir (Nota: Al comprar está expuesto al daño enemigo, mas no al salir del menú)");

            number = scanner.nextInt();
            if(jugadorcito.get_energia()<2){
                System.out.println("No se tiene suficiente energía");
            }

            if(number==1 && jugadorcito.get_energia()>=2){
                jugadorcito.set_energia(jugadorcito.get_energia()-2);
                for (int i = 0; i < tamano; i++){
                    if(mapita[i] instanceof Enemigo){
                        ((Enemigo)mapita[i]).set_vida( ((Enemigo)mapita[i]).get_vida()-10);
                    }
            }}
            else if(number==2 && jugadorcito.get_energia()>=2){
                jugadorcito.set_energia(jugadorcito.get_energia()-2);
                jugadorcito.set_vida(jugadorcito.get_vida()/2);
                mult = 2;
            }
            else if(number==3 && jugadorcito.get_energia()>=2){
                jugadorcito.set_energia(jugadorcito.get_energia()-2);
                System.out.println(3  +"- NaN... ¿o YaN...?");
                //efectivamente no hace nada
            }
            else if (number==4){
                avanzar = false;
            }
            else{
                System.out.println("Error");
            }
        }
            else if(option== "Mostrar mapa"){
                arenita.mostrar();
                avanzar = false;
            }
            else if(option== "Interactuar terminal izquierda" || option== "Interactuar terminal derecha"){
                System.out.println("Lista de venta:");
                for (int i = 0; i < terminalcita.get_armas_disponibles().size(); i++) {
                    Arma item =  terminalcita.get_armas_disponibles().get(i);
                    System.out.println(i+1+"- " + item.getClass().getName());
                    System.out.println("   -" + "Precio: " + item.get_dano() + item.get_precision() + " P_Points");
                    System.out.println("   -" + "Daño:" + item.get_dano());
                    System.out.println("   -" + "Precisión:" + item.get_precision());
                    if(item instanceof Escopeta){
                        System.out.println("   -" + "Perdigones:" + ((Escopeta)item).get_perdigones());
                    }
            }
            System.out.println(terminalcita.get_armas_disponibles().size() + 1 +"- Comprar 50 vida por 50 P_Points:");
            System.out.println(terminalcita.get_armas_disponibles().size() + 2  +"- Comprar 1 energía por 10 P_Points:");
            System.out.println(terminalcita.get_armas_disponibles().size() + 3 + "- Salir de terminal (Nota: Al comprar está expuesto al daño enemigo, mas no al salir de la terminal)");

            number = scanner.nextInt();
            if(number <terminalcita.get_armas_disponibles().size()+1){
                terminalcita.ComprarArma(jugadorcito,terminalcita.get_armas_disponibles().get(number-1),(int)(terminalcita.get_armas_disponibles().get(number-1).get_dano() + terminalcita.get_armas_disponibles().get(number-1).get_precision()));
            }
            else if(number==terminalcita.get_armas_disponibles().size() + 2){
                terminalcita.ComprarEnergia(jugadorcito);
            }
            else if(number==terminalcita.get_armas_disponibles().size() + 1){
                terminalcita.ComprarVida(jugadorcito);
            }
            else if (number==terminalcita.get_armas_disponibles().size() + 3){
                avanzar = false;
            }
            else{
                System.out.println("Error");
            }
        }


        dmg = 0;
        if(pos>0 && mapita[pos-1] instanceof Enemigo){
            dmg = dmg + ((Enemigo)mapita[pos-1]).get_atk();
        }
        if(pos<14 && mapita[pos+1] instanceof Enemigo){
            dmg = dmg + ((Enemigo)mapita[pos+1]).get_atk();
        }

            jugadorcito.set_P_Points(arenita.quitar_enemigos_muertos()*30 + jugadorcito.get_P_points());



            if(avanzar){
            if(flag){
            jugadorcito.recibirDano((dmg/mult));
            }


            arenita.mostrar();
            if(jugadorcito.get_vida()<=0){
                flag = false;
                System.out.println("Derrota");
            }


            //arenita.set_ronda(arenita.get_ronda()+1); debe ir en el metodo nueva_ronda

            if(flag && arenita.contar_enemigos()==0){
                arenita.nuevaRonda();
                if(arenita.get_ronda()>numero_de_rondas){
                    System.out.println("\nVICTORIA!!");
                    flag = false;
                }
                if(flag){
                System.out.println("Se pasa a la siguiente Ronda");
                arenita.mostrar();
                }
                //scanner.close();
            }
        }
        }
        scanner.close();
    }
}

