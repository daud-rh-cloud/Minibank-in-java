import java.util.ArrayList;

public class Main{ 

public static void main(String [] args){

Book book1 = new Book("Clean code", 399 ,12, 464);
Book book2 = new Book("The Pragmatic Programmer", 440, 3, 352); 

Electonik electonik1 = new Electonik("USB CABLE", 210, 8, "24 Months");
Electonik electonik2 = new Electonik("keyboard", 189,28, "36 Months");

Food food1 = new Food("Coffee Beans 1kg", 189, 25, 180); 
Food food2 = new Food("Fresh Bread", 45, 4, 2); 


ArrayList<Inventory> products = new ArrayList<>();
products.add(book1);
products.add(book2);
products.add(electonik1);
products.add(electonik2);
products.add(food1);
products.add(food2); 

System.out.println("                      === SHIPPING REPORT ===   ");
for (int i = 0; i < products.size(); i++){
    products.get(i).describe();
    System.out.println("\n---------------------"); 
}


System.out.println("                      === EXPRESS DELIVARY ===  ");

for (int i = 0; i < products.size();i++){
    try {
        if (products.get(i) instanceof ExpressDelivary){
            ExpressDelivary ED = (ExpressDelivary) products.get(i); 
            ED.expressDev();
        }
        else {
            continue; 
        }
    }
    catch ( Exception e) {}
}




System.out.println("                      === INVENTORY VALUE ===  ");
InventoryValueCalculator(products); 



System.out.println("                      === STOCK OPARARATION ===  ");
book1.remove(5);
electonik2.remove(50);



System.out.println("                      === NEW INVENTORY VALUE ===  ");
InventoryValueCalculator(products); 
CallculateShippingCOST(products);


} 



static void InventoryValueCalculator(ArrayList<Inventory> products){
int Inventoryvalue = 0;

for (int i = 0; i < products.size();i++){
   int  price =  products.get(i).price; 
   int  ammout = products.get(i).inStock;  
   int total = price * ammout; 
    
    Inventoryvalue += total; 
}
System.out.println("TOTAL:- $" + Inventoryvalue);}


static void CallculateShippingCOST(ArrayList<Inventory> products){
    int TotalShippingCOST = 0; 
    for (int i =0 ; i < products.size();i++){
       TotalShippingCOST += products.get(i).Shippingcost();  
     }
        System.out.println("TOTAL SHIPPINNG COST $:- " +TotalShippingCOST);

}


} 