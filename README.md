# microserviceAssignment
Implemented Three micro services 
1) Homepage Service
access url : http://localhost:8081/Telstra/homePage/500082
response json is {"stockDetails":{"name":"Telstra Corporation Limited","price":3.41,"change":0.08,"currency":"AUD","bid":3.4},
"weatherSummary":{"country":"IND","city":"HYDERABAD","zipCode":"500082","temperature":"28°C","wind":"10","humidity":"86","precipitation":"2%"}}

 2) Stock Service (using Yahoo Finance API)
access url : http://localhost:8082/weather/500082
response json is {"country":"IND","city":"HYDERABAD","zipCode":"500082","temperature":"28°C","wind":"10","humidity":"86","precipitation":"2%"}

3) Weather Service (using Mock Data)
access url : http://localhost:8083/stock/TLS.AX
{"name":"Telstra Corporation Limited","price":3.41,"change":0.08,"currency":"AUD","bid":3.4}

Implemented using Netflix Service Discovery, Circuit Breaker patterns.

