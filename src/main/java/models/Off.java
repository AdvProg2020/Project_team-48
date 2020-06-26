package models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class Off {
    private int offId;
    private ArrayList<Product> products;
    private LocalDate startDate;
    private LocalDate finishDate;
    private int offAmount;
    private int percent;
    private static ArrayList<Off> offs = new ArrayList<>();
    private static ArrayList<Off> requested = new ArrayList<>();
    private static int size = 0;

    public Off(String startDate, String finishDate, int offAmount, ArrayList<Product> product, int percent,Account account) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm");
        this.startDate = LocalDate.parse(startDate, formatter);
        this.finishDate = LocalDate.parse(finishDate, formatter);
        this.offAmount = offAmount;
        this.products = product;
        this.offId = size++;
        this.percent = percent;
        requested.add(this);
        new Request(account, null, this);
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getFinishDate() {
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
        this.startDate = LocalDate.parse(startDate, formatter);
    }

    public void setFinishDate(String finishDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy 'at' hh:mm a");
        this.finishDate = LocalDate.parse(finishDate, formatter);
    }

    public void setOffAmount(int offAmount) {
        this.offAmount = offAmount;
    }
}