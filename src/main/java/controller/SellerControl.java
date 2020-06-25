package controller;

import models.Off;
import models.Product;
import models.Request;
import view.Page;

import java.util.ArrayList;

public class SellerControl {

    public static void requestEditPrice(int price, Product product) {
        new Request(Page.getAccount()).addProductEditRequest(Page.getAccount(), product, price, null);
    }

    public static void requestEditExisting(int existing, Product product) {
        new Request(Page.getAccount()).addProductEditRequest(Page.getAccount(), product, null, existing);
    }

    public static void requestAddOff(ArrayList<Product> product, Off off) {
        new Request(Page.getAccount()).addOffRequest(Page.getAccount(), product, off);
    }

    public static void requestAddProduct(Product product) {
        new Request(Page.getAccount()).addProductRequest(Page.getAccount(), product);
    }

    public static void remove(int id) {
        Product.remove(Product.getProductById(id));
        Request.remove(Request.getIdByProduct(Product.getProductById(id)));
    }

    public static void requestEditOff(Off off, ArrayList<Product> products, String start, String end, int amount) {
        new Request(Page.getAccount()).addOffEditRequest(Page.getAccount(), products, off, start, end, amount);
    }
}
