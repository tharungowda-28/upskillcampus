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

public class Deposit implements ActionListener
{
	ArrayList<account> dlist = new ArrayList<>();
	long daccnum;
	double deposit;
	JFrame dframe = new JFrame();
	JLabel mainlabel,balabel,dlabel;
	JTextField dtext = new JTextField();
	JButton dbutton = new JButton();
	JButton hbbutton = new JButton();
	Border border = BorderFactory.createLineBorder(Color.BLACK,1);
	
	public void deposit()
	{
		for(account dac: dlist)
		{
			if(daccnum==dac.getAccnum())
			{
				this.deposit = dac.getDeposit();
			}
		}
		
		mainlabel = new JLabel();
		mainlabel.setText("----- Amount Deposition -----");//main top heading
		mainlabel.setFont(new Font("",Font.BOLD,20));
		mainlabel.setBorder(border);
		mainlabel.setForeground(Color.WHITE);
		mainlabel.setBackground(new Color(0xdb6551));
		mainlabel.setOpaque(true);
		mainlabel.setVerticalAlignment(JLabel.TOP);
		mainlabel.setHorizontalAlignment(JLabel.CENTER);
		mainlabel.setBounds(0, 0, 500, 30);
		
		balabel = new JLabel();
		balabel.setText("Available Balance :   Rs. "+deposit);//sub heading
		balabel.setFont(new Font("",Font.BOLD,16));
		balabel.setHorizontalAlignment(JLabel.CENTER);
		balabel.setAlignmentY(50);
		balabel.setBounds(0, 50, 500, 26);
		
		dlabel = new JLabel();
		dlabel.setText(" Enter the Amount for Deposition ");
		dlabel.setFont(new Font("",Font.BOLD,16));
		dlabel.setHorizontalAlignment(JLabel.CENTER);
		dlabel.setAlignmentY(100);
		dlabel.setBounds(0, 100, 500, 26);
		
		dtext = new JTextField();
		dtext.setPreferredSize(new Dimension(50,30));
		dtext.setBounds(175, 160, 150, 30);
		
		dbutton.setBounds(325, 220, 100, 35);//Deposit button
		dbutton.setText(" Deposit ");
		dbutton.setFocusable(false);
		dbutton.addActionListener(this);
		dbutton.setBorder(border);
		
		hbbutton.setBounds(75, 220, 100, 35);//back button
		hbbutton.setText(" BACK ");
		hbbutton.setFocusable(false);
		hbbutton.addActionListener(this);
		hbbutton.setBorder(border);
		
		dframe.setTitle("Amount Deposition");//overall frame for deposit page
		dframe.setSize(500,400);
		ImageIcon icon = new ImageIcon("images.png");
		dframe.setIconImage(icon.getImage());
		dframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dframe.setResizable(false);
		dframe.setLayout(null);
		dframe.getContentPane().setBackground(new Color(0xf9dcc5));
		dframe.add(mainlabel);
		dframe.add(balabel);
		dframe.add(dlabel);
		dframe.add(dtext);
		dframe.add(dbutton);
		dframe.add(hbbutton);
		dframe.setVisible(true);
	}
	
	public void adddeposit(ArrayList<account> list,long accnum)
	{
		this.dlist = list;
		this.daccnum = accnum;
	}

	public void actionPerformed(ActionEvent de) 
	{
		try
		{
			if(de.getSource()==dbutton)
			{
				for(account dac: dlist)
				{
					if(daccnum==dac.getAccnum())
					{
						String dhp = dtext.getText();
				        double dp = Double.parseDouble(dhp);
				        dac.setDeposit(dp+deposit);
				        JOptionPane.showMessageDialog(dframe, "Your Available Balance: Rs."+dac.getDeposit(), "Successful Deposition", JOptionPane.INFORMATION_MESSAGE);
				        Homepage hobj = new Homepage();
						hobj.addhomelist(dlist);
						hobj.addaccnum(daccnum);
						dframe.dispose();
						hobj.Home();
						break;
					}
				}
		        
			}
			
			if(de.getSource()==hbbutton)
			{
				Homepage hobj = new Homepage();
				hobj.addhomelist(dlist);
				hobj.addaccnum(daccnum);
				dframe.dispose();
				hobj.Home();
			}
			
		}
		catch(NumberFormatException ex)
		{
			JOptionPane.showMessageDialog(dframe, "Invalid Amount Entered", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
}
