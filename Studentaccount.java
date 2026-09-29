public class Studentaccount extends Account implements interest{
    
    
    
    Studentaccount (String ownername,double balance){
    super(ownername,balance);
    }

 

@Override 
      void withdrawl(double ammount){
        if (ammount > balance){
            System.out.println("Not sufficent Balance ");
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
void describe() {
    super.describe();
    System.out.println("interestEarn:- " +calculate_interest());
}


}








