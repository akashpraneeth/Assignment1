import java.util.Scanner;

public class AccountTest {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Account acc = new Account();
		boolean flag = true;

		while (flag) {

			System.out.println("\nEnter your choice:\n");
			System.out.println("1. Read, validate and store account number and internet usage of all Customers.");
			System.out.println("2. Calculate, store and display the cost for all customers.");
			System.out.println("3. Display all account numbers which have over 10 GB usage.");
			System.out.println("4. Display the account number with the highest cost.");
			System.out.println("5. Display the account number with the lowest usage.");
			System.out.println("6. Display the cost in ascending order.");
			System.out.println("7. Display the accounts which have usage equal to the given usage.");
			System.out.println("8. Exit Application.\n");

			int choice = scan.nextInt();

			switch (choice) {
			case (1): {
				acc.inputData();
				break;
			}
			case (2): {
				acc.calculateCost();
				break;
			}
			case (3): {
				acc.displayCustomersOverTenGBUsage();
				break;
			}
			case (4): {
				acc.findHighestCost();
				break;
			}
			case (5): {
				acc.findLowestUsage();
				break;
			}
			case (6): {
				acc.displayBasedOnSortedCost();
				break;
			}
			case (7): {
				System.out.println("Enter the Internet Usage to be checked: ");
				int selectedUsage = scan.nextInt();
				acc.findSelectedInternetUsage(selectedUsage);
				break;
			}
			case (8): {
				System.out.println("Thank You.");
				flag = false;
				break;
			}
			default: {
				System.out.println("Please Enter the input between 1 - 8.\n");
				break;
			}
			}
		}

	}

}
