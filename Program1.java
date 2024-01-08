

interface DeclareGreet {
    public void Greet();
    
}
class Greeted implements DeclareGreet{
   public  void Greet()
    {
        System.out.println("Hey, this is an example for the structure of a java program");
    }
}
public class Program1 {
   public static void main(String[] args) {
        Greeted obj=new Greeted();
        obj.Greet();
   } 
}
