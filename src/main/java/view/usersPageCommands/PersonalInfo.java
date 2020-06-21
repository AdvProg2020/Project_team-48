package view.usersPageCommands;

import view.Back;
import view.Page;

public class PersonalInfo extends Page {
    public PersonalInfo(Page parentPage) {
        super(parentPage, "view personal info");
        subPages.put("edit (email|name|last name|phone number|password)", Edit());
        subPages.put("back", new Back(this));
    }

    @Override
    public void execute() {
        System.out.println(Page.getAccount());
        super.execute();
    }

    protected Page Edit() {
        return new Page(this, "edit") {
            @Override
            public void execute() {
                if (parentPage.getMatcher().group(1).equals("name")) {
                    Page.getAccount().setFirstName(scanner.nextLine());
                } else if (parentPage.getMatcher().group(1).equals("last name")) {
                    Page.getAccount().setLastName(scanner.nextLine());
                } else if (parentPage.getMatcher().group(1).equals("email")) {
                    Page.getAccount().setEmail(scanner.nextLine());
                } else if (parentPage.getMatcher().group(1).equals("phone number")) {
                    Page.getAccount().setPhoneNumber(scanner.nextLine());
                } else if (parentPage.getMatcher().group(1).equals("password")) {
                    Page.getAccount().setPassword(scanner.nextLine());
                }
                new Back(parentPage).execute();
            }
        };
    }

}
