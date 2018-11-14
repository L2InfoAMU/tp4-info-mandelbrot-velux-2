package viewer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
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
        GridPane pane = fxmlLoader.load(getClass().getResource("/viewer/viewer.fxml").openStream());
        Controller controller = (Controller) fxmlLoader.getController();

        /*Display ColorPicker*/
        final ColorPicker colorPicker1 = new ColorPicker(Color.rgb(51,51,51));
        colorPicker1.setTranslateX(300);
        colorPicker1.setTranslateY(240);

        final ColorPicker colorPicker2 = new ColorPicker(Color.rgb(179,179,179));
        colorPicker2.setTranslateX(300);
        colorPicker2.setTranslateY(270);

        final ColorPicker colorPicker3 = new ColorPicker(Color.rgb(55, 118, 145));
        colorPicker3.setTranslateX(300);
        colorPicker3.setTranslateY(300);

        final ColorPicker colorPicker4 = new ColorPicker(Color.rgb(63, 74, 132));
        colorPicker4.setTranslateX(300);
        colorPicker4.setTranslateY(330);

        final ColorPicker colorPicker5 = new ColorPicker(Color.rgb(145, 121, 82));
        colorPicker5.setTranslateX(300);
        colorPicker5.setTranslateY(360);

        final ColorPicker colorPicker6 = new ColorPicker(Color.rgb(250, 250, 200));
        colorPicker6.setTranslateX(300);
        colorPicker6.setTranslateY(390);

        pane.getChildren().addAll(colorPicker1,colorPicker2,colorPicker3,colorPicker4,colorPicker5,colorPicker6);


        /*Display description text*/
        DescText descColor = new DescText("Color:","impact",25,Color.WHITE,300,210);
        DescText descCamera = new DescText("Camera:","impact",25,Color.WHITE,10,270);
        DescText descCenterX = new DescText("centerX","impact",16,Color.WHITE,185,300);
        DescText descCenterY = new DescText("centerY","impact",16,Color.WHITE,185,330);
        DescText descWidth = new DescText("camWidth","impact",16,Color.WHITE,185,360);
        DescText descRatio = new DescText("camRatio","impact",16,Color.WHITE,185,390);

        pane.getChildren().addAll(
                descColor.getDescText(),
                descCamera.getDescText(),
                descCenterX.getDescText(),
                descCenterY.getDescText(),
                descWidth.getDescText(),
                descRatio.getDescText()
        );


        /*Spinner for Camera*/
        Spinners centerX = new Spinners(10,300,-2.0,5.0,-0.5);
        Spinners centerY = new Spinners(10,330,-2.0,5.0,0.0);
        Spinners CamWidth = new Spinners(10,360,-2.0,5.0,3.0);
        Spinners CamRatio = new Spinners(10,390,1.0,3.0,4./3.0);

        pane.getChildren().addAll(
                centerX.getSpinner(),
                centerY.getSpinner(),
                CamWidth.getSpinner(),
                CamRatio.getSpinner()
        );


        /*Display set Buttons*/
        Buttons setColor = new Buttons("Set color",480,300,80,30);
        Buttons setCamera = new Buttons("Set camera",480,340,80,30);
        Buttons setDefault = new Buttons("Default",480,380,80,30);

        pane.getChildren().addAll(setColor,setCamera,setDefault);

        /*Display scene*/
        primaryStage.setTitle("Mandelbrot");
        primaryStage.setScene(new Scene(pane,1200,900));


        /*Set new color*/
        setColor.setOnMouseClicked((MouseEvent event) -> {
                    if (event.getButton().equals(MouseButton.PRIMARY)) {

                                /*Display new mandelbrot color*/
                                controller.setNewColor(new ColorList(
                                        colorPicker1.getValue(),
                                        colorPicker2.getValue(),
                                        colorPicker3.getValue(),
                                        colorPicker4.getValue(),
                                        colorPicker5.getValue(),
                                        colorPicker6.getValue()
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
                        CamWidth.getSpinner().getValue(),
                        CamRatio.getSpinner().getValue()));
            }
        });

        /*Set default values*/
        setDefault.setOnMouseClicked((MouseEvent event) -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {

                centerX.setDefault();
                centerY.setDefault();
                CamWidth.setDefault();
                CamRatio.setDefault();

                colorPicker1.setValue(Color.rgb(51,51,51));
                colorPicker2.setValue(Color.rgb(179,179,179));
                colorPicker3.setValue(Color.rgb(55, 118, 145));
                colorPicker4.setValue(Color.rgb(63, 74, 132));
                colorPicker5.setValue(Color.rgb(145, 121, 82));
                colorPicker6.setValue(Color.rgb(250, 250, 200));


            }
        });

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
