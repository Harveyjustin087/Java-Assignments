package EJB;

import javax.ejb.Local;

@Local
public interface AccountBean {
    public void deposit(double amount);
    public void withdraw(double amount);
    public double getBalance();
}
