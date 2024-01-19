public class Class {

    static int var=10; 
    int ab=19;

    static void function(){
        System.out.println("static function");
    }

    void normal()
    {
        System.out.println("normal function");
    }
    public static void main(String[] args) {
        System.out.println(var); //  can be accessed directly, coz of static keyword
        function();
        Class obj= new Class();
        System.out.println(obj.ab); // can be accessed only when object is created
        obj.normal();
    }
}
