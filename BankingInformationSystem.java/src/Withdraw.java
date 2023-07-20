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

public class Withdraw implements ActionListener
{
	ArrayList<account> wlist = new ArrayList<>();
	long waccnum;
	double deposit;
	JFrame wframe = new JFrame();
	JLabel mainlabel,balabel,wlabel;
	JTextField wtext = new JTextField();
	JButton wbutton = new JButton();
	JButton backbutton = new JButton();
	Border border = BorderFactory.createLineBorder(Color.BLACK,1);
	
	
	public void withdraw()
	{
		for(account wac: wlist)
		{
			if(waccnum==wac.getAccnum())
			{
				this.deposit = wac.getDeposit();
			}
		}
		
		mainlabel = new JLabel();
		mainlabel.setText("----- Amount Withdrawal -----");//main top heading
		mainlabel.setFont(new Font("",Font.BOLD,20));
		mainlabel.setBorder(border);
		mainlabel.setForeground(Color.WHITE);
		mainlabel.setBackground(new Color(0xdb6551));
		mainlabel.setOpaque(true);
		mainlabel.setVerticalAlignment(JLabel.TOP);
		mainlabel.setHorizontalAlignment(JLabel.CENTER);
		mainlabel.setBounds(0, 0, 500, 30);
		
		balabel = new JLabel();// sub heading
		balabel.setText("Available Balance :   Rs. "+deposit);
		balabel.setFont(new Font("",Font.BOLD,16));
		balabel.setHorizontalAlignment(JLabel.CENTER);
		balabel.setAlignmentY(50);
		balabel.setBounds(0, 50, 500, 26);
		
		wlabel = new JLabel();
		wlabel.setText(" Enter the Amount for Withdrawal ");
		wlabel.setFont(new Font("",Font.BOLD,16));
		wlabel.setHorizontalAlignment(JLabel.CENTER);
		wlabel.setAlignmentY(100);
		wlabel.setBounds(0, 100, 500, 26);
		
		wtext = new JTextField();
		wtext.setPreferredSize(new Dimension(50,30));
		wtext.setBounds(175, 160, 150, 30);
		
		wbutton.setBounds(325, 220, 100, 35);//Deposit button
		wbutton.setText(" Withdraw ");
		wbutton.setFocusable(false);
		wbutton.addActionListener(this);
		wbutton.setBorder(border);
		
		backbutton.setBounds(75, 220, 100, 35);//back button
		backbutton.setText(" BACK ");
		backbutton.setFocusable(false);
		backbutton.addActionListener(this);
		backbutton.setBorder(border);
		
		wframe.setTitle("Amount Withdrawal");//overall frame for withdraw
		wframe.setSize(500,400);
		ImageIcon icon = new ImageIcon("images.png");
		wframe.setIconImage(icon.getImage());
		wframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		wframe.setResizable(false);
		wframe.setLayout(null);
		wframe.getContentPane().setBackground(new Color(0xf9dcc5));
		wframe.add(mainlabel);
		wframe.add(balabel);
		wframe.add(wlabel);
		wframe.add(wtext);
		wframe.add(wbutton);
		wframe.add(backbutton);
		wframe.setVisible(true);
		
	}
	
	public void addwithdraw(ArrayList<account> list,long accnum)
	{
		this.wlist = list;
		this.waccnum = accnum;
	}

	public void actionPerformed(ActionEvent we) 
	{
		try
		{
			if(we.getSource()==wbutton)
			{
				for(account wac: wlist)
				{
					if(waccnum==wac.getAccnum())
					{
						String phn = wtext.getText();
				        double wp = Double.parseDouble(phn);
				        if(wac.getDeposit()>=wp)
				        {
				        	wac.setDeposit(deposit-wp);
				        	JOptionPane.showMessageDialog(wframe, "Your Available Balance: Rs."+wac.getDeposit(), "Successful Deposition", JOptionPane.INFORMATION_MESSAGE);
				        	Homepage hobj = new Homepage();
							hobj.addhomelist(wlist);
							hobj.addaccnum(waccnum);
							wframe.dispose();
							hobj.Home();
				        }
				        else
				        {
				        	JOptionPane.showMessageDialog(wframe, "There is insufficient balance to withdraw","WARNING",JOptionPane.WARNING_MESSAGE);
				        }
						break;
					}
				}
		        
			}
			
			if(we.getSource()==backbutton)
			{
				Homepage hobj = new Homepage();
				hobj.addhomelist(wlist);
				hobj.addaccnum(waccnum);
				wframe.dispose();
				hobj.Home();
			}
			
		}
		catch(NumberFormatException ex)
		{
			JOptionPane.showMessageDialog(wframe, "Invalid Amount Entered", "Error", JOptionPane.ERROR_MESSAGE);
		}
				
	}
}
