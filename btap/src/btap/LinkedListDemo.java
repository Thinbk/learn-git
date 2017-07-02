/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btap;

import java.util.*;

public class LinkedListDemo {

   public static void main(String args[]) {
      // tao mot linked list
      LinkedList ll = new LinkedList();
      // them cac phan tu toi linked list
      ll.add("F");
      ll.add("B");
      ll.add("D");
      ll.add("E");
      ll.add("C");
      ll.addLast("Z");
      ll.addFirst("A");
      ll.add(1, "A2");
      System.out.println("Noi dung ban dau cua LinkedList: " + ll);

      // xoa cac phan tu tu linked list
      ll.remove("F");
      ll.remove(2);
      System.out.println("Noi dung cua LinkedList sau khi xoa: "
       + ll);
      
      // xoa cac phan tu dau tien va cuoi cung
      ll.removeFirst();
      ll.removeLast();
      System.out.println("LinkedList sau khi xoa phan tu dau tien va cuoi cung: "
       + ll);

      // lay va thiet lap mot gia tri
      Object val = ll.get(2);
      ll.set(2, (String) val + " Dathaydoi");
      System.out.println("LinkedList sau khi thay doi: " + ll);
   }
}
