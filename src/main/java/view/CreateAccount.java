package view;

import controller.LoginRegister;
import models.Account;
import models.Seller;

import java.time.format.SignStyle;
import java.util.Scanner;

public class CreateAccount extends Page {
    public CreateAccount(Page parentPage) {
        super(parentPage, "create account");
    }

    @Override
    public void execute() {
        returnExceptions(parentPage.getMatcher().group(1), parentPage.getMatcher().group(2));
        new Back(this).execute();
    }

    public void returnExceptions(String type, String name) {
        Account account = null;
        try {
            account = LoginRegister.createAccount(type, name);
        } catch (LoginRegister.ExistUsernameException e) {
            System.out.println("username exist");
            new Back(this).execute();
        } catch (LoginRegister.ExistManagerException e) {
            System.out.println("head manager should register you");
            new Back(this).execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        getInfo(account, parentPage.getMatcher().group(1));
    }

    public void getInfo(Account account, String type) {
        System.out.println("password:");
        account.setPassword(scanner.nextLine());
        System.out.println("name:");
        account.setFirstName(scanner.nextLine());
        System.out.println("family name:");
        account.setLastName(scanner.nextLine());
        System.out.println("email:");
        account.setEmail(scanner.nextLine());
        System.out.println("phone number:");
        try {
            account.setPhoneNumber(Integer.parseInt(scanner.nextLine()));
        } catch (Exception e) {
            System.out.println("it should be numbers");
        }
        if (type.equals("seller")) {
            System.out.println("organization:");
            Seller seller = (Seller) account;
            seller.setOrganization(scanner.nextLine());
        }
    }
}
