package xpenst_version.Model;

import java.time.LocalDate;
import java.time.LocalTime;

    public class Expense{
    private double amt;
    private String itemi;
    private String category;
    private LocalDate tdate; // today date 
    private LocalTime ntime; //time of item purchased

    public Expense(double amt,String itemi,String category,LocalDate tdate,LocalTime ntime){
        this.amt = amt;
        this.itemi = itemi;
        this.category = category;
        this.tdate = tdate;
        this.ntime = ntime;
    }
    public double getAmount(){
        return amt;
    }
    public String getItem(){
        return itemi;
    }
    public String getCategory(){
        return category;
    } 
    public LocalDate getDate(){
        return tdate;
    }
    public LocalTime getTime(){
        return ntime;
    }

    }
