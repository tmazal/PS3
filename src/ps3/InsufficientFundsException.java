package ps3;

@SuppressWarnings("serial")
public class InsufficientFundsException extends Exception {
	private double transaction;

	public InsufficientFundsException(double transaction) {
		this.transaction = transaction;
		System.out.println("Insufficient Funds! You need $" + (-1*transaction) + " more to withdraw that amount.");
	}

	public double getTransaction() {
		return transaction;
	}

	public void setTransaction(double transaction) {
		this.transaction = transaction;
	}
}