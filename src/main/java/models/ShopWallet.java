package models;

public class ShopWallet {
    private static ShopWallet shopWallet = null;
    private int credit;

    public ShopWallet() {
        if (shopWallet == null){
            shopWallet = new ShopWallet();
            credit = 0;
        }
    }
}
