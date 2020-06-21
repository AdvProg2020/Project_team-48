package models;

import java.util.ArrayList;

public class Rating {
    private Account user;
    private int mark;
    private Product product;
    private static ArrayList<Rating> ratings = new ArrayList<>();

    public Rating(Account user, int mark, Product product) {
        this.user = user;
        this.mark = mark;
        this.product = product;
        product.setRate(mark);
        ratings.add(this);
    }

}