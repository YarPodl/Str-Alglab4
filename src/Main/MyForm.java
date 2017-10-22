package Main;

import javax.swing.*;
import java.awt.*;

public class MyForm extends JFrame {

    public JButton buttonSearch;
    public JButton buttonAdd;
    public JTextField textField;
    public JLabel label;
    public JList listBox;
    public JPanel panel;
    public DefaultListModel listModel;

    public MyForm() {
        super();
        //UIManager.getSystemLookAndFeelClassName ();
        setMinimumSize(new Dimension(300, 300));
        setSize(450, 300);
        setVisible(true);
        setTitle("Лабораторня работа №4. Цифровой поиск");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);





        setLayout(new BorderLayout());

        listModel = new DefaultListModel();
        listBox = new JList(listModel);
        getContentPane().add(listBox, BorderLayout.CENTER);

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        getContentPane().add(panel, BorderLayout.EAST);
        panel.setPreferredSize(new Dimension(150, 300));

        buttonAdd = new JButton("Добавить");
        buttonAdd.setPreferredSize(new Dimension(150, 25));

        buttonSearch = new JButton("Найти");
        buttonSearch.setPreferredSize(new Dimension(100, 25));

        textField = new JTextField();
        textField.setMaximumSize(new Dimension(300, 25));

        label = new JLabel("");


        panel.add(Box.createVerticalStrut(20));
        panel.add(new JLabel("Введите слово"));
        panel.add(textField);
        panel.add(Box.createVerticalStrut(20));
        panel.add(buttonAdd);
        panel.add(Box.createVerticalStrut(20));
        panel.add(buttonSearch);
        panel.add(Box.createVerticalStrut(20));
        panel.add(label);


    }
}
