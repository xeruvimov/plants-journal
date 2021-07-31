package com.plants.journal.service;

import java.util.List;
import java.util.UUID;

/**
 * Contract
 *
 * @param <T> - response DTO.
 * @param <U> - request DTO.
 */
public interface CrudSecurityService<T, U> {
    T findById(UUID id, String userName);

    List<T> findAll(String userName);

    UUID create(U dto, String userName);

    UUID update(T dto, String userName);

    void delete(UUID id, String userName);

}
