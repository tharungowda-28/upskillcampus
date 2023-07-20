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
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Viewupdate implements ActionListener
{
	long upaccnum;
	ArrayList <account> uplist = new ArrayList<>();
	JFrame upframe = new JFrame();
	Border border = BorderFactory.createLineBorder(Color.BLACK,1);
	JLabel mainlabel,sublabel,namelabel,addresslabel,emaillabel,phonelabel,balabel;
	JTextField nametext,addresstext,emailtext,phonetext;
	JButton subbutton,backbutton;
	String name,address,email;
	long phone;
	double deposit;
	
	public void update()
	{
		mainlabel = new JLabel();
		mainlabel.setText("----- View And Update -----");//main top heading
		mainlabel.setFont(new Font("",Font.BOLD,20));
		mainlabel.setBorder(border);
		mainlabel.setForeground(Color.WHITE);
		mainlabel.setBackground(new Color(0xdb6551));
		mainlabel.setOpaque(true);
		mainlabel.setVerticalAlignment(JLabel.TOP);
		mainlabel.setHorizontalAlignment(JLabel.CENTER);
		mainlabel.setBounds(0, 0, 600, 30);
		
		sublabel = new JLabel();
		sublabel.setText("Editing and Viewing details in the Text Field");// sub heading
		sublabel.setFont(new Font("",Font.BOLD,16));
		sublabel.setHorizontalAlignment(JLabel.CENTER);
		sublabel.setAlignmentY(50);
		sublabel.setBounds(0, 30, 600, 26);
		
		namelabel = new JLabel();
		nametext = new JTextField(name);
		namelabel.setText("Name: ");
		namelabel.setFont(new Font("",Font.BOLD,16));
		namelabel.setBounds(10,75,60,30);
		nametext.setPreferredSize(new Dimension(50,30));
		nametext.setBounds(150, 75, 430, 30);
		
		addresslabel = new JLabel();
		addresstext = new JTextField(address);
		addresslabel.setText("Address: ");
		addresslabel.setFont(new Font("",Font.BOLD,16));
		addresslabel.setBounds(10,125,80,30);
		addresstext.setPreferredSize(new Dimension(50,30));
		addresstext.setBounds(150, 125, 430, 30);
		
		emaillabel = new JLabel();
		emailtext = new JTextField(email);
		emaillabel.setText("Email ID: ");
		emaillabel.setFont(new Font("",Font.BOLD,16));
		emaillabel.setBounds(10,175,100,30);
		emailtext.setPreferredSize(new Dimension(50,30));
		emailtext.setBounds(150, 175, 430, 30);
		
		phonelabel = new JLabel();
		phonetext = new JTextField(String.valueOf(phone));
		phonelabel.setText("Phone Number: ");
		phonelabel.setFont(new Font("",Font.BOLD,16));
		phonelabel.setBounds(10,225,160,30);
		phonetext.setPreferredSize(new Dimension(50,30));
		phonetext.setBounds(150, 225, 430, 30);
		
		balabel = new JLabel();
		balabel.setText("Available Balance :   Rs. "+deposit);
		balabel.setFont(new Font("",Font.BOLD,16));
		balabel.setBounds(10,275,500,30);
		
		subbutton = new JButton();
		subbutton.setBounds(420, 350, 60, 30);//update button
		subbutton.setText(" UPDATE ");
		subbutton.setFocusable(false);
		subbutton.addActionListener(this);
		subbutton.setBorder(border);
		
		backbutton = new JButton();
		backbutton.setBounds(120, 350, 60, 30);//back button
		backbutton.setText(" Back ");
		backbutton.setFocusable(false);
		backbutton.addActionListener(this);
		backbutton.setBorder(border);
		
		upframe.setTitle("View And Update");//overall frame for view and update
		upframe.setSize(600,500);
		ImageIcon icon = new ImageIcon("images.png");
		upframe.setIconImage(icon.getImage());
		upframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		upframe.setResizable(false);
		upframe.setLayout(null);
		upframe.getContentPane().setBackground(new Color(0xf9dcc5));
		upframe.add(mainlabel);
		upframe.add(sublabel);
		upframe.add(namelabel);
		upframe.add(nametext);
		upframe.add(addresslabel);
		upframe.add(addresstext);
		upframe.add(emaillabel);
		upframe.add(emailtext);
		upframe.add(phonelabel);
		upframe.add(phonetext);
		upframe.add(balabel);
		upframe.add(subbutton);
		upframe.add(backbutton);
		upframe.setVisible(true);
	}
	
	public void addupdate(ArrayList<account> list) 
	{
		this.uplist = list;
	}
	
	public void addupdate(long accnum)
	{
		this.upaccnum = accnum;
		for(account uac: uplist)
		{
			if(this.upaccnum==uac.getAccnum())
			{
				this.name = uac.getName();
				this.address = uac.getAddress();
				this.email = uac.getEmail();
				this.phone = uac.getPhone();
				this.deposit = uac.getDeposit();
				break;
			}
			
		}
	}

	public void actionPerformed(ActionEvent vi) 
	{
		try
		{
			if(vi.getSource()==subbutton)
			{
				for(account uac: uplist)
				{
					if(this.upaccnum==uac.getAccnum())
					{
						uac.setName(nametext.getText());
						uac.setAddress(addresstext.getText());
						uac.setEmail(emailtext.getText());
						String phn = phonetext.getText();
				        phone = Long.parseLong(phn);
						uac.setPhone(phone);
						break;
					}
				}
				JOptionPane.showMessageDialog(upframe, "..Successfully Updated the Account details: ","Update Page",JOptionPane.INFORMATION_MESSAGE);
			}
			if(vi.getSource()==backbutton)
			{
				Homepage hobj = new Homepage();
				hobj.addhomelist(uplist);
				hobj.addaccnum(upaccnum);
				upframe.dispose();
				hobj.Home();
			}
		}
		catch(Exception v)
		{
			JOptionPane.showMessageDialog(upframe, "Internal Error", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}