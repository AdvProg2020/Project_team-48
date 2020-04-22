package view;

import view.productPageCommands.Comments;
import view.productPageCommands.Digest;

import java.util.Collections;
import java.util.Comparator;

public class ProductPage extends Page {
    public ProductPage(Page parentPage) {
        super(parentPage);
        subPages.put("digest",new Digest(this));
        subPages.put("attributes",Attributes());
        subPages.put("Compare\\s(\\d+)", Compare());
        subPages.put("Comments",new Comments(this));
        subPages.put("back",new Back(this));

    }

    protected Page Attributes(){
        return new Page(this) {
            @Override
            public void execute() {

            }
        };
    }

    protected Page Compare(){
        return new Page(this) {
            @Override
            public void execute() {

            }
        };
    }
}
