package seedu.addressbook.commands;

import java.util.Stack;

/**
 * Class to help maintain a stack of commands that have been entered by the user
 * @author Ram
 *
 */

public class CommandHistory {
	
	/**
	 * history is the main stack that contains the commands (as strings) entered
	 * overflow acts as a buffer, when history is popped off but needs to be refilled
	 * current is the command viewed by the user
	 */
	private static Stack<String> history;
	private static Stack<String> overflow;
	private static String current;
	
	public CommandHistory(){
		history = new Stack<String>();
		overflow = new Stack<String>();
		current = null;
	}	
	
	/**
	 * Method that pushes new command onto the top of the stack
	 * @param command
	 * Returns a boolean if successful
	 */
	public static boolean AddCommandToStack(String command){
		return history.add(command);
	}
	
	
	/**
	 * Method that returns the command at the top of the stack
	 * Returns null if stack is empty
	 */
	public static String GetPreviousCommand(){
		if(history.isEmpty()){
			return null;
		}else {
			current = history.pop();
			return current;			
		}
	}
	
	public static String GetNextCommand(){
		if(overflow.empty()){
			if(current != null){
				history.add(current);
			}
			return null;
		}else {
			history.add(current);
			current = overflow.pop();
			return current;
		}
	}
	
	
}
