package controller;

import models.Account;
import models.Product;

public class Manager {
    public static void deleteUser(String name){
        Account.remove(Account.getUserByName(name));
    }

    public static void deleteProduct(int id){
        Product.remove(Product.getProductById(id));
    }
}
