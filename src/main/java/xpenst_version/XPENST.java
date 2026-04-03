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
            System.out.println("        ________Welcome to XPENST________");
            System.out.println("-> One stop destination to manage your Expenses <-");

             ExpenseService service = new ExpenseService(in);
            
             //Connection to MySql Database 
            Connection conn = DataConnections.getConnection();
            if(conn != null){
                System.out.println("Database connected successfully ");
            }else{
                System.out.println("Connection Failed");
            }

            String item ;
            Double amt ;
            LocalTime time ;
            LocalDate date ;
            String category ;
           
            
            String loop_choice = "y";
            while(loop_choice.equalsIgnoreCase("y")){
            try{  
           

            System.out.println("""
            ------MENU------
            1. Add Expense 
            2. Update Expense 
            3. View all Expenses
            4. Delete Expense
            5. Exit""");

            System.out.print("Enter your choice: ");
            int menu_choice = in.nextInt();
            in.nextLine();
                
            switch(menu_choice){
            case 1 -> {
            String category = "";
            System.out.println("""
                    Which category you want to select:
                    1.Food
                    2.Travel
                    3.Shopping
                    4.Education
                    5.Loan
                    6.EMI""");
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
            item = in.nextLine(); 

            System.out.print("Enter Amount: ");
            amt = in.nextDouble();
            in.nextLine();

            time = service.getTime(); // to get time 
            date = service.getDate(); // to get date 
            
            Expense expnse = new Expense(amt,item,category,date,time);
            
            service.addExpense(expnse);
            service.displayExpense();
            
            System.out.println("\nDo you want to add another item Y/N:");
                    loop_choice = in.nextLine();
            }
            case 2 ->{
                    System.out.println("---- Update Expense ----");
                System.out.print("Enter row ID you want to update: ");
                    int id = in.nextInt();
                    in.nextLine();

                    category = "";
                    System.out.println("""
                    Which category you want to select:
                    1.Food
                    2.Travel
                    3.Shopping
                    4.Education
                    5.Loan
                    6.EMI""");
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
                    item = in.nextLine();
                    
                    System.out.print("Enter Amount: ");
                    amt = in.nextDouble();
                    in.nextLine();
                    
                    

                    time = service.getTime(); // for time 
                    date = service.getDate();
                    
                    Expense expnse = new Expense(amt,item,category,date,time);
                    service.UpdateExpense(expnse,id);

                }
            case 3->{
                System.out.println("---- View All Expenses ----");
                List<Expense> list = service.view_all();    
                // String viewhistory = in.nextLine();
                // if(viewhistory.equalsIgnoreCase( "y")){
                for(Expense e :list){
                System.out.println(
                "Item: " + e.getItem()+
                " | Rs. " + e.getAmount() +
                " | Category: " + e.getCategory() +
                " | Date: " + e.getDate() +
                " | Time: " + e.getTime());
                }
                }
            case 4 ->{
                System.out.println("---- Delete Expense ----");
                // System.out.println("Do you want to delete any Expense Y/N: ");
                // String del_ans = in.nextLine();
                // if(del_ans.equalsIgnoreCase("y")){
                System.out.println("Enter Record ID to delete: ");
                int delete = in.nextInt();
                service.deleteRecord(delete);
                }
                case 5 ->{
                System.out.println("Thank you for using XPENST ");
                return;
                }
                default -> System.out.println("Please choose a correct option");
            }
            }
            catch(InputMismatchException e){
                System.out.println("Please enter a valid option");
                }
            }
           
        }
}
}
