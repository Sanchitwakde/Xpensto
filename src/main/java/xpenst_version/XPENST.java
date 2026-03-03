/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package xpenst_version;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


class expense{
    double amt;
    String itemi;
    String category;
    LocalDate tdate; // today date 
    LocalTime ntime; //time of item purchased

    public expense(double amt,String itemi,String category,LocalDate tdate,LocalTime ntime){
        this.amt = amt;
        this.itemi = itemi;
        this.category = category;
        this.tdate = tdate;
        this.ntime = ntime;
    }


}
class expense_tracker {
    
    Scanner in;
    double amt;
    String itemi;
    String category;
    LocalDate date; // today date 
    LocalTime time; //time of item purchased

    public expense_tracker(Scanner in){
        this.in = in;
    }
    
    ArrayList<expense> expnselist = new ArrayList<>();

    public void times(){
        System.out.println("Do you want to enter time Y/N: ");
            String time_choice = in.nextLine();
            if(time_choice.equalsIgnoreCase("y")){
                System.out.println("Enter time in Format(HH:MM)");
                String input = in.nextLine();
                time = LocalTime.parse(input);
            }else{
                time = LocalTime.now();
                // System.out.println("no time added");
            }
    }


    public void console(){
       
        System.out.println("Which category you want to select:\n1.Food\n2.Travel\n3.Shopping\n4.Education\n5.Loan\n6.EMI");
        System.out.print("Enter your choice: ");
        int choice_category = in.nextInt();
        in.nextLine(); // to clear buffer 

        switch(choice_category){
            case 1:
            category = "Food";
            break;

            case 2:
            category = "Travel";
            break;

            case 3:
            category = "Shopping";
            break;
            
            case 4:
            category = "Education";
            break;

            case 5:
            category = "Loan";
            break;

            case 6:
            category = "EMI";
            break;

            default:
                System.out.println("Please choose a correct option");
                
        }
        System.out.print("Enter item: ");
        itemi = in.nextLine(); 

        System.out.print("Enter Amount: ");
        amt = in.nextDouble();
        in.nextLine();
        times(); // to get time when purchased 
        date = LocalDate.now(); // to get current date 
        expense expnse = new expense(amt,itemi,category,date,time);
        expnselist.add(expnse);
        savexpense(expnse); // object is passed so that it can work connection establised from this method to another 
        
        System.out.println("__Expense List__");
        for(expense e : expnselist){
            System.out.println("Item: " + e.itemi +" | "+ "Rs. "+e.amt+" | "+"Category: "+ e.category +" | "+"Today's Date: "+ e.tdate+" | "+"Time: "+e.ntime);
        }
    }
    public void savexpense(expense expnse)// here expense is the class and expnse is the object that i have created inn previous class 
    {
        
        try(BufferedWriter uinput = new BufferedWriter( new FileWriter("Userdata.txt",true))){
            String convo_data = 
                expnse.itemi+" | "+
                expnse.amt+" | "+
                expnse.category+" | "+
                expnse.tdate+" | "+
                expnse.ntime;
            uinput.write(convo_data);
            uinput.newLine();
        
        }catch(IOException e){
            System.out.println("Something is wrong with file or permission");
        }
    }
    
    }

public class XPENST {
public static void main(String[] args){
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("________Welcome to XPENST________");
            System.out.println("-> One stop destination to manage your Expenses <-");
            
            expense_tracker et = new expense_tracker(in);
            
            String loop_choice = "y";
            while(loop_choice.equalsIgnoreCase("y")){
            try{  
                et.console();
                System.out.println("Do you want to add another item Y/N: ");
                loop_choice = in.nextLine();
            }catch(InputMismatchException e){
                    System.out.println("Enter choose a valid option");
                }
            }
            System.out.println("Thank you for using XPENST\nSee you soon...");
        }
}
}
