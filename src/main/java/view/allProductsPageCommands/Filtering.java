package view.allProductsPageCommands;

import models.Filter;
import models.Product;
import view.Back;
import view.Page;

public class Filtering extends Page {
    public Filtering(Page parentPage) {
        super(parentPage, "Filtering");
        subPages.put("show available filters", ShowAvailableFilters());
        subPages.put("filter (\\S+)", Filter());
        subPages.put("current filters", CurrentFilters());
        subPages.put("disable filter (\\S+)", DisableFilter());
        subPages.put("back", new Back(this));

    }

    protected Page ShowAvailableFilters() {
        return new Page(this, "Show available filters") {
            @Override
            public void execute() {
                for (Filter filter : Filter.getFilters()) {
                    System.out.println("filter by" + filter.getFilterName());
                }
                new Back(this).execute();
            }
        };
    }

    protected Page Filter() {
        return new Page(this, "Filter") {
            @Override
            public void execute() {
                if (parentPage.getMatcher().group(1).equals("existing")) {
                    for (Product product1 : Product.filterByExisting()) {
                        System.out.println(product1);
                    }
                } else if (parentPage.getMatcher().group(1).equals("price")) {
                    System.out.println("enter price");
                    int price = Integer.parseInt(scanner.nextLine());
                    Filter.setPriceFilter(price);
                    for (Product product1 : Product.filterByPrice(price)) {
                        System.out.println(product1);
                    }
                } else if (parentPage.getMatcher().group(1).equals("Brand")) {
                    System.out.println("enter brand");
                    String brand = scanner.nextLine();
                    Filter.setBrandFilter(brand);
                    for (Product product1 : Product.filterByBrand(brand)) {
                        System.out.println(product1);
                    }
                }
                new Back(this).execute();
            }
        };
    }

    protected Page CurrentFilters() {
        return new Page(this, "current filters") {
            @Override
            public void execute() {
                for (Filter filter : Product.getCurrentFilters()) {
                    System.out.println(filter.getFilterName());
                }
                new Back(this).execute();
            }
        };
    }

    protected Page DisableFilter() {
        return new Page(this, "disable filter") {
            @Override
            public void execute() {
                Product.DisableFilter(parentPage.getMatcher().group(1));
                new Back(this).execute();
            }
        };
    }
}
