package com.example.productservicettsevening.InheritanceExample.singletableclass;


import org.springframework.data.jpa.repository.JpaRepository;

public interface STUserRepository extends JpaRepository<User,Long> {
   User save(User user);
    User findUserById(Long id);
}
