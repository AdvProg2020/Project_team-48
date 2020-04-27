package models;

import java.util.ArrayList;
import java.util.Date;

enum BuyStatus{

}

public class BuyLog{
    private ArrayList<Product> buyedProducts;
    private int logId;
    private Date date;
    private int paidPrice;
    private int offAmount;
    private Seller seller;
    private BuyStatus buyStatus;
}