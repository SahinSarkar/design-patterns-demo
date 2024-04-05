package com.sahin.sarkar.designpatternsdemo.observer.email.subscriber;

import com.sahin.sarkar.designpatternsdemo.observer.email.publisher.OrderPublisher;

public class DeliveryConfirmationEmailService implements EmailNotificationService {

	private int id;

	public DeliveryConfirmationEmailService(int id) {
		System.out.println("DeliveryConfirmationEmailService with id = " + id);
		this.id = id;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void update(OrderPublisher order) {
		System.out.println("Delivery completed = " + order);
	}
}
