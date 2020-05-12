package models;

public class Rating{
    private Account user;
    private int mark;
    private Product product;

    public Rating(Account user, int mark, Product product) {
        this.user = user;
        this.mark = mark;
        this.product = product;
        product.setRate(mark);
    }
}