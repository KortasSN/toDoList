package com.josh;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

public class ToDoList extends JFrame{
private JTextField newToDoTextField;
private JList<String> toDoList;

    private DefaultListModel<String> listModel;
    private JButton addToDoButton;
private JPanel rootPanel;
    protected ToDoList() {
        setContentPane(rootPanel);
        setPreferredSize(new Dimension(500,500));

        listModel = new DefaultListModel<String>();

        toDoList.setModel(listModel);

        addListeners();
        pack();
        setVisible(true);

    }

    private void addListeners() {
        addToDoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newToDo = newToDoTextField.getText();
                newToDo = newToDo.trim(); //remove whitespace

                //Check to see if the JTextField is empty - if so, ignore.
                if (newToDo.length() == 0) {
                    return;
                }
                listModel.addElement(newToDo);
                newToDoTextField.setText("");
            }
        });
    toDoList.addListSelectionListener(new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            int selectedIndex = toDoList.getSelectedIndex();
            if (selectedIndex != -1) {
                listModel.remove(selectedIndex);

            }
        }
    });


    

    public static void main(String[] args) {
	ToDoList toDoGui = new ToDoList();

    }
}
