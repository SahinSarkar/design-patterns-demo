package com.sahin.sarkar.designpatternsdemo.observer.email.publisher;

import com.sahin.sarkar.designpatternsdemo.observer.email.subscriber.EmailNotificationService;

import java.util.*;

public class Order implements OrderPublisher {

	Map<String, List<EmailNotificationService>> notificationServiceMap = new HashMap<>();

	private int orderId;
	private int userId;
	private OrderStatus orderStatus;

	public Order(int orderId, int userId, OrderStatus orderStatus) {
		this.orderId = orderId;
		this.userId = userId;
		this.orderStatus = orderStatus;
		notifyEmailServiceObservers();
	}

	@Override
	public void registerNotificationService(String ensType, EmailNotificationService notificationService) {
		if (notificationServiceMap.containsKey(ensType)) {
			notificationServiceMap.get(ensType).add(notificationService);
		} else {
			ArrayList<EmailNotificationService> notificationServices = new ArrayList<>();
			notificationServices.add(notificationService);
			notificationServiceMap.put(ensType, notificationServices);
		}
	}

	@Override
	public void deregisterNotificationService(String ensType, int id) {
		Iterator notifierIt = notificationServiceMap.get(ensType).iterator();
		while (notifierIt.hasNext()) {
			EmailNotificationService notifierService = (EmailNotificationService) notifierIt.next();
			if (notifierService.getId() == id) {
				notifierIt.remove();
			}
		}
	}

	@Override
	public void notifyEmailServiceObservers() {
		if (orderStatus == OrderStatus.SHIPPED) {
			notifyAllNotificationServices("shippedNotifier");
		} else if (orderStatus == OrderStatus.CONFIRMED) {
			notifyAllNotificationServices("confirmedNotifier");
		} else if (orderStatus == OrderStatus.DELIVERED) {
			notifyAllNotificationServices("deliveredNotifier");
		}
	}

	private void notifyAllNotificationServices(String shippedNotifier) {
		notificationServiceMap.get(shippedNotifier).stream()
			.forEach(notifier -> notifier.update(this));
	}

	@Override
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
		notifyEmailServiceObservers();
	}

	@Override
	public int getOrderId() {
		return orderId;
	}

	@Override
	public int getUserId() {
		return userId;
	}

	public String toString() {
		return "Order{" +
			"orderId=" + orderId +
			", userId=" + userId +
			", orderStatus=" + orderStatus +
			'}';
	}
}
