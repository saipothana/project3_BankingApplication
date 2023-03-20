
class SavingsAccount implements Account{
	private double balance;
	private double ammount;
	private String password;
	private double overdraftlimit;
	private double intrest;
	private int Transactioncount;
	private Transaction[] transactionhistory;
	
	public SavingsAccount(String password,double intrest){
		
		this.balance=0;
		this.ammount=0;
		this.Transactioncount=0;
		this.password=password;
		this.intrest=intrest;
		this.overdraftlimit=0;
		this.transactionhistory=new Transaction[100];
	
		
	}
	
	
	public void deposit(double ammount) {
		balance+=ammount;
		
		transactionhistory[Transactioncount++]=new Transaction(balance,"debit");
	}
	
	public void withdraw(double ammount) throws insufficientbalanceException {
		if(balance-ammount<-overdraftlimit) {
			throw new insufficientbalanceException("Oops! insuficient funds");
		}
		else {
			balance-=ammount;
			transactionhistory[Transactioncount++]=new Transaction(balance,"withdraw");
		}
	}
	
	public double getbalance() {
		return balance;
	}
	
	public void applyintrest() {
		balance+=balance*intrest;
		transactionhistory[Transactioncount++]=new Transaction(balance,"applyintrest");	
	}
	
	public void transfer(Account destinationAccount,double ammount) throws insufficientbalanceException{
		if(balance-ammount<-overdraftlimit) {
			throw new insufficientbalanceException("Oops! insuficient funds");
		}
		balance-=ammount;
		destinationAccount.deposit(ammount);
		transactionhistory[Transactioncount++]=new Transaction(ammount,"transfer");
	}
	
	
	
	public void setoverdraft(double ammount) {
        overdraftlimit = ammount;
    }
	public boolean validatepassword(String password) {
		return this.password.equals(password);
	}


	@Override
	public Transaction[] gettransactionhistory() {
		
		return transactionhistory;
	}


	
	
	
}
