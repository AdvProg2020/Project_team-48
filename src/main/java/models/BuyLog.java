package models;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Date;

enum BuyStatus{

}

public class BuyLog{
    private ArrayList<Product> boughtProducts;
    private int logId;
    private Date date;
    private int paidPrice;
    private int offAmount;
    private Buyer buyer;
    private BuyStatus buyStatus;
    private static ArrayList<BuyLog> logs = new ArrayList<>();
    private int code ;

    public BuyLog(ArrayList<Product> boughtProducts, int offAmount, Buyer buyer) {
        this.boughtProducts = boughtProducts;
        this.offAmount = offAmount;
        this.buyer = buyer;
        this.logs.add(this);
        this.code = logs.size();
    }

    public int getCode() {
        return code;
    }

    public static ArrayList<Integer> getLogCodeByAccount(Account account){
        ArrayList<Integer> orders = new ArrayList<>();
        for (BuyLog log : logs) {
            if (log.buyer == account){
                orders.add(log.code);
            }
        }
        return orders;
    }

    public static BuyLog getLogByCode(int code){
        for (BuyLog log : logs) {
            if (log.code == code){
                return log;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return
                "boughtProducts=" + boughtProducts +
                ", logId=" + logId +
                ", date=" + date +
                ", paidPrice=" + paidPrice +
                ", offAmount=" + offAmount +
                ", code=" + code
                ;
    }

    public static boolean hasProduct(Product product , Account account){
        for (BuyLog log : logs) {
            if (log.buyer == (Buyer) account){
                for (Product boughtProduct : log.boughtProducts) {
                    if (boughtProduct == product){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}