package com.fortier.sebastien.demo_db.accesingdatamysql;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findByEmail(String email);

    boolean existsByEmail(String email);
}
