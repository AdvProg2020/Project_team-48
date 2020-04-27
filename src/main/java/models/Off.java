package models;

import java.util.ArrayList;
import java.util.Date;

enum OffStatus{

}

public class Off{
    private int offId;
    private ArrayList<Product> allProducts;
    private OffStatus offStatus;
    private Date startDate;
    private Date finishDate;
    private int offAmount;
}