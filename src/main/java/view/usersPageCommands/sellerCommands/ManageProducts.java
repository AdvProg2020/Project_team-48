package view.usersPageCommands.sellerCommands;

import controller.SellerControl;
import models.Buyer;
import models.Product;
import models.Seller;
import view.Back;
import view.Page;


public class ManageProducts extends Page {
    public ManageProducts(Page parentPage) {
        super(parentPage, "manage products");
        subPages.put("view (\\d+)", View());
        subPages.put("view buyers (\\d+)", ViewBuyers());
        subPages.put("edit (\\d+)", Edit());
    }

    @Override
    public void execute() {
        Seller seller = (Seller) Page.getAccount();
        for (Product product : seller.getProducts()) {
            System.out.println(product.getName());
        }
        super.execute();
    }

    protected Page View() {
        return new Page(this, "view") {
            @Override
            public void execute() {
                System.out.println(Product.getProductById(Integer.parseInt(parentPage.getMatcher().group(1))));
                new Back(parentPage).execute();
            }
        };
    }

    protected Page ViewBuyers() {
        return new Page(this, "view buyers") {
            @Override
            public void execute() {
                for (Buyer buyer : Product.getProductById(Integer.parseInt(parentPage.getMatcher().group(1))).getProductBuyers()) {
                    System.out.println(buyer);
                }
                new Back(parentPage).execute();
            }

        };
    }

    protected Page Edit() {
        return new Page(this, "edit") {
            @Override
            public void execute() {
                Product product = Product.getProductById(Integer.parseInt(parentPage.getMatcher().group(1)));
                System.out.println("what do you want to edit?");
                String input = scanner.nextLine();
                if (input.equals("price")) {
                    int price = Integer.parseInt(scanner.nextLine());
                    SellerControl.requestEditPrice(price, product);
                } else if (input.equals("existing")) {
                    int existing = Integer.parseInt(scanner.nextLine());
                    SellerControl.requestEditExisting(existing, product);
                }
                new Back(parentPage).execute();
            }
        };
    }
}
