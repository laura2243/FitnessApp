![Database](https://www.planttext.com/api/plantuml/svg/hLN1QkCm4BtxAsQxiCHGKtQX9GHZUkgbrxq7nPh48fPiPBbDIFhlErOKPzQrcrAgN1BflJVpHZFAO-E4TQqkenyIryeWr5PfOVVBBUvdknZILPRcLLdPnS_LVFxmctx-egCilVEx6UpIkrNMizULHRKnFJjGHRVUCNkM4wiIEpmQfzmUTf2cCFjx2w-5SXX3TWb0t5ORhethxaFY6gKIYSMyilA_AAv0JSPAeKmKHQTWk4ERgmQR-101d6N51kC5AEDmWvRjIsnogsgdAaFdByBcXR2pF_VtCGUrLWJ4UuM2obAuqQFjPdJR28qZmNY5tRv69IziAjlJCnLh07kjxBPgtGIINpY7H6-XLBOggKnmk9xRLQakuM-IQXkqo-0iA7BFdE-X97ArK9mKfCTvF8c1dwaMGYrKETqytzOVuRGMJKCMv3IYo_qJFTRT_lAhhHEAE2YH50wNDCsgAOZZb4PwXNGzUuY78FywVO0PdRXFJiWW-PCajn3rRmIy9Sdn2Bvx5t1p4bqeUSCW442qpgwxxq3uVluyXJSkmF6O90U2-Kw2i8WJUdQ4qLCcmd2MFplZk-LdcOK9j-i95xtWnFjbOEOxUaGZwM_Z7m00)
@startuml
!define primary_key(x) <b><color:#b8861b><&key></color> x</b>
!define foreign_key(x) <color:#aaaaa><&key></color> x
!define table(x) entity x << (T, white) >>
!define column(x) <color:#efefef><&media-record></color> x
!theme plain


table(exercises){
   column(age): integer
   column(description): varchar(255)
   column(duration): integer
   column(height): integer
   column(kg): integer
   column(name): varchar(255)
   foreign_key(typeid): integer <<FK>>
   foreign_key(workoutid): integer <<FK>>
   primary_key(id): integer
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