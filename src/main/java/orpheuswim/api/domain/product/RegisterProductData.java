package orpheuswim.api.domain.product;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record RegisterProductData(
        @NotBlank
        String title,
        @NotBlank
        String description,
        @NotNull
        @DecimalMin(value = "0.01", message = "O preço deve ser maior que zero")
        @Digits(integer = 10, fraction = 2, message = "Preço inválido")
        BigDecimal price,
        @NotBlank
        String imageUrl,
        @NotNull
        String category
) {
}
