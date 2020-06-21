package view.usersPageCommands.managerCommands;

import controller.ManagerControl;
import models.Discount;
import view.Back;
import view.Page;

public class ViewDiscountCodes extends Page {
    public ViewDiscountCodes(Page parentPage) {
        super(parentPage, "view discount codes");
        subPages.put("view discount code (\\S+)", ViewDiscountCode());
        subPages.put("edit discount code (\\S+)", EditDiscountCode());
        subPages.put("remove discount code (\\S+)", RemoveDiscountCode());
    }

    @Override
    public void execute() {
        for (Discount discount : Discount.getAllDiscounts()) {
            System.out.println(discount.getDiscountCode());
        }
        super.execute();
    }

    protected Page ViewDiscountCode() {
        return new Page(this, "view discount code") {
            @Override
            public void execute() {
                ManagerControl.viewDiscount(Integer.parseInt(parentPage.getMatcher().group(1)));
                new Back(this).execute();
            }
        };
    }

    protected Page EditDiscountCode() {
        return new Page(this, "edit discount code") {
            @Override
            public void execute() {
                int code = Integer.parseInt(parentPage.getMatcher().group(1));
                if (Discount.existCode(code)) {
                    Discount discount = Discount.getDiscountByCode(code);
                    System.out.println("which field do you want to edit?");
                    String input = scanner.nextLine();
                    if (input.equals("start date")) {
                        discount.setStartDate(scanner.nextLine());
                    } else if (input.equals("finish date")) {
                        discount.setFinishDate(scanner.nextLine());
                    } else if (input.equals("maximum amount")) {
                        discount.setMax(Integer.parseInt(scanner.nextLine()));
                    } else if (input.equals("percent")) {
                        discount.setDiscountPercent(Integer.parseInt(scanner.nextLine()));
                    }
                } else {
                    System.out.println("code does not exist");
                }
                new Back(this).execute();
            }
        };
    }

    protected Page RemoveDiscountCode() {
        return new Page(this, "remove discount code") {
            @Override
            public void execute() {
                ManagerControl.removeDiscount(Integer.parseInt(parentPage.getMatcher().group(1)));
                new Back(this).execute();
            }
        };
    }
}
