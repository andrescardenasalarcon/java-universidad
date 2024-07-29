package programacion.enumeraciones;

public enum Continenetes {
    AFRICA(53),
    EUROPA(43),
    ASIA(34),
    AMERICA(44),
    OCEANIA(14);

    private final int paises;
    //Definimos un costructor para asignar los paises a nuestos enum de Continentes
    Continenetes(int paises){
        this.paises = paises;
    }

    public int getPaises() {
        return this.paises;
    }
}
