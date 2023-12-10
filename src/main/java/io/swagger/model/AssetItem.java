package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AssetItem
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-12-09T18:32:47.495412114Z[GMT]")


public class AssetItem   {
  @JsonProperty("id")
  private UUID id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("promotionStatus")
  private boolean promotionStatus = false;

  @JsonProperty("children")
  @Valid
  private List<UUID> children = null;

  public AssetItem(UUID _id, String name2, boolean promotionStatus2, List<UUID> children2) {
    this.id = _id;
    this.name = name2;
    this.promotionStatus = promotionStatus2;
    this.children = children2;
  }

  public AssetItem id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * User ID in Gen 1 UUID format
   * @return id
   **/
  @Schema(example = "9858c2e8-96aa-11ee-b9d1-0242ac120002", required = true, description = "User ID in Gen 1 UUID format")
      @NotNull

    @Valid
    public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public AssetItem name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   **/
  @Schema(example = "SuperCool Asset", required = true, description = "")
      @NotNull

    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public AssetItem promotionStatus(boolean promotionStatus) {
    this.promotionStatus = promotionStatus;
    return this;
  }

  /**
   * Get promotionStatus
   * @return promotionStatus
   **/
  @Schema(example = "false", description = "")
  
    public boolean getPromotionStatus() {
    return promotionStatus;
  }

  public void setPromotionStatus(boolean promotionStatus) {
    this.promotionStatus = promotionStatus;
  }

  public AssetItem children(List<UUID> children) {
    this.children = children;
    return this;
  }

  public AssetItem addChildrenItem(UUID childrenItem) {
    if (this.children == null) {
      this.children = new ArrayList<UUID>();
    }
    this.children.add(childrenItem);
    return this;
  }

  /**
   * Get children
   * @return children
   **/
  @Schema(description = "")
      @Valid
    public List<UUID> getChildren() {
    return children;
  }

  public void setChildren(List<UUID> children) {
    this.children = children;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AssetItem assetItem = (AssetItem) o;
    return Objects.equals(this.id, assetItem.id) &&
        Objects.equals(this.name, assetItem.name) &&
        Objects.equals(this.promotionStatus, assetItem.promotionStatus) &&
        Objects.equals(this.children, assetItem.children);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, promotionStatus, children);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AssetItem {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    promotionStatus: ").append(toIndentedString(promotionStatus)).append("\n");
    sb.append("    children: ").append(toIndentedString(children)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
