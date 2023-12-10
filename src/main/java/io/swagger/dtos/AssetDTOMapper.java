package io.swagger.dtos;

import java.util.function.Function;

import io.swagger.model.AssetItem;

public class AssetDTOMapper implements Function<AssetItem, AssetDTO>{

    public AssetDTO apply(AssetItem a){
        return new AssetDTO(a.getId(), a.getName(), a.getPromotionStatus(), a.getChildren());
    }
    
}
