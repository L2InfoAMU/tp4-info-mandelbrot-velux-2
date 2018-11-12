package viewer;

import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

/**Create spinner to associate with a specific variable*/
public class Spinners {

    final Spinner<Double> spinner = new Spinner<Double>();
    private double initialValue;
    private double min;
    private double max;
    private SpinnerValueFactory<Double> valueFactory;

    public Spinners(int transX, int transY, double min,double max,double initialValue){
        spinner.setTranslateX(transX);
        spinner.setTranslateY(transY);

        this.min = min;
        this.max = max;
        this.initialValue = initialValue;

        valueFactory =
                new SpinnerValueFactory.DoubleSpinnerValueFactory(min, max, initialValue);
        ((SpinnerValueFactory.DoubleSpinnerValueFactory) valueFactory).setAmountToStepBy(0.1);
        spinner.setValueFactory(valueFactory);
    }

    public Spinner<Double> getSpinner(){ return spinner;}

    public void setDefault(){
        valueFactory =
                new SpinnerValueFactory.DoubleSpinnerValueFactory(min, max, initialValue);
        ((SpinnerValueFactory.DoubleSpinnerValueFactory) valueFactory).setAmountToStepBy(0.1);
        spinner.setValueFactory(valueFactory);
    }
}
