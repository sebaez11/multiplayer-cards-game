
import com.is.database.repositories.UserQueries;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sebastian-dev
 */
public class Main {
    
    public static void main(String[] args) {
        
        UserQueries uq = new UserQueries();
        
        boolean bool = uq.existsByUsername("hola");
        System.out.println(bool);
    }
    
}
