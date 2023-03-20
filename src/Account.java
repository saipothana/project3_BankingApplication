
public interface Account {

	void deposit(double amount);
	//void withdraw(double amount) throws insufficientbalanceException("Oops! insuficient funds ");
	
	void withdraw(double amount) throws insufficientbalanceException;
	double getbalance();
	void applyintrest();
	void transfer(Account destinationAccount,double ammount) throws insufficientbalanceException;
	void setoverdraft(double ammount);
	Transaction[] gettransactionhistory();
	boolean validatepassword(String password);
}

