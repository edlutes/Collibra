# Collibra Demo
Spring application with basic CRUD operations interfacing with MongoDB.

The good:
The wiring between the Spring application and MongoDB are functioning with the service abstraction.
Created using OpenAPI 3.0 stubs so documentation should come easier.
Creating an Asset works, promoting an asset appears to work but isn't fully tested.

The bad:
Deleting is currently not implemented, nor is update.  
Update would be a rather quick fix, but burdensome based on the input being the whole Asset as opposed to an identifier (name/UUID) and the field/values to be updated.
If I had time, I would leave the current endpoint as is and add new options to be able to update {name, List <Map> field:value}
Internally delete is implemented by searching for the UUID and removing from the db.  Unfortunately, it's not plumbed correctly so it is not exposed.

OpenAPI 3.0 was used to create the code stubs.
MongoDB (3.4.10) was used to store persistent data.
