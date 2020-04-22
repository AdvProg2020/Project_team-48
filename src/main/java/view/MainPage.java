package view;
import models.*;
public class MainPage extends Page{
    Account account = null ;
    public MainPage() {
        super(null);
        subPages.put("products", new AllProductsPage(this));
        subPages.put("offs",new OffsPage(this));
    }
}
