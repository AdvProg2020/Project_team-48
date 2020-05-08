package view;

import com.sun.tools.javac.Main;
import models.Account;

import java.nio.channels.AcceptPendingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Page {
    protected String name;
    protected HashMap<String,Page> subPages = new HashMap<>();
    protected Page parentPage;
    protected static ArrayList<Page> allPages = new ArrayList<>();
    protected Matcher matcher ;
    protected static Account account = null;
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

    public String getName() {
        return name;
    }

    public static void setAccount(Account account) {
        Page.account = account;
    }

    public void execute(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println(name);
        int cnt = 1;
        for(String subPageName : subPages.keySet()) {
            System.out.println(cnt + "- " + subPageName);
            cnt++;
        }
        String chosenPage=scanner.nextLine();
        getMatchedPage(chosenPage).execute();
    }

    public Page getMatchedPage(String input){
        if(input.equals("back") && parentPage == null)
            return this;
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
