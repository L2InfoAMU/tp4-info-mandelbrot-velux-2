package viewer;

import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

/**Create spinner to associate with a specific variable*/
public class Spinners {

    final Spinner<Double> spinner = new Spinner<Double>();
    private double initialValue;
    private SpinnerValueFactory<Double> valueFactory;

    public Spinners(int transX, int transY, Double min,Double max,double initialValue){
        spinner.setTranslateX(transX);
        spinner.setTranslateY(transY);
        this.initialValue = initialValue;
        valueFactory =
                new SpinnerValueFactory.DoubleSpinnerValueFactory(min, max, initialValue);
        ((SpinnerValueFactory.DoubleSpinnerValueFactory) valueFactory).setAmountToStepBy(0.1);
        spinner.setValueFactory(valueFactory);
    }

    public Spinner<Double> getSpinner(){ return spinner;}
}
