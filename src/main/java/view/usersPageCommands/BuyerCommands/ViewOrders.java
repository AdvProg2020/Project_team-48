package view.usersPageCommands.BuyerCommands;

import view.Page;

public class ViewOrders extends Page {
    public ViewOrders(Page parentPage) {
        super(parentPage);
        subPages.put("show\\sorder\\s(\\d+)",ShowOrder());
        subPages.put("rate\\s(\\d+)\\s([1-5])",Rate());
    }

    protected Page ShowOrder(){
        return new Page(this) {
            @Override
            public void execute() {

            }
        };
    }

    protected Page Rate(){
        return new Page(this) {
            @Override
            public void execute() {

            }
        };
    }
}
