package view.allProductsPageCommands;

import view.Page;

public class Filtering extends Page {
    public Filtering(Page parentPage) {
        super(parentPage);
        subPages.put("show\\savailable\\sfilters",ShowAvailableFilters());
        subPages.put("filter\\s(\\S+)",Filter());
        subPages.put("current\\sfilters",CurrentFilters());
        subPages.put("disable\\sfilter\\s(\\S+)",DisableFilter());

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
