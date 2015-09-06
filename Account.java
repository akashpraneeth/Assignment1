import java.util.Scanner;

public class Account {
	final static int N = 8;
	static Scanner scan = new Scanner(System.in);
	static int accountNumber[] = new int[N];
	static int sortedAccountNumber[] = new int[N];
	static int internetUsage[] = new int[N];
	static int sortedInternetUsage[] = new int[N];
	static int cost[] = new int[N];
	static int sortedCost[] = new int[N];
	static int highestCost = 0;
	static int lowestUsage = 1000;
	int tempAccountNumber, tempUsage, tempCost;

	void inputData() {
		for (int a = 0; a < N; a++) {
			boolean flag = false;
			while (flag == false) {
				System.out.println("Enter the Account Number of " + (a + 1) + "th Customer: ");
				accountNumber[a] = scan.nextInt();
				flag = validateAccountNumber(accountNumber[a]);
			}
			flag = false;
			while (flag == false) {
				System.out.println("Enter the Internet Usage: " + (a + 1) + "th Customer: ");
				internetUsage[a] = scan.nextInt();
				flag = validateInternetUsage(internetUsage[a]);
			}
		}
	}

	boolean validateAccountNumber(int accNumber) {
		if (accNumber < 1111 || accNumber > 8888) {
			System.out.println("Account Number should be between 1111 and 8888\n");
			return false;
		} else {
			return true;
		}
	}

	boolean validateInternetUsage(int internetUsage) {
		if (internetUsage < 5 || internetUsage > 1000) {
			System.out.println("Internet Usage should be between 5 and 1000\n");
			return false;
		} else {
			return true;
		}
	}

	void calculateCost() {
		for (int b = 0; b < N; b++) {
			if (b == 0) {
				System.out.println("Account Number\t\tUsage\t\tCost");
			}
			cost[b] = 2 * internetUsage[b];
			System.out.print("  " + accountNumber[b] + "\t\t\t" + internetUsage[b] + "\t\t" + cost[b] + "\n");

		}
	}

	int totalCost() {
		int total = 0;
		for (int c = 0; c < N; c++) {
			total = total + cost[c];
		}
		return total;
	}

	void displayCustomersOverTenGBUsage() {
		if (totalCost() == 0) {
			System.out.println("Please Calculate and store Cost before choosing this option\n");
		} else {
			boolean flag = false;
			for (int d = 0; d < N; d++) {
				if (internetUsage[d] > 10) {
					if (flag == false) {
						System.out.println("Account Number\t\tUsage\t\tCost");
						flag = true;
					}
					System.out.print("  " + accountNumber[d] + "\t\t\t" + internetUsage[d] + "\t\t" + cost[d] + "\n");
				} else if (flag == false && d == (N - 1)) {
					System.out.println("No Customers crossed 10 GB usage.\n");
				}
			}
		}
	}

	void findHighestCost() {

		if (totalCost() == 0) {
			System.out.println("Please Calculate and store Cost before choosing this option\n");
		} else {

			for (int e = 0; e < N; e++) {
				if (cost[e] > highestCost) {
					highestCost = cost[e];
					tempAccountNumber = accountNumber[e];
					tempUsage = internetUsage[e];
				}
			}
			System.out.println("Account Number\t\tUsage\t\tCost");
			System.out.print("  " + tempAccountNumber + "\t\t\t" + tempUsage + "\t\t" + highestCost + "\n");
		}
	}

	void findLowestUsage() {
		if (totalCost() == 0) {
			System.out.println("Please Calculate and store Cost before choosing this option\n");
		} else {
			for (int f = 0; f < N; f++) {
				if (internetUsage[f] < lowestUsage) {
					lowestUsage = internetUsage[f];
					tempAccountNumber = accountNumber[f];
					tempCost = cost[f];
				}
			}
			System.out.println("Account Number\t\tUsage\t\tCost");
			System.out.print("  " + tempAccountNumber + "\t\t\t" + lowestUsage + "\t\t" + tempCost + "\n");
		}
	}

	void displayBasedOnSortedCost() {
		for (int g = 0; g < N; g++) {
			for (int h = g + 1; h < N; h++) {
				sortedAccountNumber = accountNumber;
				sortedInternetUsage = internetUsage;
				sortedCost = cost;

				int currentRecord, nextRecord, i;
				for (i = 0; i < N; i++) {
					for (currentRecord = 0; currentRecord < N; currentRecord++) {
						for (nextRecord = (currentRecord + 1); nextRecord < N; nextRecord++) {
							if (sortedCost[currentRecord] > sortedCost[nextRecord]) {
								swapDetails(currentRecord, nextRecord);
							}
							currentRecord = nextRecord;
						}
					}
				}
			}
		}
		for (int j = 0; j < N; j++) {
			if (j == 0) {
				System.out.println("Account Number\t\tUsage\t\tCost");
			}
			System.out.print(
					"  " + sortedAccountNumber[j] + "\t\t\t" + sortedInternetUsage[j] + "\t\t" + sortedCost[j] + "\n");
		}
	}

	void swapDetails(int firstRecord, int secondRecord) {

		int tempIntValue = sortedAccountNumber[firstRecord];
		sortedAccountNumber[firstRecord] = sortedAccountNumber[secondRecord];
		sortedAccountNumber[secondRecord] = tempIntValue;

		tempIntValue = sortedInternetUsage[firstRecord];
		sortedInternetUsage[firstRecord] = sortedInternetUsage[secondRecord];
		sortedInternetUsage[secondRecord] = tempIntValue;

		tempIntValue = sortedCost[firstRecord];
		sortedCost[firstRecord] = sortedCost[secondRecord];
		sortedCost[secondRecord] = tempIntValue;
	}

	void findSelectedInternetUsage(int selectedUsage) {
		boolean flag1 = false;
		for (int k = 0; k < N; k++) {
			if (internetUsage[k] == selectedUsage) {
				if (flag1 == false) {
					System.out.println("Account Number\t\tUsage\t\tCost");
					flag1 = true;
				}
				System.out.print("  " + tempAccountNumber + "\t\t\t" + lowestUsage + "\t\t" + tempCost + "\n");
			} else if (flag1 == false && k == (N - 1)) {
				System.out.println("No Customers exists with " + selectedUsage + " GB internet usage.\n");
			}

		}
	}

}
