# Metro.Transit.Consumer

Springboot application which is used to consume Metro Transit Services and return next bus time.

```json
Sample Request 1:
-----------------
REST URI: GET http://localhost:9090/api/nextbus/get/Brooklyn Ctr - Fremont - 26th Av - Chicago - MOA/44th Ave  and Fremont Ave /north

Sample Response 1:
------------------
3 Min


Sample Request 2:
-----------------
REST URI: GET http://localhost:9090/api/nextbus/RequestMappingGET/Brooklyn Ctr - Fremont - 26th Av - Chicago - MOA/44th Ave  and Fremont Ave /north

Sample Response 2:
------------------
3 Min


Sample 3:
---------
REST URI: POST http://localhost:9090/api/nextbus/PostMapping
Content-Type: application/json
Request:
{
	"BUS_ROUTE" : "Brooklyn Ctr - Fremont - 26th Av - Chicago - MOA",
	"BUS_STOP_NAME" : "44th Ave  and Fremont Ave ",
	"DIRECTION" : "north"
}

Response 3:
-----------
3 Min

Sample 4:
---------
REST URI: POST http://localhost:9090/api/nextbus/RequestMappingPOST
Content-Type: application/json
Request:
{
	"BUS_ROUTE" : "Brooklyn Ctr - Fremont - 26th Av - Chicago - MOA",
	"BUS_STOP_NAME" : "44th Ave  and Fremont Ave ",
	"DIRECTION" : "north"
}

Response 4:
-----------
3 Min


Sample Request 5:
-----------------
REST URI: GET http://localhost:9090/api/RefreshRoutes

Sample Response 5:
------------------
Successfully loaded Routes

```
