package library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginPage implements ActionListener {
    JFrame fr;
    JPanel panel, panel2;
    ImageIcon background;
    JLabel lbl_heading,lbl_account,lbl_username,lbl_password, lbl_img;
    JTextField txt_username;
    JPasswordField txt_password;
    JButton btn_login,btn_exit,btn_reg;
    Font fon1,fon2;
    public LoginPage(){
        fr=new JFrame("Login Page");

        panel = new JPanel();
        panel.setBounds(100, 70, 450, 500);
        panel.setBackground(Color.white);
        panel.setLayout(null);
        fr.add(panel);

        panel2 = new JPanel();
        panel2.setBounds(0, 0, 800, 700);
        panel2.setLayout(null);
        fr.add(panel2);



        //Fonts
        fon1=new Font("arial",Font.BOLD,25);
        fon2=new Font("arial",Font.BOLD,15);

        //Heading
        lbl_heading=new JLabel("USER LOGIN");
        lbl_heading.setFont(fon1);
        lbl_heading.setForeground(Color.BLACK);
        lbl_heading.setBounds(150,10,250,30);
        panel.add(lbl_heading);

        //Label
        lbl_username=new JLabel("Username");
        lbl_username.setFont(fon1);
        lbl_username.setForeground(Color.BLACK);
        lbl_username.setBounds(25,100,120,40);
        panel.add(lbl_username);


        //label for password
        lbl_password=new JLabel("Password");
        lbl_password.setFont(fon1);
        lbl_password.setForeground(Color.BLACK);
        lbl_password.setBounds(25,190,120,40);
        panel.add(lbl_password);

        lbl_account=new JLabel("Don't have an account?");
        lbl_account.setFont(fon2);
        lbl_account.setForeground(Color.BLACK);
        lbl_account.setBounds(30,400,200,40);
        panel.add(lbl_account);

        //TextField password
        txt_password=new JPasswordField();
        txt_password.setFont(fon2);
        txt_password.setBounds(155,190,220,40);
        panel.add(txt_password);

        //TextField
        txt_username=new JTextField();
        txt_username.setFont(fon2);
        txt_username.setBounds(155,100,220,40);
        panel.add(txt_username);

        //Buttons
        btn_login=new JButton("Login");
        btn_login.setFont(fon1);
        btn_login.setBounds(90,300,150,40);
        btn_login.addActionListener(this);
        panel.add(btn_login);

        btn_exit=new JButton("Exit");
        btn_exit.setFont(fon1);
        btn_exit.setBounds(270,300,150,40);
        btn_exit.addActionListener(this);
        panel.add(btn_exit);

        btn_reg=new JButton("Sign Up");
        btn_reg.setFont(fon1);
        btn_reg.setForeground(Color.red);
        btn_reg.setBounds(200,405,150,30);
        btn_reg.addActionListener(this);
        panel.add(btn_reg);

        //Image
        background = new ImageIcon(getClass().getResource("bg.png"));
        lbl_img = new JLabel(background);
        lbl_img.setBounds(0, 0, 700, 700);
        panel2.add(lbl_img);

        fr.setSize(700,700);
        fr.setLayout(null);
        fr.setVisible(true);
    }


    public static void main(String[] args){

        new LoginPage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn_reg){
            fr.dispose();
            new RegisterPage();
        }
        if (e.getSource()==btn_exit){
            fr.dispose();
        }

        if(e.getSource()==btn_login){
            String username=txt_username.getText();
            String passw=txt_password.getText();
            String query="select * from usr_tbl where username='"+username+"'and pass='"+passw+"'";
            DbConnection db=new DbConnection();
            ResultSet rs=db.select(query);
            try {
                if(rs.next()){
                    JOptionPane.showMessageDialog(fr,"Login Successful");
                    new HomePage();
                    fr.dispose();

                }
                else{
                    JOptionPane.showMessageDialog(fr,"Invalid Username and Password");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }


        }
    }

}
