package view;

public class Logout extends Page {
    public Logout(Page parentPage) {
        this.parentPage = parentPage;
        this.name = "logout";

    }

    @Override
    public void execute() {
        Page.setAccount(null);
        if (parentPage.name.equals("your account(manager)") || parentPage.name.equals("your account(buyer)") || parentPage.name.equals("your account(seller)")) {
            new MainPage(parentPage).execute();
        } else {
            parentPage.execute();
        }

    }
}
 