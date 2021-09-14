package library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginPage implements ActionListener {
    JFrame fr;
    JLabel lbl_heading,lbl_account,lbl_username,lbl_password;
    JTextField txt_username;
    JPasswordField txt_password;
    JButton btn_login,btn_cancel,btn_reg;
    Font fon1,fon2;
    public LoginPage(){
        fr=new JFrame("Login Page");
        fr.getContentPane().setBackground(Color.LIGHT_GRAY);

        //Fonts
        fon1=new Font("arial",Font.BOLD,25);
        fon2=new Font("arial",Font.BOLD,15);

        //Heading
        lbl_heading=new JLabel("Login Credentials");
        lbl_heading.setFont(fon1);
        lbl_heading.setForeground(Color.red);
        lbl_heading.setBounds(150,10,250,30);
        fr.add(lbl_heading);

        //Label
        lbl_username=new JLabel("Username");
        lbl_username.setFont(fon1);
        lbl_username.setForeground(Color.BLUE);
        lbl_username.setBounds(25,50,120,40);
        fr.add(lbl_username);


        //label for password
        lbl_password=new JLabel("Password");
        lbl_password.setFont(fon1);
        lbl_password.setForeground(Color.BLUE);
        lbl_password.setBounds(25,100,120,40);
        fr.add(lbl_password);

        lbl_account=new JLabel("Don't have an account?");
        lbl_account.setFont(fon2);
        lbl_account.setForeground(Color.BLACK);
        lbl_account.setBounds(10,225,200,40);
        fr.add(lbl_account);

        //TextField password
        txt_password=new JPasswordField();
        txt_password.setFont(fon2);
        txt_password.setBounds(155,100,220,40);
        fr.add(txt_password);

        //TextField
        txt_username=new JTextField();
        txt_username.setFont(fon2);
        txt_username.setBounds(155,50,220,40);
        fr.add(txt_username);

        //Buttons
        btn_login=new JButton("Login");
        btn_login.setFont(fon1);
        btn_login.setBounds(30,150,150,40);
        btn_login.addActionListener(this);
        fr.add(btn_login);

        btn_cancel=new JButton("Cancel");
        btn_cancel.setFont(fon1);
        btn_cancel.setBounds(200,150,150,40);
        fr.add(btn_cancel);

        btn_reg=new JButton("Sign Up");
        btn_reg.setFont(fon1);
        btn_reg.setForeground(Color.red);
        btn_reg.setBounds(180,230,150,30);
        btn_reg.addActionListener(this);
        fr.add(btn_reg);


        fr.setSize(400,300);
        fr.setLayout(null);
        fr.setVisible(true);
    }
    public static void main(String[] args){

        new LoginPage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn_reg){
            new RegisterPage();
        }
        if(e.getSource()==btn_login){
            String username=txt_username.getText();
            String passw=txt_password.getText();
            String query="select * from usr_tbl where username='"+username+"'and pass='"+passw+"'";
            DbConnection db=new DbConnection();
            ResultSet rs=db.select(query);
            try {
                if(rs.next()){
                    JOptionPane.showMessageDialog(fr,"Login Successfull");
                    new HomePage(username);
                    fr.dispose();

                }
                else{
                    JOptionPane.showMessageDialog(fr,"Invalid username and password");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }


        }
    }

}
