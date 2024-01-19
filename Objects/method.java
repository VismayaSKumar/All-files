public class method {
    void add()              //without static keyword-instance method
    {
        int a=10,b=10;
        System.out.println(a+b); 
    }
     static void show()     //with static keyword- static method
    {
        System.out.println("hi");
    }
    public static void main(String[] args) {
        show();                         //method called without obj creation
        method m=new method();          //0bject created
        m.add();                        //method called after obj creation
    }
   
}
