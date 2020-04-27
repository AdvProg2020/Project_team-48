package models;

enum CommentStatus{

}

public class Comment {
    private Account user;
    private Product product;
    private String comment;
    private CommentStatus commentStatus;
    private Boolean userHasBoughtThisProduct;
}