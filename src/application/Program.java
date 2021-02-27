package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat dateAndTime = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		System.out.println("Enter client data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Date of Birth: ");
		Date dateOfBirth = date.parse(sc.next());
		
		Client client = new Client(name, email, dateOfBirth);
		
		System.out.println("Enter order data: ");
		System.out.print("Enter order status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		Order order = new Order(new Date(), status);
		
		System.out.print("How many items to this order? ");
		int numberOfItems = sc.nextInt();
		
		
		
		for (int i=1;i<=numberOfItems;i++) {
			sc.nextLine();
			System.out.println("Enter product #" + i + " data:");
			System.out.print("Product name: ");
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double price = sc.nextDouble();
			
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			
			Product product = new Product(productName, price);
			OrderItem orderItem = new OrderItem(quantity, price, product);
			order.addItem(orderItem);
		}
		
		System.out.println("ORDER SUMMARY: ");
		System.out.println("Order moment: " + order.getMoment());
		System.out.println("Order status: " + order.getStatus());
		System.out.println("Cliente: " + client);
		System.out.println("Order items: ");
		
		for (OrderItem orderItem : order.getOrderItems()) {
			System.out.println(orderItem.getProduct().getName()
					+ ", $" + String.format("%.2f", orderItem.getPrice()) 
					+ ", Quantity: " + orderItem.getQuantity()
					+ ", Subtotal: $" + String.format("%.2f", orderItem.subTotal()));
		}
		
		System.out.println("Total price: $" + String.format("%.2f", order.total()));
		
			
		
		sc.close();

	}

}
