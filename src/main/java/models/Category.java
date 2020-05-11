package models;

import java.util.ArrayList;

public class Category{
    private String name;
    private String attribute;
    private Category subCategory;
    private ArrayList<Product> allProducts;
    private static ArrayList<Category> allCategories = new ArrayList<>();

    public Category(String name, String attribute, Category subCategory, ArrayList<Product> allProducts) {
        this.name = name;
        this.attribute = attribute;
        this.subCategory = subCategory;
        this.allProducts = allProducts;
        allCategories.add(this);
    }

    public static ArrayList<Category> getAllCategories() {
        return allCategories;
    }

    public String getName() {
        return name;
    }

    public static boolean existCategory(String name){
        for (Category category : allCategories) {
            if (category.name.equals(name)){
                return true;
            }
        }
        return false;
    }

    public static Category getCategoryByName(String name){
        for (Category category : allCategories) {
            if (category.name.equals(name)){
                return category;
            }
        }
        return null;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public static void remove(Category category){
        allCategories.remove(category);
    }
}