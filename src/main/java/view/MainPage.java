package view;
import models.*;
public class MainPage extends Page{
    public MainPage(Page parentPage) {
        super(parentPage);
        this.name = "main page";
        subPages.put("products", new AllProductsPage(this));
        subPages.put("offs",new OffsPage(this));
        subPages.put("login register",new LoginRegisterPage(this));
        subPages.put("manager page",new ManagerPage(this));
        subPages.put("buyer page", new BuyerPage(this));
        subPages.put("seller page" , new SellerPage(this));
        subPages.put("back",new Back(this));
    }

}
