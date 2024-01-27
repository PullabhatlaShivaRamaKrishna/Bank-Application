package bank;

//***
//Bank.java
//***
public class Bank {
  // Perform a transaction:
  public void doTransaction(Transaction transaction){
      switch (transaction.getTransactionType()) {
          case Transaction.CREDIT:
                  //System.out.println(
                    //      "Start credit of " + transaction.getAccn() + " amount: " + transaction.getAmount());
                  // Get current balance:
                  //int balance = transaction.getAccn().getBalance();
                  // Credits require require a lot of checks:
                  /*try {
                      Thread.sleep(10);
                      // wait() time reduced to speed things up.
                  } catch (InterruptedException e) {
                      System.out.println(e);
                  }*/
                  try {
                  accountdao.creditacc(transaction.getAccn(),transaction.getAmount());
                  accountdao.incrementnoofCredits(transaction.getAccn());
                  accountdao.incrementCreditamount(transaction.getAccn(),transaction.getAmount());
                  
                  }
                  catch(Exception e){
                	  e.printStackTrace();
                  }
                  // Increment the balance.
                  //transaction.getAccount().setBalance(balance); // Restore account balance.
                  break;
              
          case Transaction.DEBIT:
               
              
                  try {
                  accountdao.debitacc(transaction.getAccn(),transaction.getAmount());
                  accountdao.incrementnoofDebits(transaction.getAccn());
                  accountdao.incrementDebitamount(transaction.getAccn(),transaction.getAmount());
                  }
                  catch(Exception e){
                	  e.printStackTrace();
                  }
                  // Increment the balance.
                  //transaction.getAccount().setBalance(balance); // Restore account balance.
                  break;
      }
  }
public void doloan(Loan loan) {
		/*try {
            Thread.sleep(10);
            // wait() time reduced to speed things up.
        } catch (InterruptedException e) {
            System.out.println(e);
        }*/
        try { 
        loandao.creditloan(loan.getAccn(),loan.getAmount());
        loandao.incrementnoofCredits(loan.getAccn());
        loandao.incrementCreditamount(loan.getAccn(),loan.getAmount());
        

        }
        catch(Exception e){
      	  e.printStackTrace();
        }
      
  }
}