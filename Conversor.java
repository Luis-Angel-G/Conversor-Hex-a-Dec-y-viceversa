import java.util.Scanner;

/**
 * Clase principal para ejecutar el programa de conversión de números
 * hexadecimales a decimales y de decimales a hexadecimales.
 * Gestiona la interacción con el usuario y las funcionalidades de conversión.
 * 
 * @Project : Conversor de Números
 * @Author : Luis Girón y Juan Gualim
 *         Creación : 28.02.2025
 *         Última modificación : 28.02.2025
 * @File Name: Conversor.java
 */
public class Conversor {
    /**
     * Método principal que ejecuta el programa.
     * 
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        int opcion = 0;

        System.out.println(
                "Bienvenido al conversor de números hexadecimales a decimales y de decimales a hexadecimales.");
        while (continuar) {
            System.out.println("Por favor, seleccione una opción:");
            System.out.println("1. Hexadecimal a decimal");
            System.out.println("2. Decimal a hexadecimal");
            System.out.println("3. Salir");
            if (!scanner.hasNextInt()) {
                System.out.println("La opción ingresada no es un número.");
                scanner.nextLine();
                continue;
            }

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Por favor, ingrese el número hexadecimal de 3 dígitos");
                    String hexadecimal = scanner.next();
                    if (hexadecimal.length() <= 3) {
                        Integer dec;
                        try {
                            dec = Integer.parseInt(hexadecimal, 16);
                        } catch (NumberFormatException e) {
                            System.out.println(
                                    "El número ingresado contiene caracteres que no son den sistema hexadecimal.");
                            continue;
                        }
                        System.out.println("El número decimal es: " + dec);
                    } else {
                        System.out.println("El número tiene más de 3 dígitos.");
                    }
                    break;
                case 2:
                    System.out
                            .println("Por favor, ingrese el número decimal a representar en 3 dígitos hexadecimales:");
                    int decimal;
                    if (!scanner.hasNextInt()) {
                        System.out.println("La opción ingresada no es un número.");
                        scanner.nextLine();
                        continue;
                    }

                    decimal = scanner.nextInt();
                    scanner.nextLine();
                    if (decimal > -1 && decimal < 4096) {
                        String hex;
                        try {
                            hex = Integer.toHexString(decimal).toUpperCase();
                            hex = String.format("%3s", hex).replace(' ', '0');
                        } catch (NumberFormatException e) {
                            System.out.println("El número ingresado no es un número decimal.");
                            break;
                        }
                        System.out.println("El número hexadecimal es: " + hex);
                    } else {
                        System.out.println("El número no se puede representar en 3 dígitos hexadecimales.");
                    }
                    break;
                case 3:
                    System.out.println("Gracias por usar el conversor.");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
        scanner.close();
    }
}