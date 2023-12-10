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
public interface AssetApi {

    @Operation(summary = "adds an asset", description = "Adds an asset to the system", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "asset created"),
        
        @ApiResponse(responseCode = "400", description = "invalid input, object invalid"),
        
        @ApiResponse(responseCode = "409", description = "an existing asset already exists") })
    @RequestMapping(value = "/asset",
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Void> addAsset(@Parameter(in = ParameterIn.DEFAULT, description = "Asset item to add", schema=@Schema()) @Valid @RequestBody AssetItem body
);


    @Operation(summary = "deletes an asset by id", description = "Deletes an asset from the system", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "asset deleted"),
        
        @ApiResponse(responseCode = "400", description = "invalid input, object invalid"),
        
        @ApiResponse(responseCode = "409", description = "asset does not exist") })
    @RequestMapping(value = "/asset",
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteAsset();


    @Operation(summary = "searches assets", description = "By passing in the appropriate options, you can search for available inventory in the system ", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = AssetItem.class)))),
        
        @ApiResponse(responseCode = "400", description = "bad input parameter") })
    @RequestMapping(value = "/asset",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<AssetItem>> searchAsset(@Parameter(in = ParameterIn.QUERY, description = "pass an optional search string for looking up inventory" ,schema=@Schema()) @Valid @RequestParam(value = "searchString", required = false) String searchString
, @Min(0)@Parameter(in = ParameterIn.QUERY, description = "number of records to skip for pagination" ,schema=@Schema(allowableValues={ "0" }
)) @Valid @RequestParam(value = "skip", required = false) Integer skip
, @Min(0) @Max(50) @Parameter(in = ParameterIn.QUERY, description = "maximum number of records to return" ,schema=@Schema(allowableValues={ "0", "50" }, maximum="50"
)) @Valid @RequestParam(value = "limit", required = false) Integer limit
);


    @Operation(summary = "updates an existing asset", description = "Update an existing asset in the system", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "asset updated"),
        
        @ApiResponse(responseCode = "400", description = "invalid input, object invalid"),
        
        @ApiResponse(responseCode = "409", description = "asset does not exist") })
    @RequestMapping(value = "/asset",
        consumes = { "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateAsset(@Parameter(in = ParameterIn.DEFAULT, description = "Updated asset", schema=@Schema()) @Valid @RequestBody AssetItem body
);

}

