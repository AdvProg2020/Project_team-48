package models;

import java.util.ArrayList;
import java.util.HashMap;

public class Cart {
    private ArrayList<Product> products = new ArrayList<>();
    private HashMap<Product, Integer> amountOfProducts = new HashMap<>();

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void changeAmountOfProduct(Product product, int change) {
        for (Product pro : amountOfProducts.keySet()) {
            int amount = amountOfProducts.get(pro) + change;
            amountOfProducts.replace(pro, amount);
        }
    }

    public int getTotalPrice() {
        int total = 0;
        for (Product product : amountOfProducts.keySet()) {
            total = total + product.getPrice() * amountOfProducts.get(product);
        }
        return total;
    }

    public void clear() {
        products.clear();
        amountOfProducts.clear();
    }

    public void addProductToCart(Product product) {
        products.add(product);
    }
}
