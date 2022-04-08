package com.sprint1.assets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint1.assets.model.Asset;

@Repository
public interface AssetManagementRepository extends JpaRepository<Asset, Integer> {

}