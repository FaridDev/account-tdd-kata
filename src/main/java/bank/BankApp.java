package bank;

public class BankApp {

    private Account pierreJeanAccount;

    public BankApp() {
        this.pierreJeanAccount = new Account("pierre-jean", 100.0);
    }

    public Double withdrawsAmountFromClientAccount(String clientName, Double amount) {
        if (clientName.isEmpty()) {
            throw new RuntimeException("Empty client name is not allowed");
        }

        if (!clientName.equals(pierreJeanAccount.getClientName())) {
            throw new RuntimeException("No account is found for this client");
        }

        if (amount <= 0) {
            throw new RuntimeException("Negative amount is not allowed");
        }

        Account clientAccount = pierreJeanAccount;

        if (clientAccount.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance, your balance is: " + clientAccount.getBalance());
        }

        clientAccount.setBalance(clientAccount.getBalance() - amount);

        return clientAccount.getBalance();
    }
}
