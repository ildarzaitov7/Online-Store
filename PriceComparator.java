package lessons.java.comparators;

import lessons.java.date.models.Product;

import java.util.Comparator;

public class PriceComparator implements Comparator<Product> {
    public boolean isAsc;

    public PriceComparator() {
        this.isAsc = true;
    }

    public PriceComparator(boolean isAsc) {
        this.isAsc = isAsc;
    }



    @Override
    public int compare(Product p1, Product p2) {
        if (isAsc){
            return p1.price - p2.price;
        }else {
            return p2.price - p1.price;
        }
    }
}
