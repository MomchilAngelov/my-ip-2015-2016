#If you want to add a command to the app
*Create a new instance of it in the contructor of parser, and tag it with a string for input comparison

*Change parser as neccesary (if command is not in the format \<student\>:\<command\>)	

*Write the class behaviour in a class with the name, and define its behaviour in a method with a signature

```java
	public void execute(String[] command){}
```

*full class template:
```java
	public class <myclass> extends Command{
		public void execute(String[] command){
		//Your class behaviour
		}
	}
```