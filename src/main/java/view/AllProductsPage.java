package view;

import view.allProductsPageCommands.Filtering;
import view.allProductsPageCommands.Sorting;

public class AllProductsPage extends Page {
    public AllProductsPage(Page parentPage) {
        super(parentPage);
        subPages.put("view\\scategories",ViewCategories());
        subPages.put("filtering",new Filtering(this));
        subPages.put("sorting",new Sorting(this));
        subPages.put("show\\sproducts",ShowProducts());
        subPages.put("show\\sproduct\\s(\\d+)",ShowProduct());

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

    protected Page ShowProduct(){
        return new Page(this) {
            @Override
            public void execute() {

            }
        };
    }
}
