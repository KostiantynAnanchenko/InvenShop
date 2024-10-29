package project.InvenShop.product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.util.UUID;



@Data
@RequiredArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    private long id;
    @Column
    private String name;
    @Column
    private int quantity;
    @Column
    private int price;
    @Column
    private long EAN;

    public Product(String name, int quantity, int price, long EAN) {
        this.id = UUID.randomUUID().getLeastSignificantBits();
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.EAN = EAN;
    }
}
