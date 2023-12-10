package io.swagger.dtos;

import java.util.List;
import java.util.UUID;

import io.swagger.model.AssetItem;

public record AssetDTO (
    UUID id,
    String name,
    boolean promotionStatus,
    List<UUID> children){

        public AssetDTO() {
            this(null,"",false,null);
        }

        public AssetDTO(AssetItem a){
             this(a.getId() == null ? UUID.randomUUID() : a.getId(), a.getName(), a.getPromotionStatus(), a.getChildren());
        }

        public AssetItem toAssetItem(){
            UUID _id = id == null ? UUID.randomUUID() : id;
            return new AssetItem(_id, name, promotionStatus, children);
        }
}

