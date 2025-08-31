package com.nxhu.restfull_api.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nxhu.restfull_api.persistence.entity.ProductEntity;

@Repository
public interface IProductRepository extends JpaRepository<ProductEntity, Long> {
}
