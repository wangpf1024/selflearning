package geek.homework;


import java.util.List;


/**
 * window form
 */
public class WindowForm implements Component {

    private String msg;

    private List<Component> components;

    public WindowForm(String msg,List<Component> components){
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
