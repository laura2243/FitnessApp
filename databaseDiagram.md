![Database](https://www.planttext.com/api/plantuml/svg/hLLDRzim3BtxLt0TCCJ0Z683MXI1OVIqIw-x1xB5s48isv3bDa7I_pvQKMpE7-qEKow9zDuZ-KGgpwqLndQw3Bv8tAiAeJ5A2tFQ7V2qEOOGfqcSrMLjjb_JfwV77_Jp6nqbyRtRJU0OtwV9mDxN1bLU3MnF5VsQCGUM5Mc9FHuhg-m9ZX37iFdz7TuAPJ64P0n0t4vNN1lt_OV4DKeb8eDPRUHVKMo1cWehXQg28BW6moEQJBNOXkS0u2OhSWotaAfSLPPjIsmpenghwegENuN92c4sFnyUGWxgZF28cK11fXHswUIGB-rMGkD29EwkFJMev40cntwza4yJr5jj3dLdbu7ygXaYUFSUcReaV-3yUM8p9PB17CqWrMVxdwIw5itEr-KLUSMSxw0aCggisCH9NdgPnvEOr7FjdLksupvgeShrjXbQOyvqlJ7VNZ7EdpQYRQa4kOxeS_-71kjlVyTluAFEcLwIDt5YaHGMTpJ6gYs8OvL6UdvqitaCfo3tB7s06MUD-RCu7fycVvNa9GJ3um3lKNIvWElUBTnTHRTAtZ48U12jMzNzTo3yC7sEmXiNu7A9eZF1N2U1NyJnFRl062WhOJZBdTtm_NAppCBustM4KSzNukfbO5Pty8oLfF-BFm00)

@startuml
!define primary_key(x) <b><color:#b8861b><&key></color> x</b>
!define foreign_key(x) <color:#aaaaa><&key></color> x
!define table(x) entity x << (T, white) >>
!define column(x) <color:#efefef><&media-record></color> x
!theme plain


table(exercises){
   column(age): bigint
   column(description): varchar(255)
   column(duration): bigint
   column(height): bigint
   column(kg): bigint
   column(name): varchar(255)
   foreign_key(typeid): bigint <<FK>>
   foreign_key(workoutid): bigint <<FK>>
   primary_key(id): bigint
}
table(roles) {
   column(name): varchar(255)
   primary_key(id): integer
}
table(types) {
   column(name): varchar(255)
   primary_key(id): integer
}
table(user_workout) {
   foreign_key(primary_key(user_id)): integer <<FK>>
   foreign_key(primary_key(workout_id)): integer <<FK>>
}
table(users) {
   column(age): integer
   column(email): varchar(255)
   column(height): integer
   column(kg): integer
   column(name): varchar(255)
   column(password): varchar(255)
   column(username): varchar(255)
   foreign_key(role_id): integer <<FK>>
   primary_key(id): integer
}
table(workouts) {
   column(date_finish): timestamp(6)
   column(date_start): timestamp(6)
   column(duration): integer
   foreign_key(typeid): integer <<FK>>
   primary_key(id)column: integer
}

exercises }--|| types: "typeid:id"
exercises   }--||    workouts     : "workoutid:id"
user_workout  ||--{   users        : "user_id:id"
user_workout   ||--{   workouts     : "workout_id:id"
users    ||--{       roles        : "role_id:id"
workouts  }--||  types        : "typeid:id"

@enduml