import java.util.ArrayList;
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
}
