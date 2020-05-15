package models;

import javax.sql.rowset.serial.SerialStruct;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;



public class Off{
    private int offId ;
    private ArrayList<Product> products = new ArrayList<>();
    private String  offStatus;
    private LocalDateTime startDate;
    private LocalDateTime finishDate;
    private int offAmount;
    private static ArrayList<Off> offs = new ArrayList<>();

    public Off(String startDate, String finishDate, int offAmount,ArrayList<Product> product) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy 'at' hh:mm a");
        this.startDate = LocalDateTime.parse(startDate , formatter);
        this.finishDate = LocalDateTime.parse(finishDate , formatter);
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

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getFinishDate() {
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy 'at' hh:mm a");
        this.startDate = LocalDateTime.parse(startDate, formatter);
    }

    public void setFinishDate(String finishDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy 'at' hh:mm a");
        this.finishDate = LocalDateTime.parse(finishDate, formatter);
    }

    public void setOffAmount(int offAmount) {
        this.offAmount = offAmount;
    }
}