package models;

import java.util.ArrayList;



 public class Product {
     private int productId;
     private String productState;
     private String name;
     private String brand;
     private int price;
     private int existing;
     private Seller seller;
     private ArrayList<Buyer> productBuyers = new ArrayList<>();
     private Category category;
     private String details;
     private Rating buyersRating;
     private ArrayList<Comment> allComments;
     private static ArrayList<Product> allProduct =new ArrayList<>();

     public Product(String name, String brand, int price, int existing, Seller seller, String details) {
         this.name = name;
         this.brand = brand;
         this.price = price;
         this.existing = existing;
         this.seller = seller;
         this.details = details;
         this.productState = "requested";
         allProduct.add(this);
         productId = allProduct.size();
     }

     public static boolean existProduct(int id){
         for (Product product : allProduct) {
             if (product.productId == id){
                 return true;
             }
         }
         return false;
     }

     public static Product getProductById(int id){
         for (Product product : allProduct) {
             if (product.productId == id){
                 return product;
             }
         }
         return null;
     }

     public static void remove(Product product){
         allProduct.remove(product);
     }

     @Override
     public String toString() {
         return "productId=" + productId +
                 ", productState=" + productState +
                 ", name='" + name +
                 ", brand='" + brand +
                 ", price=" + price +
                 ", existing=" + existing +
                 ", seller=" + seller +
                 ", productBuyers=" + productBuyers +
                 ", category=" + category +
                 ", details='" + details +
                 ", buyersRating=" + buyersRating +
                 ", allComments=" + allComments
                 ;
     }

     public String getName() {
         return name;
     }

     public ArrayList<Buyer> getProductBuyers() {
         return productBuyers;
     }

     public void setPrice(int price) {
         this.price = price;
     }

     public void setExisting(int existing) {
         this.existing = existing;
     }

     public String getProductState() {
         return productState;
     }

     public void setProductState(String productState) {
         this.productState = productState;
     }
 }

