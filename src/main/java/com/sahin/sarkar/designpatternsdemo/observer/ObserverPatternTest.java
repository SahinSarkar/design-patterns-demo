package com.sahin.sarkar.designpatternsdemo.observer;

import com.sahin.sarkar.designpatternsdemo.observer.email.publisher.Order;
import com.sahin.sarkar.designpatternsdemo.observer.email.publisher.OrderPublisher;
import com.sahin.sarkar.designpatternsdemo.observer.email.publisher.OrderStatus;
import com.sahin.sarkar.designpatternsdemo.observer.email.subscriber.DeliveryConfirmationEmailService;
import com.sahin.sarkar.designpatternsdemo.observer.email.subscriber.EmailNotificationService;
import com.sahin.sarkar.designpatternsdemo.observer.email.subscriber.OrderConfirmationEmailService;
import com.sahin.sarkar.designpatternsdemo.observer.email.subscriber.ShipmentUpdateEmailService;

public class ObserverPatternTest {

	public static void main(String[] args) {
		EmailNotificationService orderConfirmedService = new OrderConfirmationEmailService((int) (Math.random() * 1000));
		EmailNotificationService shipmentUpdateService = new ShipmentUpdateEmailService((int) (Math.random() * 1000));
		EmailNotificationService deliveryConfirmedService = new DeliveryConfirmationEmailService((int) (Math.random() * 1000));

		OrderPublisher order = new Order((int) (Math.random() * 1000), (int) (Math.random() * 1000), null);

		System.out.println("order created = " + order);
		order.registerNotificationService("confirmedNotifier", orderConfirmedService);
		order.registerNotificationService("shippedNotifier", shipmentUpdateService);
		order.registerNotificationService("deliveredNotifier", deliveryConfirmedService);

		order.setOrderStatus(OrderStatus.CONFIRMED);
		order.setOrderStatus(OrderStatus.SHIPPED);
		order.setOrderStatus(OrderStatus.DELIVERED);

		/////////////------//////////////
		System.out.println("------------Start-------------------");
		System.out.println("Going to deregister order confirmed service");
		order.deregisterNotificationService("confirmedNotifier", orderConfirmedService.getId());
		order.setOrderStatus(OrderStatus.CONFIRMED);
		order.setOrderStatus(OrderStatus.SHIPPED);
		order.setOrderStatus(OrderStatus.DELIVERED);
		System.out.println("------------End-------------------");

		System.out.println("------------Start-------------------");
		System.out.println("Going to deregister shipment service");
		order.deregisterNotificationService("shippedNotifier", shipmentUpdateService.getId());
		order.setOrderStatus(OrderStatus.CONFIRMED);
		order.setOrderStatus(OrderStatus.SHIPPED);
		order.setOrderStatus(OrderStatus.DELIVERED);
		System.out.println("------------End-------------------");

		System.out.println("------------Start-------------------");
		System.out.println("Going to deregister delivered service");
		order.deregisterNotificationService("deliveredNotifier", deliveryConfirmedService.getId());
		order.setOrderStatus(OrderStatus.CONFIRMED);
		order.setOrderStatus(OrderStatus.SHIPPED);
		order.setOrderStatus(OrderStatus.DELIVERED);
		System.out.println("------------End-------------------");

	}
}
