package com.Ivan395;

import java.util.Scanner;
import DoublyLinkedList.DoublyLinkedList;

public class Main {

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
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
}
