package lv.gundega;

import java.util.Scanner;

import lv.gundega.tips.PrintTipsForMan;
import lv.gundega.tips.PrintTipsForWoman;


public class TestTips {
	
	//METHOD CHECK INPUT (in brackets 2 conditions, for example, male or female)
	public static String checkInput(String a, String b) {
		
		int i=0;
		String answer;
		Scanner scan = new Scanner(System.in);
		answer = scan.nextLine().toLowerCase();
		for (i=0; i<=1;i++) {
		if (answer.equalsIgnoreCase(a)||answer.equalsIgnoreCase(b)) {
			i=1;
		}else {
			System.out.println("Invalid input. Please type "+a.toUpperCase()+" or "+b.toUpperCase());
			i=0;
			answer = scan.nextLine().toLowerCase();
		}
		}return answer;
		
	}

	public static void main(String[] args) throws Exception {

		String[] arr = new String[1];
		String answer;
		Scanner scan = new Scanner(System.in);
		System.out.println("Insert your gender: MALE or FEMALE!");
		answer = checkInput("male", "female");
		
//*****************************************************WOMAN******************************************************************
		// ADD OR PRINT TIP
		if (answer.equals("female")) {
			System.out.println("      *");
		    System.out.println("   *     *");
		    System.out.println("  *       *");
		    System.out.println("   *     *");
		    System.out.println("      *");
		    System.out.println("      *");
		    System.out.println("    *****");
		    System.out.println("      *");
		    System.out.println("      *");
			System.out.println("If you want to get tips, type GET, if you want to add tips, type ADD!");
			answer = checkInput("get", "add");

			// ADD TIP FOR WOMAN
			if (answer.equals("add")) {

				do {
					System.out.println("Please type your tip, then press ENTER");
					answer = scan.nextLine().toLowerCase();
					PrintTipsForWoman printTipsForWoman = new PrintTipsForWoman();
					printTipsForWoman.addTipForWoman(answer);
					System.out.println("Tip added.");
					System.out.println("If you want add another tip, type YES, else NO!");
					answer = checkInput("yes", "no");

				} while (answer.equals("yes"));
			}

			// PRINT TIP FOR WOMAN
			if (answer.equals("no") || answer.equals("get")) {
				do {
					PrintTipsForWoman printTipsForWoman = new PrintTipsForWoman();
					printTipsForWoman.printRandomTipForWoman();
					arr[0] = printTipsForWoman.lineTo;

					// GOOD OR NOT GOOD TIP
					System.out.println("If this tip was good, type YES, else type NO");
					answer = checkInput("yes", "no");
					if (answer.equals("no")) {

						System.out.print("If you want to delete this tip, type DELETE! ");
						System.out.println("If you want to choose different tip, type GET!");
						answer = checkInput("delete", "get");
					

					if (answer.equals("delete")) {
						// DELETE TIP
						PrintTipsForWoman deleteTipForWoman = new PrintTipsForWoman();
						deleteTipForWoman.removeLineFromFile(arr[0]);
						PrintTipsForWoman deleteEmptyLines = new PrintTipsForWoman();
						deleteEmptyLines.removeEmptyLine();
						System.out.println("Tip is deleted!");
						System.out.println("Your new tip is:");
					}
					
					}
					if (answer.equals("yes")) {
						System.out.println("Great! Have a nice day! ");
						break;
					}
					}
				while (answer!= "yes");
					
				
			
			}
		}

//*****************************************************MAN******************************************************************
		// ADD OR PRINT TIP
		if (answer.equals("male")) {
			System.out.println("          * * *");
		    System.out.println("            * *");
		    System.out.println("          *   *");
		    System.out.println("     * * *     ");
		    System.out.println("   *       *   ");
		    System.out.println("  *         *  ");
		    System.out.println("   *       *   ");
		    System.out.println("     * * *     ");
			System.out.println("If you want to get tips, type GET, if you want to add tips, type ADD!");
			answer = checkInput("get", "add");

			// ADD TIP FOR MAN
			if (answer.equals("add")) {

				do {
					System.out.println("Please type your tip, then press ENTER");
					answer = scan.nextLine().toLowerCase();
					PrintTipsForMan printTipsForMan = new PrintTipsForMan();
					printTipsForMan.addTipForMan(answer);
					System.out.println("Tip added.");
					System.out.println("If you want add another tip, type YES, else NO!");
					answer = checkInput("yes", "no");

				} while (answer.equals("yes"));
			}

			// PRINT TIP FOR MAN
			if (answer.equals("no") || answer.equals("get")) {
				do {
					PrintTipsForMan printTipsForMan = new PrintTipsForMan();
					printTipsForMan.printRandomTipForMan();
					arr[0] = printTipsForMan.lineTo;

					// GOOD OR NOT GOOD TIP
					System.out.println("If this tip was good, type YES, else type NO");
					answer = checkInput("yes", "no");
					if (answer.equals("no")) {

						System.out.print("If you want to delete this tip, type DELETE! ");
						System.out.println("If you want to choose different tip, type GET!");
						answer = checkInput("delete", "get");
					

					if (answer.equals("delete")) {
						// DELETE TIP
						PrintTipsForMan deleteTipForMan = new PrintTipsForMan();
						deleteTipForMan.removeLineFromFile(arr[0]);
						PrintTipsForMan deleteEmptyLines = new PrintTipsForMan();
						deleteEmptyLines.removeEmptyLine();
						System.out.println("Tip is deleted!");
						System.out.println("Your new tip is:");
					}
					
					}
					if (answer.equals("yes")) {
						System.out.println("Great! Have a nice day! ");
						break;
					}
					}
				while (answer!= "yes");
					
				
			
			}
		}

		scan.close();
	}

}