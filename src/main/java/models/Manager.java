package models;

import java.util.ArrayList;

public class Manager extends Account {
    public static ArrayList<Manager> allManagers = new ArrayList<>();

    public Manager(String username) {
        super(username);
        allManagers.add(this);
        super.setAccountType(AccountType.MANAGER);
    }

    public void addManager(Manager manager){
        allManagers.add(manager);
    }

    public static ArrayList<Manager> getAllManagers() {
        return allManagers;
    }
}
