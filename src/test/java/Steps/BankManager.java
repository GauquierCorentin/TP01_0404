package Steps;

import java.util.HashMap;
import java.util.Map;

public class BankManager {

    public Map<Integer, Double> accounts;

    public BankManager() {
        accounts = new HashMap<>();
    }

    public BankManager(int firstAccount, double firstAccountSolde) {
        accounts = new HashMap<>();
        accounts.put(firstAccount,firstAccountSolde);
    }

    public void create(int accountId) {
        accounts.put(accountId, 0.0);
    }

    public void deposit(int accountId, double amount) {
        double amnt = accounts.get(accountId);
        accounts.put(accountId, amnt + amount);
    }

    public void withdraw(int accountId, double amount) {
        double amnt = accounts.get(accountId);
        if (amount > amnt) {
            throw new IllegalArgumentException("Not enough Money");
        }
        accounts.put(accountId, amnt - amount);
    }

    public double getBalance(int accountId) {
        return accounts.get(accountId);
    }
}