public class Savingaccount extends Account implements interest{
    
double maxwithrawl = 0 ; 

Savingaccount (String ownername,double balance){
    super(ownername,balance);
}



@Override 
      void withdrawl(double ammount){
        if (ammount > balance){
            System.out.println("Not sufficent Balance ");
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
       double interest =  balance * (0.4 / 12); 
          return interest;
      }


     @Override
      void describe() {
          super.describe();
          System.out.println("MAX-Monthly-Withraw-Limit: 3 \nEarnable-Interest: " +calculate_interest());
      }




}
