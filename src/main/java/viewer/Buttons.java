package viewer;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


/**Create Button with text and graphical interactions with the mouse*/
public class Buttons extends Parent {

    private String letter = new String("1");
    private int positionX = 0;
    private int positionY = 0;
    Rectangle backgroundButton;
    private Text letterButton = new Text();

    public Buttons(String letter, int positionX, int positionY,int sizeX,int sizeY){
        this.backgroundButton = new Rectangle(sizeX,sizeY,Color.WHITE);
        this.letter = letter;
        this.positionX = positionX;
        this.positionY = positionY;

        backgroundButton.setArcHeight(10);
        backgroundButton.setArcWidth(10);
        this.getChildren().add(backgroundButton);

        letterButton.setText(this.letter);
        letterButton.setFont(new Font("impact",11.5));
        letterButton.setFill(Color.GREY);
        letterButton.setX(sizeX/6);
        letterButton.setY(sizeY/1.5);
        this.getChildren().add(letterButton);

        this.setTranslateX(positionX);
        this.setTranslateY(positionY);

        this.setOnMouseEntered(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                backgroundButton.setFill(Color.LIGHTGREY);
            }
        });

        this.setOnMouseExited(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                    backgroundButton.setFill(Color.WHITE);
            }
        });

        this.setOnMousePressed(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                appuyer();
            }
        });

        this.setOnMouseReleased(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                relacher();
            }
        });
    }
    public void appuyer(){
        this.setTranslateY(positionY+2);
    }



    public void relacher(){
        this.setTranslateY(positionY);
    }

}
