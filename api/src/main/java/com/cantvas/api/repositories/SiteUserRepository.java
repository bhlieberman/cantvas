package com.cantvas.api.repositories;

import org.springframework.data.repository.CrudRepository;

import com.cantvas.api.models.SiteUser;

public interface SiteUserRepository extends CrudRepository<SiteUser, Long> {
    SiteUser findByUsername(String username);
}
