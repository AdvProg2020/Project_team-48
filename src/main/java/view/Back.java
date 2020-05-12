package view;

public class Back extends Page {
    public Back( Page parentPage) {
        super(parentPage,"Back");
    }

    @Override
    public void execute() {
        parentPage.parentPage.execute();
    }
}
