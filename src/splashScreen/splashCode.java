/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splashScreen;

import library.Main.DaftarPrototipe;

/**
 *
 * @author My Computer
 */
public class splashCode {
    public static void main(String[] args){
        splash Splash = new splash();
        Splash.setVisible(true);
        DaftarPrototipe dp = new DaftarPrototipe();
        
       try{
           for(int i = 0; i <= 100; i++){
               Thread.sleep(35);
//               Splash.nama.setText(Integer.toString(i)+ "%");
               Splash.loadingbar.setValue(i);
                 
               
               if(i == 100){
                   Splash.setVisible(false);
                   // mp.setVisible(true);
                   dp.setVisible(true);
                   
               }
           }
       } catch (Exception e){
           
       }
    }
}
