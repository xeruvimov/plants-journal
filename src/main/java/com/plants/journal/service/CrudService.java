package com.plants.journal.service;

import java.util.List;
import java.util.UUID;

/**
 * Contract
 *
 * @param <T> - response DTO.
 * @param <U> - request DTO.
 */
public interface CrudService<T, U> {
    T findById(UUID id);

    List<T> findAll();

    UUID create(U dto);

    UUID update(T dto);

    void delete(UUID id);
}
