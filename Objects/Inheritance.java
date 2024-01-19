

class Shape{
    String col;
}
class Triangle extends Shape{
    public void print(){
    System.out.println(col);
    }
}
class Circle extends Triangle{
   public void print(String col){
   
    System.out.println(col);
}
}

public class Inheritance {
    public static void main(String[] args) {
        Circle s1=new Circle();
        
        s1.col="blue";
        
        s1.print();
        s1.print("red");
    }
}
