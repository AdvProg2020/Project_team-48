package models;

import java.nio.channels.Pipe;
import java.util.ArrayList;
import java.util.PrimitiveIterator;

public class Request {
    private int requestId;
    private String start;
    private String end;
    private Integer amount;
    private Account account;
    private Off off;
    private Product product;
    private ArrayList<Product> offProducts = new ArrayList<>();
    private Integer price;
    private Integer existing;
    private static ArrayList<Seller> sellers = new ArrayList<>();
    private static ArrayList<Account> products = new ArrayList<>();
    private static ArrayList<Account> offs = new ArrayList<>();
    private static ArrayList<Request> requests = new ArrayList<>();

    public Request(Account account) {
        requestId = requests.size();
        this.account = account;
        requests.add(this);
    }

    public int getRequestId() {
        return requestId;
    }

    public Account getAccount() {
        return account;
    }

    public static Request getRequestById(int id) {
        for (Request request : requests) {
            if (request.requestId == id) {
                return request;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        if (sellers.contains(this.account)) {
            return "requestId=" + requestId + "\n" +
                    "   account=" + account;
        } else if (products.contains(this.account)) {
            return "requestId=" + requestId + "\n" +
                    "   account=" + account + "\n" +
                    "   product=" + product;
        } else {
            return "requestId=" + requestId + "\n" +
                    "   account=" + account + "\n" +
                    "   off=" + off + "\n" +
                    "   product=" + product;
        }
    }

    public static void remove(int id) {
        Request request = getRequestById(id);
        requests.remove(request);
        if (sellers.contains(request.account)) {
            sellers.remove(request.account);
        } else if (products.contains(request.account)) {
            products.remove(request.account);
        } else {
            offs.remove(request.account);
        }
    }

    public static Integer getIdByProduct(Product product) {
        for (Request request : requests) {
            if (request.product == product) {
                return request.requestId;
            }
        }
        return null;
    }

    public static void acceptRequest(int id) {
        Request request = getRequestById(id);
        if (sellers.contains(request.account)) {
            sellers.remove(request.account);
            Seller seller = (Seller) request.account;
            seller.add();
        } else if (products.contains(request.account)) {
            if (request.product.getProductState().equals("requested")) {
                request.product.setProductState("accepted");
            } else if (request.price != null) {
                request.product.setPrice(request.price);
            } else if (request.existing != null) {
                request.product.setExisting(request.existing);
            }
            products.remove(request.account);
        } else {
            if (request.off.getOffStatus().equals("requested")) {
                request.off.setOffStatus("accepted");
            } else if (request.amount != null) {
                request.off.setOffAmount(request.amount);
            } else if (request.product != null) {
                request.off.setProducts(request.offProducts);
            } else if (request.start != null) {
                request.off.setStartDate(request.start);
            } else if (request.end != null) {
                request.off.setFinishDate(request.end);
            }
            offs.remove(request.account);
        }
        requests.remove(request);
    }

    public static ArrayList<Request> getRequests() {
        return requests;
    }

    public void addSeller(Seller seller) {
        sellers.add(seller);
    }

    public void addProductEditRequest(Account account, Product product, Integer price, Integer existing) {
        this.product = product;
        this.price = price;
        this.existing = existing;
        this.account = account;
        products.add(account);
    }

    public void addOffRequest(Account account, ArrayList<Product> product, Off off) {
        this.offProducts = product;
        this.account = account;
        offs.add(account);
        this.off = off;
    }

    public void addProductRequest(Account account, Product product) {
        this.product = product;
        this.account = account;
        products.add(account);
    }

    public void addOffEditRequest(Account account, ArrayList<Product> product, Off off, String start, String end, Integer amount) {
        this.offProducts = product;
        this.account = account;
        offs.add(account);
        this.off = off;
        this.start = start;
        this.end = end;
        this.amount = amount;
    }
}
