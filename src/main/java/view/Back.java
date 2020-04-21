package view;

public class Back extends Page {
    public Back( Page parentPage) {
        super( parentPage);
        subPages.put("",parentPage);
    }
}
