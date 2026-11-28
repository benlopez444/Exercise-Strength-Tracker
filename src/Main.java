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
                if(sets <= 0 || reps <= 0 || weight <= 0){
                    System.out.println("Sets, Reps, or Weight must be positive");
                    continue;
                }
                Exercise e = new Exercise(name);
                Entry e1 = new Entry(date,sets,reps,weight);
                e.add(e1);
                wm.addExercise(e);
                wm.saveWorkouts();
                System.out.println("Exercise Added Successfully");
            } else if(opt == 2){
                System.out.println("Enter Exercise Name:");
                String name = scan.nextLine();
                if(wm.getExercise(name) == null){
                    System.out.println("Exercise Not Found");
                    continue;
                }
                System.out.println("Enter Exercise Date:");
                String date = scan.nextLine();
                System.out.println("Enter Exercise Sets:");
                int sets = scan.nextInt();
                System.out.println("Enter Exercise Reps:");
                int reps = scan.nextInt();
                System.out.println("Enter Exercise Weight:");
                double weight = scan.nextDouble();
                if(sets <= 0 || reps <= 0 || weight <= 0){
                    System.out.println("Sets, Reps, or Weight must be positive");
                    continue;
                }
                Entry e = new Entry(date,sets,reps,weight);
                wm.getExercise(name).add(e);
                wm.saveWorkouts();
            } else if(opt == 3){
                System.out.println("Enter Exercise Name:");
                String name = scan.nextLine();
                if(wm.getExercise(name) == null){
                    System.out.println("Exercise Not Found");
                    continue;
                }
                System.out.println(wm.getExercise(name).toString());
            } else if(opt == 4){
                System.out.println("Enter Exercise Name:");
                String name = scan.nextLine();
                if(wm.getExercise(name) == null){
                    System.out.println("Exercise Not Found");
                    continue;
                }
                System.out.println(wm.getExercise(name).toString());
                System.out.println("Number of First Entry:");
                int num1 = scan.nextInt() - 1;
                System.out.println("Number of Second Entry:");
                int num2 = scan.nextInt() - 1;
                if(num1 < 0 || num2 < 0){
                    System.out.println("Numbers must be Greater than 1");
                    continue;
                }
                if(num1 == num2){
                    System.out.println("Numbers Cannot be the Same");
                    continue;
                }
                if(num1 > num2){
                    System.out.println("First Entry Cannot be after Second Entry");
                    continue;
                }
                if(num1 > wm.getExercise(name).getSize() - 1 || num2 > wm.getExercise(name).getSize() - 1){
                    System.out.println("Number Cannot be Greater than Number of Entries");
                    continue;
                }
                double vol1 = wm.getExercise(name).getEntries().get(num1).getVolume();
                double vol2 = wm.getExercise(name).getEntries().get(num2).getVolume();
                double imp = ((vol2 / vol1) - 1) * 100;
                String improve = String.format("%.2f", imp);
                System.out.println("Improvement Percentage: " + improve + "%");
            } else if(opt == 5){
                System.out.println("Goodbye!");
                wm.saveWorkouts();
                return;
            }
        }
    }
}