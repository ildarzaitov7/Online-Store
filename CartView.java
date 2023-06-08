package lessons.java.view;

import lessons.java.common.AppView;
import lessons.java.date.models.CartItem;
import lessons.java.date.models.Product;
import lessons.java.date.service.ShopService;

import java.util.ArrayList;

public class CartView extends AppView {
    final ShopService shopService;

    public CartView(ShopService shopService) {
        super("Корзина", new ArrayList<>());
        this.shopService = shopService;
    }

    @Override
    public void action() {
        ArrayList<CartItem> cart = shopService.getCart();
        for (CartItem cartItem : cart){
            System.out.println(cartItem.product.id + " " + cartItem.product.title + " " + cartItem.count);
        }
        System.out.println();
    }
}
