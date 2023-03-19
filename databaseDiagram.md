![Database](https://www.planttext.com/api/plantuml/svg/hLN1Ri8m3BttAxnDcgYqQjeafWbL5QTTTjqTXTRGY2QjqdI0W7-V4q89h8LfMxX0_DvpdkEOSQsPqeqeWfiCPrmYL8eBfjQJ1Qu7gn3YQHAdPL6gqTtqzVNbYNxUKoY97-rk0gluSPgqx5cfaCzbotPKPjOtPilIR5gWmQFKNAzX1N4CWuy7MEPSOmZ9CG5n6o5zRPoP3uaBp3YB5AQboawow1m56IiObq4Gx9FX2bNAQwp3JG1muffduGYur3X7PMA-9xskq8_JGT_UwNXdi6Mf5cMZUv3E0vlZQIAtds6TAbvfNagAVpALvamDdeV3q0SrYZd4TuMS3fBhpj1YthajcS2EPC7EbKkL1PKAhjRgebohPghuPxMZN5EZchYIErN_ClmC5affhjwWJtBItJp_43_nv2SnLPtyhabGC5xqjyU_TO2BLgokgGnPFyBultPHhf0zPTeB_URf7Tu4qpYXAS7hd62Q2wJf9gh1ItWEibFl0gRpSP6De1qRi8kYxHPi9u_WTd-u4SzkFGWu4As3S_CT2DyE24ln6nXWkusY3S5iHu5Rn76zsy5eAJrfV9QD7V1csQVjfN5DQGb7FUV4-lN0dkzWZ3AZVv8l)
@startuml
!define primary_key(x) <b><color:#b8861b><&key></color> x</b>
!define foreign_key(x) <color:#aaaaa><&key></color> x
!define table(x) entity x << (T, white) >>
!define column(x) <color:#efefef><&media-record></color> x
!theme plain


table(exercises){
   primary_key(id): integer
   foreign_key(typeid): integer <<FK>>
   foreign_key(workoutid): integer <<FK>>
   column(age): integer
   column(description): varchar(255)
   column(duration): integer
   column(height): integer
   column(kg): integer
   column(name): varchar(255)
   
}
table(roles) {
   primary_key(id): integer
   column(name): varchar(255)
  
}
table(types) {
   primary_key(id): integer
   column(name): varchar(255)
   
}
table(user_workout) {
   foreign_key(primary_key(user_id)): integer <<FK>>
   foreign_key(primary_key(workout_id)): integer <<FK>>
}
table(users) {
   primary_key(id): integer
   foreign_key(role_id): integer <<FK>>
   column(age): integer
   column(email): varchar(255)
   column(height): integer
   column(kg): integer
   column(name): varchar(255)
   column(password): varchar(255)
   column(username): varchar(255)
   
}
table(workouts) {
   primary_key(id)column: integer
   foreign_key(typeid): integer <<FK>>
   column(date_finish): timestamp(6)
   column(date_start): timestamp(6)
   column(duration): integer
   
}

exercises }--|| types: "typeid:id"
exercises   }--||    workouts     : "workoutid:id"
user_workout  ||--{   users        : "user_id:id"
user_workout   ||--{   workouts     : "workout_id:id"
users    ||--{       roles        : "role_id:id"
workouts  }--||  types        : "typeid:id"

@enduml