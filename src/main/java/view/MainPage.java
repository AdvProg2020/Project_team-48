package view;

public class MainPage extends Page {
    public MainPage(Page parentPage) {
        super(parentPage, "main page");
        subPages.put("products", new AllProductsPage(this));
        subPages.put("offs", new OffsPage(this));
        if (getAccount() != null) {
            //subPages.put("my account", MyAccount());
        }
    }

    //protected Page MyAccount() {
        //return new Page(this, "my account") {
            //@Override
            //public void execute() {
              //  getAccount().getAccountPage().execute();
            //}
        //};
    //}
}
