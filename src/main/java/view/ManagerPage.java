package view;

import controller.ManagerControl;
import models.Discount;
import view.usersPageCommands.managerCommands.ManageCategories;
import view.usersPageCommands.managerCommands.ManageRequests;
import view.usersPageCommands.managerCommands.ManageUsers;
import view.usersPageCommands.PersonalInfo;
import view.usersPageCommands.managerCommands.ViewDiscountCodes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ManagerPage extends Page{
    public ManagerPage(Page parentPage) {
        super(parentPage,"your account(manager");
        subPages.put("view personal info",new PersonalInfo(this));
        subPages.put("manage users",new ManageUsers(this));
        subPages.put("create discount code",CreateDiscountCode());
        subPages.put("view discount codes",new ViewDiscountCodes(this));
        subPages.put("manage requests",new ManageRequests(this));
        subPages.put("manage categories",new ManageCategories(this));
        subPages.put("back",new Back(this));
    }

    protected Page CreateDiscountCode(){
        return new Page(this,"create discount code") {
            @Override
            public void execute() {
                System.out.println("discount code:");
                int discountCode=0;
                try {
                    discountCode = Integer.parseInt(scanner.nextLine());
                }
                catch (Exception e){
                    System.out.println("invalid input");
                    new Back(this).execute();
                }
                if (Discount.existCode(discountCode)){
                    System.out.println("code exist");
                    new Back(this).execute();
                }
                System.out.println("exact start time:(05/10/2020,05:33)");
                String startTime=scanner.nextLine();
                Pattern pattern = Pattern.compile("\\d\\d/\\d\\d/\\d\\d\\d\\d,\\d\\d:\\d\\d");
                Matcher matcher = pattern.matcher(startTime);
                if (!matcher.find()){
                    System.out.println("invalid input");
                    new Back(this).execute();
                }
                System.out.println("exact end time:(05/10/2020,05:33)");
                String endTime =scanner.nextLine();
                matcher = pattern.matcher(endTime);
                if (!matcher.find()){
                    System.out.println("invalid input");
                    new Back(this).execute();
                }
                System.out.println("discount percent:");
                int percent =Integer.parseInt(scanner.nextLine());
                System.out.println("repeat amount:");
                int repeat =Integer.parseInt(scanner.nextLine());
                System.out.println("users list:");
                String usersList =scanner.nextLine();
                ManagerControl.createDiscount(discountCode,startTime,endTime,percent,repeat,usersList);
                new Back(this).execute();
            }
        };
    }


}
