package testpack;

import java.util.Scanner;

public class TextInput {

		public static void main(String[] args){
			System.out.println("Enter your name:");
			final Scanner in = new Scanner(System.in);
			final String name = in.next();
			System.out.printf("Hello, %s",name);
			in.close();
		}
}
