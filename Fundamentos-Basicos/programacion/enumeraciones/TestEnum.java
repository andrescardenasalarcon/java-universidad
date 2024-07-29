package programacion.enumeraciones;

import javax.lang.model.SourceVersion;

public class TestEnum {
    public static void main(String[] args) {
        System.out.println("Dia 1: "+Dias.LUNES);
        imprimirDiaSemana(Dias.JUEVES);

        System.out.println("------CONTINENTES---------");
        System.out.println("continente $4 = " + Continenetes.AMERICA + ", tiene "+Continenetes.AMERICA.getPaises()+" Paises");
    }


    private static void imprimirDiaSemana(Dias dias){
        switch (dias){
            case LUNES:
                System.out.println("Dia 1: "+dias.LUNES);break;
            case MARTES: System.out.println("Dia 2: "+dias.MARTES); break;
            case MIERCOLES: System.out.println("Dia 3: "+dias.MIERCOLES); break;
            case JUEVES: System.out.println("Dia 3: "+dias.JUEVES); break;
            case VIERNES: System.out.println("Dia 3: "+dias.VIERNES); break;
            default:
                System.out.println("Dias fuera de rango laboral!!!");
                break;

        }
    }
}
