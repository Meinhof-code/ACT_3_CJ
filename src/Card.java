public class Card {
    //Definición de atributos
    private String palo, valor, color;

    //Creando un constructor
    public Card(String palo, String color, String valor){
        this.palo = palo;
        this.color = color;
        this.valor = valor;
    }

    /*Implementación de los métodos getter y setter,
    para cada uno de los atributos de la calse card*/
    public String getPalo(){
        return palo;
    }

    public void setPalo(String palo){
        this.palo = palo;
    }

    public String getColor(){
        return color;
    }

    public void setColor(String color){
        this.color = color;
    }
    public String getValor(){
        return valor;
    }
    public void setValor(String valor){
        this.valor = valor;
    }


}
