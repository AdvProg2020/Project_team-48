package view;

import view.allProductsPageCommands.Filtering;

import view.allProductsPageCommands.Sorting;

public class OffsPage extends Page {
    public OffsPage(Page parentPage) {
        super(parentPage,"offs");
        subPages.put("show product [Product Name]", new ProductPage(this));
        subPages.put("filtering",new Filtering(this));
        subPages.put("sorting",new Sorting(this));
        subPages.put("back",new Back(this));
    }
}
