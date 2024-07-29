package javabean.test;

import javabean.domein.Persona;

public class TestJavaBean {
    public static void main(String[] args) {
        Persona persona = new Persona();
        persona.setNombre("Andrés");
        persona.setApellido("Cárdenas");
        System.out.println(persona.toString());

    }
}
