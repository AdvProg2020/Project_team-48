package view.allProductsPageCommands;

import view.Page;

public class Sorting extends Page {
    public Sorting(Page parentPage) {
        super(parentPage);
        subPages.put("show\\savailable\\ssorts",ShowAvailableSorts());
        subPages.put("sort\\s(\\S+)",Sort());
        subPages.put("current\\ssort",CurrentSort());
        subPages.put("disable\\ssort",DisableSort());
    }

    protected Page ShowAvailableSorts(){
        return new Page(this) {
            @Override
            public void execute() {

            }
        };
    }

    protected Page Sort(){
        return new Page(this) {
            @Override
            public void execute() {

            }
        };
    }

    protected Page CurrentSort(){
        return new Page(this) {
            @Override
            public void execute() {

            }
        };
    }

    protected Page DisableSort(){
        return new Page(this) {
            @Override
            public void execute() {

            }
        };
    }
}
