#Terraform POC on AWS/Hibernate/MySql/Docker


## Install and RUn MySql Image in Docker
  * docker run -p 3306:3306 -d --name mysql -e MYSQL_ROOT_PASSWORD=password mysql/mysql-server


## Connect to MySql Running Instance: 
  * docker exec -it mysql mysql -uroot -ppassword


## Build and Run Java Project in Docker:
  
  * docker build -t hbdb .    <-- to build image

  * docker run -t hbdb        <-- run image



## Test Spring Boot App

  *  curl 'localhost:7070/student/all' .... (look into controller for more endpoints)
  

## Infra Code (courtesy of medium.com) Curtsy:

   * https://medium.com/@I_M_Harsh/build-and-deploy-using-jenkins-packer-and-terraform-40b2aafedaec

   For this POC, I took reference from above link from medium.com. Pls refer this webpage for more detail information.
   
For any question/comment or issues pls write me - <raja khan> getrk@yahoo.com