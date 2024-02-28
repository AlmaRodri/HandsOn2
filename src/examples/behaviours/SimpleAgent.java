
package examples.behaviours;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;

import java.util.Arrays;

public class SimpleAgent extends Agent {

  protected void setup() {
    System.out.println("Agent "+getLocalName()+" started.");

    // Add the CyclicBehaviour
    addBehaviour(new CyclicBehaviour(this) {
      public void action() {
        System.out.println("Cycling");
      }
    });   

    //Add OneshotBehaviour
    addBehaviour(new OneShotBehaviour() {
          public void action() {
            double x;
            DataSet dataSetInsurance = new DataSet(
                new double[] {18, 22, 23, 26, 28, 31, 33},
                new double[] {10000, 15000, 18000, 21000, 24000, 26500, 27000}
            );
            System.out.println("Comportamiento one-shot");
            DiscreteMaths discreteMaths = new DiscreteMaths();
            SLR slr = new SLR(dataSetInsurance, discreteMaths);
            System.out.println("Beta 0 = "+ slr.calculateIntersection());
            System.out.println("Beta 1 = "+ slr.calculateSlope());
            slr.printRegEquation(); //imprime la ecuacion de regresion
            System.out.println("Coeficiente de correlacion: " + Correlations.correlaCoef(dataSetInsurance));
            System.out.println("Coeficiente de determinacion: " + Correlations.correlaDetermina(dataSetInsurance));
            x = 28;
            slr.predict(x);
            x = 30;
            slr.predict(x);
            x = 32;
            slr.predict(x);
          }
        });
    // Add the generic behaviour
      addBehaviour(new generic());
    addBehaviour(new FourStepBehaviour());
  } 
  private class generic extends Behaviour{
      private boolean bandera=false;

      public void action(){
          double x;
          DataSet dataSetPopu = new DataSet(
                  new double[] {1955, 1960, 1965, 1970, 1975, 1980, 1985, 1990, 1995, 2000, 2005, 2010, 2015, 2016,
                          2017, 2018, 2019, 2020, 2025, 2030, 2035, 2040, 2045, 2050},
                  new double[] {409880595, 450547679, 499123324, 555189792, 623102897, 698952844, 784360008, 873277798,
                          963922588, 1056575549, 1147609927, 1234281170, 1310152403, 1324517249, 1338676785, 1352642280,
                          1366417754, 1380004385, 1445011620, 1503642322, 1553723810, 1592691513, 1620619200, 1620619200}
          );
          System.out.println("Comportamiento generico");
          DiscreteMaths discreteMaths = new DiscreteMaths();
          SLR slr = new SLR(dataSetPopu, discreteMaths);
          System.out.println("Beta 0 = "+ slr.calculateIntersection());
          System.out.println("Beta 1 = "+ slr.calculateSlope());
          slr.printRegEquation(); //imprime la ecuacion de regresion
          System.out.println("Coeficiente de correlacion: " + Correlations.correlaCoef(dataSetPopu));
          System.out.println("Coeficiente de determinacion: " + Correlations.correlaDetermina(dataSetPopu));
          x = 2022;
          slr.predict(x);
          x = 2013;
          slr.predict(x);
          x = 1994;
          slr.predict(x);
          bandera = true;
      }
      public boolean done() {
          return bandera;
      }
  }
  /**
   * Inner class FourStepBehaviour
   */
  private class FourStepBehaviour extends Behaviour {
    private int step = 1;

    public void action() {
      double x;
 DataSet dataSetSalary = new DataSet(
        new double[] {1.2000000000000002, 1.4000000000000001, 1.6, 2.1, 2.3000000000000003,  3.0, 3.1,
                3.3000000000000003, 3.300000000000000, 3.8000000000000003, 4.0, 4.1, 4.1, 4.199999999999999, 4.6, 5.0,
                5.199999999999999, 5.3999999999999995, 6.0, 6.1, 6.8999999999999995, 7.199999999999999, 8.0,
                8.299999999999999, 8.799999999999999, 9.1, 9.6, 9.7, 10.4, 10.6},
        new double[] {39344.0, 46206.0, 37732.0, 43526.0, 39892.0, 56643.0, 60151.0, 54446.0, 64446.0, 57190.0,
                63219.0, 55795.0, 56958.0, 57082.0, 61112.0, 67939.0, 66030.0, 83089.0, 81364.0, 93941.0, 91739.0,
                98274.0, 101303.0, 113813.0, 109432.0, 105583.0, 116970.0, 112636.0, 122392.0, 121873.0}
 );
      DiscreteMaths discreteMaths = new DiscreteMaths();
      SLR slr = new SLR(dataSetSalary, discreteMaths);

      switch (step) {
      case 1:
        // Perform operation 1: print out a message
        System.out.println("Comportamiento por pasos");
        System.out.println("Beta 0 = "+ slr.calculateIntersection());
        System.out.println("Beta 1 = "+ slr.calculateSlope());
        slr.printRegEquation(); //imprime la ecuacion de regresion
        break;
      case 2:
        System.out.println("Operation 2. ");
        System.out.println("Coeficiente de correlacion: " + Correlations.correlaCoef(dataSetSalary));
        System.out.println("Coeficiente de determinacion: " + Correlations.correlaDetermina(dataSetSalary));
        break;
      case 3:
        // Perform operation 3: print out a message
        System.out.println("Operation 3");
        x = 3;
        slr.predict(x);
        x = 4;
        slr.predict(x);
        x = 6;
        slr.predict(x);
        break;
      }
      step++;
    } 

    public boolean done() {
      return step == 4;
    } 

    public int onEnd() {
      myAgent.doDelete();
      return super.onEnd();
    } 
  }    // END of inner class FourStepBehaviour
}




