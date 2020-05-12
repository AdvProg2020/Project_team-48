package view.allProductsPageCommands;

import view.Back;
import view.Page;

public class Sorting extends Page {
    public Sorting(Page parentPage) {
        super(parentPage, "sort");
        subPages.put("show available sorts",ShowAvailableSorts());
        subPages.put("sort [Sort by]",Sort());
        subPages.put("current sort",CurrentSort());
        subPages.put("disable sort",DisableSort());
        subPages.put("back",new Back(this));

    }

    protected Page ShowAvailableSorts(){
        return new Page(this,"show available sorts") {
            @Override
            public void execute() {

            }
        };
    }

    protected Page Sort(){
        return new Page(this,"sort") {
            @Override
            public void execute() {

            }
        };
    }

    protected Page CurrentSort(){
        return new Page(this, "current sort") {
            @Override
            public void execute() {

            }
        };
    }

    protected Page DisableSort(){
        return new Page(this,"disable sort") {
            @Override
            public void execute() {

            }
        };
    }
}
