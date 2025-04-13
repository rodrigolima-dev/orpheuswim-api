package orpheuswim.api.product;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record RegisterProductData(
        String title,
        String description,
        BigDecimal price,
        String imageUrl,
        String category
) {
}
