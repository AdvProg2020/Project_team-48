package view;

public class Back extends Page {
    public Back(Page parentPage) {
        this.parentPage = parentPage;
        this.name = "back";
    }

    @Override
    public void execute() {
        parentPage.parentPage.execute();
    }
}
