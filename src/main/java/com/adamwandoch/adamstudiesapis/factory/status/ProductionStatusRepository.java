package com.adamwandoch.adamstudiesapis.factory.status;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Adam Wandoch
 */

public interface ProductionStatusRepository extends CrudRepository<ProductionStatus, String> {
}
