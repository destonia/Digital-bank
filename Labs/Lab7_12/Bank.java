package Lab7_12;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addBranch(String branchName) {
        Branch checkedBranch = findBranch(branchName);
        if (checkedBranch != null) {
            return false;
        }
        this.branches.add(new Branch(branchName));
        return true;
    }

    public boolean addCustomer(String customerName, String branchName, double initialAmount) {
        Branch checkedBrand = findBranch(branchName);
        if (checkedBrand != null) {
            checkedBrand.addCustomer(customerName, initialAmount);
            return true;
        }
        return false;
    }

    public boolean addCustomerTransaction(String customerName, String branchName, double amount) {
        Branch checkedBranch = findBranch(branchName);
        if (checkedBranch != null) {
            checkedBranch.addCustomerTransaction(customerName, amount);
            return true;
        }
        return false;
    }

    public ArrayList<Customer> listCustomer(String branchName, boolean showTransactions) {
        Branch checkedBranch = findBranch(branchName);
        if (checkedBranch != null) {
            ArrayList<Customer> customers = checkedBranch.getCustomers();
            if (!showTransactions) {
                for (Customer customer : customers) {
                    customer.setTransactions(null);
                }
            }
            return customers;
        }
        return null;
    }

    private Branch findBranch(String branchName) {
        if (this.branches != null) {
            for (Branch checkedBranch : this.branches) {
                if (checkedBranch.getName().equals(branchName)) {
                    return checkedBranch;
                }
            }
        }
        this.branches = new ArrayList<Branch>();
        return null;
    }

    public static void main(String[] args) {
        Bank bank = new Bank("Ngan Hang Nha Nuoc VN");
        bank.addBranch("First Branch");
        bank.addCustomer("First Customer", "First Branch", 50.5);
        bank.addCustomer("Second Customer", "First Branch", 77);
        bank.addCustomerTransaction("First Customer", "First Branch", 61);
        bank.addCustomerTransaction("Second Customer", "First Branch", 100);
        ArrayList<Customer> customers = bank.listCustomer("First Branch",true);
        for (Customer customer: customers) {
            System.out.println(customer.getName() + " has " + customer.getTransactions());
        }
    }
}
