package view.usersPageCommands.managerCommands;

import controller.Manager;
import models.Product;
import view.Page;

public class ManageAllProducts extends Page {
    public ManageAllProducts(Page parentPage) {
        super(parentPage);
        subPages.put("remove (\\S+)",Remove());
    }

    protected Page Remove(){
        return new Page(this) {
            @Override
            public void execute() {
                if ( ! Product.existProduct(Integer.parseInt(parentPage.getMatcher().group(1)))){
                    System.out.println("The product does not exist");
                }else{
                    Manager.deleteProduct(Integer.parseInt(parentPage.getMatcher().group(1)));
                }
            }
        };
    }
}
