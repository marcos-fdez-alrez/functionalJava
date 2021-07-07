package es.nom.marcosfernandez.functional.chapter1;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

@Component
public class Introduction {

    public final static List<BigDecimal> prices = Arrays.asList(
            new BigDecimal("5"), new BigDecimal("10"),
            new BigDecimal("21"), new BigDecimal("7"), new BigDecimal("3"));

    public BigDecimal calculateTotalDiscount(List<BigDecimal> prices, BigDecimal discount, BigDecimal priceLimit) {
        return prices.stream()
                .filter(price -> price.compareTo(priceLimit) > 0)
                .map(price -> price.multiply(discount))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal alternativeCalculateTotalDiscount(List<BigDecimal> prices, BigDecimal discount, BigDecimal priceLimit) {
        Predicate<BigDecimal> predicate = price -> price.compareTo(priceLimit) > 0;

        Function<BigDecimal, BigDecimal> function = price -> price.multiply(BigDecimal.ONE.subtract(discount));

        return prices.stream()
                .filter(predicate)
                .map(function)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
