package Application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entitie_Enum.OrderStatus;
import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		DateTimeFormatter fmtLocalDate = DateTimeFormatter.ofPattern("dd/MM/yyy");

		System.out.println("Enter cliente data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date: ");
		LocalDate birthDate = LocalDate.parse(sc.next(), fmtLocalDate);
		
		Client client = new Client(name, email, birthDate);
		
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		Order order = new Order(LocalDateTime.now(), status , client);

		System.out.print("How many items to this order? ");
		int num = sc.nextInt();

		for (int i = 1; i <= num; i++) {

			System.out.println("Enter #" + i + " item data: ");
			System.out.print("Product name: ");
			String productName = sc.next();
			System.out.print("Product price: ");
			Double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			Integer quantity = sc.nextInt();

			OrderItem orderItem = new OrderItem(quantity, productPrice, new Product(productName, productPrice));
			order.additem(orderItem);
		}
		
		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);
				

		sc.close();
	}

}
