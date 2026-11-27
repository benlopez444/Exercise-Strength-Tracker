import java.util.Scanner;
public class Main{
    private static WorkoutManager wm = new WorkoutManager();
    public static void main(String[] args){
        wm.loadWorkouts();
        Scanner scan = new Scanner(System.in);
        System.out.print("Welcome to Exercise Strength Tracker! ");
        while(true){
            System.out.println("Choose an option:");
            System.out.println("1. Add New Exercise (and add one entry)\n2. Add Entry\n3. View Exercise\n4. Calculate Improvement Percentage\n5. Exit");
            int opt = scan.nextInt();
            scan.nextLine();
            if(opt == 1){
                System.out.println("Enter Exercise Name:");
                String name = scan.nextLine();
                System.out.println("Enter Exercise Date:");
                String date = scan.next();
                System.out.println("Enter Exercise Sets:");
                int sets = scan.nextInt();
                System.out.println("Enter Exercise Reps:");
                int reps = scan.nextInt();
                System.out.println("Enter Exercise Weight:");
                double weight = scan.nextDouble();
                Exercise e = new Exercise(name);
                Entry e1 = new Entry(date,sets,reps,weight);
                e.add(e1);
                wm.addExercise(e);
                wm.saveWorkouts();
                System.out.println("Exercise Added Successfully");
            } else if(opt == 2){

            }
        }
    }
}