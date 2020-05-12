package view.usersPageCommands.managerCommands;

import controller.ManagerControl;
import models.Product;
import view.Page;

public class ManageAllProducts extends Page {
    public ManageAllProducts(Page parentPage) {
        super(parentPage,"manage all products");
        subPages.put("remove (\\S+)",Remove());
    }

    protected Page Remove(){
        return new Page(this,"remove") {
            @Override
            public void execute() {
                if ( ! Product.existProduct(Integer.parseInt(parentPage.getMatcher().group(1)))){
                    System.out.println("The product does not exist");
                }else{
                    ManagerControl.deleteProduct(Integer.parseInt(parentPage.getMatcher().group(1)));
                }
            }
        };
    }
}
