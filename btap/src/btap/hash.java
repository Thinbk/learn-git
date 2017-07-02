/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btap;

import java.util.HashMap;

/**
 *
 * @author win7
 */
public class hash {
     
    public static void main(String[] args) {
        HashMap<Integer, String> user = new HashMap<>();
        user.put(8, "Vu Van A");
        user.put(5, "Nguyenvan t");
        user.put(3, "Nguyenvan C");
        user.put(10, "NguyenvanE");
 
        for (Integer i : user.keySet()) {
            System.out.println(i + " " + user.get(i));
        }
    }
}
