public class Class {
    static int a=10; 
    int ab=19;
    public static void main(String[] args) {
        System.out.println(a); // a can be accessed directly, coz of static keyword
        Class obj= new Class();
        System.out.println(obj.ab); //ab can be accessed only when object is created
    }
}
