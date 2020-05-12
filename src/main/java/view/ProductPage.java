package view;

import view.productPageCommands.Comments;
import view.productPageCommands.Digest;

import java.util.Collections;
import java.util.Comparator;

public class ProductPage extends Page {
    int productId ;
    public ProductPage(Page parentPage) {
        super(parentPage,"product");
       // productId = Integer.parseInt(parentPage.getMatcher().group(1));
        subPages.put("digest",new Digest(this));
        subPages.put("attributes",Attributes());
        subPages.put("compare [Product Name]", Compare());
        subPages.put("comments",new Comments(this));
        subPages.put("back",new Back(this));

    }

    protected Page Attributes(){
        return new Page(this,"attributes") {
            @Override
            public void execute() {

            }
        };
    }

    protected Page Compare(){
        return new Page(this,"compare") {
            @Override
            public void execute() {

            }
        };
    }
}
