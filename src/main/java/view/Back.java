package view;

public class Back extends Page {
    public Back( Page parentPage) {
        super(parentPage);
    }

    @Override
    public void execute() {
        parentPage.parentPage.execute();
    }
}
