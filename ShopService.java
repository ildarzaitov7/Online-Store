package lessons.java.date.service;

import lessons.java.Order;
import lessons.java.date.data_source.cart.CartDataSource;
import lessons.java.date.data_source.catalog.CatalogDataSource;
import lessons.java.date.data_source.order.OrderDataSource;
import lessons.java.date.models.CartItem;
import lessons.java.date.models.Product;

import java.util.ArrayList;
import java.util.Comparator;

public class ShopService {
    public final CatalogDataSource catalogDataSource;
    public final CartDataSource cartDataSource;
    public final OrderDataSource orderDataSource;

    public ShopService(CatalogDataSource catalogDataSource, CartDataSource cartDataSource, OrderDataSource orderDataSource) {
        this.catalogDataSource = catalogDataSource;
        this.cartDataSource = cartDataSource;
        this.orderDataSource = orderDataSource;
    }

    public ArrayList<Product> getCatalog(int page, int limit){
        return catalogDataSource.getCatalog( page,  limit);
    }
    public ArrayList<Product> getCatalog(int page, int limit, Comparator<Product> comparator){
        return catalogDataSource.getCatalog( page, limit, comparator);
    }

    public boolean addToCart(String productId, int count){
        ArrayList<Product> products = getCatalog(0,9999999);
        for (Product p : products){
            if (p.id.equals(productId)){
                cartDataSource.addToCart(p,count);
                return true;
            }
        }
        return false;
    }

    public ArrayList<CartItem> getCart(){
        return cartDataSource.getCart();
    }

    public void createOrder(String name, String phone, String address, String paymentType, String deliveryTime){
        ArrayList<CartItem> cart = getCart();
        Order newOrder = new Order(name, phone, address, paymentType,deliveryTime,cart);
        orderDataSource.createOrder(newOrder);
    }

}
