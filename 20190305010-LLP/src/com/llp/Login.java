package com.llp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {

    private JPanel panel1;
    private JLabel lbl_login;
    private JLabel lbl_username;
    private JLabel lbl_password;
    private JTextField txt_username;
    private JPasswordField txt_password;
    private JButton btn_login;

    public Login(){
        add(panel1);
        setSize(500,450);
        setBounds(500,150,500,450);
        setTitle("Library Layout Project");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        btn_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = txt_username.getText();
                String password = new String(txt_password.getPassword());

                if(username.equals("admin") && password.equals("admin"))
                {   Main m = new Main();
                    m.setVisible(true);
                    setVisible(false);
            }
                else{
                    JOptionPane.showMessageDialog(null,"Username and Password Do Not Match");
                    txt_username.setText("");
                    txt_password.setText("");
                    txt_username.requestFocus();
                }
            }

        });

    }

}
