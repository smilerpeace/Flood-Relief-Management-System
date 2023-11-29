/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Govt.Official;

import javax.swing.JOptionPane;
import java.sql.ResultSet;
/**
 *
 * @author CSC
 */

class govtController {
    govtModel model;
    ResultSet result;
    govtController(govtModel model)
    {
        this.model =model;
    }

    boolean logProcess() {
        DB dbreq = new DB();
        String selectData = "SELECT username FROM govt_official WHERE username=? and password = ?";
       try{
            if(model.getUsername().isEmpty() || model.getPassword().isEmpty())
            {
                JOptionPane.showMessageDialog(null,"Fill all necessary details","Error Message",JOptionPane.ERROR_MESSAGE);
            }
            else
            {
               
                result = dbreq.processLog(model.getUsername(),model.getPassword(), selectData);
                if(result.next())
                {
                    
                    JOptionPane.showMessageDialog(null,"Successfully Login!","Inofrmation Message",JOptionPane.INFORMATION_MESSAGE);
                    govt_Form uPage = new govt_Form();
                    uPage.setFocusable(true);
                    uPage.show();
                    return true;
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Incorrect Username/Password","Error Message",JOptionPane.ERROR_MESSAGE);
                }
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
       return false;
    }
    
    
}
