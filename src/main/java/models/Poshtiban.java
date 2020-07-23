package models;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

public class Poshtiban extends Account {

    private static ArrayList<Poshtiban> all = new ArrayList<>();

    public static ArrayList<Poshtiban> getAll() {
        return all;
    }

    public Poshtiban(String username) {
        super(username);
        all.add(this);
        allAccounts.add(this);
    }



}
