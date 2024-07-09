package student.information.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddStudent extends JFrame implements ActionListener {
    JTextField textName,textFather,textaddress,textPhone,textEmail,textM10,textM12,textAadhar;
    JLabel enrollN;
    JDateChooser cdob;
    JButton submit,cancel;
    JComboBox courseBox,branchBox;
    Random ran=new Random();
    long f4=Math.abs((ran.nextLong()%9000L)+1000L);
    AddStudent(){
        getContentPane().setBackground(new Color(173,216,230));

        JLabel heading=new JLabel("New Student Details");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("Serif",Font.BOLD,30));
        add(heading);

        JLabel name=new JLabel("Name");
        name.setBounds(20,150,200,30);
        name.setFont(new Font("Serif",Font.BOLD,20));
        add(name);

        textName=new JTextField();
        textName.setBounds(150,150,200,30);
        add(textName);

        JLabel fname=new JLabel("Enter Father's Name");
        fname.setBounds(430,150,200,30);
        fname.setFont(new Font("Serif",Font.BOLD,20));
        add(fname);

        textFather=new JTextField();
        textFather.setBounds(650,150,200,30);
        add(textFather);

        JLabel enrollNo=new JLabel("Enrollment No");
        enrollNo.setBounds(20,200,200,30);
        enrollNo.setFont(new Font("Serif",Font.BOLD,20));
        add(enrollNo);

        enrollN=new JLabel("ST000000"+f4);
        enrollN.setBounds(180,200,200,30);
        enrollN.setFont(new Font("Serif",Font.BOLD,20));
        add(enrollN);

        JLabel dob=new JLabel("Date of Birth");
        dob.setBounds(430,200,200,30);
        dob.setFont(new Font("Serif",Font.BOLD,20));
        add(dob);

        cdob=new JDateChooser();
        cdob.setBounds(650,200,200,30);
        add(cdob);

        JLabel address=new JLabel("Address");
        address.setBounds(20,250,200,30);
        address.setFont(new Font("Serif",Font.BOLD,20));
        add(address);

        textaddress=new JTextField();
        textaddress.setBounds(150,250,200,30);
        add(textaddress);

        JLabel phone=new JLabel("Enter Mobile No");
        phone.setBounds(430,250,200,30);
        phone.setFont(new Font("Serif",Font.BOLD,20));
        add(phone);

        textPhone=new JTextField();
        textPhone.setBounds(650,250,200,30);
        add(textPhone);

        JLabel email=new JLabel("Email");
        email.setBounds(20,300,200,30);
        email.setFont(new Font("Serif",Font.BOLD,20));
        add(email);

        textEmail=new JTextField();
        textEmail.setBounds(150,300,200,30);
        add(textEmail);

        JLabel M10=new JLabel("Class X (%)");
        M10.setBounds(430,300,200,30);
        M10.setFont(new Font("Serif",Font.BOLD,20));
        add(M10);

        textM10=new JTextField();
        textM10.setBounds(650,300,200,30);
        add(textM10);

        JLabel M12=new JLabel("Class XII (%)");
        M12.setBounds(20,350,200,30);
        M12.setFont(new Font("Serif",Font.BOLD,20));
        add(M12);

        textM12=new JTextField();
        textM12.setBounds(150,350,200,30);
        add(textM12);

        JLabel aadhar=new JLabel("Aadhar No");
        aadhar.setBounds(430,350,200,30);
        aadhar.setFont(new Font("Serif",Font.BOLD,20));
        add(aadhar);

        textAadhar=new JTextField();
        textAadhar.setBounds(650,350,200,30);
        add(textAadhar);

        JLabel course=new JLabel("Course");
        course.setBounds(20,400,200,30);
        course.setFont(new Font("Serif",Font.BOLD,20));
        add(course);

        String cou[]={"--Select--","B.Tech","MCA"};
        courseBox=new JComboBox(cou);
        courseBox.setBounds(150,400,200,30);
        courseBox.setBackground(Color.white);
        add(courseBox);

        JLabel branch=new JLabel("Branch");
        branch.setBounds(430,400,200,30);
        branch.setFont(new Font("Serif",Font.BOLD,20));
        add(branch);

        String dept[]={"--Select--","Computer Science and Engineering","Electronics and Communication Engineering"};
        branchBox=new JComboBox(dept);
        branchBox.setBounds(650,400,220,30);
        branchBox.setBackground(Color.WHITE);
        add(branchBox);

        submit=new JButton("Register");
        submit.setBounds(300,500,120,30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);

        cancel=new JButton("Cancel");
        cancel.setBounds(450,500,120,30);
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
        if(e.getSource()==submit){
            String name=textName.getText();
            String fname=textFather.getText();
            String enroll= enrollN.getText();
            String dob=((JTextField)cdob.getDateEditor().getUiComponent()).getText();
            String address=textaddress.getText();
            String phone=textPhone.getText();
            String email=textEmail.getText();
            String class_10=textM10.getText();
            String class_12=textM12.getText();
            String aadhar=textAadhar.getText();
            String course=(String) courseBox.getSelectedItem();
            String branch=(String) branchBox.getSelectedItem();
            try{
                String q="insert into new_student_detail values('"+name+"','"+fname+"','"+enroll+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+class_10+"','"+class_12+"','"+aadhar+"','"+course+"','"+branch+"')";
                Conn c=new Conn();
                c.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Student Registered!!!");
                setVisible(false);
            }catch(Exception E){
                E.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args){
        new AddStudent();
    }
}
