import kon.lib.*;
import kon.coord.*;
import kon.translate.*;
import mains.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame implements ActionListener{
    public static void main(String[] args){
        MainFrame frame = new MainFrame("kon_tool");
        frame.setVisible(true);
    }
    public MainFrame(String title){
        setTitle(title);
        setBounds(100,100,600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel p = new JPanel();

        /*ボタンを追加する場合は、以下に追加したのち、actionPerformedに処理内容を追加してください。
         * -----------------------------------
         * JButton btn = new JButton("Push");
         * btn.addActionListener(this);
         * p.add(btn);
         * --------------------------------
         */

         JButton btn = new JButton("一致する地物");
         btn.addActionListener(this);
         p.add(btn);

        getContentPane().add(p, BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e){
        String cmdName = e.getActionCommand();
        String[] params = new String[1];
        JLabel label;

        //ボタンを増やした場合はcaseを追加してください。
        switch(cmdName){
            case "Push":
                label = new JLabel("Push A Button");
                JOptionPane.showMessageDialog(this, label);
                break;
            case "一致する地物":
                DebugPolygon.main(params);
                label = new JLabel("Push A Button");
                JOptionPane.showMessageDialog(this, label);
                break;
            default:
                System.out.println("ボタンが設定されていません。\nボタン名："+cmdName);
        }
    }
}
