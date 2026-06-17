package br.com.devsuperior.componentesDI.services;

import br.com.devsuperior.componentesDI.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {
    public double shipment(Order order) {
        double basicValue = order.getBasic();

        if (basicValue < 100) {
            return 20.0;
        } else if (basicValue >= 100 && basicValue < 200) {
            return 12.0;
        } else {
            return 0.0;
        }
    }
}
