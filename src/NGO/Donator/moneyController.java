/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NGO.Donator;


import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author CSC
 */
class moneyController {
    private ResultSet result;
    private  moneyModel model;
    
    public moneyController(moneyModel model)
    {
        this.model=model;
    }
    
    public boolean processTransaction(){
        DB dbreq = new DB();
        String insertData = "INSERT INTO moneyDonation (organization,name,amount) "+"VALUES(?,?,?)";
        
          try {
               if(model.getOrgaization().isEmpty() || model.getName().isEmpty() || model.getAmount().isEmpty())
               {
                    JOptionPane.showMessageDialog(null,"Please fill all blank fields","Error Message",JOptionPane.ERROR_MESSAGE);
               }
               else
               {
                   
                       dbreq.processTransaction(model.getOrgaization(),model.getName(),model.getAmount(),insertData);
                       JOptionPane.showMessageDialog(null,"Successfully Donated Account,Thank You!","Information Message",JOptionPane.INFORMATION_MESSAGE);
                       landingPage dPage = new landingPage();
                       dPage.setFocusable(true);
                       dPage.show();
                       return true;
                }  
              
          } catch (Exception ex) {
              System.out.println(ex);
          }
          return false;
    }

    public ResultSet showOrganization() {
        DB dbreq = new DB();
      
    
        String selectData = "SELECT name from ngo";
    
   
    
    try{
      
        result=dbreq.showReq(selectData);
        return result;
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
    return null;
    }
 
}
