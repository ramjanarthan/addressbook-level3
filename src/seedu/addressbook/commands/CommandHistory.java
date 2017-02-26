package seedu.addressbook.commands;

import java.util.Stack;

/**
 * Class to help maintain a stack of commands that have been entered by the user
 * @author Ram
 *
 */

public class CommandHistory {
	
	/**
	 * history is the main stack that contains the commands entered
	 * overflow acts as a buffer, when history is popped off but needs to be refilled
	 * current is the command viewed by the user
	 */
	private static Stack<Command> history;
	private static Stack<Command> overflow;
	private static Command current;
	
	public CommandHistory(){
		history = new Stack<Command>();
		overflow = new Stack<Command>();
		current = null;
	}	
	
	/**
	 * Method that pushes new command onto the top of the stack
	 * @param command
	 * Returns a boolean if successful
	 */
	public boolean AddCommandToStack(Command command){
		return history.add(command);
	}
	
	
	/**
	 * Method that returns the command at the top of the stack
	 * Returns null if stack is empty
	 */
	public Command GetPreviousCommand(){
		if(history.isEmpty()){
			return null;
		}else {
			current = history.pop();
			return current;			
		}
	}
	
	public Command GetNextCommand(){
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
