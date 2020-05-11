package models;

import java.util.ArrayList;

public class Request {
    private int requestId = 0;
    private Account account;
    private Off off;
    private Product product;
    private static ArrayList<Seller> sellers = new ArrayList<>();
    private static ArrayList<Account> products = new ArrayList<>();
    private static ArrayList<Account> offs = new ArrayList<>();
    private static ArrayList<Request> requests = new ArrayList<>();

    public Request(Account account) {
        requestId++;
        this.account = account;
        requests.add(this);
    }

    public int getRequestId() {
        return requestId;
    }

    public static void addSellerRequest(Seller seller) {
        sellers.add(seller);
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
        Request request =getRequestById(id);
        requests.remove(request);
        if (sellers.contains(request.account)){
            sellers.remove(request.account);
        }else if (products.contains(request.account)){
            products.remove(request.account);
        }else{
            offs.remove(request.account);
        }
    }

    public static void acceptRequest(int id){
        Request request =getRequestById(id);
        if (sellers.contains(request.account)){
            sellers.remove(request.account);
            Seller seller = (Seller)request.account;
            seller.add();
        }else if (products.contains(request.account)){
            products.remove(request.account);
        }else{
            offs.remove(request.account);
        }
    }
}
