**Assignment Title:** Implement an Email Notification System using the Observer Design Pattern.

**Background:**
An online retail store wants to implement a system to send email notifications to users when there are updates to their order status. Different types of emails (e.g., Order Confirmation, Shipment Update, Delivery Confirmation) need to be sent based on the specific status updates of an order.

**Your Task:**
Design and implement an Email Notification System using the Observer Design Pattern to achieve this. The assignment should be divided into two parts:

**Part 1:**

1. Define an `Observable`:
- An `Order` class that represents a user's order. This class should have attributes like orderId, userId, status, etc. It should be responsible for notifying different types of email services (observers) when order status changes.

2. Define `Observer`:
- An interface `EmailNotificationService` that represents different types of email notification services. This interface should define a method `update(Order order)` for receiving updates from `Order`.

**Part 2:**

1. Implement `Observers`:
- Create some specific `EmailNotificationService` classes like `OrderConfirmationEmailService`, `ShipmentUpdateEmailService`, and `DeliveryConfirmationEmailService`.
- Each email service should send out the relevant email notification when an `Order` status changes.

**Specific Requirements:**

1. When an order's status (like 'Order Placed', 'Shipped', 'Delivered') is updated, the relevant email notification service (observers) must automatically send out the appropriate emails.
2. Provide functionality in `Order` to add and remove observers.
3. Each specific `EmailNotificationService` (like `OrderConfirmationEmailService`, `ShipmentUpdateEmailService`, `DeliveryConfirmationEmailService`) should implement the `update(Order order)` method to send out the appropriate email based on its functionality.
4. Proper usage of the Observer pattern should be maintain throughout the design.

**Deliverable:**
- A project source code that fulfills the given requirements.
- Document explaining the design and how to run the code.

**Note:**

- You are free to use any programming language of your choice.
- Your solution will be judged on your ability to apply the Observer Pattern, code quality, and completion of the requirements
