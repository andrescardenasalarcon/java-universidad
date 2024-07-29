package operaciones;

public class Aritmetica {
    //Atributos
    int a;
    int b;

    //Constructor
    public Aritmetica(){}
    public Aritmetica(int a, int b){
        this.a = a;
        this.b = b;
    }

    //Metodos
    public void sumar(){
        int rta = a + b;
        System.out.println("rta = " + rta);
    }
    public int sumarReturn(){
        return a + b;

    }public int sumarConArgs(int arg1, int arg2){
        this.a = arg1;
        this.b = arg2;
        //return a + b;
        return this.sumarReturn();
    }
}
