package EJB;

import javax.ejb.Stateful;

@Stateful
public class AccountBeanImpl implements AccountBean{
    //set balance variable to be $100.00
    private double balance = 100.00;

    @Override
    public void deposit(double amount) {
        // add amount to balance if a deposit
        balance +=  amount;
    }

    @Override
    public void withdraw(double amount) {
        //subtract amount from balance if a withdrawal
        balance -= amount;

    }
    //return current balance
    @Override
    public double getBalance() {
        return balance;
    }
}
