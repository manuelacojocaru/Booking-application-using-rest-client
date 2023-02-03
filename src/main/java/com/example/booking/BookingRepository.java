package com.example.booking;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface BookingRepository extends CrudRepository<Hotel, Integer> {
}
