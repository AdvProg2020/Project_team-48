package view.usersPageCommands.sellerCommands;

import controller.SellerControl;
import main.Main;
import models.Off;
import models.Product;
import view.Back;
import view.Page;

import java.util.ArrayList;

public class ViewOffs extends Page {
    public ViewOffs(Page parentPage) {
        super(parentPage, "view offs");
        subPages.put("view (\\d+)", View());
        subPages.put("edit (\\d+)", Edit());
        subPages.put("add off", AddOff());
    }

    @Override
    public void execute() {
        for (Off off : Off.getOffs()) {
            System.out.println(off.getOffId() + " :" + off.getStartDate() + " ," + off.getFinishDate());
        }
        super.execute();
    }

    protected Page View() {
        return new Page(this, "view") {
            @Override
            public void execute() {
                System.out.println(Off.getOffById(Integer.parseInt(parentPage.getMatcher().group(1))));
                new Back(parentPage).execute();
            }
        };
    }

    protected Page Edit() {
        return new Page(this, "edit") {
            @Override
            public void execute() {
                Off off = Off.getOffById(Integer.parseInt(parentPage.getMatcher().group(1)));
                System.out.println("what do you want to edit?");
                String input = scanner.nextLine();
                ArrayList<Product> productArray = new ArrayList<>();
                String startDate = null;
                String endDate = null;
                Integer amount = null;
                if (input.equals("product")) {
                    String products = scanner.nextLine();
                    for (String s : products.split(",")) {
                        productArray.add(Product.getProductById(Integer.parseInt(s)));
                    }
                } else if (input.equals("start date")) {
                    startDate = scanner.nextLine();
                } else if (input.equals("end date")) {
                    endDate = scanner.nextLine();
                } else if (input.equals("amount")) {
                    amount = Integer.parseInt(scanner.nextLine());
                }
                SellerControl.requestEditOff(off, productArray, startDate, endDate, amount);
                new Back(this).execute();
            }
        };
    }

    protected Page AddOff() {
        return new Page(this, "add off") {
            @Override
            public void execute() {
                System.out.println("Start date:");
                String startDate = scanner.nextLine();
                System.out.println("end date:");
                String endDate = scanner.nextLine();
                System.out.println("off amount:");
                int offAmount = Integer.parseInt(scanner.nextLine());
                System.out.println("Products:");
                String product = scanner.nextLine();
                ArrayList<Product> products = new ArrayList<>();
                for (String s : product.split(",")) {
                    products.add(Product.getProductById(Integer.parseInt(s)));
                }
                int percent = Integer.parseInt(scanner.nextLine());
                SellerControl.requestAddOff(products, new Off(startDate, endDate, offAmount, products,percent, Main.getAccount()));
                new Back(this).execute();
            }
        };
    }
}
