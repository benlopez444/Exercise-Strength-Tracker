public class Entry {
    private String date;
    private int reps;
    private int sets;
    private double weight;
    public Entry(String date, int sets, int reps, double weight){
        this.date = date;
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
    }
    public String getDate(){
        return this.date;
    }
    public int getReps(){
        return this.reps;
    }
    public int getSets(){
        return this.sets;
    }
    public double getWeight(){
        return this.weight;
    }
    public double getVolume(){
        return (double) this.reps * this.sets * this.weight;
    }
    //display data of this entry
    @Override
    public String toString(){
        return "Date: " + date + " | " + reps + " reps | " + sets + " sets | " + weight + " lbs";
    }


}
