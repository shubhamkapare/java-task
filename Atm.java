import java.util.Scanner;
class Bank_Account{
 String name;
 String UserName;
 String password;
 String Account_No;
 float Balance = 10000f;
 int transactions = 0;
 String transactionHistory = "";
 Scanner sc = new Scanner(System.in);
 public void register(){
  System.out.print("Enter Your Name : ");
  name = sc.nextLine();
  System.out.print("Set Your Username : ");
  UserName = sc.nextLine();
  System.out.print("Set Your Password : ");
  password = sc.nextLine();
  System.out.print("Enter Your Account Number : ");
  Account_No = sc.nextLine();
  System.out.print("User Registered Successfully !\nProceed to Login\n");
  System.out.println("-------------------------------------------------------");
 }
 public boolean login() {
  boolean is_Login = false;
  while ( !is_Login ) {
   System.out.print("Enter Your Username : ");
   String Uname = sc.nextLine();
   System.out.print("Enter Your Password : ");
   String Password = sc.nextLine();
   if ( Uname.equals(UserName) & Password.equals(password) ) {
      System.out.print("\nLogin Successful !!\n");
      System.out.println("-------------------------------------------------------");
      is_Login = true;
   }
   else {
    System.out.println("\n Username or Password not found");
   }
  }
  return is_Login;
 }
 public void withdraw_money(){
  System.out.print("\nEnter amount to be withdraw : ");
  Scanner sc = new Scanner(System.in);
  float withdraw_amount = sc.nextFloat();
    if(Balance >= withdraw_amount){
      Balance = Balance - withdraw_amount;
               System.out.println("Money Withdraw Successfully");
               System.out.println("Kindly collect your Rs."+withdraw_amount+" withdrawed ! \n");
               System.out.println("-------------------------------------------------------");
               transactions++;
    }
    else{
     System.out.print("Sorry,cannot withdraw money due to Insufficient Balance! \n" );
    }
 }
 public void deposit_money() {
  System.out.print("Enter money to be deposited:");
        float deposited_money = sc.nextInt();
        //add the deposit amount to the total Balanace
        Balance = Balance + deposited_money;
        System.out.println("Money Rs."+deposited_money+" has been successfully depsited");
        System.out.println("-------------------------------------------------------");
// System.out.println("");
 }
 public void transfer_money() {
// System.out.print("Enter the Receipients name : ");
// String receipients_name = sc.nextLine();
  System.out.print("Enter amount to transfer : ");
  float transfer_amount = sc.nextFloat();
  if( Balance >= transfer_amount){
   Balance = Balance - transfer_amount;
   System.out.println("Rs."+transfer_amount+" Transfered Successfully." );
   System.out.println("\n-------------------------------------------------------");
   transactions++;
  }
  else {
   System.out.println("\nSorry, you have Insufficient Balance !");
  }
 }
 public void check_Balance() {
  System.out.println("\nYour bank balance is : Rs."+ Balance);
  System.out.println("-------------------------------------------------------");
 }
}
public class Atm_Interface {
 public static void main(String[] args) {
  // TODO Auto-generated method stub
  Scanner sc = new Scanner(System.in);
  System.out.println(" ------------------------------ ");
  System.out.print(" ********** | Pune Peoples Bank ATM System | **********\n");
  System.out.println(" ------------------------------ ");
  System.out.println("1.Register");
  System.out.println("2.Exit");
  System.out.print("Enter Your Choice - ");
  int choice = sc.nextInt();
  if(choice == 1){
   Bank_Account b1 = new Bank_Account();
   b1.register();
   while(true){
    System.out.println("1.login");
    System.out.println("2.Exit");
    System.out.print("Enter Your Choice - ");
    int user_choice = sc.nextInt();
    if(user_choice == 1){
     boolean login_status = b1.login();
     if(login_status){
      System.out.println("\n\n----------- WELCOME " + b1.name + " !! -----------\n");
      boolean is_quit = false;
      while(!is_quit){
       System.out.println("1.Deposit Money");
       System.out.println("2.Withdraw Money");
       System.out.println("3.Transfer Money");
       System.out.println("4.Check Bank Balance");
       System.out.println("5.Quit");
       System.out.println("____________________________");
       System.out.print("Enter Your Choice - ");
       int ch = sc.nextInt();
       switch(ch){
        case 1:
         b1.deposit_money();
         break;
        case 2:
         b1.withdraw_money();
            break;
        case 3:
         b1.transfer_money();
         break;
        case 4:
         b1.check_Balance();
         break;
        case 5:
         is_quit = true;
         System.out.println("**********************************************************");
         break;
       }
      }
     }
    }
   }
  }
 }
}
	
