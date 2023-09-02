package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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


		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter Client data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("E-mail: ");
		String email = sc.nextLine();
		System.out.print("Brith date (DD/MM/YYYY): ");
		Date nasc = sdf.parse(sc.next());
		
		Client client = new Client(name, email, nasc);
		
		System.out.println();
		System.out.println("Enter order data:");
		System.out.print("Status");
		OrderStatus status = OrderStatus.valueOf(sc.next());	
		
		
		System.out.print("How many items to this order?");
		int n = sc.nextInt();
			
		Order order = new Order(new Date(), status, client);
		
		for(int i = 0; i < n; i++) {
			System.out.println("Enter #" + (i+1) + " item data:" );
			sc.nextLine();
			System.out.print("Product name: ");
			String nameProduct = sc.nextLine();
			System.out.print("Product price: ");
			double price =  sc.nextDouble();
			System.out.print("Quantities: ");
			int quantities = sc.nextInt();
			
			Product prod = new Product(nameProduct, price);
			
			OrderItem orderItem = new OrderItem(quantities, price, prod);
			
			order.addItem(orderItem);
			
		}
		
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);
		
		
		
		
		
		sc.close();
	}

}
