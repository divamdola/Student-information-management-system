package student.information.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_class extends JFrame implements ActionListener {
    Main_class(){
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/first.png"));
        Image i2=i1.getImage().getScaledInstance(1540,700,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        add(img);
        JMenuBar mb=new JMenuBar();

        //new Information

        JMenu studentInfo=new JMenu("Student Information");
        studentInfo.setBackground(Color.black);
        mb.add(studentInfo);

        JMenuItem addStudentInfo=new JMenuItem("Register New Student");
        addStudentInfo.setBackground(Color.white);
        addStudentInfo.addActionListener(this);
        studentInfo.add(addStudentInfo);

        JMenuItem studentDetails=new JMenuItem("View Students Details");
        studentDetails.setBackground(Color.white);
        studentDetails.addActionListener(this);
        studentInfo.add(studentDetails);

        //Leave

        JMenu Leave=new JMenu("Leave");
        Leave.setBackground(Color.black);
        mb.add(Leave);

        JMenuItem studentLeave=new JMenuItem("Apply Leave");
        studentLeave.setBackground(Color.white);
        studentLeave.addActionListener(this);
        Leave.add(studentLeave);

        JMenuItem studentLeaveDetails=new JMenuItem("Leave Detail");
        studentLeaveDetails.setBackground(Color.white);
        studentLeaveDetails.addActionListener(this);
        Leave.add(studentLeaveDetails);

        //Exams

        JMenu exam=new JMenu("Examination");
        exam.setBackground(Color.black);
        mb.add(exam);

        JMenuItem examMarks=new JMenuItem("Enter Marks");
        examMarks.setBackground(Color.white);
        examMarks.addActionListener(this);
        exam.add(examMarks);

        JMenuItem examinationDetails=new JMenuItem("Results");
        examinationDetails.setBackground(Color.white);
        examinationDetails.addActionListener(this);
        exam.add(examinationDetails);

        //Update Info

        JMenu updateInfo=new JMenu("Update Information");
        updateInfo.setBackground(Color.black);
        mb.add(updateInfo);

        JMenuItem updateStudentInfo=new JMenuItem("Update Student Information");
        updateStudentInfo.setBackground(Color.white);
        updateStudentInfo.addActionListener(this);
        updateInfo.add(updateStudentInfo);

        JMenuItem updateMarks=new JMenuItem("Update Marks");
        updateMarks.setBackground(Color.white);
        updateMarks.addActionListener(this);
        updateInfo.add(updateMarks);

        //fee

        JMenu fees=new JMenu("Fee Details");
        fees.setBackground(Color.black);
        mb.add(fees);

        JMenuItem feeStructure=new JMenuItem("Fee Structure");
        feeStructure.setBackground(Color.white);
        feeStructure.addActionListener(this);
        fees.add(feeStructure);

        //about

        JMenu about=new JMenu("About");
        about.setBackground(Color.black);
        about.addActionListener(this);
        mb.add(about);

        //exit

        JMenu exit=new JMenu("Exit");
        exit.setBackground(Color.black);
        mb.add(exit);

        JMenuItem Exit=new JMenuItem("Exit");
        Exit.setBackground(Color.white);
        Exit.addActionListener(this);
        exit.add(Exit);

        setJMenuBar(mb);
        setSize(1550,850);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String sm=e.getActionCommand();
        if(sm.equals("Register New Student")){
            new AddStudent();
        }else if(sm.equals("Apply Leave")){
            new Leave();
        } else if (sm.equals("View Students Details")) {
            new StudentDetails();
        } else if (sm.equals("Leave Detail")) {
            new LeaveDetails();
        } else if (sm.equals("Enter Marks")) {
            new EnterMarks();
        } else if (sm.equals("Update Student Information")) {
            new UpdateStudent();
        } else if (sm.equals("Results")) {
            new Result();
        } else{
            System.exit(405);
        }
    }

    public static void main(String[] args){
        new Main_class();
    }
}
