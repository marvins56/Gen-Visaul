package coderevies;

class Account {
	    float principal;
	    float rate;
	    int daysActive;
  	    int accountType;
  	
  	    public static final int  STANDARD = 0;
  	    public static final int  BUDGET = 1;
  	    public static final int  PREMIUM = 2;
  	    public static final int  PREMIUM_PLUS = 3;
  	/* compound interest calculation to figure out how much interest was earned on the account
  	  this method is extracted from line 20 to 22 since it wasnt effectively used then.
  	 
  	     * The first problem was that its not  exactly clear why there was a division by 365.25
  	     * in the Account class daysActive represented the number of days that the account was active,but the rate was an annual interest rate,
  	     *  so they had to divide daysActive by 365.25 to convert it to years
  	     * */
  	    
  	    float interestEarned() {
  	    	//so they had to divide daysActive by 365.25 to convert it to years
  	        float years = daysActive / (float) 365.25;
  	        float compoundInterest = principal * (float) Math.exp( rate * years );
  	        /*
  	         * the  principal is being subtracted at the end of the interest calculation because
  	         *   the fee calculation was based only on the interest earned 
  	         *   regardless of the principal that was initially put into the account. at initialisation
  	         * */
  	        return ( compoundInterest - principal );
  	    }
  	/* because of the confusion about why the accountType variable is being checked in lines 23 and 24. of the original code
  	 * 
  	 * having  several account types, its not clear why the account was being checked 
  	 * for just these two types.(PREMIUM andPREMIUM_PLUS)
  	 * therefore i think there can only be PREMIUM or PREMIUM_PLUS.*/
  	    
  	    public boolean isPremium() {
  	        if (accountType == Account.PREMIUM || accountType == Account.PREMIUM_PLUS)
  	            return true;
 	        else
  	            return false;
  	    }
  	
  	
  	float calculateFee(Account accounts[]) {
  	    float totalFee = 0;
  	    Account account;
  	    for (int i = 0; i < accounts.length; i++) {
  	        account = accounts[i];
  	        if ( account.isPremium() ) {
  	            totalFee += BROKER_FEE_PERCENT * account.interestEarned();
  	        }
  	    }
  	    return totalFee;
  	}
  	
  	//the constant BROKER_FEE_PERCENT  represents a percentage that is given maybe as a commison or somthing like that
  	// since this value can change overtime it can be initialised
  	static final double BROKER_FEE_PERCENT = 0.0125;
	}