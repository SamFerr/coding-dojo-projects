import java.util.ArrayList;
public class Exceptionally {
    public static void main(String[] args){
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");

        for (Object value : myList){
            try {
                Integer newValue = (Integer) value;
                System.out.println(newValue);
                myList.set(myList.indexOf(newValue), newValue);
            }catch (ClassCastException cce){
                System.out.println("ERROR ON INDEX "+ myList.indexOf(value));
            }
        }
    }
}