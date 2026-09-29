import java.util.ArrayList;
import java.util.Scanner;

public class Main{ 
public static void main(String [] args){


Scanner scanner  = new Scanner (System.in); 

Savingaccount savingaccount1 = new Savingaccount("Robin", 5000); 
Cheakingaccount cheakingaccount1 = new Cheakingaccount("Robin", 1220);
Studentaccount studentaccount1 = new Studentaccount("Robin", 7000); 

ArrayList <Account> accounts = new ArrayList<>(); 
accounts.add(savingaccount1);
accounts.add(cheakingaccount1);
accounts.add(studentaccount1);

String ChossenAccountName;
Account chossenAccount = null; 
ArrayList<String>  transaction_history = new ArrayList<>(); 


int option = -1; 

while (option !=  0 ){

System.out.println(" --------------------------------  ");
System.out.println("1. Open account \n2. Close account \n3. Deposit \n4. Witchoosehdraw \n5. Transfer  \n6. Show transaction history  \n7. Bank statistics\n0. Exit \nChoose a Nummer:-  ");

try {option = scanner.nextInt(); 
    scanner.nextLine();
}
catch (Exception e){
    System.out.println("Enter a Valid Nummer");
    break; 
}   


// Chosssing the Account 

if (option == 1 ){                                                                                      

    System.out.println("--------Type Account name You want to Open---------");

     for (Account accout : accounts ){
        System.out.println(accout.getClass().getSimpleName()); 
    }
        ChossenAccountName = scanner.nextLine();



 // Matching the Accoutname ---> Object 

    chossenAccount = choose_account_method(accounts,ChossenAccountName);

//// Logging
    transaction_history.add("One account has been Logeed in!"); 
    }


    if (option == 2 ){
        System.out.println("-----> Account closed !! ");
        chossenAccount = null; 
/// Logging 
    transaction_history.add("One account has been Closed!"); 

    }

    if (option == 3){
         if (chossenAccount == null){
            System.out.println(" -->> You have to open a Account first! ");
//Logging 
      transaction_history.add("Failed Attempt to Deposit! "); 
            break; 
         }


         else {
        System.out.println("How Much Do you want to Deposit?");
        double deposit_ammount = scanner.nextDouble(); 
        chossenAccount.deposit(deposit_ammount);
//Logging 
      transaction_history.add("One Succesfull Deposit has been performed! "); 
    }
}

    if (option == 4 ){
        System.out.println("How Much Do you want to Withrawl?");
        double Withrawl_ammount = scanner.nextDouble(); 
        chossenAccount.withdrawl(Withrawl_ammount);
//Logging 
      transaction_history.add("One Succesfull Withrawl has been performed! "); 
    }


    if (option == 5 ){
        System.out.println("--------Type Account name You want to TRASFER to ---------"); 
        
     /// SELECT Account  
    for (Account accout : accounts ){
    System.out.println(accout.getClass().getSimpleName()); 
    }
        ChossenAccountName = scanner.nextLine();
        Account chossenAccount2 = choose_account_method(accounts,ChossenAccountName ); 

    //// SELECT AMMOAUT 
    System.out.println("How Much Do you want to TRASFER ?");
    double ammount_to_Trassfer = scanner.nextDouble(); 



     //// MAKE THE TRASFER
    Trasfer_method(accounts, chossenAccount, chossenAccount2, ammount_to_Trassfer);

//Logging 
      transaction_history.add("One Trasfer has been performed! "); 
    }



    if (option == 6 ); 











    } /// whille close 
} // maIN CLOSE 




static Account choose_account_method(ArrayList<Account> accounts, String input_name) {
    for (Account accaout : accounts) {
        if (input_name.equals(accaout.getClass().getSimpleName())) {
            accaout.describe();
            return accaout;
        }
    }
    return null;
}


static void Trasfer_method(ArrayList<Account> accounts, Account FROM , Account TO, double transferAmmount  ){
    double Previous_balance = TO.balance; 
    if (FROM.balance < transferAmmount){
        System.out.println("InsufficientFunds");
    }
    else {
    FROM.balance -= transferAmmount; 
    TO.balance += transferAmmount; 
    System.out.println("Trasfer Has Been SuccesFull! ");
    System.out.println(TO.getClass().getSimpleName() + ":- " + " Previous balance:- " + Previous_balance + " " + " NEW Balance;- "+TO.balance);
    }
}




}//class close 