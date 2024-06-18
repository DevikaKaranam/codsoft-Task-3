import java.util.Scanner;
public class ATMInterface
{
public static void main(String[] args)
{
BankAccount userAccount = new BankAccount(1000);
ATM atm = new ATM(userAccount);
atm.performTransaction();
}
}
class BankAccount
{
double balance;
public BankAccount(double initialBalance)
{
balance = initialBalance;
}
public void deposit(double amount)
{
balance += amount;
}
public boolean withdraw(double amount) {
if(balance >= amount)
{
balance -= amount;
System.out.println("Transaction is success.");
return true;
}
else
{
System.out.println("\nTransaction is Failed.");
return false;
}
}
public double getBalance()
{
System.out.println("BALANCE : "+ balance);
return balance;
}
}
class ATM
{
BankAccount account;
Scanner scanner;
public ATM(BankAccount account)
{
this.account = account;
scanner = new Scanner(System.in);
}
public void displayMenu()
{
System.out.println("\n***Welcome to ATM***");
System.out.println("1. Check Balance");
System.out.println("2. Withdraw");
System.out.println("3. Deposit");
System.out.println("4. Exit");
}
public void performTransaction()
{
while(true)
{
displayMenu();
System.out.print("\nEnter your choice: ");
int choice = scanner.nextInt();
switch (choice)
{
case 1:
checkBalance();
break;
case 2:
withdraw();
break;
case 3:
deposit();
break;
case 4:
System.out.println("***THANK YOU***");
return;
default:
System.out.println("Invalid choice. Please try again.");
}
}
}
void withdraw()
{
System.out.print("Enter amount : ");
double amount = scanner.nextDouble();
if(amount < 500)
{
System.out.println("Invalid Transaction.");
}
else if(amount >10000)
{
System.out.println("Maximum Withdrawl Limit per day is 10000.\nTransaction Failed.");
}
else if(account.withdraw(amount))
{
System.out.println("Withdrawal successful.\nRemaining Balance: " + account.getBalance());
}
else
{
System.out.println("Insufficient Balance.");
}
}
void deposit()
{
System.out.print("Enter amount : ");
double amount = scanner.nextDouble();
if((amount < 100) || (amount > 50000))
{
System.out.println("Invalid amount.");
}
else
{
account.deposit(amount);
System.out.println("Deposit successful.\nNew Balance: " + account.getBalance());
}
}
void checkBalance()
{
System.out.println("Current Balance is: " + account.getBalance());
}
}


