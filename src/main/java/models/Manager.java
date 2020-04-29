package models;

import java.util.ArrayList;

public class Manager extends Account {
    public static ArrayList<Manager> allManagers;

    public Manager(String username) {
        super(username);
    }

    public void addManager(Manager manager){
        allManagers.add(manager);
    }
}
