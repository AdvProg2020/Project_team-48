package models;

import java.util.ArrayList;

public class Filter extends Product {
    private String filterName;
    private static ArrayList<Filter> filters = new ArrayList<>();
    private static String brandFilter;
    private static int priceFilter;

    public Filter(String filterName) {
        this.filterName = filterName;
        filters.add(this);
    }

    public static String getBrandFilter() {
        return brandFilter;
    }

    public static int getPriceFilter() {
        return priceFilter;
    }

    public static void setBrandFilter(String brandFilter) {
        Filter.brandFilter = brandFilter;
    }

    public static void setPriceFilter(int priceFilter) {
        Filter.priceFilter = priceFilter;
    }

    public String getFilterName() {
        return filterName;
    }

    public static ArrayList<Filter> getFilters() {
        return filters;
    }

    public static Filter getFilterByName(String name) {
        for (Filter filter : filters) {
            if (filter.filterName.equals(name)) {
                return filter;
            }
        }
        return null;
    }
}
