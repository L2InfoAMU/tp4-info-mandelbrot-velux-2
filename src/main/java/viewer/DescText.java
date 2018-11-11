package viewer;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**Create text for the scene*/
public class DescText {

    private Text descText;

    public DescText(String text, String font, int fontSize, Color color, int setX, int setY){

        descText = new Text(text);
        descText.setFont(new Font(font,fontSize));
        descText.setFill(color);
        descText.setX(setX);
        descText.setY(setY);
    }

    public Text getDescText(){return descText;}
}
