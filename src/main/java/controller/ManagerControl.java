package controller;

import models.Account;
import models.Category;
import models.Discount;
import models.Product;

import java.util.ArrayList;

public class ManagerControl {
    public static void deleteUser(String name) {
        Account.remove(Account.getUserByName(name));
    }

    public static void deleteProduct(int id) {
        Product.remove(Product.getProductById(id));
    }

    public static void createDiscount(int discountCode, String startTime, String endTime, int percent, int repeat, String usersList, int max) {
        ArrayList<Account> users = new ArrayList<>();
        for (String s : usersList.split(",")) {
            users.add(Account.getUserByName(s));
        }
        new Discount(discountCode, startTime, endTime, percent, repeat, users, max);
    }

    public static void viewDiscount(int code) {
        if (Discount.existCode(code)) {
            System.out.println(Discount.getDiscountByCode(code));
        } else {
            System.out.println("code does not exist");
        }
    }

    public static void removeDiscount(int code) {
        if (Discount.existCode(code)) {
            Discount.getDiscountByCode(code).remove();
        } else {
            System.out.println("code does not exist");
        }
    }

    public static void addCategory(String name, String attribute, String subpage, String product) {
        ArrayList<Product> products = new ArrayList<>();
        for (String s : product.split(",")) {
            int id = Integer.parseInt(s);
            if (Product.getProductById(id) != null) {
                products.add(Product.getProductById(id));
            }
        }
        new Category(name, attribute, Category.getCategoryByName(subpage), products);
    }


}
