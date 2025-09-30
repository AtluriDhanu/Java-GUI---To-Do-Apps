package simulate;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


public class ToDoApp {

    private JFrame frame;
    private JTextField textField;
    private JButton addButton;
    private JButton delButton;
    private JList<String> taskList;
    private DefaultListModel<String> listModel;

    public ToDoApp() {
        frame = new JFrame("Simple To-Do List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 350);
        frame.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.setAlignmentX(JPanel.CENTER_ALIGNMENT);

        textField = new JTextField(15);
        textField.setMaximumSize(new Dimension(200, 25));
        textField.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        topPanel.add(Box.createVerticalStrut(10));
        topPanel.add(textField);

        addButton = new JButton("Add Task");
        addButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        topPanel.add(Box.createVerticalStrut(10));
        topPanel.add(addButton);

        delButton = new JButton("Delete Task");
        delButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        topPanel.add(Box.createVerticalStrut(10));
        topPanel.add(delButton);
        topPanel.add(Box.createVerticalStrut(10));
        frame.add(topPanel, BorderLayout.NORTH);

        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        frame.add(new JScrollPane(taskList), BorderLayout.CENTER);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String task = textField.getText().trim();
                if (!task.isEmpty()) {
                    listModel.addElement(task);
                    textField.setText("");
                }
            }
        });

        delButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex != -1) {
                    listModel.remove(selectedIndex);
                }
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new ToDoApp();
    }
}
