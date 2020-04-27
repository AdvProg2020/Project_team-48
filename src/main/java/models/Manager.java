package models;

import java.util.ArrayList;

public class Manager extends Account {
    public static ArrayList<Manager> allManagers;

    public Manager(String username, String password, String firstName, String lastName, String email, int phoneNumber) {
        super(username, password, firstName, lastName, email, phoneNumber);
    }

    public void addManager(Manager manager){
        allManagers.add(manager);
    }
}
