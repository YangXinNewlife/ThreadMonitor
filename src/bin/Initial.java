package bin;

import java.util.ArrayList;
import java.util.Scanner;

import obj.InputMessage;
import task.Task;

public class Initial {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<InputMessage> inList = new ArrayList<InputMessage>();
		String context;
		Scanner sc = new Scanner(System.in);
		Task tm = new Task();
		System.out.println("===Please type IFTTT Statements, end of 'END'!==");
		while(true){
			context = sc.nextLine();
			if(context.equals("END")){
				break;
			}
			else{
				InputMessage im = new InputMessage();
				im.setContext(context.split(" ")[1]);
				System.out.println(context.split(" ")[1]);
				im.setTriger(context.split(" ")[2]);
				System.out.println(context.split(" ")[2]);
				im.setTask(context.split(" ")[4]);
				System.out.println(context.split(" ")[4]);
				inList.add(im);
			}
		}
		System.out.println("=================Type Finish!=====================");
		tm.TaskDist(inList);
	}
}
