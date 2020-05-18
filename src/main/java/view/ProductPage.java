package view;

import models.Product;
import view.productPageCommands.Comments;
import view.productPageCommands.Digest;


public class ProductPage extends Page {
    public ProductPage(Page parentPage, Product product) {
        super(parentPage, "product");
        this.product = product;
        subPages.put("digest", new Digest(this));
        subPages.put("attributes", Attributes());
        subPages.put("compare [Product Name]", Compare());
        subPages.put("comments", new Comments(this));
        subPages.put("back", new Back(this));

    }

    protected Page Attributes() {
        return new Page(this, "attributes") {
            @Override
            public void execute() {
                System.out.println(product);
                new Back(this).execute();
            }
        };
    }

    protected Page Compare() {
        return new Page(this, "compare") {
            @Override
            public void execute() {
                System.out.println(Product.getProductById(Integer.parseInt(parentPage.getMatcher().group(1))));
                System.out.println(product);
                new Back(this).execute();
            }
        };
    }
}
