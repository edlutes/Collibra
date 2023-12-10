package io.swagger.api;

import io.swagger.model.AssetItem;
import io.swagger.services.AssetService;
import io.swagger.services.AssetServiceImpl;
import io.swagger.database.AssetRepository;
import io.swagger.dtos.AssetDTO;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-12-09T18:32:47.495412114Z[GMT]")
@ComponentScan({"io.swagger.database"})
@RestController
public class AssetApiController implements AssetApi {

    private static final Logger log = LoggerFactory.getLogger(AssetApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private AssetRepository assetRepository;


    @org.springframework.beans.factory.annotation.Autowired
    public AssetApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

     public ResponseEntity<Void> addAsset(@Parameter(in = ParameterIn.DEFAULT, description = "Asset item to add", schema=@Schema()) @Valid @RequestBody AssetItem body
) {
        String accept = request.getHeader("Accept");
        log.info("We received request to add: " + body.getId().toString());
        // At this point I know we have a valid request to add coming in
        // Next step is to add the object to a db to keep it persistent
        try
        {
            //this.assetRepository.save(body);
            AssetItem _assetItem = assetRepository.save(new AssetItem(body.getId(),body.getName(),body.getPromotionStatus(),body.getChildren()));
            log.info("Create an asset. Id: " + body.getId().toString());
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            log.error("Error while adding Asset. Exception: " + e);
            return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
        }
    }
    
    public ResponseEntity<Void> deleteAsset(@Parameter(in = ParameterIn.DEFAULT, description = "Delete asset by UUID", schema=@Schema()) @Valid @RequestBody AssetItem body
) {
        // This doesn't work as delete can't hold a request body. 
        String accept = request.getHeader("Accept");
        try
         {
            assetRepository.deleteById(body.getId());
            log.info("request to delete asset id: " + body.getId());
            return new ResponseEntity(HttpStatus.OK);
         }
         catch (Exception e)
        {
            log.error("Error while deleting Asset. Exception: " + e);
            return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
        }
    }

    public ResponseEntity<List<AssetItem>> searchAsset(@Parameter(in = ParameterIn.QUERY, description = "pass an optional search string for looking up inventory" ,schema=@Schema()) @Valid @RequestParam(value = "searchString", required = false) String searchString
,@Min(0)@Parameter(in = ParameterIn.QUERY, description = "number of records to skip for pagination" ,schema=@Schema(allowableValues={ "0" }
)) @Valid @RequestParam(value = "skip", required = false) Integer skip
,@Min(0) @Max(50) @Parameter(in = ParameterIn.QUERY, description = "maximum number of records to return" ,schema=@Schema(allowableValues={ "0", "50" }, maximum="50"
)) @Valid @RequestParam(value = "limit", required = false) Integer limit
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {

                return new ResponseEntity<List<AssetItem>>(objectMapper.readValue("[ {\n  \"children\" : [ \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" ],\n  \"name\" : \"SuperCool Asset\",\n  \"id\" : \"9858c2e8-96aa-11ee-b9d1-0242ac120002\",\n  \"promotionStatus\" : \"false\"\n}, {\n  \"children\" : [ \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" ],\n  \"name\" : \"SuperCool Asset\",\n  \"id\" : \"9858c2e8-96aa-11ee-b9d1-0242ac120002\",\n  \"promotionStatus\" : \"false\"\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<AssetItem>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<AssetItem>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updateAsset(@Parameter(in = ParameterIn.DEFAULT, description = "Updated asset", schema=@Schema()) @Valid @RequestBody AssetItem body
) {
        /* Out of time, but this isn't the best implementation either.  Taking in a whole object just 
         * to update is wasteful. Should be able to enter in UUID/name and field to be updated. This
         * is essentially a replace at this point.
         */
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<Void> deleteAsset() {
        /* I messed up in the schema design.  Thought I could pass a requestBody through delete 
        *  I would need to revisit this and come up with a better solution. Quick thought would be 
        *  a new endpoint that accepts a POST with a UUID and/or list of UUIDs to search for and 
        *  delete.
        */
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAsset'");
    }

}
