import java.util.ArrayList;
import java.util.Collections;
public class ArrayLists
{
    public static void main(String[] args) {
        ArrayList<Integer>list =new ArrayList<>();
        //add elements
        list.add(5);
        list.add(3);
        list.add(1);
        System.out.println(list);

        //get element
        System.out.println(list.get(1));

        //add element inbtwm
        list.add(1, 2);
        System.out.println(list);

        //set element
        list.set(0, 1);
        System.out.println(list);
    
        //delete element
        list.remove(0);
        System.out.println(list);
    
        //size
        System.out.println(list.size());

        //sorting
        Collections.sort(list);
        System.out.println(list);

        //loop to print each element
        for(int i=0;i<list.size();i++)
        System.out.println(list.get(i));
    }
}