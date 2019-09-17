// It is possible to implement in an interface for two reasons:
/* 
1- So that when a method is later on added to the interface, the code that has already used the interface would not be broken.
2- When a class that inherits the interface does not need to implement a method, then that method can have a default implementation
    in the interface that does nothing. In that case, the class that inherits the interface does not have to implement that method (would it be hidden
    in the inherited class?)

Because an interface cannnot hold data, it does not have memory. It is very important to remember that.
*/