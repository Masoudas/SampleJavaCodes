package EffectiveJava.Methods;

import java.util.Date;

/**
 * Sometimes when references to mutable classes are provided, and they are stored
 * as internal parameters of the class, the class is prone to attack. Either through
 * the provided parameter, or thorugh the accessor method (see AttackProneClass)
 * 
 * To remedy this, the constructor must copy the parameters safely (normaly by creating
 * a new instance for itself, rather than using copy because of thread issues). Note that
 * checking must be done on the copy, and not on the original, becuase the original is still
 * subject to change, by other threads for example.
 * Second, when returning, we should make another copy.
 * 
 * Note however this only needs to be done, when there's mistrust present, not for 
 * every internal class.
 */



 class AttackProneClass {
     final Date date;

     public AttackProneClass(Date date) {
         this.date = date;
         
     }
 
     public Date getDate()
     {
         return date;
     }

     public static void main(String[] args) {
         Date date = new Date();
         AttackProneClass c1 = new AttackProneClass(date);

         date.setHours(15); // Suddenly, we are changing internal parameters of the class from outside.

         c1.date.setHours(15);  // Another way of chaning from outside.
     }
     
 }


 class AttackImmuneClass{
    final Date date;

    public AttackImmuneClass(Date date) {
        this.date = new Date(date.getTime());
        // Perform checks on date now!
    }

    public Date getDate()
    {
        return new Date(date.getTime());
    }

 }