package models;

import java.util.ArrayList;

enum ProductState{

}

public class Product{
    private int productId;
    private ProductState productState;
    private String name;
    private String brand;
    private int price;
    private int existing;
    private ArrayList<Seller> productSellers;
    private Category category;
    private String details;
    private Rating buyersRating;
    private ArrayList<Comment> allComments;
}