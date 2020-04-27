package view;
import models.*;
public class MainPage extends Page{
    Account account = null ;
    public MainPage(Page parentPage) {
        super(parentPage);
        subPages.put("products", new AllProductsPage(this));
        subPages.put("offs",new OffsPage(this));
        if (account == null){
            subPages.put("loginRegister",new LoginRegisterPage(this));
        }

    }
}
