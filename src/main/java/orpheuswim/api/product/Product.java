package orpheuswim.api.product;

import jakarta.persistence.*;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Table(name = "products")
@Entity(name = "Product")

public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private BigDecimal price;
    private String imageUrl;

    @Enumerated(EnumType.STRING)
    private Category category;

    private LocalDateTime createdAt;



    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now(); // seta a data na hora de salvar
    }

    public Product(RegisterProductData data) {
        this.title = data.title();
        this.description = data.description();
        this.price = data.price();
        this.imageUrl = data.imageUrl();
        this.category = Category.fromString(data.category());
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Category getCategory() {
        return category;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
