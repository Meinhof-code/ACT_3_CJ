import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class Deck {

    //Lista de cartas del mazo
    private List<Card> cards;

    public Deck(){
        cards = new ArrayList<>(); //Se crea un arreglo para la lista de cartas
        crearDeck(); // Se inicia el mazo creando todas las cartas
    }
    //Se crea el método para poder crear el mazo mediante 3 arreglos
    private void crearDeck() {
        String[] palos = {"Picas", "Treboles", "Corazones", "Diamantes"};
        String[] colores = {"Negro","Negro","Rojo","Rojo"};
        String[] valores = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    /*Iteración entre los arreglos del método crearDeck() para que se
      puedan crear las cartas*/
        for (int i = 0; i < palos.length; i++){
            String palo = palos[i];
            String color = colores[i];
            //Crear una carta nueva con palo, color y valor
            for (String valor : valores){
                Card card = new Card(palo,color,valor);
                //Agregar la carta nueva a la lista de cartas
                cards.add(card);
            }
        }
    }
    //Método getter y setter para la lista del mazo
    public List<Card> getCards(){
        return cards;
    }

    public void setCards(List<Card> cards){
        this.cards = cards;
    }

    //Método para revolver el mazo
    public void shuffle(){
        if (cards.isEmpty()){
            System.out.println("+-----------------------------------------+");
            System.out.println("|           El mazo está vacío            |");
            System.out.println("+-----------------------------------------+");
        } else {
            Collections.shuffle(cards);
            System.out.println("+-----------------------------------------+");
            System.out.println("|           Se mezcló el deck             |");
            System.out.println("+-----------------------------------------+");
        }
    }
    //Método para sacar la primera carta del mazo
    public void head(){
        if (cards.isEmpty()){
            System.out.println("+-----------------------------------------+");
            System.out.println("|           El mazo está vacío            |");
            System.out.println("+-----------------------------------------+");
        } else {
            Card primeraCard = cards.remove(0);
            System.out.println("+-----------------------------------------+");
            System.out.println("| " +primeraCard.getPalo() + ", " + primeraCard.getColor() + ", " + primeraCard.getValor() + "                        |");
            System.out.println("| Quedan " + cards.size() + " cartas en el mazo             |");
            System.out.println("+-----------------------------------------+");
        }
    }
    //Método para sacar una carta aleatoria del mazo
    public void pick(){
        if (cards.isEmpty()){
            System.out.println("+-----------------------------------------+");
            System.out.println("|           El mazo está vacío            |");
            System.out.println("+-----------------------------------------+");
        } else {
            Random random = new Random();
            int index = random.nextInt(cards.size());
            Card pickCard = cards.remove(index);
            System.out.println("+-----------------------------------------+");
            System.out.println("| " + pickCard.getPalo() + ", " + pickCard.getColor() + ", " + pickCard.getValor() +"                      |");
            System.out.println("| Quedan " + cards.size() + " cartas en el mazo             |");
            System.out.println("+-----------------------------------------+");

        }
    }
    //Método para recibir una mano de 5 cartas
    public List<Card> hand() {
        List<Card> hand = new ArrayList<>();
        if(cards.size()<5){
            System.out.println("+-----------------------------------------+");
            System.out.println("|  No hay suficientes cartas en el mazo   |");
            System.out.println("+-----------------------------------------+");
            return hand;
        }

        Random random = new Random();
        for(int i = 0; i<5; i++){
            int index = random.nextInt(cards.size());
            Card card = cards.remove(index);
            hand.add(card);
            System.out.println("+-----------------------------------------+");
            System.out.println("| " + card.getPalo() + " " + card.getColor() + " " + card.getValor()+ "                        |");
        }
        System.out.println("|                                         |");
        System.out.println("+-----------------------------------------+");
        System.out.println("| Quedan " + cards.size() + " cartas en el mazo             |");
        System.out.println("+-----------------------------------------+");
        return hand;
    }

    public static void main (String[] args){
        //Crear un nuevo mazo
        Deck deck = new Deck();
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("+-----------------------------------------+");
            System.out.println("| ¿Qué desea realizar?                    |");
            System.out.println("| 1. Ver el mazo                          |");
            System.out.println("| 2. Revolver el mazo                     |");
            System.out.println("| 3. Sacar la primera carta del mazo      |");
            System.out.println("| 4. Sacar una carta aleatoria del mazo   |");
            System.out.println("| 5. Recibir 5 cartas                     |");
            System.out.println("| 0. Salir                                |");
            System.out.println("+-----------------------------------------+");

            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion){
                case 1:
                    //ver el mazo
                    List<Card> cards = deck.getCards();
                    //Iterar sobre las cartas para mostrarlas
                    System.out.println("+-----------------------------------------+");
                    for (Card card : cards){
                        System.out.println("| Palo: " + card.getPalo() + " , Color: " + card.getColor() + ", Valor: " + card.getValor()+ " |");
                    }
                    System.out.println("+-----------------------------------------+");
                    break;
                case 2:
                    //Revolver el mazo
                    deck.shuffle();
                    break;
                case 3:
                    //Sacar la primera carta del mazo
                    deck.head();
                    break;
                case 4:
                    //Sacar una carta aleatoria del mazo
                    deck.pick();
                    break;
                case 5:
                    //Recibir 5 cartas
                    deck.hand();
                    break;
                case 0:
                    System.out.println("Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;

            }
            System.out.println();
        } while (opcion != 0);
      }
    }
