package view;

import com.sun.tools.javac.Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Page {
    protected String name;
    protected HashMap<String,Page> subPages = new HashMap<>();
    protected Page parentPage;
    protected static ArrayList<Page> allPages = new ArrayList<>();
    protected Matcher matcher ;
    public static Scanner scanner = new Scanner(System.in);

    public Page(Page parentPage) {
        this.parentPage = parentPage;
    }

    public void setParentPage(Page parentPage) {
        this.parentPage = parentPage;
    }

    public void setSubPages(HashMap<String, Page> subPages) {
        this.subPages = subPages;
    }

    public Matcher getMatcher() {
        return matcher;
    }

    public void execute(){
        System.out.println(name);
        String chosenPage=scanner.nextLine();
        getMatchedPage(chosenPage).execute();
    }

    public Page getMatchedPage(String input){
        for (String pat:subPages.keySet()) {
            if (setMatcher(input,pat) != null){
                return subPages.get(pat);
            }
        }
        System.out.println("invalid command");
        return this;
    }

    public Matcher setMatcher(String input , String pat){
        Pattern pattern = Pattern.compile(pat);
        matcher = pattern.matcher(input);
        if (matcher.matches()){
            return matcher;
        }
        return null;
    }
}
