package arrays.foreach;

public class ForEach {
    public static void main(String[] args) {
        int edades[] = {1, 21, 4, 7, 8, 10};

        for (int edad : edades) {
            System.out.println("edad = " + edad);
        }

        Person personas[] = {new Person("Andres"), new Person("Juan"), new Person("Karla")};

        /*for (Object persona: personas){ --> tambien se puede usando el tipo Object pero no es tan bien visto*/
        for (Person persona: personas){
            System.out.println("persona = " + persona);
        }
    }
}
