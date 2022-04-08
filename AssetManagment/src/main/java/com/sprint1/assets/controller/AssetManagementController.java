package com.sprint1.assets.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint1.assets.exception.NotFoundException;
import com.sprint1.assets.model.Asset;
import com.sprint1.assets.service.AssetServiceImpl;

@RestController
@RequestMapping(path = "/api/asset")
public class AssetManagementController {
	// Creating logger Object
	Logger logger = org.slf4j.LoggerFactory.getLogger(AssetManagementController.class);
	@Autowired
	AssetServiceImpl assetImplementation;

	// Removing Assets
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<String> deleteAsset(@PathVariable int id) throws NotFoundException {
		boolean assetRemoved = assetImplementation.deleteAsset(id);
		logger.info("Asset Deleted");
		if (assetRemoved == false) {
			throw new NotFoundException("Invalid AssetId");
		}
		ResponseEntity<String> response = new ResponseEntity<>("Asset with the ID" + id + "is deleted", HttpStatus.OK);

		return response;
	}

	// Updating Assets
	@PutMapping(path = "/update")
	public ResponseEntity<String> updateAsset(@RequestBody Asset asset) throws NotFoundException {
		boolean assetUpdated = assetImplementation.modifyAsset(asset);
		logger.info("Asset Updated");

		if ((assetUpdated == false)) {
			throw new NotFoundException("invaild");

		}
		return new ResponseEntity<String>("Asset updated successfully", HttpStatus.OK);
	}

}
