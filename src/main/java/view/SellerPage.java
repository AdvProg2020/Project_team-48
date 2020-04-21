package view;

import view.usersPageCommands.PersonalInfo;

public class SellerPage extends Page {
    public SellerPage(Page parentPage) {
        super(parentPage);
        subPages.put("view\\spersonal\\sinfo", new PersonalInfo(this));
        subPages.put("view\\scompany\\sinformation",CompanyInformation());
        subPages.put("view\\ssales\\shistory", SalesHistory());
        subPages.put("add\\sproduct",AddProduct());
        subPages.put("remove\\sproduct\\s(\\S+)",RemoveProduct());
        subPages.put("show\\scategories",ShowCategories());
        subPages.put("view\\sbalance",ViewBalance());
    }

    protected Page CompanyInformation(){
        return new Page(this) {
            @Override
            public void execute() {

            }
        };
    }

    protected Page SalesHistory(){
        return new Page(this) {
            @Override
            public void execute() {

            }
        };
    }

    protected Page AddProduct(){
        return new Page(this) {
            @Override
            public void execute() {

            }
        };
    }

    protected Page RemoveProduct(){
        return new Page(this) {
            @Override
            public void execute() {

            }
        };
    }

    protected Page ShowCategories(){
        return new Page(this) {
            @Override
            public void execute() {

            }
        };
    }

    protected Page ViewBalance(){
        return new Page(this) {
            @Override
            public void execute() {

            }
        };
    }
}
