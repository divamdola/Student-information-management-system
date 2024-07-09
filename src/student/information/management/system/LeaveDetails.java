package student.information.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class LeaveDetails extends JFrame implements ActionListener {
    JTextField textEnroll;
    JButton search,cancel;
    JTable table;
    Choice choice;

    LeaveDetails(){
        getContentPane().setBackground(new Color(210,252,218));

        JLabel heading = new JLabel("Leave Details");
        heading.setBounds(20,20,150,20);
        add(heading);

        choice=new Choice();
        choice.setBounds(180,20,150,20);
        add(choice);

        try{
            Conn c=new Conn();
            ResultSet resultSet=c.statement.executeQuery("select * from leaveDetails");
            while(resultSet.next()){
                choice.add(resultSet.getString("enroll_no"));
            }
        }catch(Exception E){
            E.printStackTrace();
        }
        table=new JTable();
        try{
            Conn c=new Conn();
            ResultSet resultSet=c.statement.executeQuery("select * from leaveDetails");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }

        JScrollPane js=new JScrollPane(table);
        js.setBounds(0,100,900,600);
        add(js);

        search=new JButton("Search");
        search.setBounds(20,70,80,20);
        search.setBackground(Color.black);
        search.setForeground(Color.white);
        search.addActionListener(this);
        add(search);

        cancel=new JButton("Cancel");
        cancel.setBounds(120,70,80,20);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);

        setLayout(null);
        setSize(900,700);
        setLocation(300,100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==search){
            String q="select * leaveDetails where enroll_no='"+choice.getSelectedItem()+"'";
            try{
                Conn c=new Conn();
                ResultSet resultSet=c.statement.executeQuery(q);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            }catch (Exception E){
                E.printStackTrace();
            }
        }else if(e.getSource()==cancel){
            setVisible(false);
        }
    }

    public static void main(String[] args){
        new LeaveDetails();
    }
}
