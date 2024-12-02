import java.util.Date;
import java.util.Scanner;

class BankAccount {
    private String name;
    private Date birthDate;
    private String number;
    private double balance;

    public BankAccount(String name, Date birthDate, String number, double balance) {
        this.name = name;
        this.birthDate = birthDate;
        this.number = number;
        this.balance = balance;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Рахунок поповнений на суму: " + amount);
        } else {
            System.out.println("Сума поповнення повинна бути більше нуля.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("З рахунку знято суму: " + amount);
        } else if (amount > balance) {
            System.out.println("Недостатньо коштів на рахунку.");
        } else {
            System.out.println("Сума зняття повинна бути більше нуля.");
        }
    }

    public void displayAccountInfo() {
        System.out.println("Ім'я клієнта: " + name);
        System.out.println("Дата народження: " + birthDate);
        System.out.println("Номер рахунку: " + number);
        System.out.println("Баланс: " + balance);
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть ім'я клієнта: ");
        String name = scanner.nextLine();

        System.out.print("Введіть дату народження (у форматі рік місяць день, наприклад, 2000 5 15): ");
        int year = scanner.nextInt();
        int month = scanner.nextInt() - 1; // Місяці від 0 до 11
        int day = scanner.nextInt();
        Date birthDate = new Date(year - 1900, month, day); // Встановлення дати

        System.out.print("Введіть номер рахунку: ");
        String accountNumber = scanner.next();

        System.out.print("Введіть початковий баланс: ");
        double initialBalance = scanner.nextDouble();
        BankAccount account = new BankAccount(name, birthDate, accountNumber, initialBalance);
        account.displayAccountInfo();

        System.out.print("Введіть суму для поповнення рахунку: ");
        double depositAmount = scanner.nextDouble();
        account.deposit(depositAmount);

        System.out.print("Введіть суму для зняття з рахунку: ");
        double withdrawAmount = scanner.nextDouble();
        account.withdraw(withdrawAmount);
        account.displayAccountInfo();

        scanner.close();
    }
}
