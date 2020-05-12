package view;

import view.usersPageCommands.PersonalInfo;

public class SellerPage extends Page {
    public SellerPage(Page parentPage) {
        super(parentPage,"your account(seller)");
        subPages.put("view personal info", new PersonalInfo(this));
        subPages.put("view company information",CompanyInformation());
        subPages.put("view sales history", SalesHistory());
        subPages.put("add product",AddProduct());
        subPages.put("remove product (\\S+)",RemoveProduct());
        subPages.put("show categories",ShowCategories());
        subPages.put("view balance",ViewBalance());
        subPages.put("back",new Back(this));
    }

    protected Page CompanyInformation(){
        return new Page(this,"company information") {
            @Override
            public void execute() {

            }
        };
    }

    protected Page SalesHistory(){
        return new Page(this,"sales history") {
            @Override
            public void execute() {

            }
        };
    }

    protected Page AddProduct(){
        return new Page(this,"add product") {
            @Override
            public void execute() {

            }
        };
    }

    protected Page RemoveProduct(){
        return new Page(this,"remove product") {
            @Override
            public void execute() {

            }
        };
    }

    protected Page ShowCategories(){
        return new Page(this,"show categories") {
            @Override
            public void execute() {

            }
        };
    }

    protected Page ViewBalance(){
        return new Page(this,"view balance") {
            @Override
            public void execute() {

            }
        };
    }
}
