package lessons.java.view;

import lessons.java.common.AppView;
import lessons.java.date.service.ShopService;

import java.util.ArrayList;
import java.util.Scanner;

public class AddToCartView extends AppView {
    public AddToCartView(ShopService shopService) {
        super("Добавить товар", new ArrayList<>());
        this.shopService = shopService;
    }

    final ShopService shopService;

    @Override
    public void action() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id product ");
        String productId = sc.nextLine();
        if (productId == null) return;
        System.out.println("Enter count ");
        int count = sc.nextInt();
       final boolean res =  shopService.addToCart(productId, count);
       if (res){
           System.out.println("Товар добавлен");
       }else {
           System.out.println("Не удалось добавить товар");
       }

    }
}
