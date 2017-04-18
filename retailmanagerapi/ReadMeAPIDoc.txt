====================================================================================================
====================================================================================================
Create Shop - (POST):
====================================================================================================
====================================================================================================
Example (1)  ---------------------------------------------------------------------------------------

request method - POST
url: localhost:8080/shops

request object:
{
  "shopName": "One New Change",
  "shopNumber": "1",
  "postalCode": "EC4M 9AF"
}

response object:

{
  "shopName": "One New Change",
  "shopNumber": "1",
  "postalCode": "EC4M 9AF",
  "latitude": 51.513819,
  "longitude": -0.09558079999999999,
  "formatted_address": "3rd Floor, 1 New Change, London EC4M 9AF, UK",
  "place_id": "ChIJJwNc2aoEdkgRT744EaBS3pk"
}

Example (2)  ---------------------------------------------------------------------------------------

request method - POST
url: localhost:8080/shops

request object:
{
  "shopName": "Shopping Center MyZeil",
  "shopNumber": "106",
  "postalCode": "60313"
}

response object:
{
  "shopName": "Shopping Center MyZeil",
  "shopNumber": "106",
  "postalCode": "60313",
  "latitude": 50.1144604,
  "longitude": 8.6817742,
  "formatted_address": "Shopping Center MyZeil, MyZeil, Zeil 106, 60547 Frankfurt am Main, Germany",
  "place_id": "ChIJZ3J6h68OvUcRzh3B4yQX1So"
}

Example (3)  ---------------------------------------------------------------------------------------

request method - POST
url: localhost:8080/shops

request object:

{
  "shopName": "Skyline Plaza Frankfurt",
  "shopNumber": "6",
  "postalCode": "60327"
}

response object:

{
  "shopName": "Skyline Plaza Frankfurt",
  "shopNumber": "6",
  "postalCode": "60327",
  "latitude": 50.1100664,
  "longitude": 8.651494899999999,
  "formatted_address": "Skyline Plaza Frankfurt, Europa-Allee 6, 60327 Frankfurt am Main, Germany",
  "place_id": "ChIJoRX0cgrhvkcR9c5dEuTNxZE"
}

Example (4)  ---------------------------------------------------------------------------------------

request method - POST
url: localhost:8080/shops

request object:

{
  "shopName": "Olympia-Einkaufszentrum",
  "shopNumber": "68",
  "postalCode": "80993"
}

response object:

{
  "shopName": "Olympia-Einkaufszentrum",
  "shopNumber": "68",
  "postalCode": "80993",
  "latitude": 48.1835757,
  "longitude": 11.5316385,
  "formatted_address": "Hanauer Str. 68, 80993 München, Germany",
  "place_id": "ChIJJQiE0fZ2nkcRhzwtwtVKqv8"
}

Example (5)  ---------------------------------------------------------------------------------------

request method - POST
url: localhost:8080/shops

request object:
{
  "shopName": "Burlington Arcade",
  "shopNumber": "51",
  "postalCode": "W1J 0QJ"
}

response object:
{
  "shopName": "Burlington Arcade",
  "shopNumber": "51",
  "postalCode": "W1J 0QJ",
  "latitude": 51.5089779,
  "longitude": -0.140237,
  "formatted_address": "51 Piccadilly, Mayfair, London W1J 0QJ, UK",
  "place_id": "ChIJjyvv_9UEdkgRUrbU725BBf4"
}

Example (6)  ---------------------------------------------------------------------------------------

request method - POST
url: localhost:8080/shops

request object:

{
  "shopName": "Alexa",
  "shopNumber": "20",
  "postalCode": "10179"
}

response object:
{
  "shopName": "Alexa",
  "shopNumber": "20",
  "postalCode": "10179",
  "latitude": 52.5199023,
  "longitude": 13.4147944,
  "formatted_address": "Grunerstraße 20, 10179 Berlin, Germany",
  "place_id": "ChIJ9zT4ayJOqEcRogVDca0TJxA"
}




====================================================================================================
====================================================================================================
Find closest Shop - (GET):
====================================================================================================
====================================================================================================

Example (1)  ---------------------------------------------------------------------------------------
request method - GET
url-             localhost:8080/closest/50.11/8.68

Example (2)  find me closet shop from Heathrow Airport (LHR)-----------------------------------------
request method - GET
url-             localhost:8080/closest/51.4700256/-0.4564842

Example (3)  find me closet shop from Berlin Tegel Airport-------------------------------------------
request method - GET
url-             localhost:8080/closest/52.5580555556/13.2847222222













