package view;
import models.*;
public class MainPage extends Page{
    public MainPage(Page parentPage) {
        super(parentPage);
        this.name = "Main Page";
        subPages.put("products", new AllProductsPage(this));
        subPages.put("offs",new OffsPage(this));
        if(Account.isAUserLoggedIn)
            subPages.put("logout" , new Logout(this));
        else
            subPages.put("login register", new LoginRegisterPage(this));
        showPersonalPage();
    }

    private void showPersonalPage()
    {
        if(Account.accountType().equalsIgnoreCase("Manager"))
            subPages.put("manager page", new ManagerPage(this));
        else if(Account.accountType().equalsIgnoreCase("Buyer"))
            subPages.put("buyer page", new BuyerPage(this));
        else if(Account.accountType().equalsIgnoreCase("Seller"))
            subPages.put("seller page", new SellerPage(this));
    }
}
