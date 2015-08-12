/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package setgame;

import java.util.ArrayList;
import java.util.Stack;

public class SetCheck {
    
   public static  ArrayList<Cards> CardsonTable =  new ArrayList<>();
   public static ArrayList<Cards> Cardstobesolved =  new ArrayList<>();
   //public static  void CardsOnTableMethod()
    public static  ArrayList<Cards> CardsOnTableMethod()
    {
        Cards c = new Cards();
        
        //Stack s= new Stack();
        //Usde stack here
        Cardstobesolved.clear();
        Cardstobesolved = c.Generate();
        //System.out.println(Cardstobesolved.size());
     
     CardsonTable.clear();  
            
 for(int i=0;i<79;i++)
       {
         if(GameEngine.Compare(Cardstobesolved.get(i),Cardstobesolved.get(i+1),Cardstobesolved.get(i+2))== true)
          {
              //System.out.println(Cardstobesolved.size());
              CardsonTable.add(Cardstobesolved.remove(i));
              CardsonTable.add(Cardstobesolved.remove(i+1));
              CardsonTable.add(Cardstobesolved.remove(i+2));
                if(CardsonTable.size()==12)
              {
                 // System.out.println(CardsonTable);
                  return CardsonTable;
              }
          }
       }
         
        return CardsonTable;
    } 
    
    public static void select(int i,int j,int k)
    {
         
       Cards s1 = new Cards();
       Cards s2 = new Cards();
       Cards s3 = new Cards();
       
       
        s1 = CardsonTable.get(i);
        s2 = CardsonTable.get(j);
        s3 = CardsonTable.get(k);
 
        
   if(GameEngine.Compare(s1,s2,s3) == true)
     {  
         System.out.println("It is a set");
     }
     else
     {
         System.out.println("It is not a set");
     }
    }
}
