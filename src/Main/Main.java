package Main;
import digSearch2.DigSearch;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        DigSearch digSearch = new DigSearch();
        MyForm myForm = new MyForm();
        myForm.revalidate();
        myForm.buttonSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (myForm.textField.getText().isEmpty()){
                    myForm.label.setText("Поле ввода пусто");
                } else {
                    if (digSearch.search(myForm.textField.getText())) {
                        myForm.label.setText("Слово найдено");
                    } else {
                        myForm.label.setText("Слово отсутствует");
                    }
                }
            }
        });
        myForm.buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (myForm.textField.getText().isEmpty()){
                    myForm.label.setText("Поле ввода пусто");
                } else {
                    if (digSearch.add(myForm.textField.getText())) {
                        myForm.label.setText("Слово добавлено");
                        myForm.listModel.addElement(myForm.textField.getText());
                    } else {
                        myForm.label.setText("Слово уже имеется");
                    }
                }
            }
        });
    }
}
