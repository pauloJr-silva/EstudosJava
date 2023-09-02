package entities;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
 	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date momentDate;
	private OrderStatus status;
	
	List<OrderItem> items = new ArrayList<>();
	private Client client;
	
	
	public Order() {
		
	}

	public Order(Date momentDate, OrderStatus status, Client client) {
		this.momentDate = momentDate;
		this.status = status;
		this.client = client;
	}

	public Date getMomentDate() {
		return momentDate;
	}

	public void setMomentDate(Date momentDate) {
		this.momentDate = momentDate;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<OrderItem> getListOrder() {
		return items;
	}

	
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void addItem(OrderItem orderIntem) {
		items.add(orderIntem);
	}
	
	public void remuveItem(OrderItem orderItem) {
		items.remove(orderItem);
		
	}
	
	public double total() {
		double sum = 0.0;
		for(OrderItem item: items) {
			sum += item.subTotal();
		}
		
		return sum;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
				sb.append("Order Moment: ");
				sb.append(sdf.format(momentDate) + "\n");
				sb.append("Order Status: ");
				sb.append(status + "\n");
				sb.append("Client ");
				sb.append(client + "\n");
				sb.append("Ordem Items:\n");
				
				for (OrderItem item: items) {
					sb.append(item + "\n");
				}
				sb.append("Total price $");
				sb.append(String.format("%.2f", total()));
		
				return sb.toString();
	}
	
}
