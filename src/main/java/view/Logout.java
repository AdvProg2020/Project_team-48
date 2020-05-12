package view;

public class Logout extends Page{
    public Logout(Page parentPage){
        super(parentPage,"logout");
        subPages.put("back" , new Back(this));
    }
}
