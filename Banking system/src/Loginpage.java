import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Loginpage implements ActionListener 
{
	JFrame logframe = new JFrame();
	JLabel loglabel = new JLabel();
	JLabel acclabel = new JLabel();
	JLabel passwordlabel = new JLabel();
	JPanel accpanel = new JPanel();
	JTextField acctext,passtext;
	JPanel passpanel = new JPanel();
	JLabel passlabel = new JLabel();
	JButton subbutton = new JButton();
	JButton backbutton = new JButton();
    Border border = BorderFactory.createLineBorder(Color.BLACK,1);
    ArrayList <account> lolist = new ArrayList<>();
    ArrayList <statement> laclist = new ArrayList<>();
    Homepage hobj = new Homepage();
    long laccnum;
    
	public void Login()
	{				
		loglabel.setText("----- LOGIN -----");//main top heading
		loglabel.setFont(new Font("",Font.BOLD,20));
		loglabel.setBorder(border);
		loglabel.setVerticalAlignment(JLabel.TOP);
		loglabel.setHorizontalAlignment(JLabel.CENTER);
		loglabel.setForeground(Color.WHITE);
		loglabel.setBackground(new Color(0xdb6551));
		loglabel.setOpaque(true);
		loglabel.setBounds(0, 0, 500, 30);
				
		accpanel.setBounds(30,80,430,105);
		accpanel.setBorder(border);
		acclabel.setText("Account Number");
		acclabel.setFont(new Font("",Font.BOLD,16));
		acclabel.setBounds(35, 85, 75, 20);
		
		passpanel.setBounds(30,185,430,105);
		passpanel.setBorder(border);
		passlabel.setText("Password");
		passlabel.setFont(new Font("",Font.BOLD,16));
		passlabel.setBounds(35, 85, 75, 20);
		
		acctext = new JTextField();
		acctext.setPreferredSize(new Dimension(50,30));
		acctext.setBounds(40, 130, 410, 30);
		
		passtext = new JTextField();
		passtext.setPreferredSize(new Dimension(50,30));
		passtext.setBounds(40, 235, 410, 30);
		
		subbutton.setBounds(345, 310, 60, 30);//submit button
		subbutton.setText(" SUBMIT ");
		subbutton.setFocusable(false);
		subbutton.addActionListener(this);
		subbutton.setBorder(border);
		
		backbutton = new JButton();//back button
		backbutton.setBounds(95, 310, 60, 30);
		backbutton.setText("Back");
		backbutton.setFocusable(false);
		backbutton.addActionListener(this);
		backbutton.setBorder(border);
		
		logframe.setTitle("Login Page");//overall log in frame window
		logframe.setSize(500,400);
		ImageIcon icon = new ImageIcon("images.png");
		logframe.setIconImage(icon.getImage());
		logframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		logframe.setResizable(false);
		logframe.setLayout(null);
		logframe.getContentPane().setBackground(new Color(0xf9dcc5));
		logframe.add(loglabel);
		logframe.add(accpanel);
		accpanel.add(acclabel);
		logframe.add(passpanel);
		passpanel.add(passlabel);
		logframe.add(acctext);
		logframe.add(passtext);
		logframe.add(subbutton);
		logframe.add(backbutton);
		logframe.setVisible(true);
		
    }
	
	public void addlogin(ArrayList<account> list) 
	{
		this.lolist = list;
	}
	
	public void addloginstatement(ArrayList<statement> list) 
	{
		this.laclist = list;
	}

	public void actionPerformed(ActionEvent ev)
	{
		try
		{
			if(ev.getSource()==subbutton)
			{
				boolean found = false;
		        String enternum = acctext.getText();
		        long enteraccnum = Long.parseLong(enternum);
		        String enterpass = passtext.getText();
		        for(account lac: lolist)
		        {
		        	if(enteraccnum==lac.getAccnum() && lac.getPassword().equals(enterpass)) 
		      		{
					    laccnum = lac.getAccnum();
					    JOptionPane.showMessageDialog(logframe, "..You have Successfull LOG IN: "+lac.getName(),"LOGIN PAGE",JOptionPane.INFORMATION_MESSAGE);
					    found = true;
					    hobj.addhomelist(lolist);
					    hobj.addaccnum(laccnum);
					    AccountStatement acobj = new AccountStatement();
						acobj.addaccstatement(laclist);
						hobj.addstatementlist(laclist);
						logframe.dispose();
						hobj.Home();
					    break;
				    }
		        }
		        if(found==false)
				{	   
					JOptionPane.showMessageDialog(logframe, "Unsuccessful LOGIN....!\nEnter Your Credentials Correctly","WARNING",JOptionPane.WARNING_MESSAGE);
				}
			}
			if(ev.getSource()==backbutton)
		    {
				firstpage fobj = new firstpage();
				fobj.addfirst(lolist);
				fobj.addfirststatement(laclist);
				logframe.dispose();
				fobj.Firstpage();
		    }
			

		}
		catch (NumberFormatException ex) 
		{
            JOptionPane.showMessageDialog(logframe, "Invalid Account Number!", "Error", JOptionPane.ERROR_MESSAGE);
        }
		
	}		
}