package view.allProductsPageCommands;

import view.Back;
import view.Page;

public class Filtering extends Page {
    public Filtering(Page parentPage) {
        super(parentPage,"Filtering");
        subPages.put("show available filters",ShowAvailableFilters());
        subPages.put("filter [Filter Name]",Filter());
        subPages.put("current filters",CurrentFilters());
        subPages.put("disable filter [Filter Name]",DisableFilter());
        subPages.put("back",new Back(this));

    }

    protected Page ShowAvailableFilters(){
        return new Page(this,"Show available filters") {
            @Override
            public void execute() {

            }
        };
    }

    protected Page Filter(){
        return new Page(this,"Filter") {
            @Override
            public void execute() {

            }
        };
    }

    protected Page CurrentFilters(){
        return new Page(this,"current filters") {
            @Override
            public void execute() {

            }
        };
    }

    protected Page DisableFilter(){
        return new Page(this , "disable filter") {
            @Override
            public void execute() {

            }
        };
    }
}
