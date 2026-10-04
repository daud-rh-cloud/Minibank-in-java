public class Cheakingaccount extends Account{
    
    double monthlyFee; 

Cheakingaccount (String ownername,double balance){ 
    super(ownername,balance);
}

 

@Override 
      void withdrawl(double ammount){
        if (balance - ammount < -1100){
            System.out.println("Not sufficent Balance ");
        }
        else if (ammount < 0 ) {
            
              System.out.println("---->> ERROR: Nummer Must be positiv");
            
        }
        else { 
            balance -= ammount; 
             System.out.println("Withrawl Has been Successsfull!");
         }
        }
    

    double monthlyFee(){
        if (balance < 2500  ){
            monthlyFee = 25 ; 
        }
        else{
        monthlyFee  = 0.01 * balance;
         }

        return monthlyFee; 
    }

    @Override 
    void applyMonthEnd(){
        //  Carging the Monthtly free 
        balance -= monthlyFee(); 
         System.out.println("--- MonthlyFee " + monthlyFee() + " has been chargeed to the "  +getClass().getSimpleName());
    }



@Override
void describe() {
    super.describe();
    System.out.println("MonthlyFee:- " +monthlyFee);
}


}
