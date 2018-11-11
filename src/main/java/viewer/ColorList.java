package viewer;

import javafx.scene.paint.Color;

/**Create a list of colors to display*/
public class ColorList {

    static Color[] color0 =
            {       Color.gray(0.2),
                    Color.gray(0.7),
                    Color.rgb(55, 118, 145),
                    Color.rgb(63, 74, 132),
                    Color.rgb(145, 121, 82),
                    Color.rgb(250, 250, 200)
            };

    public ColorList(Color color1,Color color2,Color color3,Color color4){
        Color []color = {
                Color.gray(0.2),
                Color.gray(0.7),
                color1,
                color2,
                color3,
                color4
        };

        color0 = color;
    }

    public Color[] getColor(){return color0;}

}
