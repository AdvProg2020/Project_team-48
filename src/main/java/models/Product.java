package models;

import java.awt.image.AreaAveragingScaleFilter;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Product {
    private int productId;
    private static ArrayList<Product> requested = new ArrayList<>();
    private String name;
    protected String brand;
    protected int price;
    protected int existing;
    private Seller seller;
    private ArrayList<Buyer> productBuyers = new ArrayList<>();
    private float rate;
    private Category category;
    private String details;
    private ArrayList<Comment> allComments = new ArrayList<>();
    private static ArrayList<Product> allProduct = new ArrayList<>();
    private static ArrayList<Product> filteredProduct = new ArrayList<>();
    private static ArrayList<Filter> currentFilters = new ArrayList<>();
    private static int size = 0 ;
    private static int ratedBuyers = 0;

    public Product(String name, String brand, int price, int existing, Seller seller, String details) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.existing = existing;
        this.seller = seller;
        this.details = details;
        this.requested.add(this);
        productId = size++;
    }

    public Product() {
    }

    public void addBuyers(Account account){
        productBuyers.add((Buyer)account);
    }

    public void setRate(float rate) {
        this.rate = (this.rate * ratedBuyers + rate) / (ratedBuyers + 1);
        ratedBuyers++;
    }

    public int getExisting() {
        return existing;
    }

    public Seller getSeller() {
        return seller;
    }

    public float getRate() {
        return rate;
    }

    public Category getCategory() {
        return category;
    }

    public static boolean existProduct(int id) {
        for (Product product : allProduct) {
            if (product.productId == id) {
                return true;
            }
        }
        return false;
    }

    public static Product getProductById(int id) {
        for (Product product : allProduct) {
            if (product.productId == id) {
                return product;
            }
        }
        return null;
    }

    public static void remove(Product product) {
        allProduct.remove(product);
    }

    public static ArrayList<Filter> getCurrentFilters() {
        return currentFilters;
    }

    @Override
    public String toString() {
        return "productId=" + productId +
                ", name='" + name +
                ", brand='" + brand +
                ", price=" + price +
                ", existing=" + existing +
                ", seller=" + seller +
                ", productBuyers=" + productBuyers +
                ", category=" + category +
                ", details='" + details +
                ", rate=" + rate +
                ", allComments=" + allComments
                ;
    }

    public static void addProduct(Product product){
        allProduct.add(product);
        requested.remove(product);
        filteredProduct.add(product);
    }

    public String getName() {
        return name;
    }

    public static ArrayList<Product> getRequested() {
        return requested;
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

    public int getPrice() {
        for (Off off : Off.getOffs()) {
            for (Product product : off.getProducts()) {
                if (product == this){
                    if (off.getStartDate().isBefore(LocalDateTime.now()) && off.getFinishDate().isAfter(LocalDateTime.now())){
                        return (int)(price * off.getOffAmount() / 100);
                    }
                }
            }
        }
        return price;
    }

    public void addComment(Comment comment) {
        allComments.add(comment);
    }

    public static ArrayList<Product> filterByExisting() {
        ArrayList<Product> pro = new ArrayList<>();
        for (Product product : filteredProduct) {
            if (product.existing > 0) {
                pro.add(product);
            }
        }
        filteredProduct.clear();
        for (Product product : pro) {
            filteredProduct.add(product);
        }
        currentFilters.add(Filter.getFilterByName("existing"));
        return filteredProduct;
    }

    public static ArrayList<Product> filterByPrice(int max) {
        ArrayList<Product> pro = new ArrayList<>();
        for (Product product : filteredProduct) {
            if (product.price <= max) {
                pro.add(product);
            }
        }
        filteredProduct.clear();
        for (Product product : pro) {
            filteredProduct.add(product);
        }
        currentFilters.add(Filter.getFilterByName("price"));
        return filteredProduct;
    }

    public static ArrayList<Product> filterByBrand(String filterBrand) {
        ArrayList<Product> pro = new ArrayList<>();
        for (Product product : filteredProduct) {
            if (product.brand.equals(filterBrand)) {
                pro.add(product);
            }
        }
        filteredProduct.clear();
        for (Product product : pro) {
            filteredProduct.add(product);
        }
        currentFilters.add(Filter.getFilterByName("brand"));
        return filteredProduct;
    }

    public static ArrayList<Product> DisableFilter(String filterName) {
        for (Filter filter : currentFilters) {
            if (filter.getFilterName().equals(filterName)) {
                currentFilters.remove(filter);
            }
        }
        filteredProduct.clear();
        for (Product product : allProduct) {
            filteredProduct.add(product);
        }
        for (Filter currentFilter : currentFilters) {
            if (currentFilter.getFilterName().equals("existing")) {
                filterByExisting();
            } else if (currentFilter.getFilterName().equals("brand")) {
                filterByBrand(Filter.getBrandFilter());
            } else if (currentFilter.getFilterName().equals("price")) {
                filterByPrice(Filter.getPriceFilter());
            }
        }
        return filteredProduct;
    }
}

