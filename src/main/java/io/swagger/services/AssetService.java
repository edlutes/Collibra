package io.swagger.services;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import io.swagger.database.AssetRepository;
import io.swagger.dtos.AssetDTO;
import io.swagger.dtos.AssetDTOMapper;
import io.swagger.model.AssetItem;

public interface AssetService {

    //AssetDTO save(AssetItem asset);
    AssetItem save(AssetItem asset);
    List<AssetItem> getAllAssetItems();
    AssetItem getAssetbyUUID(UUID id);
    void deleteAssetbyUUID(UUID id);

    // Define all new methods here
    boolean promoteAsset(AssetItem asset);

}
