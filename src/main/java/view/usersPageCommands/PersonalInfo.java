package view.usersPageCommands;

import view.Page;

public class PersonalInfo extends Page {
    public PersonalInfo(Page parentPage) {
        super(parentPage);
        this.name = "View Personal Information";
        subPages.put("edit [field]", edit());
    }

    @Override
    public void execute() {
        System.out.println(account);
        super.execute();
    }

    protected Page edit(){
        return new Page(this) {
            @Override
            public void execute() {
                if (parentPage.getMatcher().group(1).equals("name")){
                    Page.account.setFirstName(scanner.next());
                }else if (parentPage.getMatcher().group(1).equals("last name")){
                    Page.account.setLastName(scanner.nextLine());
                }else if (parentPage.getMatcher().group(1).equals("email")){
                    Page.account.setEmail(scanner.nextLine());
                }else if (parentPage.getMatcher().group(1).equals("phone number")){
                    Page.account.setPhoneNumber(Integer.parseInt(scanner.nextLine()));
                }else if (parentPage.getMatcher().group(1).equals("password")){
                    Page.account.setPassword(scanner.nextLine());
                }
            }
        };
    }

}
