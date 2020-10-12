package bank;

import currency.Currency;
import database.BankTable;
import database.ClientTable;
import files.CSVUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Bank {
    String name;
    private List<Client> clients;

    public Bank(String name) {
        this.name = name;
        this.clients = new ArrayList<>();
        BankTable.addBank(name, 0);
    }

    public void addClient(Client client) {
        ClientTable.addClient(client.getFirstName(),
                client.getLastName(),
                client.getAddress(),
                client.getBirthday().toString(),
                this.clients.size());
        clients.add(client);
    }

    public void deleteClient(Client client) {
        CSVUtils.getInstance().appendToCSV("delete_client", Thread.currentThread().getName());
        clients.remove(client);
    }

    public Rate calculateLoan(Float value, Currency currency, Duration duration) {
        Client fakeClient = new Client("bank", "bank", "bank", new Date());
        Loan loan = new Loan(fakeClient, value, currency, duration);
        return loan.getRate();
    };
}
