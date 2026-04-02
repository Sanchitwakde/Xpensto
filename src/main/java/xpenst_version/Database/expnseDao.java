package xpenst_version.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

import xpenst_version.Model.Expense;

public class expnseDao {
    public void saveExp(Expense exps){
        try{
            Connection conn = DataConnections.getConnection();
            String sql = "Insert INTO expenses( item, amount, category, expense_date, expense_time) VALUES (?,?,?,?,?)";
            PreparedStatement pstat = conn.prepareStatement(sql);
            
            pstat.setString(1, exps.getItem());
            pstat.setDouble(2,exps.getAmount());
            pstat.setString(3,exps.getCategory());
            pstat.setDate(4,java.sql.Date.valueOf(exps.getDate()));
            pstat.setTime(5,java.sql.Time.valueOf(exps.getTime()));
            pstat.executeUpdate();
            System.out.println("Expense Added Succesfully");
        }
        catch(SQLException e) {
             System.out.println("Expense not added" + e.getMessage());
        }
    }

    public List<Expense> view_all(){
        List<Expense> list = new ArrayList<>();
        String history_sql = "Select * from expenses";
        try (Connection conn = DataConnections.getConnection();
            PreparedStatement pstat = conn.prepareStatement(history_sql)){ // used to create a statement object to run sql 

            java.sql.ResultSet rs = pstat.executeQuery(); //ResultSet is inbuilt to fetch table like object 
            //executeQuery --  execute sql select statement 

            while(rs.next()){// .next means go to next row 
                    Expense sqexp = new Expense(
                        rs.getDouble("amount"),
                        rs.getString("item"),
                        rs.getString("category"),
                        rs.getDate("expense_date").toLocalDate(),
                        rs.getTime("expense_time").toLocalTime()
                    );
                    list.add(sqexp);
            }

        } catch (SQLException e) {
            System.out.println("Cannot view all the expenses");
        }
        return list;
    }
    public void deleteRecord(int id){
        String delete_sql = " delete from expenses where id = ?";
        try(Connection conn = DataConnections.getConnection();
        PreparedStatement pstat = conn.prepareStatement(delete_sql)){
        pstat.setInt(1,id);

        int deletedrow = pstat.executeUpdate();
        if(deletedrow>0){
            System.out.println("Expense deleted successfully ");
        }else{
            System.out.println("No record found");
        }
    }catch(SQLException e){
    System.out.println("Error" + e.getMessage());
    }

}

