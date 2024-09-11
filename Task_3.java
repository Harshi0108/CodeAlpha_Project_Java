import java.util.*;
public class Task_3 {
    static  double balance=1000;

    public static void Showmenu(){
        System.out.println("-------Bank Menu--------");
        System.out.println("1. Deposite");
        System.out.println("2. WithDrawl");
        System.out.println("3. CheckBalance");
        System.out.println("4. Exit");
        System.out.println("-: Select Operation :-");
    }

      public static void Deposite(double deposite){
      if(deposite>0){   
        balance +=deposite;
        System.out.println("Your  new balance is "+balance);
        }
        else{
            System.out.println("Invalid amount");
        }
    }
      public static void Withdrawl(double amount){
      if(amount>0 && amount<balance){   
        balance -=amount;
        System.out.println("Your new balance is "+balance);
        }
        else if (balance<amount) {
            System.out.println("Sorry, balance is not enough");
            
        }
        else{
            System.out.println("Invalid amount");
        }
    }
    public static void CheckBalance(){
        System.out.println("Your current balance is  "+balance);
    }
    public static void main(String[] args){

        
        Scanner sc=new Scanner(System.in);
        boolean exit=false;

        while (!exit) {
            Showmenu();
            int choice=sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enetr a deposite amount  ");
                    double deposite=sc.nextDouble();
                    Deposite(deposite);
                    
                    break;
            
                case 2:
                    System.out.println("Enetr a withdrawl amount  ");
                    double withdrawl=sc.nextDouble();
                    Withdrawl(withdrawl);
                    
                    break;
            
                case 3:
                    CheckBalance();
                    break;
                case 4:
                    exit=true;
                    System.out.println("Exiting.....Thank You ");
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
            
        }
    }
}
