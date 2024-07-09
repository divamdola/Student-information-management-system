package student.information.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Leave extends JFrame implements ActionListener {
    JTextField textName, textRoll,textmobile,textPurpose;
    JButton apply,cancel;
    JDateChooser from, to;
    JComboBox resBox;
    Leave(){
        getContentPane().setBackground(new Color(173,216,230));

        JLabel heading= new JLabel("Apply for Leave");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("Serif",Font.BOLD,30));
        add(heading);

        JLabel name=new JLabel("Enter name");
        name.setBounds(20,150,200,30);
        name.setFont(new Font("Serif",Font.BOLD,20));
        add(name);

        textName=new JTextField();
        textName.setBounds(150,150,200,30);
        add(textName);

        JLabel Rollno=new JLabel("Enrollment no");
        Rollno.setBounds(430,150,200,30);
        Rollno.setFont(new Font("Serif",Font.BOLD,20));
        add(Rollno);

        textRoll=new JTextField();
        textRoll.setBounds(650,150,200,30);
        add(textRoll);

        JLabel residents=new JLabel("Residents");
        residents.setBounds(20,200,200,30);
        residents.setFont(new Font("Serif",Font.BOLD,20));
        add(residents);

        String res[]={"--Select","Hosteler","Day Boarder"};
        resBox=new JComboBox(res);
        resBox.setBounds(150,200,200,30);
        resBox.setBackground(Color.white);
        add(resBox);

        JLabel mobile=new JLabel("Enter Mobile no.");
        mobile.setBounds(430,200,200,30);
        mobile.setFont(new Font("Serif",Font.BOLD,20));
        add(mobile);

        textmobile=new JTextField();
        textmobile.setBounds(650,200,200,30);
        add(textmobile);

        JLabel leaveFrom=new JLabel("Leave From");
        leaveFrom.setBounds(20,250,200,30);
        leaveFrom.setFont(new Font("Serif",Font.BOLD,20));
        add(leaveFrom);

        from=new JDateChooser();
        from.setBounds(150,250,200,30);
        add(from);

        JLabel leaveTo=new JLabel("Leave To");
        leaveTo.setBounds(430,250,200,30);
        leaveTo.setFont(new Font("Serif",Font.BOLD,20));
        add(leaveTo);

        to=new JDateChooser();
        to.setBounds(650,250,200,30);
        add(to);

        JLabel purpose=new JLabel("Purpose for Leave");
        purpose.setBounds(20,300,200,30);
        purpose.setFont(new Font("Serif",Font.BOLD,20));
        add(purpose);

        textPurpose =new JTextField();
        textPurpose.setBounds(200,300,200,30);
        add(textPurpose);

        apply=new JButton("Apply");
        apply.setBounds(300,450,120,30);
        apply.setBackground(Color.black);
        apply.setForeground(Color.white);
        apply.addActionListener(this);
        add(apply);

        cancel=new JButton("Cancel");
        cancel.setBounds(450,450,120,30);
        cancel.setBackground(Color.white);
        cancel.addActionListener(this);
        add(cancel);

        setSize(900,700);
        setLocation(350,50);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==apply){
            String sname=textName.getText();
            String enroll=textRoll.getText();
            String residents=(String) resBox.getSelectedItem();
            String mobile=textmobile.getText();
            String leaveFrom=((JTextField)from.getDateEditor().getUiComponent()).getText();
            String leaveTo=((JTextField)to.getDateEditor().getUiComponent()).getText();
            String purpose=textPurpose.getText();
            try{
                String q="insert into leaveDetails values('"+enroll+"','"+sname+"','"+residents+"','"+mobile+"','"+leaveFrom+"','"+leaveTo+"','"+purpose+"')";
                Conn c=new Conn();
                c.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Applied for Leave!!!");
                setVisible(false);

            }catch (Exception E){
                E.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args){
        new Leave();
    }
}
