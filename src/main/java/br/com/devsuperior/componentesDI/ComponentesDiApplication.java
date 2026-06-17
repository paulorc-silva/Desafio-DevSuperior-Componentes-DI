package br.com.devsuperior.componentesDI;

import br.com.devsuperior.componentesDI.entities.Order;
import br.com.devsuperior.componentesDI.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class ComponentesDiApplication implements CommandLineRunner {

	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(ComponentesDiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		int code = sc.nextInt();
		double basicValue = sc.nextDouble();
		double discountPercentage = sc.nextDouble();

		Order order = new Order(code, basicValue, discountPercentage);

		System.out.println("Pedido código " + code);
		System.out.printf("Valor total: R$ %.2f", orderService.total(order));
	}
}
