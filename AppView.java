package lessons.java.common;

import lessons.java.comparators.AppComporator;
import lessons.java.date.models.Product;

import java.util.ArrayList;
import java.util.Comparator;

public abstract class AppView {
    public final String title;
    public final ArrayList<AppView> children;
    public  int nowPage = 0;
    public final int pageLimit = 5;
    public boolean hasNextPage = false;
    public final ArrayList<AppComporator<Product>> availableComparators = new ArrayList<>();
    public AppComporator<Product> selectedComparator;

    protected AppView(String title, ArrayList<AppView> children) {
        this.title = title;
        this.children = children;
    }


    public void action(){}
}
