import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{ 
public static void main(String [] args){

String Admin_PASSSWORD = "12345"; 


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
System.out.println("1. Open account \n2. Close account \n3. Deposit \n4. Witchoosehdraw \n5. Transfer  \n6. Show transaction history \n7. Run Monthly End  \n8. Bank statistics\n9. Show Balance  \n0.EXIT \nChoose a Nummer:-  ");

try {option = scanner.nextInt(); 
    scanner.nextLine();
}
catch (InputMismatchException e){
    System.out.println("Enter a Valid Nummer");
    scanner.nextLine(); 
    continue; 
}   


// Chosssing the Account 

if (option == 1 ){                                                                                      

    System.out.println("--------TYPE Account name You want to Open (Copy,Paste)---------");

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
         if (chossenAccount == null){
            System.out.println(" -->> You have to open a Account first! ");}
        else{
        System.out.println("How Much Do you want to Withrawl?");
        double Withrawl_ammount = scanner.nextDouble(); 
        chossenAccount.withdrawl(Withrawl_ammount);}


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



    if (option == 6 ){
    System.out.println("---------transaction history-------------");
       for (String log : transaction_history){
        System.out.println(log);
       }

    }
    
    
    // APPLYING MONTHLY END -- PAYING INTEREST AND CHARGING FEES ---- (ADMIN ONLY CAN RUN !!!! )
    if (option == 7){
        System.out.println("Enter the Admin-PASSWORD :- ");
        String input = scanner.nextLine();
        if(!input.equals(Admin_PASSSWORD)){
            System.out.println("Permissiion Denied! Cheak for Corrrect Password.");
        }
        else {
            for (int i = 0 ; i < accounts.size();i++){
                accounts.get(i).applyMonthEnd();
            }
        }
    }


    if (option == 8 ){
        int TotalAccount = 0; 
        double TotalBankBalance = 0 ; 
        String AccountWithHighestBalance = null ; 
        double counter = 0 ;

        for (Account account : accounts ){
            TotalAccount += 1; 
            TotalBankBalance += account.balance; 
            if (counter < account.balance){
                counter = account.balance; 
                AccountWithHighestBalance = account.getClass().getSimpleName(); 
            }
             
        }
        System.out.println("TotalAccount = "+TotalAccount + "\nTotalBankBalance:- $" +TotalBankBalance + "\nAccountWithHighestBalance:- "+AccountWithHighestBalance );
    }


    if (option == 9 ){
         if (chossenAccount == null){
            System.out.println(" -->> You have to open a Account first! ");}
        else{
            System.out.println("$" + chossenAccount.balance);
         }
     }


    if(option == 0 ){
    break;
    }


    } /// while loop close 
} // MAIN CLOSE 




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