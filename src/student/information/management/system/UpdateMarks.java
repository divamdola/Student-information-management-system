package student.information.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateMarks extends JFrame implements ActionListener {
    Choice cenroll;
    UpdateMarks(){
        getContentPane().setBackground(new Color(230,210,252));

        JLabel heading=new JLabel("Update Marks Detail");
        heading.setBounds(50,10,500,50);
        heading.setFont(new Font("Serif",Font.BOLD,35));
        add(heading);

        cenroll=new Choice();
        cenroll.setBounds(250,100,200,20);
        add(cenroll);
        try{
            Conn c=new Conn();
            ResultSet rs=c.statement.executeQuery("select * from new_student_detail");
            while(rs.next()){
                cenroll.add(rs.getString("enroll_no"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public static void main(String[] args){

    }
}
