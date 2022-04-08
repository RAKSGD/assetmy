package com.sprint1.assets.service;
import com.sprint1.assets.exception.NotFoundException;
import com.sprint1.assets.model.Asset;

public interface AssetService {

public boolean deleteAsset(int assetId) throws NotFoundException;
public boolean modifyAsset(Asset asset) throws NotFoundException;

}

