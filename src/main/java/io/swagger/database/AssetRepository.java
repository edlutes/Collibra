package io.swagger.database;
import java.util.List;
import java.util.UUID;

import io.swagger.model.AssetItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface AssetRepository extends MongoRepository<AssetItem, UUID> {
 
  // Custom methods for interfacing with Mongo would go here
  //List<AssetItem> findByUUID(UUID uuid);
  //List<AssetItem> findByPromotion(boolean promotionStatus);
 
}