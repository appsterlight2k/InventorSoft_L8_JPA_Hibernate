package co.inventorsoft.academy.hibernate.util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Objects;

public class JpaUtil {
    private static final String PERSISTENCE_UNIT_NAME = "BasicEntitiesMySQL";
    private static EntityManagerFactory factory;

    public static EntityManagerFactory getEntityManagerFactory() {
        if (Objects.isNull(factory)) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }

        return factory;
    }

    public static void close() {
        if (!Objects.isNull(factory)) {
            factory.close();
        }
    }
}
