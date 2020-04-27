package models;

import java.util.ArrayList;
import java.util.Date;

enum SellStatus{
    PENDING,
    POSTING,
    DELIVERED
}

public class SellLog{
    private ArrayList<Product> soldProducts;
    private int logId;
    private Date sellDate;
    private int recievedPrice;
    private int offAmount;
    private Buyer buyer;
    private SellStatus status;
}