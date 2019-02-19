<b>RANDOM BEER APPLICATION REST API</b>

# Create Beer
Http Method: POST
<br>
/v1/beers/ 
<br>
<i>
Request Sample: 
<br>
{
	"name": "sampleBeerName",
	"description": "sampleBeerDesc",
	"alcoholPercentage" :"5.0",
	"breweryLocation": "China"
}
<p>
Response Sample:
<br>{
  "id": "5c6b5395b2aa101127d48e6b",
  "name": "sampleBeerName",
  "description": "sampleBeerDesc",
  "alcoholPercentage": "5.0",
  "breweryLocation": "China"
} 
</i>

# Update Beer
Http Method: PUT
<br>
/v1/beers/{id} 
<br>
<i>
Request Sample:  http://localhost:9090/v1/beers/5c6b5395b2aa101127d48e6b
{
	"name": "sampleBeerName",
	"description": "sampleBeerDesc",
	"alcoholPercentage" :"5.0",
	"breweryLocation": "China"
}
	<p>
Response Sample: <br>{
  "id": "5c6b5395b2aa101127d48e6b",
  "name": "sampleBeerName",
  "description": "sampleBeerDesc",
  "alcoholPercentage": "5.0",
  "breweryLocation": "China"
}
		</i>

# Delete Beer
Http Method: DELETE
<br>
/v1/beers/{id} 
<br>
<i>
Request Sample:<br>  http://localhost:9090/v1/beers/5c6b5395b2aa101127d48e6b
<p>
Response Sample:<br> 5c6b5395b2aa101127d48e6b
</i>

# Retrieve List Of Beers
Http Method: GET
<br>
/v1/beers/
<br>
Request Sample:<br> http://localhost:9090/v1/beers/
<p>
Response Sample: 
<br>
[
  {
    "id": "5c6affa5b2aa108a1571bb2d",
    "name": "Efes",
    "description": "Efes Pilsener",
    "alcoholPercentage": "4.0",
    "breweryLocation": "Izmir"
  },
  {
    "id": "5c6affc9b2aa108a1571bb2f",
    "name": "Rebel Red",
    "description": "Francescan Well Red Ale",
    "alcoholPercentage": "3.5",
    "breweryLocation": "Cork"
  }
 ]

# Retrieve Individual Beer
Http Method: GET
<br>
/v1/beers/{id}
<br>
Request Sample:<br> http://localhost:9090/v1/beers/5c6affa5b2aa108a1571bb2d
<p>
Response Sample: <br>
{
  "id": "5c6affa5b2aa108a1571bb2d",
  "name": "Efes",
  "description": "Efes Pilsener",
  "alcoholPercentage": "4.0",
  "breweryLocation": "Izmir"
}


# Retrieve Random Beer
Http Method: GET
<br>
/v1/beers/random
<br>
Request Sample:<br> http://localhost:9090/v1/beers/random
Response Sample: <br>
{
  "id": "5c6affa5b2aa108a1571bb2d",
  "name": "Efes",
  "description": "Efes Pilsener",
  "alcoholPercentage": "4.0",
  "breweryLocation": "Izmir"
}


# BUILD:
mvn clean install

# RUN
java -jar target/beer-nrc-0.0.1-SNAPSHOT.jar

# DOCKER
mvn clean package docker:build
