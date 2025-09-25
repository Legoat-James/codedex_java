import javax.swing.*;
public class CodeDex_final_GUI {
    public static void main(String args[]){
        //create a new window (JFrame)
        JFrame frame = new JFrame("my first GUI");
        frame.setSize(1000,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); //absolute positioning
        //frame.setLayout(new java.awt.FlowLayout()); //components are placed in a row, left to right, top to bottom

        // JTextField textField = new JTextField();
        // textField.setBounds(200,20,200,25);

        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(200,50,700,325);
        

        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        JButton button = new JButton("click me to save your text as a text file!");
        //im gonna use .getPrefferedSize() to grab the size of the button
        java.awt.Dimension button_size = button.getPreferredSize();
        button.setBounds(600,0, button_size.width, button_size.height);

        JLabel greeting_label = new JLabel("Hello!, select a radio button to choose the topic");
        greeting_label.setFont(new java.awt.Font("SansSerif", java.awt.Font.PLAIN, 24));
        java.awt.Dimension greeting_size = greeting_label.getPreferredSize();
        greeting_label.setBounds(0, 0, greeting_size.width, greeting_size.height);

        JLabel info_label = new JLabel("No topic selected");
        java.awt.Dimension infoLabelSize = info_label.getPreferredSize();
        info_label.setBounds(0, 350, infoLabelSize.width, infoLabelSize.height);
        // info_label.setFont(new java.awt.Font("SansSerif", java.awt.Font.PLAIN, 24));

        JRadioButton radioButton1 = new JRadioButton("School");
        JRadioButton radioButton2 = new JRadioButton("Work");     
        JRadioButton radioButton3 = new JRadioButton("Other");

        ButtonGroup group = new ButtonGroup();
        group.add(radioButton1);
        group.add(radioButton2);
        group.add(radioButton3);
        
        //  JRadioButton currentlySelected = null; //keep track of currently selected button
        JRadioButton currentlySelected[] = {null};
    
        
        // lay out all buttons with automatic sizing and spacing
        java.util.Enumeration<AbstractButton> buttons = group.getElements();
        int y = 50;
        while (buttons.hasMoreElements()) {
            AbstractButton b = buttons.nextElement();
            java.awt.Dimension d = b.getPreferredSize();
            b.setBounds(0, y, d.width, d.height);
            y += 30;
        }
        

        //whenever a radio button from group is selected, change the label to that buttons text
        java.awt.event.ActionListener radioListener = e -> {
            //gets the object on which the event occured, then gets the button that was clicked
            JRadioButton selected = (JRadioButton) e.getSource();
            info_label.setText("file name is: " + selected.getText() +".txt");
            java.awt.Dimension newSize = info_label.getPreferredSize();
            info_label.setBounds(0, 350, newSize.width, newSize.height);

            currentlySelected[0] = selected;
        }; 
        radioButton1.addActionListener(radioListener);
        radioButton2.addActionListener(radioListener);
        radioButton3.addActionListener(radioListener);
        
        button.addActionListener(e ->{
            if( currentlySelected[0] == null) {
                JOptionPane.showMessageDialog(frame, "Please select a topic first");
                return;
            }
            // Save the text area content to a text file, even though we use a scrollpane the text is stored in the text area
            String content = textArea.getText();
            try {
                String filename = currentlySelected[0].getText().toLowerCase() + ".txt";
                java.nio.file.Files.write(java.nio.file.Paths.get(filename), content.getBytes());
                JOptionPane.showMessageDialog(frame, "Text saved to " + filename + ".txt");
            } catch (java.io.IOException ex) {
                JOptionPane.showMessageDialog(frame, "Error saving file: " + ex.getMessage());
            }
        });
        
        
       



        
        frame.add(scrollPane);
        frame.add(button);
        frame.add(greeting_label);
        frame.add(info_label);
        
        frame.add(radioButton1);
        frame.add(radioButton2);
        frame.add(radioButton3);


        frame.setVisible(true);

    }
}
