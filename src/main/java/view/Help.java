package view;

public class Help extends Page {
    public Help(Page parentPage) {
        super(parentPage, "help");
    }

    @Override
    public void execute() {
        System.out.println("this is the orders list:");
        for (String s : parentPage.getSubPagesKey()) {
            System.out.println(s);
        }
    }
}
