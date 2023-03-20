import java.util.Scanner;

import javax.naming.InsufficientResourcesException;

public class main {

	public static void main(String[]args) {
		Scanner sc=new Scanner(System.in);
		
		Account account=new SavingsAccount("Jeev@123",0.01);
		char ch;
		int choice;
		do {
			
			System.out.println("1.deposit");
			System.out.println("2.set overdraft limit");
			System.out.println("3.withdraw");
			System.out.println("4.check funds");
			System.out.println("5.Apply intrest");
			System.out.println("6.transfer");
			System.out.println("7.Transaction history");
			System.out.println("8.Exit");
			
			choice=sc.nextInt();
			switch(choice) {
			
			case 1:
				System.out.println("You have chosen deposit");
				System.out.println("Please the ammount you want to deposit");
				
				double ammount=sc.nextDouble();
				account.deposit(ammount);
				System.out.println("ammount deposited successfully");
				break;
			case 2:
				System.out.println("You have choose overdraft");
				System.out.println("Enter limit ");
				double oammount=sc.nextDouble();
				account.setoverdraft(oammount);
				System.out.println("overdraft limit set successfully");
				break;
			case 3:
				System.out.println("You have chosen withdraw");
				System.out.println("Please the ammount you want to withdraw");
				
				double wammount=sc.nextDouble();
				
				try {
				account.withdraw(wammount);
				System.out.println("you have withdraw ammount successfully");
				}
				catch(insufficientbalanceException e) {
					e.printStackTrace();
				}
				
				break;
				
			case 4:
				System.out.println("balance check");
				System.out.println("Current balance"+account.getbalance());
				break;
			
			
			case 5:
				System.out.println("intrest");
				System.out.println("Intrest rate");
				
				account.applyintrest();
				System.out.println("u have applied intrest");
		break;
		
			case 6:
			    System.out.println("You have chosen to transfer money");
			    System.out.println("Enter the account number to transfer to:");
			    int accountNumber = sc.nextInt();
			    System.out.println("Enter the password for the destination account:");
			    String destinationPassword = sc.next();
			    System.out.println("Enter the amount to transfer:");
			    double transferAmount = sc.nextDouble();

			    // Replace this block with actual code to link the destination account to the correct account
			    Account destinationAccount = new SavingsAccount(destinationPassword, 0.01);

			    try {
			        account.transfer(destinationAccount, transferAmount);
			        System.out.println("Amount transferred successfully");
			    } catch (insufficientbalanceException e) {
			        System.out.println(e.getMessage());
			    }

			    break;
			    
			case 7:
				System.out.println("You have Entered the transaction history");
				Transaction[] transactionHistory = account.gettransactionhistory();
                System.out.println("Transaction History:");
                for (Transaction transaction : transactionHistory) {
                    if (transaction != null) {
                        System.out.println(transaction);
                    }
                }
				break;

			case 8:
				System.out.println("exit");
				break;
				
			default: System.out.println("Enter only choices from 1 to 6");
			break;
			}
			
			System.out.println("dou want to continue");
			ch=sc.next().charAt(0);
			
			
		}
		while(ch=='Y'||ch=='y');
		System.out.println("Thanks for visiting us");
		  // sc.close();
	}
}
