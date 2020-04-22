# workout_api

A simple API to store your favourite workouts using MongoDB and Spring Boot. 

Example query to add a workout in the database:</br>
POST : localhost:8080/api/v1</br>
DATA:</br>
  {"splitType":"UPPER",</br>
   "exercises":</br>
   [</br>
     {</br>
        "bodyPart":"BACK",</br>
        "exerciseName":"Pull Ups",</br>
        "sets":[12,12,12],</br>
        "description":""</br>
     },</br>
     {</br>
        "bodyPart":"CHEST",</br>
        "exerciseName":"Push Ups",</br>
        "sets":[12,12,12],</br>
        "description":""</br>
      }</br>
   ]</br>
  }</br>
  
  GET, PUT and DELETE mappings are also available, but they are pretty straight-forward. Take a look at the WorkoutController.java file for details.
