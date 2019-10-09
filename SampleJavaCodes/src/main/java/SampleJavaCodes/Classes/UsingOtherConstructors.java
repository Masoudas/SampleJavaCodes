/**
 * It is possible to use other constructors of a class. For this
 * end, we can use the this keyword.
 * 
 * This simplies the code we are writing and so forth. The downside here
 * is that calling other constructors through this is time consuming, only
 * because the constructor is not like a normal method of a class.
 * For example, calling another method of a class inside that class is not
 * time consuming, but constructor because of its nature is.
 * 
 * In any case, use the actual inline code when dealing with classes of which
 * several instances will be created.
 * 
 * this( ) is most applicable to constructors that contain large amounts of initialization code, 
 * not those that simply set the value of a handful of fields
 * 
 */

 class UsingOtherConstructors{
     public int i,j;
     
     public UsingOtherConstructors(int i, int j){
         this.i = i;
         this.j = j;
     }

     public UsingOtherConstructors(){
         this(0, 0);
     }


 }