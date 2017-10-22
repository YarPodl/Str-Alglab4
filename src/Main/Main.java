package Main;
import digSearch2.DigSearch;

import java.awt.event.ActionEvent;

public class Main {
    public static void main(String[] args) {
        DigSearch digSearch = new DigSearch();  // Объект, содержащий дерево
        MyForm myForm = new MyForm();           // Форма
        myForm.revalidate();                    // Отрисовка формы
        myForm.buttonSearch.addActionListener(e -> {    // обработка нажатия кнопки buttonSearch
            if (myForm.textField.getText().isEmpty()){
                myForm.label.setText("Поле ввода пусто");
            } else {
                if (digSearch.search(myForm.textField.getText())) {
                    myForm.label.setText("Слово найдено");
                } else {
                    myForm.label.setText("Слово отсутствует");
                }
            }
        });
        myForm.buttonAdd.addActionListener((ActionEvent e) -> { // обработка нажатия кнопки buttonSearch
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
        });
    }
}
