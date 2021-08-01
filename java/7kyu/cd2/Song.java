import java.util.*;
public class Song {

    private String title;
    private String artist;
    private ArrayList<String> listeners = new ArrayList<String>();

    public Song (String title, String artist){
        this.title = title;
        this.artist = artist;
    }

    public String getTitle(){
        return title;
    }

    public String getArtist(){
        return artist;
    }

    public int howMany(ArrayList<String> newListeners){
        int result = 0;
        boolean isFound;
        if (listeners.size() == 0){
            listeners = newListeners;
            result = newListeners.size();
        } else {
            for (int i=0;i<newListeners.size();i++){
                isFound = false;
                for (int j=0;j<listeners.size();j++){
                    if (newListeners.get(i).toLowerCase().equals(listeners.get(j).toLowerCase())){
                        isFound = true;
                        break;
                    }
                }
                if (!isFound){
                    listeners.add(newListeners.get(i));
                    result++;
                }
            }
        }
        return result;
    }
}