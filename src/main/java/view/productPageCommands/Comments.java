package view.productPageCommands;

import models.Comment;
import view.Back;
import view.Page;

public class Comments extends Page {
    public Comments(Page parentPage) {
        super(parentPage,"add");
        subPages.put("add comment",AddComment());
    }

    protected Page AddComment(){
        return new Page(this,"add comment") {
            @Override
            public void execute() {
                System.out.println("title:");
                String title = scanner.nextLine();
                System.out.println("comment");
                String comment = scanner.nextLine();
                new Comment(Page.getAccount() , product ,comment , title);
                new Back(this).execute();
            }
        };
    }
}
