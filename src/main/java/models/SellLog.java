package models;

import java.time.LocalDateTime;
import java.util.ArrayList;


public class SellLog {
    private Product soldProduct;
    private int logId;
    private LocalDateTime sellDate;
    private int receivedPrice;
    private int offAmount;
    private Buyer buyer;
    private String status;
    private static ArrayList<SellLog> sellLogs = new ArrayList<>();

    public SellLog(Product soldProduct, LocalDateTime sellDate, Buyer buyer) {
        this.soldProduct = soldProduct;
        this.sellDate = sellDate;
        this.buyer = buyer;
        sellLogs.add(this);
    }

    @Override
    public String toString() {
        return
                "soldProduct=" + soldProduct +
                        ", logId=" + logId +
                        ", sellDate=" + sellDate +
                        ", receivedPrice=" + receivedPrice +
                        ", offAmount=" + offAmount +
                        ", buyer=" + buyer +
                        ", status=" + status
                ;
    }

}