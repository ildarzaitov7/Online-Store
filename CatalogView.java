package lessons.java.view;

import lessons.java.common.AppView;
import lessons.java.comparators.AppComporator;
import lessons.java.comparators.PriceComparator;
import lessons.java.date.models.Product;
import lessons.java.date.service.ShopService;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class CatalogView extends AppView {
    final ShopService shopService;
    public CatalogView(ShopService shopService, ArrayList<AppView> children, ArrayList<AppComporator<Product>> compatators) {
        super("Каталог", children);
        this.shopService = shopService;
        availableComparators.addAll(compatators);
        if (!availableComparators.isEmpty()){
            selectedComparator = availableComparators.get(0);
        }
    }

    @Override
    public void action() {
        PriceComparator comparator = new PriceComparator();
        comparator.isAsc = false;
        ArrayList<Product> catalog = shopService.getCatalog(nowPage,pageLimit, selectedComparator.comparator);
        hasNextPage = catalog.size() == pageLimit;
        for (Product product : catalog){
            System.out.println(product.id + " " + product.title + " " + product.price);
        }
        System.out.println();
    }
}
