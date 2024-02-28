package examples.behaviours;

public class DataSet {
    private double x[];
    private double y[];


  /*  public DataSet(){
        x = new float []{1,2,3,4,5,6,7,8,9};
        y = new float []{2,4,6,8,10,12,14,16,18};
    }*/

    public DataSet(double x[], double y[]){
        this.x = x;
        this.y = y;
    }

    public double[] getX(){

        return this.x;
    }

    public double[] getY(){

        return this.y;
    }
}
