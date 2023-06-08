package lessons.java.view;

import lessons.java.common.AppView;
import lessons.java.date.models.Product;
import lessons.java.date.service.ShopService;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class OrderView extends AppView {
    final ShopService shopService;
    public OrderView(ShopService shopService) {
        super("Оформление заказа",new ArrayList<>());
        this.shopService = shopService;
    }

    @Override
    public void action() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter you name: ");
        String name = sc.nextLine();
        System.out.println("Enter you phone: ");
        String phone = sc.nextLine();
        System.out.println("Enter you address: ");
        String address = sc.nextLine();
        System.out.println("Payment in cash or by card?: ");
        String paymentType = sc.nextLine();
        System.out.println("By what time to deliver? ");
        String deliveryTime = sc.nextLine();

        shopService.createOrder(name, phone, address,paymentType,deliveryTime);

    }
}
