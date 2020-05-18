package models;

import java.security.PrivateKey;
import java.util.ArrayList;

public class Manager extends Account {
    private static ArrayList<Manager> allManagers = new ArrayList<>();

    public Manager(String username) {
        super(username);
        allManagers.add(this);
        setAccountType(AccountType.MANAGER);
        allAccounts.add(this);
    }

    public void addManager(Manager manager) {
        allManagers.add(manager);
    }

    public static ArrayList<Manager> getAllManagers() {
        return allManagers;
    }
}
