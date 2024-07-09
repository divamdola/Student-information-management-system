package student.information.management.system;

import com.mysql.cj.protocol.ReadAheadInputStream;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class UpdateStudent extends JFrame implements ActionListener {
    JTextField textaddress,textPhone,textEmail,textCourse,textBranch;
    JLabel enrollN;
    Choice cenroll;
    JButton submit,cancel;
    UpdateStudent(){
        getContentPane().setBackground(new Color(230,210,252));

        JLabel heading=new JLabel("Update Student Details");
        heading.setBounds(50,10,500,50);
        heading.setFont(new Font("Serif",Font.BOLD,35));
        add(heading);

        JLabel empId=new JLabel("Select Enrollment No");
        empId.setBounds(50,100,200,20);
        empId.setFont(new Font("serif",Font.PLAIN,20));
        add(empId);

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

        JLabel name=new JLabel("Name");
        name.setBounds(20,150,200,30);
        name.setFont(new Font("Serif",Font.BOLD,20));
        add(name);

        JLabel textName=new JLabel();
        textName.setBounds(150,150,200,30);
        textName.setFont(new Font("Serif",Font.BOLD,20));
        add(textName);

        JLabel fname=new JLabel("Enter Father's Name");
        fname.setBounds(430,150,200,30);
        fname.setFont(new Font("Serif",Font.BOLD,20));
        add(fname);

        JLabel textFather=new JLabel();
        textFather.setBounds(650,150,200,30);
        textFather.setFont(new Font("Serif",Font.BOLD,20));
        add(textFather);

        JLabel enrollNo=new JLabel("Enrollment No");
        enrollNo.setBounds(20,200,200,30);
        enrollNo.setFont(new Font("Serif",Font.BOLD,20));
        add(enrollNo);

        enrollN=new JLabel();
        enrollN.setBounds(180,200,200,30);
        enrollN.setFont(new Font("Serif",Font.BOLD,20));
        add(enrollN);

        JLabel dob=new JLabel("Date of Birth");
        dob.setBounds(430,200,200,30);
        dob.setFont(new Font("Serif",Font.BOLD,20));
        add(dob);

        JLabel cdob=new JLabel();
        cdob.setBounds(650,200,200,30);
        cdob.setFont(new Font("Serif",Font.BOLD,20));
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

        JLabel textM10=new JLabel();
        textM10.setBounds(650,300,200,30);
        textM10.setFont(new Font("Serif",Font.BOLD,20));
        add(textM10);

        JLabel M12=new JLabel("Class XII (%)");
        M12.setBounds(20,350,200,30);
        M12.setFont(new Font("Serif",Font.BOLD,20));
        add(M12);

        JLabel textM12=new JLabel();
        textM12.setBounds(150,350,200,30);
        textM12.setFont(new Font("Serif",Font.BOLD,20));
        add(textM12);

        JLabel aadhar=new JLabel("Aadhar No");
        aadhar.setBounds(430,350,200,30);
        aadhar.setFont(new Font("Serif",Font.BOLD,20));
        add(aadhar);

        JLabel textAadhar=new JLabel();
        textAadhar.setBounds(650,350,200,30);
        textAadhar.setFont(new Font("Serif",Font.BOLD,20));
        add(textAadhar);

        JLabel course=new JLabel("Course");
        course.setBounds(20,400,200,30);
        course.setFont(new Font("Serif",Font.BOLD,20));
        add(course);

        textCourse = new JTextField();
        textCourse.setBounds(150,400,200,30);
        add(textCourse);

        JLabel branch=new JLabel("Branch");
        branch.setBounds(430,400,200,30);
        branch.setFont(new Font("Serif",Font.BOLD,20));
        add(branch);

        textBranch=new JTextField();
        textBranch.setBounds(650,400,200,30);
        add(textBranch);

        try{
            Conn c=new Conn();
            String query="select * from new_student_detail where enroll_no='"+cenroll.getSelectedItem()+"'";
            ResultSet resultSet=c.statement.executeQuery(query);
            while(resultSet.next()){
                textName.setText(resultSet.getString("sname"));
                textFather.setText(resultSet.getString("fname"));
                cdob.setText(resultSet.getString("dob"));
                textAadhar.setText(resultSet.getString("aadhar"));
                textM10.setText(resultSet.getString("m_10"));
                textCourse.setText(resultSet.getString("course"));
                textBranch.setText(resultSet.getString("branch"));
                textaddress.setText(resultSet.getString("address"));
                textPhone.setText(resultSet.getString("mobile"));
                textEmail.setText(resultSet.getString("email"));
                textM12.setText(resultSet.getString("m_12"));
                enrollN.setText(resultSet.getString("enroll_no"));
            }
        }catch (Exception E){
            E.printStackTrace();
        }
        cenroll.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    Conn c=new Conn();
                    String query="select * from new_student_detail where enroll_no='"+cenroll.getSelectedItem()+"'";
                    ResultSet resultSet=c.statement.executeQuery(query);
                    while(resultSet.next()) {
                        textName.setText(resultSet.getString("sname"));
                        textFather.setText(resultSet.getString("fname"));
                        cdob.setText(resultSet.getString("dob"));
                        textAadhar.setText(resultSet.getString("aadhar"));
                        textM10.setText(resultSet.getString("m_10"));
                        textCourse.setText(resultSet.getString("course"));
                        textBranch.setText(resultSet.getString("branch"));
                        textaddress.setText(resultSet.getString("address"));
                        textPhone.setText(resultSet.getString("mobile"));
                        textEmail.setText(resultSet.getString("email"));
                        textM12.setText(resultSet.getString("m_12"));
                        enrollN.setText(resultSet.getString("enroll_no"));
                    }
                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });

        submit=new JButton("Update");
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
            String enroll=enrollN.getText();
            String add=textaddress.getText();
            String phone=textPhone.getText();
            String em=textEmail.getText();
            String cou=textCourse.getText();
            String bran=textBranch.getText();

            try{
                String q="update new_student_detail set address='"+add+"',mobile='"+phone+"',email='"+em+"',branch='"+bran+"',course='"+cou+"' where enroll_no='"+enroll+"'";
                Conn c=new Conn();
                c.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Student Detail Updated!!!");
                setVisible(false);
            }catch(Exception E){
                E.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args){
        new UpdateStudent();
    }
}
