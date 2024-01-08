
class Student
{
    String name;
    int age;
    public void getInfo(){
        System.out.println(this.name);
        System.out.println(this.age);
       
    }
     Student()
        {
            System.out.println("constructor is called");
        }
}
public class OOPs {
    public static void main(String[] args) {
       Student s1=new Student();
       s1.name="Aman";
       s1.age=25;
     s1.getInfo();
       Student s2=new Student();
       s2.name="Arya";
       s2.age=20;
       s2.getInfo();

    }
}