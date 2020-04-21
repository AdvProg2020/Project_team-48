package view;

import view.usersPageCommands.PersonalInfo;

public class SellerPage extends Page {
    public SellerPage(Page parentPage) {
        super(parentPage);
        subPages.put("view\\spersonal\\sinfo", new PersonalInfo(this));
        subPages.put("view\\scompany\\sinformation",CompanyInformation());
    }

    protected Page CompanyInformation(){
        return new Page(this) {
            @Override
            public void execute() {

            }
        };
    }
}
