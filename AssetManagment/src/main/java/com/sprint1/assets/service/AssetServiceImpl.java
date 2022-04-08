package com.sprint1.assets.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sprint1.assets.exception.NotFoundException;
import com.sprint1.assets.model.Asset;
import com.sprint1.assets.repository.AssetManagementRepository;

@Service("assetImplementation")
public class AssetServiceImpl implements AssetService {
	@Autowired
	AssetManagementRepository assetRepository;

	@Transactional
	@Override
	public boolean modifyAsset(Asset asset) throws NotFoundException {

		if (assetRepository.existsById(asset.getAssetId())) {
			assetRepository.save(asset);
			return true;
		}
		return false;
	}

	@Transactional
	@Override
	public boolean deleteAsset(int assetId) throws NotFoundException {
		if (assetRepository.existsById(assetId)) {
			assetRepository.deleteById(assetId);
			return true;
		}
		return false;
	}

}
