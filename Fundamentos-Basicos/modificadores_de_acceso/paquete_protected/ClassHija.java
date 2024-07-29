package modificadores_de_acceso.paquete_protected;

import modificadores_de_acceso.protegido.Class1;

public class ClassHija extends Class1 {
    public ClassHija(){
        super();
        this.atributoProtected = "Modificacion atributo protected";
        System.out.println("atributoProtected = " + this.atributoProtected);
        this.metodoProtected();
    }

}
