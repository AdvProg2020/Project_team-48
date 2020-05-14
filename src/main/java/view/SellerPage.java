package view;

import controller.SellerControl;
import models.Account;
import models.Category;
import models.Product;
import models.Seller;
import view.usersPageCommands.PersonalInfo;
import view.usersPageCommands.ViewBalance;
import view.usersPageCommands.sellerCommands.ManageProducts;

public class SellerPage extends Page {
    public SellerPage(Page parentPage) {
        super(parentPage,"your account(seller)");
        subPages.put("view personal info", new PersonalInfo(this));
        subPages.put("view company information",CompanyInformation());
        subPages.put("view sales history", SalesHistory());
        subPages.put("add product",AddProduct());
        subPages.put("remove product (\\S+)",RemoveProduct());
        subPages.put("show categories",ShowCategories());
        subPages.put("view balance",new ViewBalance(this));
        subPages.put("manage products", new ManageProducts(this));
        subPages.put("back",new Back(this));
    }

    protected Page CompanyInformation(){
        return new Page(this,"company information") {
            @Override
            public void execute() {
              Seller seller = (Seller)Page.getAccount();
              System.out.println(seller.getOrganization());
            }
        };
    }

    protected Page SalesHistory(){
        return new Page(this,"sales history") {
            @Override
            public void execute() {
                System.out.println(Page.getAccount().getSellLogsList());
                new Back(this).execute();
            }
        };
    }

    protected Page AddProduct(){
        return new Page(this,"add product") {
            @Override
            public void execute() {
                System.out.println("name:");
                String productName = scanner.nextLine();
                System.out.println("brand:");
                String brand = scanner.nextLine();
                System.out.println("price:");
                int price = Integer.parseInt(scanner.nextLine());
                System.out.println("existing:");
                int existing = Integer.parseInt(scanner.nextLine());
                System.out.println("details:");
                String details = scanner.nextLine();
                SellerControl.requestAddProduct(new Product(productName,brand,price,existing,(Seller)Page.getAccount(),details));
                new  Back(this).execute();
            }
        };
    }

    protected Page RemoveProduct(){
        return new Page(this,"remove product") {
            @Override
            public void execute() {
               SellerControl.remove( Integer.parseInt(parentPage.getMatcher().group(1)));
               new Back(this).execute();
            }
        };
    }

    protected Page ShowCategories(){
        return new Page(this,"show categories") {
            @Override
            public void execute() {
                for (Category category : Category.getAllCategories()) {
                    System.out.println(category.getName());
                }
                new Back(this).execute();
            }
        };
    }

}
