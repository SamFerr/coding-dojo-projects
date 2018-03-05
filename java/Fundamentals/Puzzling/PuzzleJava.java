import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
import java.util.Arrays;

public class PuzzleJava {
    public ArrayList<Integer> puzzle1(){
        int[] nums = {3,5,1,2,7,9,8,13,25,32};
        ArrayList<Integer> bigNums = new ArrayList<Integer>();
        int sum = 0;
        for (int num : nums){
            sum += num;
            if (num > 10){
                bigNums.add(num);
            }
        }
        System.out.println(sum);
        return bigNums;
    }

    public ArrayList<String> puzzle2(){
        Random rand = new Random();
        ArrayList<String> names = new ArrayList<String>();
        names.add("Nancy");
        names.add("Jinichi");
        names.add("Fujibayashi");
        names.add("Momochi");
        names.add("Ishikawa");
        // shuffling
        for (int i = 0; i < names.size(); i++){
            int index1 = rand.nextInt(names.size());
            int index2 = rand.nextInt(names.size());
            String name1 = names.get(index1);
            String name2 = names.get(index2);
            names.set(index1, name2);
            names.set(index2, name1);
        }
        // printing & checking for length > 5 
        ArrayList<String> bigNames = new ArrayList<String>();
        for (String name: names){
            System.out.println(name);
            if (name.length() > 5){
                bigNames.add(name);
                counter++;
            }
        }
        // returning ArrayList of names
        return bigNames;
    }

    public void puzzle3(){
        Character[] alpha =  {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        Character[] vowels = {'a','e','i','o','u'};
        ArrayList<Character> alphabet = new ArrayList<Character>(Arrays.asList(alpha));
        Collections.shuffle(alphabet);
        System.out.println(alphabet.get(alphabet.size()-1)); // last letter
        System.out.println(alphabet.get(0)); // first letter
        for (Character vowel : vowels){
            if (vowel == alphabet.get(0)){
                System.out.println("Got a vowel here!");
            }
        }
    }

    public ArrayList<Integer> puzzle4(){
        Random rand = new Random();
        ArrayList<Integer> randos = new ArrayList<Integer>();
        for (int i=0; i < 10; i++){
            Integer randNum = rand.nextInt(46) + 55;
            randos.add(randNum);
        }
        return randos;
    }

    public ArrayList<Integer> puzzle5(){
        Random rand = new Random();
        ArrayList<Integer> randos = new ArrayList<Integer>();
        for (int i=0; i < 10; i++){
            Integer randNum = rand.nextInt(46) + 55;
            randos.add(randNum);
        }
        Collections.sort(randos);
        System.out.println(randos);
        System.out.println(randos.get(0));
        System.out.println(randos.get(randos.size()-1));
        return randos;
    }

    public void puzzle6(){
        Random rand = new Random();
        Character[] alpha =  {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        String word = "";
        for (int i = 0; i < 5; i++){
            int rand_index = rand.nextInt(26);
            word += alpha[rand_index];
        }
        System.out.println(word);
    }

    public void puzzle7(){
        String[] wordList = new String[10];
        Random rand = new Random();
        Character[] alpha =  {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        for (int x = 0; x < 10; x++){
            String word = "";
            
            for (int i = 0; i < 5; i++){
                int rand_index = rand.nextInt(26);
                word += alpha[rand_index];
            }

            wordList[x] = word;
        }
        
        //testing
        for (String w : wordList){
            System.out.println(w);
        }
    }
}