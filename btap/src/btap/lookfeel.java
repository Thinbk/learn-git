/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btap;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 *
 * @author win7
 */
public class lookfeel {
    
public static void main(String[] args) {

    LookAndFeelInfo[] lafList = UIManager.getInstalledLookAndFeels();

    for (LookAndFeelInfo lafInfo : lafList) {
      String name = lafInfo.getName();
      String className = lafInfo.getClassName();
      System.out.println("Name: " + name + ", Class Name: " + className);
    }
  }
}