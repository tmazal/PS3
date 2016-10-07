package ps3;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ps3.Account;
import ps3.InsufficientFundsException;

public class AccountTest {
	Account TestAcc;
	
	@Before
	public void setUp() throws Exception {
		TestAcc = new Account(1,0,5);
	}
	
	@After
	public void tearDown() throws Exception {
		TestAcc = null;
	}

	@Test
	public final void testWithdraw() throws InsufficientFundsException {
		TestAcc.deposit(500.00);
		try{
			TestAcc.withdraw(600.00);
		} catch (InsufficientFundsException err){
			err.printStackTrace();
		}
		TestAcc.withdraw(400.00);
		assertTrue(TestAcc.getBalance()==100.00);
	}

	@Test
	public final void testDeposit() {
		TestAcc.deposit(500.00);
		assertTrue(TestAcc.getBalance()==500.00);
	}
	
	@Test 
	public final void testID(){
		assertEquals(TestAcc.getId(),1);	
		}

	@Test
	public final void testMIR(){
		double MIR = TestAcc.getAnnualInterestRate()/12;
		assertTrue(TestAcc.getMonthlyInterestRate()==MIR);
	}
	
	@Test
	public void testAccBalance() throws InsufficientFundsException{
		Account acc1 = new Account(1122, 20000, 4.5);
		acc1.withdraw(2500);
		acc1.deposit(3000);
		System.out.printf("Your balance is now $%.2f \n", acc1.getBalance());
		System.out.println("Your monthly interest is " + acc1.getMonthlyInterestRate() + "%");
		System.out.println("Your account was created " + acc1.getDateCreated() + "\n");
		assertTrue(acc1.getBalance()==20500.00);
	}	
	
/*
=
		
	
	
	}
	@Test
	public final void testGetBalance() {
		fail("Not yet implemented"); // TODO
	}
	@Test
	public final void testGetNumber() {
		fail("Not yet implemented"); // TODO
	}
	*/
}
