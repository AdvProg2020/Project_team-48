package models;

import java.util.ArrayList;

enum ProductState{

}

 public class Product {
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
     private static ArrayList<Product> allProduct;

     public Product(int productId, ProductState productState, String name, String brand, int price, int existing, ArrayList<Seller> productSellers, Category category, String details, Rating buyersRating, ArrayList<Comment> allComments) {
         this.productId = productId;
         this.productState = productState;
         this.name = name;
         this.brand = brand;
         this.price = price;
         this.existing = existing;
         this.productSellers = productSellers;
         this.category = category;
         this.details = details;
         this.buyersRating = buyersRating;
         this.allComments = allComments;
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


 }

