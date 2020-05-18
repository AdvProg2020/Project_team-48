package view;

import models.Category;
import models.Product;
import view.allProductsPageCommands.Filtering;
import view.allProductsPageCommands.Sorting;

public class AllProductsPage extends Page {
    public AllProductsPage(Page parentPage) {
        super(parentPage, "products page");
        subPages.put("view categories", ViewCategories());
        subPages.put("filtering", new Filtering(this));
        subPages.put("sorting", new Sorting(this));
        subPages.put("show products", ShowProducts());
        subPages.put("show product (\\d+)", ShowProduct());
        subPages.put("back", new Back(this));

    }

    protected Page ViewCategories() {
        return new Page(this, "view categories") {
            @Override
            public void execute() {
                for (Category category : Category.getAllCategories()) {
                    System.out.println(category);
                }
                new Back(this).execute();
            }
        };
    }

    protected Page ShowProducts() {
        return new Page(this, "show products") {
            @Override
            public void execute() {
                for (Product product1 : Product.getAllProduct()) {
                    System.out.println(product1.getName() + product1.getPrice());
                }
                new Back(this).execute();
            }
        };
    }

    protected Page ShowProduct() {
        return new Page(this, "show products") {
            @Override
            public void execute() {
                int id = Integer.parseInt(parentPage.getMatcher().group(1));
                if (Product.getProductById(id) != null) {
                    new ProductPage(parentPage, Product.getProductById(id));
                } else {
                    System.out.println("product does not exist");
                }
            }
        };
    }

}
