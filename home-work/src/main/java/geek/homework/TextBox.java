package geek.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Picture
 */
public class TextBox implements Component {

    private String msg;

    private List<Component> components;

    public TextBox(String msg,List<Component> components){
        this.msg = msg;
        this.components = components;
    }

    @Override
    public void print() {
        System.out.println(msg);
        if(components != null){
            components.forEach(component -> component.print());
        }
    }
}
