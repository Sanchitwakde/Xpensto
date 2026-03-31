package xpenst_version;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;

import xpenst_version.Database.DataConnections;
import xpenst_version.Model.Expense;
import xpenst_version.Service.ExpenseService;
    
   

public class XPENST {
public static void main(String[] args){
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("________Welcome to XPENST________");
            System.out.println("-> One stop destination to manage your Expenses <-");
            
            Connection conn = DataConnections.getConnection();
            if(conn != null){
                System.out.println("Database is sucessfully connected ");
            }else{
                System.out.println("Connection Failed");
            }
           
            ExpenseService service = new ExpenseService(in);
            
            String loop_choice = "y";
            while(loop_choice.equalsIgnoreCase("y")){
            try{  double amt;
            String itemi;
            String category = "";

            
                 System.out.println("Which category you want to select:\n1.Food\n2.Travel\n3.Shopping\n4.Education\n5.Loan\n6.EMI");
            System.out.print("Enter your choice: ");
            int choice_category = in.nextInt();
            in.nextLine(); // to clear buffer 

            switch(choice_category){
            case 1 -> category = "Food";

            case 2 -> category = "Travel";

            case 3 -> category = "Shopping";
            
            case 4 -> category = "Education";

            case 5 -> category = "Loan";

            case 6 -> category = "EMI";

                default -> System.out.println("Please choose a correct option");
                    
            }
            System.out.print("Enter item: ");
            itemi = in.nextLine(); 

            System.out.print("Enter Amount: ");
            amt = in.nextDouble();
            in.nextLine();

            LocalTime time = service.getTime(); // to get time when purchased 
            LocalDate date = service.getDate(); // to get current date 
            
            Expense expnse = new Expense(amt,itemi,category,date,time);
            
            service.addExpense(expnse);
            service.displayExpense();
            
            System.out.println("\nDo you want to add another item Y/N:");
                    loop_choice = in.nextLine();
            
            

            System.out.println("Do you want to view all Expense History Y/N: ");
            List<Expense> list = service.view_all();    
                String viewhistory = in.nextLine();
                if(viewhistory.equalsIgnoreCase( "y")){
                for(Expense e :list){
                System.out.println(
                "Item: " + e.getItem()+
                " | Rs. " + e.getAmount() +
                " | Category: " + e.getCategory() +
                " | Date: " + e.getDate() +
                " | Time: " + e.getTime()
                );
            }
            }
            }catch(InputMismatchException e){
                    System.out.println("Enter choose a valid option");
                }
            }
            System.out.println("Thank you for using XPENST ");
        }
}
}
