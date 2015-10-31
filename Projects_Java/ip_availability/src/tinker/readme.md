##If you want to add a command to the app
*Create a new instance of it in the contructor of parser, and tag it with a string for input comparison

*Change parser as neccesary (if command is not in the format \<student\>:\<command\>)	

Write the class behaviour in a class with name corresponding to that in the parser contructor, and define its behaviour in a method with a signature

```java
	public void execute(String[] command){
		//Your class behaviour
	}
```

full class template:

```java
	public class <myclass> extends Command{
		public void execute(String[] command){
		//Your class behaviour
		}
	}
```

Helper functions:

```java

	void add(String student1){
		//Pass: name of student
		//Add the student to the List
	}

	void addToHash(String student1){
		//Pass: name of student
		//Add student to the HashMap
	}

	int count(String student1){
		//Pass: name of student
		//Return: how many of him are in the hash, 0 if not there
	}

	boolean delete(String student1){
		//Pass: name of student
		//Return: True if the student was in the list of online students, and deletes him
		//Return: False if the student was no in the list
	}

	boolean is_here(String student1){
		//Pass: name of student
		//Return: True if the student was in the List
		//Return: False if the was not in the List
	}

```