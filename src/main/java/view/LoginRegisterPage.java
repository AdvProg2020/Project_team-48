package view;

import controller.LoginRegister;
import models.Account;
import models.Seller;

import java.util.HashMap;

public class LoginRegisterPage extends Page{
    public LoginRegisterPage( Page parentPage) {
        super(parentPage);
        this.name= "login or register";
        subPages.put("create account [Manager,Buyer,Seller] [Username]",createAccount());
        subPages.put("login [Username]",login());
        subPages.put("back",new Back(this));
    }

    protected Page createAccount(){
        return new Page(this) {
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
        };
    }

    protected Page login(){
        return new Page(this) {
            @Override
            public void execute() {
                Account account;
                if ((account = Account.getUserByName(parentPage.getMatcher().group(1)) )== null){
                    System.out.println("username does not exist");
                    new Back(this).execute();
                }else{
                    System.out.println("password:");
                   if(account.getPassword().equals(Page.scanner.nextLine())){
                       LoginRegister.login(account,this.parentPage);
                   }else {
                       System.out.println("password is wrong");
                       new Back(this).execute();
                   }
                }
            }
        };
    }


}
