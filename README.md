# Contacts Manager Web App

The purpose of this project is to create a simple web application for a contact manager.

## Tools

The used tools are:
* AngularJS 12.1.0 for the Frontend part;
* Spring Boot 2.5.2 for the Backend part;
* MySQL for the Database part;

## Setting up the Database

First of all, you need a Database where to create your table of contacts. You need first to install MySQL Server and MySQL Workbench. You can download the MySQL Community installer [here](https://dev.mysql.com/downloads/installer/) and you should be able to install both applications.
Once the installation has finished, open MySQL Workbench and create a new connection like in the image below:

![connection](https://user-images.githubusercontent.com/45291289/124351755-897f6080-dbfc-11eb-9d38-9318fa844298.png)

Then, enter in the connection and create a new schema:

![schema](https://user-images.githubusercontent.com/45291289/124351820-d7946400-dbfc-11eb-9486-11c3858c2003.png)
![create schema](https://user-images.githubusercontent.com/45291289/124351819-d6fbcd80-dbfc-11eb-98e5-ca75a580d293.png)

## Inspecting the Spring Boot project folder 

Download the Spring Tool Suite [here](https://spring.io/tools). Once opened, choose the workspace for the project browsing into the "Spring-Boot-Server folder". Then, the project package explorer should look like this:

![springboot_progetto1](https://user-images.githubusercontent.com/45291289/124351875-33f78380-dbfd-11eb-9ce9-e09dfb4694dd.png)


To run the server go to the Boot Dashboard and click on the run button as in the image below:

![springboot_progetto2](https://user-images.githubusercontent.com/45291289/124351866-22ae7700-dbfd-11eb-8d15-4d791c035275.png)


Remember that Java Development Kit needs to be installed on your machine.


## Inspecting the Frontend Angular Project 

* Any editor can be chosen to open the frontend project folder. In Visual Studio Code just select: File-> Open Folder... -> Contacts-Manager-master 

![angular_folders](https://user-images.githubusercontent.com/45291289/124351899-5f7a6e00-dbfd-11eb-85f8-8fc10aa6d39f.png)

* Once the project has been opened, run the Terminal : Terminal -> New Terminal and digit: ```ng serve --port 8081```

Now that everything is set, open the browser and connect to ```http://localhost:8081/```

## The Web-App

Once connected to ```http://localhost:8081/``` the App shows like this:

With this app different things can be done:

* Add a new contact 
* Inspecting a contact
* Search for a contact based on the different fields
* Modify a contact
* Delete a contact
* Delete all the contact from the Contacts Manager

![progetto1](https://user-images.githubusercontent.com/45291289/124351506-09a4c680-dbfb-11eb-8fc7-b4290d4f487f.png)
![progetto2](https://user-images.githubusercontent.com/45291289/124351516-250fd180-dbfb-11eb-9662-2defb417b0f8.png)
![progetto3](https://user-images.githubusercontent.com/45291289/124351518-280ac200-dbfb-11eb-9242-79ff515e3775.png)
![progetto5](https://user-images.githubusercontent.com/45291289/124351540-4670bd80-dbfb-11eb-98fb-52c292ea7376.png)

The phone number in this Web App is set to be of a finite length of 10. If an User try to type a number longer than 10, then an error can be seen by inspecting the console in the browser:

![progetto7](https://user-images.githubusercontent.com/45291289/124352343-03fdaf80-dc00-11eb-88cf-a8f1711551c8.png)

and so the contact will not be added/update into the contact list, i.e. into the database.

## Table inspection and modifications

Every time a contact is added, the entry is stored in the database table. To check, in MySQL Workbench editor, digit:

```sql
select * from contacts;
```
and the table should look like this:

![progetto6](https://user-images.githubusercontent.com/45291289/124352064-5342e080-dbfe-11eb-90d1-3a618df2a7ce.png)
 
To make the contact search work, you need to add a FULL_TEXT index to the "contacts" table. To do that, enter into the connection in MySQL Workbench and do the following steps:

![Immagine 2021-07-03 130125](https://user-images.githubusercontent.com/45291289/124352132-d19f8280-dbfe-11eb-843f-3473d1fa98d5.png)
![Immagine 2021-07-03 130248](https://user-images.githubusercontent.com/45291289/124352186-3529b000-dbff-11eb-9fdf-568f6190fd38.png)

Finally, The phone_number should be unique, so it can be also set as a Primary Key and as Unique. This can be done by altering the table e selecting the corresponding checkboxes.



 
