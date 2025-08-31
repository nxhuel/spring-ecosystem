package com.nxhu.restfull_api.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nxhu.restfull_api.persistence.entity.LocalEntity;

@Repository
public interface ILocalRepository extends JpaRepository<LocalEntity, Long> {

	Optional<LocalEntity> findByNameIgnoreCase(String name);
}
