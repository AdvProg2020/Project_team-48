package view;

import controller.LoginRegister;
import models.Account;
import models.Seller;

import java.util.Scanner;

public class CreateAccount extends Page{
    public CreateAccount(Page parentPage){
        super(parentPage);
        this.name = "Create Account";
        subPages.put("back", new Back(this));
    }

    @Override
    public void execute() {
        Account account = null;
        try {
            account = LoginRegister.createAccount(parentPage.getMatcher().group(1),parentPage.getMatcher().group(2));
        } catch (LoginRegister.ExistUsernameException e) {
            System.out.println("username exist");
            new Back(this).execute();
        }catch (LoginRegister.ExistManagerException e){
            System.out.println("head manager should register you");
            new Back(this).execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        getInfo();
    }

    private void getInfo(){
        System.out.println("password:");
        account.setPassword(scanner.nextLine());
        System.out.println("name:");
        account.setFirstName(scanner.nextLine());
        System.out.println("family name:");
        account.setLastName(scanner.nextLine());
        System.out.println("email:");
        account.setEmail(scanner.nextLine());
        System.out.println("phone number:");
        account.setPhoneNumber(Integer.parseInt(scanner.nextLine()));
        if (parentPage.getMatcher().group(1).equals("seller")){
            System.out.println("organization:");
            Seller seller = (Seller) account;
            seller.setOrganization(scanner.nextLine());
        }
        new Back(this).execute();
    }
}
