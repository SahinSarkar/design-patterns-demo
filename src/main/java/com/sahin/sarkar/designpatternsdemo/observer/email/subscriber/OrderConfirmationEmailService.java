package com.sahin.sarkar.designpatternsdemo.observer.email.subscriber;

import com.sahin.sarkar.designpatternsdemo.observer.email.publisher.OrderPublisher;

public class OrderConfirmationEmailService implements EmailNotificationService {

	private int id;

	public OrderConfirmationEmailService(int id) {
		System.out.println("OrderConfirmationEmailService with id = " + id);
		this.id = id;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void update(OrderPublisher order) {
		System.out.println("order placed by customer = " + order);
	}
}
