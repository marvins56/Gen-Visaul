package coderevies;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class unittess {

public Account Account;

	@Test
	//testing to see if we get a valid result 
	public void testTypicalResults() {
		//assignng anew account to 3 from the array of acounts
		Account accounts[] = new Account[3];

		//asigning values to the new account 0
		accounts[0] = new Account();
		accounts[0].principal = 35;
		accounts[0].rate = (float) .04;
		accounts[0].daysActive = 365;
		accounts[0].accountType = Account.PREMIUM;

		float result = Account.calculateFee(accounts);
		//calculating total fees 
		//first value is the actual value and the second argument 
		// is the expected value  the last argument is the decimal places to assign the answer
		assertEquals(result, (float) 0.060289, (float) 0.00001);
	}
	



//this test passes if the input to the account is null

	@Test
	public void testNullInput() {
		Account accounts[] = null;
		//to pass the test we set the accounts to null
		try {
			float result = Account.calculateFee(accounts);
			fail();
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}

	}
	
