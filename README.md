# SDA-TODOLIST-001
##ToDoList App
A simple JAVA program to create and manage a personal Todo List,It support adding ,editing, and saving your tasks. 

## Discription 
Simple program for manage your ToDo List by Adding tasks and manage them.
by Simple options you can select 1 Choise that help you to use the ToDoList.

## Getting Started :
This application can be run directly via gradle or via generating jar file 
### Run with Gradle:
In the root folder Start the application with gradle's command line
```java
gradle run
```

### Run with jar file:
Generate the jar file with Gradle's build command.
```java
gradle build
```
the jar file will be generated in `build/libs` which can be run by a java enviroments.
```java
java -jar build/libs/sda.jar
```


## features
* Models a task with: 
    * task title
    * due date
    * select project
   
* Display a collection of tasks that can be sorted
    * by date
    * by project
* Support the ability to
    * add task
    * edit task
    * mark a task as done
    * remove (delete) tasks
* Support a text-based user interface


## Class Diagram: 
<img width="787" alt="Screenshot 2021-03-19 at 14 03 33" src="https://user-images.githubusercontent.com/79480685/111784983-536fd800-88bc-11eb-81bc-0d53b2b8c884.png">


## getting Started :
The Program will Startin  start menu with  some options you must Choose one to Start doing tasks .



<img width="889" alt="Screenshot 2021-03-04 at 23 27 02" src="https://user-images.githubusercontent.com/79480685/110040591-5c509d80-7d43-11eb-9626-cae663e9a421.png">

## The user select the  ( 1 ) option :
if the user select the first option it will show the tasks sorting by dueDate-Project.
if he select the project Choise he should choose what project he want the task been shown 
for ex.  press (1)
```java
1
```

and now 
press (2) to show tasks via project.
```java
2
```
<img width="439" alt="Screenshot 2021-03-04 at 23 47 16" src="https://user-images.githubusercontent.com/79480685/110041338-41325d80-7d44-11eb-926a-6b3be813edb9.png">

<img width="587" alt="Screenshot 2021-03-04 at 23 47 34" src="https://user-images.githubusercontent.com/79480685/110041672-c3bb1d00-7d44-11eb-9c44-9d9c2b253831.png">

## The user select  ( 2 ) option :
In this Option the User can add task ! 
he should add the Tasktitle and DueDate for the task after that he should select in which project the task is in . 
```java
learn java // entering the tasktitle.
```
```java
20-4-2021// entering the  duedate for the tasks
```
```java
2 // select 2 to choose the project Type
```




<img width="622" alt="Screenshot 2021-03-04 at 23 29 20" src="https://user-images.githubusercontent.com/79480685/110041941-388e5700-7d45-11eb-8cc8-5230b41ea644.png"> 




<img width="305" alt="Screenshot 2021-03-04 at 23 29 32" src="https://user-images.githubusercontent.com/79480685/110041983-50fe7180-7d45-11eb-8a8a-5783208968e4.png">




## The user select the ( 3 ) option : 


In this option the user Can update on his Task!, he Can remove , marked as Done and edit the task 



<img width="460" alt="Screenshot 2021-03-04 at 23 30 06" src="https://user-images.githubusercontent.com/79480685/110042196-b3f00880-7d45-11eb-8afa-b94bf7f22fc8.png">






<img width="611" alt="Screenshot 2021-03-04 at 23 32 50" src="https://user-images.githubusercontent.com/79480685/110042224-c0746100-7d45-11eb-8066-108e63ff2947.png">

## The user select the (4) option : 
the application will close and savaing your data in text file .
# Exclusive  feature:
## After finish making the task 
the user can get back to start menu to manage or add more task , without need to run the console again ! 
press ( * ) 
```java
* // to go back to the start menu .
```





<img width="325" alt="Screenshot 2021-03-04 at 23 47 47" src="https://user-images.githubusercontent.com/79480685/110042407-06312980-7d46-11eb-8f4e-7676a274bcd4.png">




