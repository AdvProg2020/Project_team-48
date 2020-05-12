package view.productPageCommands;

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

            }
        };
    }
}
