import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CreateAccount implements ActionListener 
{
	JFrame createframe = new JFrame();
	JLabel createmainhead = new JLabel();
	JPanel namepanel,addresspanel,emailpanel,phonepanel,depositpanel,passwordpanel;
	JLabel namelabel ,addresslabel,emaillabel,phonelabel,depositlabel,passwordlabel;
	JButton savebutton = new JButton();
	JButton gobackbutton = new JButton();
	JTextField nametext,addresstext,emailtext,phonetext,deposittext,passwordtext;
	Border border = BorderFactory.createLineBorder(Color.black,1);
	firstpage fobj = new firstpage();
	
	private String name,address,email,password,dummyphone,dummydeposit;
	private long phone,accnum;
	private double deposit;
	ArrayList <account> crlist = new ArrayList<>();	
	
	public void Create()
	{	
		createmainhead.setText("----- Account Registration Form -----");//main top heading
		createmainhead.setFont(new Font("",Font.BOLD,20));
		createmainhead.setBorder(border);
		createmainhead.setVerticalAlignment(JLabel.TOP);
		createmainhead.setHorizontalAlignment(JLabel.CENTER);
		createmainhead.setForeground(Color.WHITE);
		createmainhead.setBackground(new Color(0xdb6551));
		createmainhead.setOpaque(true);
		createmainhead.setBounds(0, 0, 600, 30);
		
		namepanel = new JPanel();//name panel
		namepanel.setBounds(0, 40, 600, 100);
		namelabel = new JLabel();
		namelabel.setText("NAME: ");
		namelabel.setFont(new Font("",Font.BOLD,18));
		namepanel.setLayout(new BorderLayout());
		nametext = new JTextField();
		nametext.setPreferredSize(new Dimension(50,30));
		nametext.setBounds(80, 75, 500, 30);
		namepanel.setBackground(Color.lightGray);
		
		addresspanel = new JPanel();//address panel
 		addresspanel.setBounds(0, 150, 600, 100);
		addresslabel = new JLabel();
		addresslabel.setText("ADDRESS: ");
		addresslabel.setFont(new Font("",Font.BOLD,18));
		addresspanel.setLayout(new BorderLayout());
		addresstext = new JTextField();
		addresstext.setPreferredSize(new Dimension(50,30));
		addresstext.setBounds(110, 185, 470, 30);
		addresspanel.setBackground(Color.lightGray);
		
		emailpanel = new JPanel();//email panel
		emailpanel.setBounds(0, 260, 600, 100);
		emaillabel = new JLabel();
		emaillabel.setText("EMAIL ID: ");
		emaillabel.setFont(new Font("",Font.BOLD,18));
		emailpanel.setLayout(new BorderLayout());
		emailtext = new JTextField();
		emailtext.setPreferredSize(new Dimension(50,30));
		emailtext.setBounds(100, 295, 480, 30);
		emailpanel.setBackground(Color.lightGray);
		
		phonepanel = new JPanel();//phone panel
		phonepanel.setBounds(0, 370, 600, 100);
		phonelabel = new JLabel();
		phonelabel.setText("PHONE NUMBER: ");
		phonelabel.setFont(new Font("",Font.BOLD,18));
		phonepanel.setLayout(new BorderLayout());
		phonetext = new JTextField();
		phonetext.setPreferredSize(new Dimension(50,30));
		phonetext.setBounds(180, 405, 400, 30);
		phonepanel.setBackground(Color.lightGray);
		
		depositpanel = new JPanel();//deposit panel
		depositpanel.setBounds(0, 480, 600, 100);
		depositlabel = new JLabel();
		depositlabel.setText("Initial Deposit Amount: ");
		depositlabel.setFont(new Font("",Font.BOLD,18));
		depositpanel.setLayout(new BorderLayout());
		deposittext = new JTextField();
		deposittext.setPreferredSize(new Dimension(50,30));
		deposittext.setBounds(210, 515, 370, 30);
		depositpanel.setBackground(Color.lightGray);
		
		passwordpanel = new JPanel();//password panel
		passwordpanel.setBounds(0, 590, 600, 100);
		passwordlabel = new JLabel();
		passwordlabel.setText("Set Password: ");
		passwordlabel.setFont(new Font("",Font.BOLD,18));
		passwordpanel.setLayout(new BorderLayout());
		passwordtext = new JTextField();
		passwordtext.setPreferredSize(new Dimension(50,30));
		passwordtext.setBounds(150, 625, 430, 30);
		passwordpanel.setBackground(Color.lightGray);
		
		savebutton.setBounds(430, 710, 40, 20);//save button
		savebutton.setText("Save");
		savebutton.setFocusable(false);
		savebutton.addActionListener(this);
		savebutton.setBorder(border);
		
		gobackbutton.setBounds(130, 710, 40, 20);//back button
		gobackbutton.setText("Back");
		gobackbutton.setFocusable(false);
		gobackbutton.addActionListener(this);
		gobackbutton.setBorder(border);
		
		createframe.setTitle("Account Registration Form");//overall frame for the Account Registration window
		createframe.setSize(600,800);
		createframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createframe.setResizable(false);
		createframe.getContentPane().setBackground(new Color(0xf9dcc5));
		createframe.setLayout(null);
		ImageIcon icon = new ImageIcon("images.png");
		createframe.setIconImage(icon.getImage());
		createframe.add(createmainhead);
		createframe.add(namepanel);
		createframe.add(addresspanel);
		createframe.add(emailpanel);
		createframe.add(phonepanel);
		createframe.add(depositpanel);
		createframe.add(passwordpanel);
		namepanel.add(namelabel);
		addresspanel.add(addresslabel);
		emailpanel.add(emaillabel);
		phonepanel.add(phonelabel);
		depositpanel.add(depositlabel);
		passwordpanel.add(passwordlabel);
		createframe.add(savebutton);
		createframe.add(gobackbutton);
		createframe.add(nametext);
		createframe.add(addresstext);
		createframe.add(emailtext);
		createframe.add(phonetext);
		createframe.add(deposittext);
		createframe.add(passwordtext);
		createframe.setVisible(true);
		
	}
	
	public void addcreate(ArrayList<account> list) 
	{
		this.crlist = list;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		try
		{
		if(e.getSource()==savebutton)
		{
			if(crlist.isEmpty())
			{
				crlist.add(new account("User-1","Bangalore","abc22@gmail.com",1234567891L,50000,"user1"));
				crlist.add(new account("User-2","Bangladesh","xyz01@gmail.com",9999999998L,50000,"user2"));
				crlist.add(new account("User-3","Himalaya","pqr28@gmail.com",9999999995L,50000,"user3"));
				crlist.add(new account("User-4","Bidar","lmno25@gmail.com",7894561230L,50000,"user4"));
			}
			name = nametext.getText();
			address = addresstext.getText();
			email = emailtext.getText();
			dummyphone = phonetext.getText();
			phone = Long.parseLong(dummyphone);
			dummydeposit = deposittext.getText();
			deposit = Double.parseDouble(dummydeposit);
			password = passwordtext.getText();
			crlist.add(new account(name,address,email,phone,deposit,password));
			addcreate(crlist);
			Loginpage lobj = new Loginpage();
			lobj.addlogin(crlist);
			Homepage hobj = new Homepage();
			hobj.addhomelist(crlist);
			fobj.addfirst(crlist);
			Viewupdate vobj = new Viewupdate();
			vobj.addupdate(crlist);
			for (account ac:crlist)
			{
				accnum = ac.getAccnum();
			}
			JOptionPane.showMessageDialog(createframe, "..Successful Registration....!\n Your Account Number: "+ accnum,"Registration",JOptionPane.INFORMATION_MESSAGE);
			createframe.dispose();
			lobj.Login();
 		}
		if(e.getSource()==gobackbutton)
		{
			createframe.dispose();
			fobj.addfirst(crlist);
			fobj.Firstpage();
		}
		}
		catch(Exception msg)
		{
			JOptionPane.showMessageDialog(createframe, "Unsuccessful Registration....!\nEnter Your Credentials Correctly","WARNING",JOptionPane.WARNING_MESSAGE);
		}
	}
}