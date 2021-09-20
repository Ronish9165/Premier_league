package library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class HomePage implements ActionListener {
    JFrame fr;
    JPanel panel;
    JLabel lbl_img, lbl_img1, lbl_club, lbl_cid;
    JButton btn_addstd, btn_update, btn_logout;
    JTextField txt_id;
    ImageIcon image_premier, image_background;
    Font fon1, fon2;
    DefaultTableModel model;
    JTable std;

    public HomePage() {
        fr = new JFrame("Homepage");

        panel = new JPanel();
        panel.setBounds(0, 0, 800, 750);
        panel.setLayout(null);
        fr.add(panel);

        //Fonts
        fon1 = new Font("arial", Font.BOLD, 22);
        fon2 = new Font("arial", Font.BOLD, 15);


        //Headings
        lbl_club = new JLabel("Club");
        lbl_club.setFont(fon1);
        lbl_club.setForeground(Color.darkGray);
        lbl_club.setBounds(70, 220, 100, 20);
        panel.add(lbl_club);

        lbl_cid = new JLabel("C.Id");
        lbl_cid.setFont(fon1);
        lbl_cid.setForeground(Color.darkGray);
        lbl_cid.setBounds(10, 220, 100, 20);
        panel.add(lbl_cid);

        //Text field
        txt_id = new JTextField();
        txt_id.setFont(fon1);
        txt_id.setBounds(100, 570, 70, 30);
        txt_id.setBorder(new LineBorder(new Color(0, 0, 0),4));
        panel.add(txt_id);

        //Buttons
        btn_addstd = new JButton("Add Standings");
        btn_addstd.setFont(fon2);
        btn_addstd.setBounds(200, 570, 150, 50);
        btn_addstd.addActionListener(this);
        panel.add(btn_addstd);

        btn_logout = new JButton("Logout");
        btn_logout.setFont(fon1);
        btn_logout.setBounds(665, 10, 120, 40);
        btn_logout.setBackground(new Color(108, 215, 255));
        panel.add(btn_logout);


        btn_logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new LoginPage();
                fr.dispose();
            }
        });

        //Image
        image_premier = new ImageIcon(getClass().getResource("premier.png"));
        lbl_img = new JLabel(image_premier);
        lbl_img.setBounds(0, 0, 798, 500);
        panel.add(lbl_img);

        image_background = new ImageIcon(getClass().getResource("background1.png"));
        lbl_img1 = new JLabel(image_background);
        lbl_img1.setBounds(0, 495, 920, 600);
        panel.add(lbl_img1);


        standing();

        fr.setSize(815, 750);
        fr.setLayout(null);
        fr.setVisible(true);

    }
    public void standing(){
        model= new DefaultTableModel();
        std= new JTable(model);
        fon1=new Font("Dialog", Font.BOLD, 22);
        fon1=new Font("Serif", Font.BOLD, 18);
        std.setFont(fon1);
        std.setRowHeight(50);
        std.setBackground(new Color(211,244,252));
        model.addColumn("MP");
        model.addColumn("W");
        model.addColumn("D");
        model.addColumn("L");
        model.addColumn("GF");
        model.addColumn("GA");
        model.addColumn("GD");
        model.addColumn("Pts");
        JTableHeader header = std.getTableHeader();
        header.setFont(fon1);
        header.setBackground(Color.white);
        header.setForeground(Color.darkGray);
        std.getTableHeader().setPreferredSize(new Dimension(30,45));
        try {
            DbConnection db=new DbConnection();
            String query="select * from standings";
            ResultSet rs=db.select(query);
            DefaultTableModel model=(DefaultTableModel)std.getModel();
            model.setRowCount(0);
            int i=0;

            while(rs.next()){
                System.out.println(rs.getString(1)+" "+rs.getString(2));
                model.addRow(new Object[]{ rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getString(5), rs.getString(6),rs.getString(7),
                        rs.getString(8),rs.getString(9)});
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        JScrollPane pg = new JScrollPane(std);
        pg.setBounds(285,200,515,298);
        panel.add(pg);
    }

    public static void main(String[] args) {
        new HomePage();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btn_update){
            standing();
        }
        if (e.getSource() == btn_addstd) {
            if (txt_id.getText().length()==0){
                JOptionPane.showMessageDialog(fr,"Insert ID First");
            return;
            }
            else {
                fr.dispose();
                new standings(txt_id.getText());
            }

        }
    }
}
