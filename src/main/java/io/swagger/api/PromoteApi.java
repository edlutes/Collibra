/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.51).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.AssetItem;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CookieValue;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-12-09T18:32:47.495412114Z[GMT]")
@Validated
public interface PromoteApi {

    @Operation(summary = "promote a specified asset", description = "Promotes the specified Asset", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "asset promoted"),
        
        @ApiResponse(responseCode = "400", description = "invalid operation"),
        
        @ApiResponse(responseCode = "409", description = "unable to promote.") })
    @RequestMapping(value = "/promote",
        consumes = { "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<Void> promoteAsset(@Parameter(in = ParameterIn.DEFAULT, description = "Asset to promote", schema=@Schema()) @Valid @RequestBody AssetItem body
);

}

