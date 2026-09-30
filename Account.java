public abstract class Account {
    
    String ownername;
    double balance; 
  

    Account (String ownername,double balance){
        this.ownername = ownername ;
        this.balance =balance; 
    }


  
     void deposit (double ammount){
        if (ammount < 0){
            System.out.println("Deposit needs to be Positiv");
        }
        else {
            balance += ammount; 
            System.out.println("$" + ammount + " has been Deposited. Your tototal Balance is: $" +balance);
        }
    }



    void withdrawl(double ammount){}

    void applyMonthEnd(){}; 



    void describe (){
        System.out.println("-------------- \nAccount type :-" +getClass().getSimpleName() + "\nOwnername:- " +ownername + "\nBalance:- $" +balance);
    }


















}
