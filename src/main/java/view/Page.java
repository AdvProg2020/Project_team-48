package view;

import models.Account;
import models.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Page {
    protected Product product;
    protected String name;
    protected HashMap<String, Page> subPages = new HashMap<>();
    protected Page parentPage;
    protected Matcher matcher;
    private static Account account = null;
    public static Scanner scanner = new Scanner(System.in);
    private static Page loginRegisterPage;

    public Page(Page parentPage, String name) {
        this.parentPage = parentPage;
        this.name = name;
        if (account != null) subPages.put("logout", new Logout(this));
        else if (!this.name.equals("login/register page") && !this.name.equals("login") && !this.name.equals("create account") && !this.name.equals("back") && !this.name.equals("help")) {
            subPages.put("login register", new LoginRegisterPage(this));
        } else if (!this.name.equals("back")) subPages.put("back", new Back(this));
        else subPages.put("help", new Help(this));
    }

    public HashMap<String, Page> getSubPages() {
        return subPages;
    }

    public ArrayList<String> getSubPagesKey() {
        return (ArrayList<String>) subPages.keySet();
    }

    public static Page getLoginRegisterPage() {
        return loginRegisterPage;
    }

    public void setLoginRegisterPage(Page loginRegisterPage) {
        Page.loginRegisterPage = loginRegisterPage;
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

    public void execute() {
        System.out.println(name);
        int cnt = 1;
        for (String subPageName : subPages.keySet()) {
            System.out.println(cnt + "- " + subPages.get(subPageName).name);
            cnt++;
        }
        String chosenPage = scanner.nextLine();
        getMatchedPage(chosenPage).execute();
    }

    public Page getMatchedPage(String input) {
        if (input.equals("back") && parentPage == null)
            return this;
        for (String pat : subPages.keySet()) {
            if (setMatcher(input, pat) != null) {
                return subPages.get(pat);
            }
        }
        System.out.println("invalid command");
        return this;
    }

    public Matcher setMatcher(String input, String pat) {
        Pattern pattern = Pattern.compile(pat);
        matcher = pattern.matcher(input);
        if (matcher.matches()) {
            return matcher;
        }
        return null;
    }
}
