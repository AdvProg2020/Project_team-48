package view;

import view.allProductsPageCommands.Filtering;
import view.allProductsPageCommands.ShowProduct;
import view.allProductsPageCommands.Sorting;

public class AllProductsPage extends Page {
    public AllProductsPage(Page parentPage) {
        super(parentPage);
        this . name = "product page";
        subPages.put("view categories",ViewCategories());
        subPages.put("filtering",new Filtering(this));
        subPages.put("sorting",new Sorting(this));
        subPages.put("show products",ShowProducts());
        subPages.put("show product [Product Name]", new ProductPage(this));
        subPages.put("back",new Back(this));

    }

    protected Page ViewCategories(){
        return new Page(this) {
            @Override
            public void execute() {

            }
        };
    }

    protected Page ShowProducts(){
        return new Page(this) {
            @Override
            public void execute() {

            }
        };
    }

}
