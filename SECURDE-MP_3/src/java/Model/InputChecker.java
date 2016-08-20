/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Stewrat
 */
public class InputChecker {
    
    public static final String[] taboo = {"<script>", "</script>", "="};
    
    public static boolean hasTaboo(String input){
        boolean res = false;
        
        for (String string : taboo) {
            if (input.contains(string)) {
                res = true;
                break;
            }
        }
        
        return res;
    }
    
}
