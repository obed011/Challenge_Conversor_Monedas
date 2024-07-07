import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("********************************************");
        System.out.println("Sea Bienvenido/a al conversor de monedas\n");
        Scanner lectura = new Scanner(System.in);
        ConsultarMoneda moneda = new ConsultarMoneda();
        int opcion=0;
        while (opcion!=7){
            System.out.println("1) Dolar =>> Peso Argentino");
            System.out.println("2) Peso Argentino =>> Dolar");
            System.out.println("3) Dolar =>> Real Brasileño");
            System.out.println("4) Real Brasileño =>> Dolar");
            System.out.println("5) Dolar =>> Peso Colombiano");
            System.out.println("6) Peso Colombiano =>> Dolar");
            System.out.println("7) Salir");
            System.out.println("Elija una opcion valida: ");
            System.out.println("*****************************************\n");
            opcion = lectura.nextInt();

            switch (opcion){
                case 1:
                    moneda.imprimirResultado("USD","ARS",lectura);
                    break;
                case 2:
                    moneda.imprimirResultado("ARS", "USD",lectura);
                    break;
                case 3:
                    moneda.imprimirResultado("USD","BRL",lectura);
                    break;
                case 4:
                    moneda.imprimirResultado("BRL","USD",lectura);
                    break;
                case 5:
                    moneda.imprimirResultado("USD","COP",lectura);
                    break;
                case 6:
                    moneda.imprimirResultado("COP","USD",lectura);
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Opcion no valida, intente nuevamente\n");
            }
            if (opcion==7){
                System.out.println("Gracias por usar nuestro programa, hasta pronto!!!");
            }
        }
    }
}