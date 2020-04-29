package com.guitar.db.repository;

public class ModelJpaRepositoryCustomImpl implements ModelJpaRepositoryCustom {

    @Override
    public void aCustomMethod() {
        System.out.println("This is a custom method with more robust business logic");
    }

}