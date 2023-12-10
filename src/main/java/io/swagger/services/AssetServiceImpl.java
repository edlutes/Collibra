package io.swagger.services;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.swagger.database.AssetRepository;
import io.swagger.model.AssetItem;

@Service
@Transactional
public class AssetServiceImpl implements AssetService{

    private static final Logger log = LoggerFactory.getLogger(AssetServiceImpl.class);

    @Autowired
    private AssetRepository assetRepository;

    @Override
    public AssetItem save(AssetItem asset){
        return assetRepository.save(asset);
    }

    @Override
    public List<AssetItem> getAllAssetItems(){
        return this.assetRepository.findAll();
    }

    @Override
    public AssetItem getAssetbyUUID(UUID id){
        Optional <AssetItem> assetDb = this.assetRepository.findById(id);
        if (assetDb.isPresent())
            return assetDb.get();
        else{
            log.warn("Asset with id (" + id + ") requested but not found");
            return null;
        }
    }

    @Override
    public void deleteAssetbyUUID(UUID id){
        Optional <AssetItem> assetDb = this.assetRepository.findById(id);
        if (assetDb.isPresent()){
            this.assetRepository.delete(assetDb.get());
        }
        else{
            log.warn("Asset with id (" + id + ") requested for deletion but not found");
        }
        return;
    }

    @Override
    // Would add other formats given time, promoting by name/UUID makes the most sense
    public boolean promoteAsset(AssetItem asset) {
        if (asset == null || asset.getId() == null)
        {
            log.error("Requested to promote an invalid asset.");
            return false;
        }
        Optional <AssetItem> assetDb = this.assetRepository.findById(asset.getId());
        if (!assetDb.isPresent())
            {
                log.error("Requested Asset to promote: " + asset.getId() + " was not found. Unable to promote.");
                return false;
            }
        // We found a match in the database. Handle the updateing of the promotion status
        AssetItem _temp = this.assetRepository.findById(asset.getId()).get();
        _temp.setPromotionStatus(asset.getPromotionStatus());
        assetRepository.save(_temp);

        // Parent has been updated, so we need to go through all children and update their promotion status
        for (UUID childUUID : _temp.getChildren())
            {
                Optional <AssetItem> child = this.assetRepository.findById(childUUID);
                if(child.isPresent())
                {
                    // This should be a recursive call as the this doesn't handle the children's children 
                    // Leaving as is
                    AssetItem _tempChild = this.assetRepository.findById(asset.getId()).get();
                    _tempChild.setPromotionStatus(asset.getPromotionStatus());
                    assetRepository.save(_tempChild);
                }

            }
        return true;
    }

    
}
