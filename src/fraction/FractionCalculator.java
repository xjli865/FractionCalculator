package fraction;

import java.util.Scanner;

/**
 * This is a <b> Fraction </b> calculator. This class reads user input and 
 * makes sense of the input. The commands entered by the user are assigned 
 * correspondingly to its performance. This class also detect validations 
 * of users' input. <p>
 * @author Jenny Li
 *
 */
public class FractionCalculator {
	Fraction f = new Fraction(0);
	Fraction updatedF = new Fraction(0);
	Fraction newFraction = new Fraction(0);
	String newN = "0";
	String newC = "a";
	String part2 = "0";
   
	 /**
     * The main method just creates a FractionCalculator object and calls
     * its <code>run</code> method.
     * 
     * @param args Not used.
     */
	public static void main(String args[]){
		FractionCalculator myInstance = new FractionCalculator();
		myInstance.run();
	}
	
	 /**
     * Prints a fraction calculator instruction, then calls methods to
     * perform each of the following actions:
     * <ol>
     *   <li>Prints a zero as current contents</li>
     *   <li>Prints prompt to enter a number</li>
     *   <li>Prints prompt to enter commands</li>
     *   <li>Handle users' inputs</li>
     * </ol>
     */
	public void run(){
		printInstruction();
		System.out.println("The current content: " + 0);
		String n = numberPrompt();
		String c = commandPrompt();
		handlePrompt(n, c);
	}
	
	/**
	 * Prints out fraction calculator instructions
	 */
	public void printInstruction(){
		System.out.printf("%42s\n", "The Fraction Calculator");
		System.out.println("a To take the absolute value of the number currently displayed");
		System.out.println("c To clear (reset to zero) the calculator");
		System.out.println("i To invert the number currently displayed");
		System.out.println("s n To discard the number currently displayed and replace it with n");
		System.out.println("q To quit the program");
		System.out.println("+ n To add n to the number currently displayed");
		System.out.println("- n To subtract n from the number currently displayed");
		System.out.println("* n To multiply the number currently displayed by n");
		System.out.println("/ n To divide the number currently displayed by n");
		System.out.printf("\n |%15s |\n", "Instructions:");
		System.out.println(" The initial value shown on the calculator is zero");
		System.out.println(" You first need to enter a fraction or integer for your calculation");
		System.out.println(" Then you can enter the command you like to perform");
		System.out.println(" The program will accept commands shown above \n");
	}
	
	/**
	 * Prints a prompt that asks users to input a number
	 * @return Users' inputs
	 */
	public String numberPrompt(){
		Scanner userInput = new Scanner(System.in);
		System.out.println("Please enter a fraction or integer");
		String s = userInput.nextLine();
		return s;
	}
	
	/**
	 * Prints a prompt that asks users to input commands
	 * @return Users' inputs
	 */
	public String commandPrompt(){
		Scanner userInput = new Scanner(System.in);
		System.out.println("Please enter your commands");
		String s = userInput.nextLine();
		return s;
	}
	
	/**
	 * Handles prompt that receives commands from users' inputs
	 * <ol>
	 *   <li> Check if there is any illegal inputs </li>
	 *   <li> Compare user's input commands to acceptable ones </li>
	 *   <li> Catch different exceptions </li>
	 * </ol>
	 * @param n Input of a integer or fraction 
	 * @param c Input of commands
	 */
	public void handlePrompt(String n, String c){
		try{
			f = new Fraction(n);
		}catch(ArithmeticException e){
			System.out.println("error");
			String newN = numberPrompt();
			String newC = commandPrompt();
			handlePrompt(newN, newC);
			return;
		}catch(NumberFormatException ex){
			System.out.println("Please enter thr correct number format!");
			String newN = numberPrompt();
			String newC = commandPrompt();
			handlePrompt(newN, newC);
			return;	
		}catch(ArrayIndexOutOfBoundsException x){
			System.out.println("Please enter thr correct number format!");
			String newN = numberPrompt();
			String newC = commandPrompt();
			handlePrompt(newN, newC);
			return;
		}
		boolean oneLetter = checkOneLetter(c);
		boolean moreLetter = checkMoreThanOne(c);
		if(oneLetter){
			if (c.trim().equals("a")){
				try{
					updatedF = f.abs();
				}catch(ArithmeticException e){
					System.out.println("Cannot be divide by 0");
					String newN = numberPrompt();
					String newC = commandPrompt();
					handlePrompt(newN, newC);
					return;	
				}catch(NumberFormatException ex){
					System.out.println("Please enter thr correct number format!");
					String newN = numberPrompt();
					String newC = commandPrompt();
					handlePrompt(newN, newC);
					return;	
				}catch(ArrayIndexOutOfBoundsException x){
					System.out.println("Please enter thr correct number format!");
					String newN = numberPrompt();
					String newC = commandPrompt();
					handlePrompt(newN, newC);
					return;
				}
				System.out.println("The calculated results is " + updatedF.toString());
				try{
					newC = commandPrompt();
				}catch(NumberFormatException ex){
					System.out.println("Please enter thr correct number format!");
					String newN = numberPrompt();
					String newC = commandPrompt();
					handlePrompt(newN, newC);
					return;	
				}
				handlePrompt(updatedF.toString(), newC);
			}else if (c.trim().equals("c")){
				int clearNumber = 0;
				System.out.println("Reset to: " + clearNumber);
				try{
					newN = numberPrompt();
					newC = commandPrompt();
					}catch(NumberFormatException ex){
						System.out.println("Please enter thr correct number format!");
						String newN = numberPrompt();
						String newC = commandPrompt();
						handlePrompt(newN, newC);
						return;	
					}
				handlePrompt(newN, newC);
			}else if (c.trim().equals("i")){
				try{
					updatedF = f.inverse();
				}catch(ArithmeticException e){
					System.out.println("Cannot be divide by 0");
					String newN = numberPrompt();
					String newC = commandPrompt();
					handlePrompt(newN, newC);
					return;	
				}catch(NumberFormatException ex){
					System.out.println("Please enter thr correct number format!");
					String newN = numberPrompt();
					String newC = commandPrompt();
					handlePrompt(newN, newC);
					return;	
				}catch(ArrayIndexOutOfBoundsException x){
					System.out.println("Please enter thr correct number format!");
					String newN = numberPrompt();
					String newC = commandPrompt();
					handlePrompt(newN, newC);
					return;
				}
				System.out.println("The calculated results is " + updatedF.toString());
				try{
					newC = commandPrompt();
					}catch(NumberFormatException ex){
						System.out.println("Please enter thr correct number format!");
						String newN = numberPrompt();
						String newC = commandPrompt();
						handlePrompt(newN, newC);
						return;	
					}
				handlePrompt(updatedF.toString(), newC);
			}else if (c.trim().equals("q")){
				System.exit(0);
			}else{
				System.out.println("Illegal input. Please enter the correct ones.");
				String newC = commandPrompt();
				handlePrompt(n, newC);
			}	
		}else{
			if(moreLetter){
				String[] part = c.split(" ");
				String part1 = part[0].trim();
				if (part.length == 2){
					part2 = part[1].trim();
				}else{
					if (part[1].contains("/") || part[2].contains("/")){
						try{
						Integer.parseInt(part[1]);
						Integer.parseInt(part[2]);
						}catch(NumberFormatException ex){
							System.out.println("Please enter thr correct number format!");
							String newC = commandPrompt();
							handlePrompt(n, newC);	
						}
						part2 = part[1].trim() + part[2].trim();
					}else{
						System.out.println("Illegal input. Please enter the correct ones.");
						String newC = commandPrompt();
						handlePrompt(n, newC);
					}
				}
				if (part1.equals("s")){
					try{
						newFraction = new Fraction(part2);
					}catch(ArithmeticException e){
						System.out.println("Cannot be divide by 0");
						String newN = numberPrompt();
						String newC = commandPrompt();
						handlePrompt(newN, newC);
						return;	
					}catch(NumberFormatException ex){
						System.out.println("Please enter thr correct number format!");
						String newN = numberPrompt();
						String newC = commandPrompt();
						handlePrompt(newN, newC);
						return;	
					}catch(ArrayIndexOutOfBoundsException x){
						System.out.println("Please enter thr correct number format!");
						String newN = numberPrompt();
						String newC = commandPrompt();
						handlePrompt(newN, newC);
						return;
					}
					System.out.println("Now number is replaced with " + newFraction.toString());
					try{
						newC = commandPrompt();
						}catch(NumberFormatException ex){
							System.out.println("Please enter thr correct number format!");
							String newN = numberPrompt();
							String newC = commandPrompt();
							handlePrompt(newN, newC);
							return;	
						}
					handlePrompt(newFraction.toString(), newC);
				}else if(part1.equals("+")){
					try{
						newFraction = f.add(new Fraction(part2));
					}catch(ArithmeticException e){
						System.out.println("Cannot be divide by 0");
						String newN = numberPrompt();
						String newC = commandPrompt();
						handlePrompt(newN, newC);
						return;	
					}catch(NumberFormatException ex){
						System.out.println("Please enter thr correct number format!");
						String newN = numberPrompt();
						String newC = commandPrompt();
						handlePrompt(newN, newC);
						return;	
					}catch(ArrayIndexOutOfBoundsException x){
						System.out.println("Please enter thr correct number format!");
						String newN = numberPrompt();
						String newC = commandPrompt();
						handlePrompt(newN, newC);
						return;
					}
					System.out.println("The calculated results is " + newFraction.toString());
					try{
						newC = commandPrompt();
						}catch(NumberFormatException ex){
							System.out.println("Please enter thr correct number format!");
							String newN = numberPrompt();
							String newC = commandPrompt();
							handlePrompt(newN, newC);
							return;	
						}
					handlePrompt(newFraction.toString(), newC);	
				}else if(part1.equals("-")){
					try{
						newFraction = f.subtract(new Fraction(part2));
					}catch(ArithmeticException e){
						System.out.println("Cannot be divide by 0");
						String newN = numberPrompt();
						String newC = commandPrompt();
						handlePrompt(newN, newC);
						return;	
					}catch(NumberFormatException ex){
						System.out.println("Please enter thr correct number format!");
						String newN = numberPrompt();
						String newC = commandPrompt();
						handlePrompt(newN, newC);
						return;	
					}catch(ArrayIndexOutOfBoundsException x){
						System.out.println("Please enter thr correct number format!");
						String newN = numberPrompt();
						String newC = commandPrompt();
						handlePrompt(newN, newC);
						return;
					}
					System.out.println("The calculated results is " + newFraction.toString());
					try{
						newC = commandPrompt();
						}catch(NumberFormatException ex){
							System.out.println("Please enter thr correct number format!");
							String newN = numberPrompt();
							String newC = commandPrompt();
							handlePrompt(newN, newC);
							return;	
						}
					handlePrompt(newFraction.toString(), newC);	
				}else if(part1.equals("*")){
					try{
						newFraction = f.multiply(new Fraction(part2));
					}catch(ArithmeticException e){
						System.out.println("Cannot be divide by 0");
						String newN = numberPrompt();
						String newC = commandPrompt();
						handlePrompt(newN, newC);
						return;	
					}catch(NumberFormatException ex){
						System.out.println("Please enter thr correct number format!");
						String newN = numberPrompt();
						String newC = commandPrompt();
						handlePrompt(newN, newC);
						return;	
					}
					catch(ArrayIndexOutOfBoundsException x){
						System.out.println("Please enter thr correct number format!");
						String newN = numberPrompt();
						String newC = commandPrompt();
						handlePrompt(newN, newC);
						return;
					}
					System.out.println("The calculated results is " + newFraction.toString());
					try{
						newC = commandPrompt();
						}catch(NumberFormatException ex){
							System.out.println("Please enter thr correct number format!");
							String newN = numberPrompt();
							String newC = commandPrompt();
							handlePrompt(newN, newC);
							return;	
						}
					handlePrompt(newFraction.toString(), newC);
				}else if(part1.equals("/")){
					try{
						newFraction = f.divide(new Fraction(part2));
					}catch(ArithmeticException e){
						System.out.println("Cannot be divide by 0");
						String newN = numberPrompt();
						String newC = commandPrompt();
						handlePrompt(newN, newC);
						return;	
					}catch(NumberFormatException ex){
						System.out.println("Please enter thr correct number format!");
						String newN = numberPrompt();
						String newC = commandPrompt();
						handlePrompt(newN, newC);
						return;	
					}catch(ArrayIndexOutOfBoundsException x){
						System.out.println("Please enter thr correct number format!");
						String newN = numberPrompt();
						String newC = commandPrompt();
						handlePrompt(newN, newC);
						return;
					}
					System.out.println("The calculated results is " + newFraction.toString());
					try{
						newC = commandPrompt();
						}catch(NumberFormatException ex){
							System.out.println("Please enter thr correct number format!");
							String newN = numberPrompt();
							String newC = commandPrompt();
							handlePrompt(newN, newC);
							return;	
						}
					handlePrompt(newFraction.toString(), newC);
				}else{
					System.out.println("Illegal input. Please enter the correct ones.");
					String newC = commandPrompt();
					handlePrompt(n, newC);
				}
			}else{
				System.out.println("Illegal input. Please enter the correct ones.");
				String newC = commandPrompt();
				handlePrompt(n, newC);
			}
		}
	}
	
	/**
	 * Checks if commands is a single letter 
	 * @param Commands received from prompt
	 * @return The answer to check the single letter command
	 */
	public boolean checkOneLetter(String c){
		int length = c.trim().length();
		if (length == 1){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Checks the format of commands that more than one letter
	 * @param Commands received from prompt
	 * @return The answer to check more than one letter command
	 */
	public boolean checkMoreThanOne(String c){
		if (c.equals(" ") || c.equals(null)){
			return false;
		}else{
			String[] part = c.split(" ");
			String part1 = part[0].trim();
			if (checkOneLetter(part1)){
				if(part.length == 2){
					return true;
				}else if(part.length == 3){
					if (part[1].contains("/") || part[2].contains("/")){
						return true;
					}else{
						return false;
					}
				}else{
					return false;
				}
			}else{
				return false;
			}
		}
	} 
}
