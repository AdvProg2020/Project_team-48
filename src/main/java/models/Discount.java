package models;

import java.util.ArrayList;
import java.util.Date;

public class Discount{
    private int discountCode;
    private Date startDate;
    private Date finishDate;
    private int discountPercent;
    private ArrayList<Account> allDiscountedUsers;
}