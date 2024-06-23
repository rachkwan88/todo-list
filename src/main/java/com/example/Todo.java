package com.example;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Todo {

    private String filename;

    public Todo(String filename) {
        this.filename = filename;
    }

    public void saveItemsToFile(ArrayList<String> items) {
        try {
            FileWriter fWriter = new FileWriter(this.filename);
            for (int i = 0; i < items.size(); i++) {
                fWriter.write(items.get(i) + "\n");
            }
            fWriter.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public int size() {
        ArrayList<String> items = this.list();
        return items.size();
    }

    public ArrayList<String> list() {
        ArrayList<String> todo = new ArrayList<String>();
        try {
            File myFile = new File(this.filename);
            Scanner reader = new Scanner(myFile);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                todo.add(data);
            }
            reader.close();

        } catch (Exception e) {
            // TODO: handle exception
        }
        return todo;
    }

    public String add(String name) {
        // Read all the existing items from file
        ArrayList<String> existingItems = this.list();
        // Add new items to the end of the list
        existingItems.add(name);
        this.saveItemsToFile(existingItems);
        return name;

    }

    public void remove(int itemId) {
        // Get content in arraylist
        ArrayList<String> items = this.list();
        // remove itemId th element
        items.remove(itemId);
        // save arraylist to file
        this.saveItemsToFile(items);
    }

    public String edit(int itemId, String name) {
        // Read existing items from file
        ArrayList<String> items = this.list();
        // Replace the itemId
        items.set(itemId, name);
        // save arraylist to file
        this.saveItemsToFile(items);

        return name;
    }

}
