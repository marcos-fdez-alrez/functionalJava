package es.nom.marcosfernandez.functional;

import es.nom.marcosfernandez.functional.chapter1.Introduction;
import es.nom.marcosfernandez.functional.chapter2.CollectionProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Optional;

@SpringBootApplication
public class FunctionalApplication implements CommandLineRunner {

    private static final BigDecimal DISCOUNT = BigDecimal.valueOf(0.25);
    private static final BigDecimal LIMIT_AMOUNT = BigDecimal.valueOf(0.9);
    private static final String LETTER = "J";

    @Autowired
    private Introduction introduction;

    @Autowired
    private CollectionProcessor collectionProcessor;

    private final static Logger LOG = LoggerFactory
            .getLogger(FunctionalApplication.class);

    public static void main(String[] args) {
        LOG.info("Starting FunctionalApplication");
        SpringApplication.run(FunctionalApplication.class, args);
        LOG.info("Finishing FunctionalApplication");
    }

    @Override
    public void run(String... args) {
        LOG.info(" Chapter 1 Examples \n");
        LOG.info(" Calculate the sum amount of apply a " + DISCOUNT + " in prices over " + LIMIT_AMOUNT + " of the list " + Introduction.prices);
        LOG.info(" Result: " + introduction.alternativeCalculateTotalDiscount(Introduction.prices, DISCOUNT, LIMIT_AMOUNT));

        LOG.info(" Chapter 2 Examples \n");
        LOG.info(" List of names: ");
        LOG.info(collectionProcessor.printNames.apply(CollectionProcessor.names));
        LOG.info(" Filter names with starts with letter " + LETTER);
        CollectionProcessor.names.stream()
                .filter(collectionProcessor.startsWithLeter.apply(LETTER))
                .forEach(System.out::println);

        LOG.info(" Optional use  ");

        LOG.info(collectionProcessor.smallerString.apply(CollectionProcessor.names).orElseGet(() -> "defaultName"));

        LOG.info("alternative method (not best practice)");
        Optional<String> finalName = collectionProcessor.smallerString.apply(CollectionProcessor.names);
        finalName.ifPresent(LOG::info);

        LOG.info(" Print Smaller names among list names and manuel ");
        LOG.info(collectionProcessor.manuelOrSmaller.apply(CollectionProcessor.names));
    }

}
