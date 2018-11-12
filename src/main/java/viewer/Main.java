package viewer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader fxmlLoader = new FXMLLoader();
        GridPane p = fxmlLoader.load(getClass().getResource("/viewer/viewer.fxml").openStream());
        Controller controller = (Controller) fxmlLoader.getController();

        /*Display ColorPicker*/
        final ColorPicker colorPicker1 = new ColorPicker(Color.rgb(55, 118, 145));
        colorPicker1.setTranslateX(300);
        colorPicker1.setTranslateY(340);

        final ColorPicker colorPicker2 = new ColorPicker(Color.rgb(63, 74, 132));
        colorPicker2.setTranslateX(300);
        colorPicker2.setTranslateY(370);

        final ColorPicker colorPicker3 = new ColorPicker(Color.rgb(145, 121, 82));
        colorPicker3.setTranslateX(300);
        colorPicker3.setTranslateY(400);

        final ColorPicker colorPicker4 = new ColorPicker(Color.gray(0.7));
        colorPicker4.setTranslateX(300);
        colorPicker4.setTranslateY(430);

        p.getChildren().addAll(colorPicker1,colorPicker2,colorPicker3,colorPicker4);


        /*Display description text*/
        DescText descColor = new DescText("Color:","impact",25,Color.WHITE,300,310);
        DescText descCamera = new DescText("Camera:","impact",25,Color.WHITE,10,310);
        DescText descCenterX = new DescText("= centerX","impact",16,Color.WHITE,160,340);
        DescText descCenterY = new DescText("= CenterY","impact",16,Color.WHITE,160,370);
        DescText descWidth = new DescText("= Width","impact",16,Color.WHITE,160,400);
        DescText descRatio = new DescText("= Ratio","impact",16,Color.WHITE,160,430);

        p.getChildren().addAll(
                descColor.getDescText(),
                descCamera.getDescText(),
                descCenterX.getDescText(),
                descCenterY.getDescText(),
                descWidth.getDescText(),
                descRatio.getDescText()
        );


        /*Spinner for Camera*/
        Spinners centerX = new Spinners(10,340,-2.0,5.0,-0.5);
        Spinners centerY = new Spinners(10,370,-2.0,5.0,0.0);
        Spinners width = new Spinners(10,400,-2.0,5.0,3.0);
        Spinners ratio = new Spinners(10,430,1.0,3.0,4./3.0);

        p.getChildren().addAll(
                centerX.getSpinner(),
                centerY.getSpinner(),
                width.getSpinner(),
                ratio.getSpinner()
        );


        /*Display set Buttons*/
        Buttons setColor = new Buttons("Set color",480,350,80,30);
        Buttons setCamera = new Buttons("Set camera",480,390,80,30);
        Buttons setDefault = new Buttons("Default",480,430,80,30);
        p.getChildren().addAll(setColor,setCamera,setDefault);

        /*Display scene*/
        primaryStage.setScene(new Scene(p,1200,900));


        /*Set new color*/
        setColor.setOnMouseClicked((MouseEvent event) -> {
                    if (event.getButton().equals(MouseButton.PRIMARY)) {

                                /*Display new mandelbrot color*/
                                controller.setNewColor(new ColorList(
                                        colorPicker1.getValue(),
                                        colorPicker2.getValue(),
                                        colorPicker3.getValue(),
                                        colorPicker4.getValue()
                                ).getColor());
                    }
        });

        /*Set new camera*/
        setCamera.setOnMouseClicked((MouseEvent event) -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {

                /*Display new camera*/
                controller.setNewCamera(new Camera(
                        centerX.getSpinner().getValue(),
                        centerY.getSpinner().getValue(),
                        width.getSpinner().getValue(),
                        ratio.getSpinner().getValue()));
            }
        });

        /*Set default values*/
        setDefault.setOnMouseClicked((MouseEvent event) -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {

                centerX.setDefault();
                centerY.setDefault();
                width.setDefault();
                ratio.setDefault();

                colorPicker1.setValue(Color.rgb(55, 118, 145));
                colorPicker2.setValue(Color.rgb(63, 74, 132));
                colorPicker3.setValue(Color.rgb(145, 121, 82));
                colorPicker4.setValue(Color.gray(0.7));
            }
        });

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
