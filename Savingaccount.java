public class Savingaccount extends Account implements interest{
    
double maxwithrawl = 0 ; 
double YearlyRate = 0.04; 
Savingaccount (String ownername,double balance){
    super(ownername,balance);
}



@Override 
      void withdrawl(double ammount){
        if (ammount > balance){
            System.out.println("Not sufficent Balance ");
        }
        else if (ammount < 0 ) {
            
              System.out.println("---->> ERROR: Nummer Must be positiv");
            
        }
        else if (maxwithrawl == 3 ){
            System.out.println("Monthly Withrawl Limit has been Exceeded");
        }
        else { 
            balance -= ammount; 
            maxwithrawl += 1 ;
            System.out.println("Withrawl Has been Successsfull!");
         }
      }

      @Override
      public double calculate_interest()  {
       double interest =  balance * (YearlyRate / 12); 
          return interest;
      }


      @Override
      void applyMonthEnd(){
          //reseting monthly-Withrawl-Limit   
          maxwithrawl = 0; 
        //Calculate and Pay the Intereset to the Castomer
            balance += calculate_interest(); 
            System.out.println("---Interset of " + calculate_interest() + " has been Paid in " +getClass().getSimpleName());
      }
    
      





     @Override
      void describe() {
          super.describe();
          System.out.println("MAX-Monthly-Withraw-Limit: 3 \nEarnable-Interest: " +calculate_interest());
      }




}
