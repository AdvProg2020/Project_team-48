package view.usersPageCommands;

import view.Page;

public class PersonalInfo extends Page {
    public PersonalInfo(Page parentPage) {
        super(parentPage);
        this.name = "View Personal Information";
        subPages.put("edit [field]", edit());
    }

    protected Page edit(){
        return new Page(this) {
            @Override
            public void execute() {
                System.out.println(account);
            }
        };
    }

}
