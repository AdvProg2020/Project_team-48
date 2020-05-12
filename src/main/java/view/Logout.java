package view;

public class Logout extends Page{
    public Logout(Page parentPage){
        this .parentPage =parentPage ;
        this.name = "logout";

    }

    @Override
    public void execute() {
        Page.setAccount(null);
        new MainPage(parentPage).execute();
    }
}
