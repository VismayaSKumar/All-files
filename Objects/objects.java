class Student{
    int id;
    String name;
    Student(int i,String n){    //constructor created
        id=i;
        name=n;
    }
}
public class objects {
    public static void main(String[] args) {
        
    
    Student s1=new Student(101,"Sonu");     //initializing the object by constructor
    System.out.println(s1.id+" "+s1.name);
    }
}
