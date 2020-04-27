package view;

import view.allProductsPageCommands.Filtering;

import view.allProductsPageCommands.Sorting;

public class OffsPage extends Page {
    public OffsPage(Page parentPage) {
        super(parentPage);
        subPages.put("show\\sproduct\\s(\\d+)", new ProductPage(this));
        subPages.put("filtering",new Filtering(this));
        subPages.put("sorting",new Sorting(this));
        subPages.put("back",new Back(this));
    }
}
