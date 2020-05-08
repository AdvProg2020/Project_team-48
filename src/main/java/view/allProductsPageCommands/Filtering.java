package view.allProductsPageCommands;

import view.Back;
import view.Page;

public class Filtering extends Page {
    public Filtering(Page parentPage) {
        super(parentPage);
        subPages.put("show available filters",ShowAvailableFilters());
        subPages.put("filter [Filter Name]",Filter());
        subPages.put("current filters",CurrentFilters());
        subPages.put("disable filter [Filter Name]",DisableFilter());
        subPages.put("back",new Back(this));

    }

    protected Page ShowAvailableFilters(){
        return new Page(this) {
            @Override
            public void execute() {

            }
        };
    }

    protected Page Filter(){
        return new Page(this) {
            @Override
            public void execute() {

            }
        };
    }

    protected Page CurrentFilters(){
        return new Page(this) {
            @Override
            public void execute() {

            }
        };
    }

    protected Page DisableFilter(){
        return new Page(this) {
            @Override
            public void execute() {

            }
        };
    }
}
