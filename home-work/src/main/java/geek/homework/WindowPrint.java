package geek.homework;

import java.util.ArrayList;
import java.util.List;

public class WindowPrint {




    public static void main(String[] args) {


        /**
         * 第一部分：组件声明
         */

        Component logo = new Picture("print Picture(LOGO图片)",null);
        Component logIn = new Button("print Button(登录)",null);
        Component signIn = new WindowForm("print Button(注册)",null);
        Component userName = new Label("print Label(用户名)",null);
        Component textbox = new TextBox("print TextBox(文本框)",null);
        Component passWord = new Label("print Label(密码)",null);
        Component passWordBox = new PasswordBox("print PasswordBox(密码框)",null);
        Component checkBox = new CheckBox("print CheckBox(复选框)",null);
        Component rememberName = new TextBox("print TextBox(记住姓名)",null);
        Component forgetName = new Linkable("print Linkable(忘记密码)",null);

        /**
         * 第二部分：组件组装
         */
        List<Component> windowComponent = new ArrayList<>();
        windowComponent.add(logo);
        windowComponent.add(logIn);
        windowComponent.add(signIn);

        List<Component> frameComponent = new ArrayList<>();
        frameComponent.add(userName);
        frameComponent.add(textbox);
        frameComponent.add(passWord);
        frameComponent.add(passWordBox);
        frameComponent.add(checkBox);
        frameComponent.add(rememberName);
        frameComponent.add(forgetName);


        Component frame = new Frame("print Frame(FREAM1)",frameComponent);
        windowComponent.add(frame);


        Component windowForm = new WindowForm("print WinForm(WINDOW窗口)",windowComponent);

        /**
         * 第三部分：组件输出
         */
        windowForm.print();


    }




}
