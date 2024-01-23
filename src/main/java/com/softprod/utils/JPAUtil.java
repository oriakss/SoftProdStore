package com.softprod.utils;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class JPAUtil {

    private static final EntityManager ENTITY_MANAGER = buildEntityManager();

    private static EntityManager buildEntityManager() {
        return Persistence.createEntityManagerFactory("Test").createEntityManager();
    }

    public static EntityManager getEntityManager() {
        return ENTITY_MANAGER;
    }
}