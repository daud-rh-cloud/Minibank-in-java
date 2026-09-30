public class Studentaccount extends Account implements interest{
    
    
    
    Studentaccount (String ownername,double balance){
    super(ownername,balance);
    }

 

@Override 
      void withdrawl(double ammount){
        if (ammount > balance){
            System.out.println("Not sufficent Balance ");
        }
        else if (ammount < 0 ) {
            {
              System.out.println("---->> ERROR: Nummer Must be positiv");
            }
        }
        else { 
            balance -= ammount; 
             System.out.println("Withrawl Has been Successsfull!");
         }
      }

 @Override
 public double calculate_interest() {
    double interest = balance * (0.4 / 12);
      return interest; 
 }


 @Override
 void applyMonthEnd() {
     // pay the interest to the Castomer 
     balance += calculate_interest(); 
        System.out.println("---Interset of " + calculate_interest() + " has been Paid in " +getClass().getSimpleName());
 }




@Override
void describe() {
    super.describe();
    System.out.println("interestEarn:- " +calculate_interest());
}


}








