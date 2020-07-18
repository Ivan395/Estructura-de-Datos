package com.Ivan395;

import java.util.Scanner;
import LinkedList.LinkedList;

public class Main {

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
	mainMenu();
    }

    private static void mainMenu() {
        LinkedList<Integer> lista = new LinkedList<Integer>();
        int opt, data = 0;
        do {
            Main.menu();
            opt = in.nextInt();
            switch (opt) {
                case 1:
                    System.out.println("Ingresa el elemento a añadir");
                    data = in.nextInt();
                    lista.addStart(data);
                    break;
                case 2:
                    System.out.println("Ingresa el elemento a añadir");
                    data = in.nextInt();
                    lista.addEnd(data);
                    break;
                case 3:
                    lista.showList();
                    System.out.println("Número total de elementos: " + lista.getSize());
                    break;
                case 4:
                    if(lista.removeAtStart()) {
                        System.out.println("The element was removed");
                    }else {
                        System.out.println("The list is empty");
                    }
                    break;
                case 5:
                    if(lista.removeAtEnd()) {
                        System.out.println("The element was removed");
                    }else {
                        System.out.println("The list is empty");
                    }
                    break;
                case 6:
                    System.out.println("Escribe el elemento a eliminar");
                    data = in.nextInt();
                    if(lista.removeByValue(data)) {
                        System.out.println("The element was removed");
                    }else {
                        System.out.println("The element was not found");
                    }
                    break;
                case 7:
                    System.out.println("Enter the index to remove");
                    data = in.nextInt();
                    if(lista.removeByIndex(data)) {
                        System.out.println("The element was removed");
                    }else {
                        System.out.println("The list is empty");
                    }
                    break;
                case 8:
                    System.out.println("Escribe el elemento para buscar el indice");
                    data = in.nextInt();
                    try {
                        int result = lista.getValue(data);
                        System.out.println("Value: " + result);
                    }catch (NullPointerException ex) {
                        System.out.println("The element no exist in the list");
                    }
                    break;
                case 9:
                    System.out.println("Ingresa el elemento a buscar");
                    data = in.nextInt();
                    int result = lista.getIndexOfValue(data);
                    if(result >= 0 && result < lista.getSize()) {
                        System.out.println("Índice: " + result);
                    }else {
                        System.out.println("The element was not found");
                    }
                    break;
                case 10:
                    int sizeList = lista.getSize();
                    System.out.println("The size of the list is: " + sizeList);
                    break;
                default:
                    System.out.println("Incorrect option, please enter a new option");
                    break;

            }
        }while (opt != 11);
    }

    private static void menu() {
        StringBuilder sb = new StringBuilder();
        sb.append("***************Menú de opciones***************\n");
        sb.append("1. Agregar un elemento al inicio de la lista\n");
        sb.append("2. Agregar un elemento al final de la lista\n");
        sb.append("3. Mostrar los datos de la lista\n");
        sb.append("4. Eliminar un elemento al inicio de la lista\n");
        sb.append("5. Eliminar un elemento al final de la lista\n");
        sb.append("6. Eliminar un elemento en específico de la lista por valor\n");
        sb.append("7. Eliminar un elemento en específico de la lista por indice\n");
        sb.append("8. Buscar un elemento en la lista por índice\n");
        sb.append("9. Obtener indice de un elemento\n");
        sb.append("10. Obtener tamaño de la lista\n");
        sb.append("11. Salir\n");
        System.out.println(sb.toString());
    }
}
