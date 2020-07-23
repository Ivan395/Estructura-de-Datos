package com.Ivan395;

import java.util.Scanner;
import LinkedList.LinkedList;
import DoublyLinkedList.DoublyLinkedList;
import Stack.Stack;
import Queue.Queue;

public class Main {

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        queueMenu();
    }

    private static void mainMenu() {
        LinkedList<Integer> lista = new LinkedList<Integer>();
        int opt, data = 0;
        do {
            Main.menuSimpleLinkedList();
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

    private static void menuSimpleLinkedList() {
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
        menu();
    }

    private static void menu() {
        DoublyLinkedList<Integer> lista = new DoublyLinkedList<Integer>();
        int opt, data = 0;
        do {
            options();
            opt = in.nextInt();
            switch (opt) {
                case 1 -> {
                    System.out.println("Enter the data");
                    data = in.nextInt();
                    lista.addStart(data);
                }
                case 2 -> {
                    System.out.println("Enter the data");
                    data = in.nextInt();
                    lista.addEnd(data);
                }
                case 3 -> lista.showDataFromStart();
                case 4 -> lista.showDatafromEnd();
                case 5 -> {
                    if(lista.removeAtStart()) {
                        System.out.println("The first element was removed");
                    }else {
                        System.out.println("The list is empty");
                    }
                }
                case 6 -> {
                    if(lista.removeAtEnd()) {
                        System.out.println("The first element was removed");
                    }else {
                        System.out.println("The list is empty");
                    }
                }
                case 7 -> {
                    System.out.println("Enter the index to remove");
                    data = in.nextInt();
                    if(lista.removeByIndex(data, false)) {
                        System.out.println("The element in the index " + data + " was removed");
                    }else {
                        System.out.println("The list is empty");
                    }
                }
                case 8 -> {
                    System.out.println("Enter the index to remove");
                    data = in.nextInt();
                    if(lista.removeByIndex(data, true)) {
                        System.out.println("The element in the index " + data + " was removed");
                    }else {
                        System.out.println("The list is empty");
                    }
                }
                case 9 -> {
                    System.out.println("Enter the value to remove");
                    data = in.nextInt();
                    if(lista.removeByValue(data)) {
                        System.out.println("The element " + data + " was removed");
                    }else {
                        System.out.println("The element is not in the list");
                    }
                }
                case 10 -> {
                    System.out.println("Enter the index");
                    data = in.nextInt();
                    try {
                        int value = lista.getValue(data);
                        System.out.println(value);
                    }catch (NullPointerException ex) {
                        System.out.println("The index is not available");
                    }
                }
                case 11 -> {
                    System.out.println("Enter the value");
                    data = in.nextInt();
                    int index = lista.getIndex(data);
                    if(index >= 0) {
                        System.out.println("The index is " + index);
                    }else {
                        System.out.println("The element no exist in the list");
                    }
                }
                case 12 -> {
                    int size = lista.getSize();
                    System.out.println("The size is: " + size);
                }
                default -> System.out.println("Option is not valid, try again");
            }
        }while (opt != 13);
    }

    private static void options() {
        StringBuilder sb = new StringBuilder();
        sb.append("*************** Menu ***************\n");
        sb.append("1. Add to the start\n");
        sb.append("2. Add to the end\n");
        sb.append("3. Show List from start to end\n");
        sb.append("4. Show List from end to start\n");
        sb.append("5. Remove the first element\n");
        sb.append("6. Remove the last element\n");
        sb.append("7. Remove by index from start to end\n");
        sb.append("8. Remove by index from end to start\n");
        sb.append("9. Remove by value\n");
        sb.append("10. Get element by index\n");
        sb.append("11. Get index of an element\n");
        sb.append("12. Get size of the linked list\n");
        sb.append("13. Exit\n");
        System.out.println(sb.toString());
    }

    private static void stackMenu() {
        Stack<Integer> stack = new Stack<Integer>();
        int opt, data = 0;
        do {
            stackOptions();
            opt = in.nextInt();
            switch (opt) {
                case 1 -> {
                    System.out.println("Add an element in the stack");
                    data = in.nextInt();
                    stack.push(data);
                }
                case 2 -> System.out.println(stack.isEmpty());
                case 3 -> System.out.printf("The size of the stack is: %d\n", stack.getSize());
                case 4 -> stack.showList();
                case 5 -> {
                    try {
                        int result = stack.pop();
                        System.out.println("The element " + result + " was removed");
                    }catch (NullPointerException ex) {
                        System.out.println("The stack is empty");
                    }
                }
                case 6 -> System.out.println("The top element is: " + stack.topElement());
                case 7 -> {
                    System.out.println("The stack was clear");
                    stack.clear();
                }
            }
        }while (opt != 8);
    }

    private static void stackOptions(){
        StringBuilder sb = new StringBuilder();
        sb.append("1. Add element to the stack\n");
        sb.append("2. Verify if the stack is empty\n");
        sb.append("3. Get the size of the stack\n");
        sb.append("4. Show the data of the stack\n");
        sb.append("5. Remove the last element of the stack\n");
        sb.append("6. Get the top element in the stack\n");
        sb.append("7. Clear stack (Remove all elements in the stack)\n");
        sb.append("8. Exit\n");
        System.out.println(sb.toString());
    }

    private static void queueMenu() {
        Queue<Integer> queue = new Queue<Integer>();
        int opt, data = 0;
        do {
            queueOptions();
            opt = in.nextInt();
            switch (opt) {
                case 1 -> {
                    System.out.println("Add element at the end of the queue");
                    data = in.nextInt();
                    queue.enqueue(data);
                }
                case 2 -> System.out.println(queue.isEmpty());
                case 3 -> System.out.println("The size of the queue is: " + queue.getSize());
                case 4 -> queue.showList();
                case 5 -> queue.dequeue();
            }
        }while (opt != 6);
    }

    private static void queueOptions(){
        StringBuilder sb = new StringBuilder();
        sb.append("1. Add element to the queue\n");
        sb.append("2. Verify if the queue is empty\n");
        sb.append("3. Get the size of the queue\n");
        sb.append("4. Show the data of the queue\n");
        sb.append("5. Remove the first element of the queue\n");
        sb.append("6. Exit\n");
        System.out.println(sb.toString());
    }
}
