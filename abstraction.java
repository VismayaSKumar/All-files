interface Animal{
    void walk();
}
interface Herbi{
    void eat();
}
class horse implements Animal{
    public void walk()
    {
        System.out.println("walks on 4 legs");
    }
}
class Hen implements Animal,Herbi{
    public void  walk()
    {
        System.out.println("walks on 2 legs");
    }
    public void eat()
    {
        System.out.println("it eats herbs");
    }
}

public class abstraction {
    public static void main(String[] args) {
        Hen h=new Hen();
        horse h1=new horse();
        h.walk();
        h.eat();
        h1.walk();
}
}
