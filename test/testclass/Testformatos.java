/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testclass;

/**
 *
 * @author GATEWAY1-
 */
public class Testformatos {
    public static void main(String [] args){
        Testformatos t = new Testformatos();
        t.formatfecha("2018-10-06 17:44:24.000");
    }
    
        private String formatfecha(String fe){
        String nfecha="";
        for(int i=0;i<fe.length()-4;i++){
            
            nfecha+=(fe.charAt(i)==' ')?"T":fe.charAt(i)+"";
        }
            System.out.println(nfecha);
        return nfecha;
    }
        
}
