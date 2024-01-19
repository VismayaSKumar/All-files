public class constructor {
    constructor()
    {
        System.out.println("Default constructor");

    }
    constructor(String str)
    {
        System.err.println("Parameterized constructor where str is "+str);
    }
    constructor(int i)      //construction overloading
    {
        System.out.println("Parameterized constructor where n is "+ i);
    }
    public static void main(String[] args) {
        constructor obj =new constructor();
        constructor obj1 = new constructor("HEY");
        constructor obj2 = new constructor(10); 
    }
}
