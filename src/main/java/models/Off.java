package models;

import java.util.ArrayList;
import java.util.Date;



public class Off{
    private int offId ;
    private ArrayList<Product> products = new ArrayList<>();
    private String  offStatus;
    private String startDate;
    private String finishDate;
    private int offAmount;
    private static ArrayList<Off> offs = new ArrayList<>();

    public Off(String startDate, String finishDate, int offAmount,ArrayList product) {
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.offAmount = offAmount;
        this.products = product;
        offs.add(this);
        this .offId = offs.size();
        offStatus ="requested";
    }

    public void setOffStatus(String offStatus) {
        this.offStatus = offStatus;
    }

    public static Off getOffById(int id){
        for (Off off : offs) {
            if (off.offId == id){
                return off;
            }
        }
        return null;
    }

    public static ArrayList<Off> getOffs() {
        return offs;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public int getOffId() {
        return offId;
    }

    @Override
    public String toString() {
        return "offId=" + offId +
                ", product=" + products +
                ", offStatus='" + offStatus +
                ", startDate='" + startDate +
                ", finishDate='" + finishDate +
                ", offAmount=" + offAmount
                ;
    }

    public String getOffStatus() {
        return offStatus;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public void setOffAmount(int offAmount) {
        this.offAmount = offAmount;
    }
}