package com.mycompany.reversestring;

import java.util.Scanner;
import java.util.Stack;

/**
 * Programa para manipular una cadena de texto con un menú interactivo.
 * Permite invertirla, eliminar, agregar y buscar caracteres.
 */
public class ReverseString {

    /**
     * Punto de entrada. Muestra el menú y ejecuta la opción elegida
     * hasta que el usuario decida salir.
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese un String:");
        String cadena = sc.nextLine();

        int opcion = 0;

        while (opcion != 5) {

            System.out.println("\n1. Revertir String");
            System.out.println("2. Eliminar un caracter");
            System.out.println("3. Agregar un caracter");
            System.out.println("4. Buscar un caracter");
            System.out.println("5. Terminar");

            System.out.print("Digite la opcion: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpia el salto de línea que deja nextInt()

            switch (opcion) {

                // Mete cada carácter a una pila y los saca al revés
                // Ejemplo: "hola" → pila → "aloh"
                case 1 -> {
                    Stack<Character> pila = new Stack<>();

                    for (int i = 0; i < cadena.length(); i++) {
                        pila.push(cadena.charAt(i));
                    }

                    StringBuilder invertida = new StringBuilder();

                    while (!pila.isEmpty()) {
                        invertida.append(pila.pop());
                    }

                    cadena = invertida.toString();
                    System.out.println("Invertida: " + cadena);
                }

                // Elimina todas las ocurrencias del carácter ingresado
                case 2 -> {
                    System.out.print("Escriba el caracter a eliminar: ");
                    String entrada = sc.nextLine();

                    if (!entrada.isEmpty()) {
                        char c = entrada.charAt(0);
                        cadena = cadena.replace(String.valueOf(c), "");
                        System.out.println("Resultado: " + cadena);
                    }
                }

                // Agrega al final lo que el usuario escriba
                case 3 -> {
                    System.out.print("Escriba el caracter a agregar: ");
                    String c = sc.nextLine();

                    cadena += c;
                    System.out.println("Resultado: " + cadena);
                }

                // Busca el índice de la primera aparición del carácter
                case 4 -> {
                    System.out.print("Escriba el caracter a buscar: ");
                    String entrada = sc.nextLine();

                    if (!entrada.isEmpty()) {
                        char c = entrada.charAt(0);
                        int index = cadena.indexOf(c); // Devuelve -1 si no existe

                        if (index != -1) {
                            System.out.println("Se encuentra en el indice: " + index);
                        } else {
                            System.out.println("No se encuentra");
                        }
                    }
                }

                // Cualquier número fuera del menú
                default -> {
                    if (opcion != 5) {
                        System.out.println("Opcion invalida");
                    }
                }
            }
        }

        System.out.println("Programa finalizado");
        sc.close();
    }
}
