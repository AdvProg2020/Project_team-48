package view;

import models.Off;
import models.Product;
import view.allProductsPageCommands.Filtering;
import view.allProductsPageCommands.Sorting;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class OffsPage extends Page {
    public OffsPage(Page parentPage) {
        super(parentPage, "offs");
        subPages.put("show product (\\d+)", ShowProduct());
        subPages.put("filtering", new Filtering(this));
        subPages.put("sorting", new Sorting(this));
        subPages.put("back", new Back(this));
    }

    @Override
    public void execute() {
        for (Off off : Off.getOffs()) {
            if (off.getStartDate().isBefore(LocalDate.now()) && off.getFinishDate().isAfter(LocalDate.now())) {
                for (Product pro : off.getProducts()) {
                    System.out.println(pro.getName() + pro.getPrice());
                }
            }
        }
        super.execute();
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
