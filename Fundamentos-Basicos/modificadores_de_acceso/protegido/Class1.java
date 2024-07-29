package modificadores_de_acceso.protegido;

public class Class1 {
    protected String atributoProtected = "Val atributo Protected";

    protected Class1(){
        System.out.println("Constructor Protected");
    }

    public Class1(String args){
        System.out.println("Constructor Public");
    }

    protected  void metodoProtected(){
        System.out.println("Metodo Protected");
    }
}
