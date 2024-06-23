package com.example;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Todo todo = new Todo("todo.txt");

        // show available commands (e.g. add, list, edit, remove)
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter in command (add/exit/list/remove/edit/filename): ");
            String userInput = scanner.nextLine();
            // add
            if (userInput.equals("add")) {
                System.out.println("What would you like to add? : ");
                String item_add = scanner.nextLine();
                todo.add(item_add);
            }
            // list
            if (userInput.equals("list")) {
                ArrayList<String> items = todo.list();
                for (int i = 0; i < items.size(); i++) {
                    System.out.println(i + " " + items.get(i));
                }
            }
            // exit
            if (userInput.equals("exit")) {
                System.exit(0);
            }
            // remove
            if (userInput.equals("remove")) {
                System.out.println("Which item id do you want to remove? : ");

                try {
                    int itemIdToRemove = Integer.parseInt(scanner.nextLine());
                    int size = todo.size();
                    if (itemIdToRemove >= size || itemIdToRemove < 0) {
                        System.out.println("Error: id is out of range");
                        continue;
                    }
                    todo.remove(itemIdToRemove);
                } catch (Exception e) {
                    System.out.println("Error: id is out of range");
                    continue;
                }
                // edit
            }
            if (userInput.equals("edit")) {
                System.out.println("Which item id do you want to edit? : ");
                try {
                    int itemIdToEdit = Integer.parseInt(scanner.nextLine());
                    int size = todo.size();
                    if (itemIdToEdit >= size || itemIdToEdit < 0) {
                        System.out.println("Error: id is out of range");
                        continue;
                    }
                    System.out.println("What do you want to rename it?: ");
                    String newItemName = scanner.nextLine();
                    todo.edit(itemIdToEdit, newItemName);
                } catch (Exception e) {
                    System.out.println("Error: id is out of range");
                    continue;
                }
            }
            // filename
            if (userInput.equals("filename")) {
                System.out.println("Enter new filename: ");
                String newFileName = scanner.nextLine();
                todo = new Todo(newFileName);
            }
        }

    }
}
