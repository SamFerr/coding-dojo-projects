import java.util.ArrayList;

public class PuzzleJavaTest {

    public static void main(String[] args){
        PuzzleJava puzzling = new PuzzleJava();

        int[] arr1 = {3,5,1,2,7,9,8,13,25,32};
        ArrayList<Integer> arr = puzzling.greaterThanTen(arr1);

        String[] arr2 = {"Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"};
        puzzling.overFiveChar(arr2)

        puzzling.isVowel();

        puzzling.genTen();
        
        puzzling.getTenSorted(puzzling.genTen());
        
        puzzling.genRandomString();
        
		puzzling.gen10RandString();
    }
}