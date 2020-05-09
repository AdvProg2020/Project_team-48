package view;

public class Logout extends Page{
    public Logout(Page parentPage){
        super(parentPage);
        subPages.put("back" , new Back(this));
    }
}
