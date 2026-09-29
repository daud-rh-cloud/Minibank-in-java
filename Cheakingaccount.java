public class Cheakingaccount extends Account{
    
    double monthlyFee; 

Cheakingaccount (String ownername,double balance){
    super(ownername,balance);
}

 

@Override 
      void withdrawl(double ammount){
        if (ammount > -1100){
            System.out.println("Not sufficent Balance ");
        }
        else { 
            balance -= ammount; 
             System.out.println("Withrawl Has been Successsfull!");
         }
      }


    double monthlyFee(){
        monthlyFee  = 0.01 * balance; 
        return monthlyFee; 
    }





@Override
void describe() {
    super.describe();
    System.out.println("MonthlyFee:- " +monthlyFee);
}


}
