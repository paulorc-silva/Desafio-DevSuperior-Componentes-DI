package br.com.devsuperior.componentesDI.services;

import br.com.devsuperior.componentesDI.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private ShippingService shippingService;

    public double total(Order order) {
        double basicValue = order.getBasic();
        double discount = basicValue * (order.getDiscount() / 100);
        double shipment = shippingService.shipment(order);

        return (basicValue - discount) + shipment;
    }
}
