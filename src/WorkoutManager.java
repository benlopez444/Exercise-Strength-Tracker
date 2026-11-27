import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class WorkoutManager {
    private ArrayList<Exercise> exercises;

    public WorkoutManager(){
        this.exercises = new ArrayList<Exercise>();
    }

    public void addExercise(Exercise e){
        exercises.add(e);
    }

    public Exercise getExercise(String name){
        for(int i = 0; i < this.exercises.size(); i++){
            if(name.equals(this.exercises.get(i).getName())){
                return this.exercises.get(i);
            }
        }
        return null;
    }
    public void saveWorkouts(){
        try(PrintWriter pw = new PrintWriter("workouts.csv")){
            pw.println("name,date,sets,reps,weight");
            for(Exercise e: this.exercises){
                for(int i = 0; i < e.getEntries().size(); i++){
                    pw.println(e.getName() + "," + e.getEntries().get(i).csvString());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error Saving Workouts!");
        }
    }
    public void loadWorkouts(){
        try(BufferedReader br = new BufferedReader(new FileReader("workouts.csv"))){
            br.readLine();
            String line;
            while((line = br.readLine()) != null){
                String[] linesplit = line.split(",");
                if(getExercise(linesplit[0]) == null){
                    Exercise e = new Exercise(linesplit[0]);
                    Entry e1 = new Entry(linesplit[1],Integer.parseInt(linesplit[2]),Integer.parseInt(linesplit[3]),Double.parseDouble(linesplit[4]));
                    e.getEntries().add(e1);
                    this.exercises.add(e);
                } else{
                    Entry e1 = new Entry(linesplit[1],Integer.parseInt(linesplit[2]),Integer.parseInt(linesplit[3]),Double.parseDouble(linesplit[4]));
                    getExercise(linesplit[0]).add(e1);
                }
            }
        } catch(FileNotFoundException e){
            System.out.println("Error Loading Workouts!");
        } catch(IOException e){
            System.out.println("Error Loading Workouts!");
        }
    }
}
