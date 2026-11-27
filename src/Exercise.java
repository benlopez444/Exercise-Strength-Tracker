import java.util.ArrayList;
public class Exercise {
    private String name;
    private ArrayList<Entry> entries;
    //gonna have an Entry class with date, sets, reps, and weight
    public Exercise(String name){
        this.name = name;
        this.entries = new ArrayList<>();
    }

    public String getName(){
        return this.name;
    }

    public ArrayList<Entry> getEntries(){
        return this.entries;
    }
    //display all entries of this exercise
    @Override
    public String toString(){
        String allentries = name + "\n";
        int num = 1;
        for(Entry e: this.entries){
            allentries += num + ". " + e.toString() + "\n";
            num++;
        }
        return allentries;
    }
    public void add(Entry e){
        this.entries.add(e);
    }

    public int getSize(){
        return this.entries.size();
    }

}
