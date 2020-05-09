package view.productPageCommands;

import view.Page;

public class Comments extends Page {
    public Comments(Page parentPage) {
        super(parentPage);
        subPages.put("Add comment",AddComment());
    }

    protected Page AddComment(){
        return new Page(this) {
            @Override
            public void execute() {

            }
        };
    }
}
