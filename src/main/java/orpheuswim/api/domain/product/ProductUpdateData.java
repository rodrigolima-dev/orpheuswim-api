package orpheuswim.api.domain.product;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductUpdateData(
        @NotNull
        Long id,
        String title,
        String description,
        BigDecimal price,
        String imageUrl

) {
}
