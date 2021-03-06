package ps3;
import java.util.Date;
import ps3.InsufficientFundsException;

public class Account {
	private int id = 0;
	private double balance = 0;
	private double annualInterestRate = 0;
	private Date dateCreated;
	
	Account(){
	}
	
	Account(int newID, double newBal, double newRate){
		this.id = newID;
		this.balance = newBal;
		this.annualInterestRate = newRate;
		this.dateCreated = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	public Date getDateCreated() {
		return dateCreated;
	}
	
	public double getMonthlyInterestRate(){
		return annualInterestRate / 12;
	}
	
	public double withdraw(double withdrawal) throws InsufficientFundsException{
		if ((balance - withdrawal) > 0){
			System.out.printf("You withdrew $%.2f \n", withdrawal);
			return balance -= withdrawal;	
		}
		else{
			throw new InsufficientFundsException(balance - withdrawal);
		}

	}

	public double deposit(double depositAmt){
		System.out.printf("You deposited $%.2f \n", depositAmt);
		return balance += depositAmt;
	}
}

