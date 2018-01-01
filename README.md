# David Stumpe
## Event Tracker Project

Deployed on AWS http://18.216.47.133:8080/EventTracker/
Currently there is no web page functionality.
To use and test functionality with database use PostMan.

* To test server
* http://18.216.47.133:8080/EventTracker/rest/ping
* You should receive a pong.

* To get a list a vehicles insert into PostMan http://18.216.47.133:8080/EventTracker/rest/vehicles.

* Get vehicle by Id
http://18.216.47.133:8080/EventTracker/rest/vehicles/1

* Add a new vehicle
* Use Post
* http://18.216.47.133:8080/EventTracker/rest/vehicles/
* Enter following information make and model are strings and the rest are integers
    {
        "make": "",
        "model": "",
        "year": ,
        "currentMiles": ,
        "milesDue":
    }

* Update a vehicle
* Use put
* get all the information from the get of the vehicle and just change the information you want. leave out the id.

* to delete
* http://18.216.47.133:8080/EventTracker/rest/vehicles/{id}
* will receive true if deleted
