package view;
import models.*;
public class MainPage extends Page{
    Account account = null ;
    public MainPage(Page parentPage) {
        super(parentPage);
        this.name = "main page";
        subPages.put("products", new AllProductsPage(this));
        subPages.put("offs",new OffsPage(this));
        if (account == null){
            subPages.put("login/register",new LoginRegisterPage(this));
        }
    }
}
