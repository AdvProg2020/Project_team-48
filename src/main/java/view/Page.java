package view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Page {
    protected HashMap<String,Page> subPages;
    protected Page parentPage;
    public static Scanner scanner;
    protected static ArrayList<Page> allPages = new ArrayList<Page>();
    protected Matcher matcher ;

    public Page( Page parentPage) {
        this.parentPage = parentPage;
    }

    public void setParentPage(Page parentPage) {
        this.parentPage = parentPage;
    }

    public static void setScanner(Scanner scanner) {
        Page.scanner = scanner;
    }

    public void setSubPages(HashMap<String, Page> subPages) {
        this.subPages = subPages;
    }

    public void setMatcher(Matcher matcher) {
        this.matcher = matcher;
    }

    public void execute(){
        Page nextPage = null;
        String chosenPage = scanner.nextLine();
        nextPage = getMatchedPage(chosenPage);
        nextPage.execute();

    }

    public Page getMatchedPage(String input){
        for (String pat:subPages.keySet()) {
            if (getMatcher(input,pat) != null){
                subPages.get(pat).setMatcher(getMatcher(input,pat));
                return subPages.get(pat);
            }
        }
        System.out.println("invalid command");
        return null;
    }

    public Matcher getMatcher(String input , String pat){
        Pattern pattern = Pattern.compile(pat);
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()){
            return matcher;
        }
        return null;
    }
}
