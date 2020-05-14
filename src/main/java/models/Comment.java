package models;


public class Comment {
    private Account user;
    private Product product;
    private String comment;
    private String title;
    private String commentStatus;


    public Comment(Account user, Product product, String comment,String title) {
        this.user = user;
        this.product = product;
        this.comment = comment;
        this.comment = comment ;
        product.addComment(this);
    }
}