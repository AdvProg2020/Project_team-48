package view.usersPageCommands;

import view.Page;

public class PersonalInfo extends Page {
    public PersonalInfo( Page parentPage) {
        super(parentPage);
        subPages.put("edit\\s(\\S+)",edit());

    }

    protected Page edit(){
        return new Page(this) {
            @Override
            public void execute() {
            }
        };
    }

}
