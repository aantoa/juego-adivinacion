import java.util.Random;
import java.util.Scanner;

public class Main {

    public static boolean adivinar(Scanner scanner, Integer intentos, Integer aleatorio){
        boolean encontrado = false;
        while(intentos > 0){
            System.out.println("Digite su número entre 0 y 100: ");
            int valor = scanner.nextInt();

            if (valor < 0 || valor > 100) {
                System.out.println("Número fuera de rango. Ingrese un número entre 0 y 100.");
                System.out.println("------------------------------------------");
                continue;
            }

            intentos--;

            if(valor > aleatorio){
                System.out.println("El número ingresado es mayor al aleatorio");
                System.out.println("Intentos restantes: " + intentos);
                System.out.println("------------------------------------------");
            } else if(valor < aleatorio){
                System.out.println("El número ingresado es menor al aleatorio");
                System.out.println("Intentos restantes: " + intentos);
                System.out.println("------------------------------------------");
            } else{
                System.out.println("Felicidades!!! Adivino el número, este era: " + aleatorio);
                System.out.println("------------------------------------------");
                encontrado = true;
                break;
            }
        }
        return encontrado;
    }

    public static void main(String[] args) {
        System.out.println("**************************************");
        System.out.println("Bienvenidos al juego de adivinacion!");
        System.out.println("Adivine un número del 0 al 100!");
        System.out.println("**************************************");

        Scanner scanner = new Scanner(System.in);
        boolean seguirJugando = true;
        Integer intentos = 5;

        while(seguirJugando) {

            Integer aleatorio= new Random().nextInt(101);

            boolean resultado = adivinar(scanner,intentos,aleatorio);

            if(!resultado){
                System.out.println("**************************************");
                System.out.println("Fallaste el número era: " + aleatorio);
                System.out.println("**************************************");
            }

            System.out.println("¿Quieres jugar seguir jugando? (s/n): ");
            String respuesta = scanner.next();

            if (!respuesta.equalsIgnoreCase("s")) {
                seguirJugando = false;
                System.out.println("Gracias por jugar. ¡Hasta la próxima!");
            }
        }

        scanner.close();
    }
}