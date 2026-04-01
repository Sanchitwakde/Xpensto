package xpenst_version.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

import xpenst_version.Database.expnseDao;
import xpenst_version.Model.Expense;

public class ExpenseService {
    
    Scanner in;
    

    public LocalDate date; // today date 
    public LocalTime time; //time of item purchased

    public ExpenseService(Scanner in){
        this.in = in;
    }
    
    ArrayList<Expense> expnselist = new ArrayList<>();

    public LocalTime getTime(){
        System.out.println("Do you want to enter time Y/N: ");
            String time_choice = in.nextLine();
            if(time_choice.equalsIgnoreCase("y")){
                System.out.println("Enter time in Format(HH:MM)");
                String input = in.nextLine();
                return LocalTime.parse(input); //converts string to local time 
            }else{
                return LocalTime.now();
                // System.out.println("no time added");
            }
    }
    public LocalDate getDate(){
        System.out.println("Do you want to use today's date Y/N: ");
        String Date_choice = in.nextLine();
        if(Date_choice.equalsIgnoreCase("y")){
            return LocalDate.now();
        }else{
            System.out.println("Enter date in format (YYYY-MM-DD) : ");
            String input = in.nextLine();
            return LocalDate.parse(input);
        }
    }
    expnseDao dao = new expnseDao();
    public void addExpense(Expense expnse){ //to add expenses in the list 
        dao.saveExp(expnse);
        expnselist.add(expnse);
    }

    public void displayExpense(){ // to display expense list 
       System.out.println("__Expense List__");
        for(Expense e : expnselist){
            System.out.println("Item: " + e.getItem() +
            " | "+ "Rs. "+e.getAmount()+
            " | "+"Category: "+ e.getCategory() + 
            " | "+"Today's Date: "+ e.getDate()+
            " | "+"Time: "+e.getTime());
        }
    }
    public List<Expense> view_all(){
        return dao.view_all();
    }
    public void deleteRecord(int id){
        dao.deleteRecord(id);
    }
    
    }


