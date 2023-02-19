package com.cantvas.api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cantvas.api.models.SiteUser;

@Repository
public interface SiteUserRepository extends CrudRepository<SiteUser, Long> {
    SiteUser findByUsername(String username);
}
