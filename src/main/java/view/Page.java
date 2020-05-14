package view;

import com.sun.tools.javac.Main;
import models.Account;
import models.Product;

import java.nio.channels.AcceptPendingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Page {
    protected Product product;
    protected String name;
    protected HashMap<String,Page> subPages = new HashMap<>();
    protected Page parentPage;
    protected static ArrayList<Page> allPages = new ArrayList<>();
    protected Matcher matcher ;
    private static Account account = null;
    public static Scanner scanner = new Scanner(System.in);

    public Page(Page parentPage ,String name) {
        this.parentPage = parentPage;
        this.name = name;
        if (account != null)subPages.put("logout",new Logout(this));
        subPages.put("back",new Back(this));
    }

    protected Page() {
    }

    public Product getProduct() {
        return product;
    }

    public Page getParentPage() {
        return parentPage;
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

    public static Account getAccount() {
        return account;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void setAccount(Account account) {
        Page.account = account;
    }

    public void execute(){
        System.out.println(name);
        int cnt = 1;
        for(String subPageName : subPages.keySet()) {
            System.out.println(cnt + "- " + subPages.get(subPageName).name);
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
