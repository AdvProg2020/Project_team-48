package view;
import models.*;
public class MainPage extends Page{
    public MainPage(Page parentPage) {
        super(parentPage);
        this.name = "Main Page";
        subPages.put("products", new AllProductsPage(this));
        subPages.put("offs",new OffsPage(this));
        if(getAccount()!= null) {
            subPages.put("logout", new Logout(this));
            subPages.put("User Page", getAccount().getAccountPage(this));
        }
        else
            subPages.put("login register", new LoginRegisterPage(this));

    }

}
