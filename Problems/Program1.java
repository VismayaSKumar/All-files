//structure of a java program

interface ToGreet
{
    void greet();
}
class Greeted implements ToGreet{
   public void greet()
    {
        System.out.println("Hey programmer");
    }
}
public class Program1 {
    public static void main(String[] args) {
       Greeted obj=new Greeted();
       obj.greet(); 
    }
}
