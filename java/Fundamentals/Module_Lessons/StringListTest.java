import java.util.HashMap;
import java.util.Map;
public class SongListTest{
    public static void main(String[] args){
        HashMap<String, String> trackList = new HashMap<String, String>();
        
        trackList.put("Song1", "LYRICS");
        trackList.put("Song2", "LYRICS");
        trackList.put("Song3", "LYRICS");
        trackList.put("Song4", "LYRICS");

        String song = trackList.get("Song2");
        for (Map.Entry<String, String> entry: trackList.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        } 
        // or
        for (String key : trackList.keySet()){
            System.out.println(key + ": " + trackList.get(key));
        }
    }
}