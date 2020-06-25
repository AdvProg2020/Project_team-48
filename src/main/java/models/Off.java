package models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class Off {
    private int offId;
    private ArrayList<Product> products;
    private LocalDateTime startDate;
    private LocalDateTime finishDate;
    private int offAmount;
    private static ArrayList<Off> offs = new ArrayList<>();
    private static ArrayList<Off> requested = new ArrayList<>();
    private static int size = 0;

    public Off(String startDate, String finishDate, int offAmount, ArrayList<Product> product) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy 'at' hh:mm a");
        this.startDate = LocalDateTime.parse(startDate, formatter);
        this.finishDate = LocalDateTime.parse(finishDate, formatter);
        this.offAmount = offAmount;
        this.products = product;
        this.offId = size++;
        this.requested.add(this);
    }

    public static void addOff(Off off) {
        offs.add(off);
        requested.remove(off);
    }

    public static ArrayList<Off> getRequested() {
        return requested;
    }

    public int getOffAmount() {
        return offAmount;
    }

    public static Off getOffById(int id) {
        for (Off off : offs) {
            if (off.offId == id) {
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

    public ArrayList<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "offId=" + offId +
                ", product=" + products +
                ", startDate='" + startDate +
                ", finishDate='" + finishDate +
                ", offAmount=" + offAmount
                ;
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