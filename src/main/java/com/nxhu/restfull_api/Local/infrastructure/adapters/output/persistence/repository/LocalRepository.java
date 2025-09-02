package com.nxhu.restfull_api.local.infrastructure.adapters.output.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nxhu.restfull_api.local.infrastructure.adapters.output.persistence.entity.LocalEntity;

@Repository
public interface LocalRepository extends JpaRepository<LocalEntity, Long> {

}
