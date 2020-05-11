package view.usersPageCommands.managerCommands;

import controller.ManagerControl;
import models.Category;
import models.Manager;
import view.Back;
import view.Page;

public class ManageCategories extends Page {
    public ManageCategories(Page parentPage) {
        super(parentPage);
        this.name = "Manage categories";
        subPages.put("edit (\\S+)", Edit());
        subPages.put("add (\\S+)",Add());
        subPages.put("remove (\\S+)",Remove());
    }

    @Override
    public void execute() {
        for (Category category : Category.getAllCategories()) {
            System.out.println(category.getName());
        }
        super.execute();
    }

    protected Page Edit(){
        this.name="Edit";
        return new Page(this) {
            @Override
            public void execute() {
                if (Category.existCategory(parentPage.getMatcher().group())){
                    System.out.println("What do you want to edit?");
                    String input = scanner.nextLine();
                    if (input.equals("name")){
                        String categoryName;
                        if (Category.existCategory( categoryName = scanner.nextLine())){
                            System.out.println("name exists");
                            new Back(this).execute();
                        }else {
                            Category.getCategoryByName(parentPage.getMatcher().group()).setName(categoryName);
                        }
                    }else if (input.equals("attributes")){
                        Category.getCategoryByName(parentPage.getMatcher().group()).setAttribute(scanner.nextLine());
                    }else{
                        System.out.println("invalid input");
                    }
                }else{
                    System.out.println("Category does not exist");
                }
                new Back(this).execute();
            }
        };
    }

    protected Page Add(){

        return new Page(this) {
            @Override
            public void execute() {
                if (Category.existCategory(parentPage.getMatcher().group())){
                    System.out.println("Category exist with this name");
                }else{
                    System.out.println("attribute:");
                    String attribute = scanner.nextLine();
                    System.out.println("subpage:");
                    String subpage = scanner.nextLine();
                    System.out.println("products:");
                    String products = scanner.nextLine();
                    ManagerControl.addCategory(parentPage.getMatcher().group() ,attribute,subpage,products);
                }
                new Back(this).execute();
            }
        };
    }

    protected Page Remove(){
        return new Page(this) {
            @Override
            public void execute() {
                if (Category.existCategory(parentPage.getMatcher().group())){
                    Category.remove(Category.getCategoryByName(parentPage.getMatcher().group()));
                }else {
                    System.out.println("Category does not exist");
                }
                new Back(this).execute();
            }
        };
    }
}
