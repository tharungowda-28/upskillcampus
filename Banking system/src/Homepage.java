import java.awt.Color;
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
import javax.swing.border.Border;

public class Homepage implements ActionListener
{
	JFrame homeframe = new JFrame();
	JLabel homelabel = new JLabel();
	JPanel homepanel = new JPanel();
	JButton vbutton,depositbutton,withbutton,fundbutton,accbutton,backbutton;
	firstpage fobj = new firstpage();
	CreateAccount cobj = new CreateAccount();
	Border border = BorderFactory.createLineBorder(Color.BLACK,1);
	ArrayList <account> hlist = new ArrayList<>();
	ArrayList <statement> stlist = new ArrayList<>();
	String hname;
	long haccnum;
	
	public void Home()
	{	
		homelabel.setText("----- WELCOME "+hname.toUpperCase()+" -----");//main top heading
		homelabel.setFont(new Font("",Font.BOLD,20));
		homelabel.setBorder(border);
		homelabel.setForeground(Color.WHITE);
		homelabel.setBackground(new Color(0xdb6551));
		homelabel.setOpaque(true);
		homelabel.setVerticalAlignment(JLabel.TOP);
		homelabel.setHorizontalAlignment(JLabel.CENTER);
		homelabel.setBounds(0, 0, 400, 30);
		
		homepanel.setBounds(15, 50, 360, 230);//HOME panel
		homepanel.setBorder(border);
		
		vbutton = new JButton();
		vbutton.setBounds(40, 70, 100, 40);//view and update button
		vbutton.setText(" View & Update ");
		vbutton.setFocusable(false);
		vbutton.addActionListener(this);
		vbutton.setBorder(border);
		
		depositbutton = new JButton();
		depositbutton.setBounds(250, 70, 100, 40);//Deposit button
		depositbutton.setText(" Deposit ");
		depositbutton.setFocusable(false);
		depositbutton.addActionListener(this);
		depositbutton.setBorder(border);
		
		withbutton = new JButton();
		withbutton.setBounds(40, 130, 100, 40);//Withdraw button
		withbutton.setText(" Withdraw ");
		withbutton.setFocusable(false);
		withbutton.addActionListener(this);
		withbutton.setBorder(border);
		
		fundbutton = new JButton();
		fundbutton.setBounds(250, 130, 100, 40);//Fund Transfer button
		fundbutton.setText(" Fund Transfer ");
		fundbutton.setFocusable(false);
		fundbutton.addActionListener(this);
		fundbutton.setBorder(border);
		
		accbutton = new JButton();
		accbutton.setBounds(40, 190, 150, 40);//Account Statement button
		accbutton.setText(" Account Statement ");
		accbutton.setFocusable(false);
		accbutton.addActionListener(this);
		accbutton.setBorder(border);
		
		backbutton = new JButton();
		backbutton.setBounds(270, 300, 80, 30);//back button
		backbutton.setText("Back");
		backbutton.setFocusable(false);
		backbutton.addActionListener(this);
		backbutton.setBorder(border);
		
		homeframe.setTitle("Welcome Homepage");//overall frame for homepage
		homeframe.setSize(400,400);
		ImageIcon icon = new ImageIcon("images.png");
		homeframe.setIconImage(icon.getImage());
		homeframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		homeframe.setResizable(false);
		homeframe.setLayout(null);
		homeframe.getContentPane().setBackground(new Color(0xf9dcc5));
		homeframe.add(homelabel);
		homeframe.add(vbutton);
		homeframe.add(depositbutton);
		homeframe.add(withbutton);
		homeframe.add(fundbutton);
		homeframe.add(accbutton);
		homeframe.add(backbutton);
		homeframe.add(homepanel);
		homeframe.setVisible(true);
	}
	
	public void addhomelist(ArrayList<account> list) 
	{
		this.hlist = list;
	}
	
	public void addstatementlist(ArrayList<statement> list) 
	{
		this.stlist = list;
	}
	
	public void addaccnum(long haccnum) 
	{
		this.haccnum = haccnum;
		for(account hac: hlist)
		{
			if(this.haccnum==hac.getAccnum())
			{
				this.hname=hac.getName();
				break;
			}
				
		}
	}
	
	public void actionPerformed(ActionEvent ev)
	{
		try
		{
			if(ev.getSource()==vbutton)
			{
				Viewupdate vobj = new Viewupdate();
				vobj.addupdate(hlist);
				vobj.addupdate(haccnum);
				homeframe.dispose();
				vobj.update();
			}
			if(ev.getSource()==depositbutton)
			{
				Deposit dobj = new Deposit();
				dobj.adddeposit(hlist,haccnum);
				homeframe.dispose();
				dobj.deposit();
			}
			if(ev.getSource()==withbutton)
			{
				Withdraw wobj = new Withdraw();
				wobj.addwithdraw(hlist,haccnum);
				homeframe.dispose();
				wobj.withdraw();
			}
			if(ev.getSource()==fundbutton)
			{
				fundtransfer ftobj = new fundtransfer();
				ftobj.addtransfer(hlist,haccnum);
				ftobj.addtransferstatement(stlist);
				homeframe.dispose();
				ftobj.transfer();
			}
			if(ev.getSource()==accbutton)
			{
				AccountStatement asobj = new AccountStatement();
				asobj.addstatement(hlist,haccnum);
				asobj.addaccstatement(stlist);
				homeframe.dispose();
				asobj.astatement();
			}
		    if(ev.getSource()==backbutton)
		    {
				fobj.addfirst(hlist);
				cobj.addcreate(hlist);
				fobj.addfirststatement(stlist);
				homeframe.dispose();
				fobj.Firstpage();
		    }
		}
		catch(Exception hx)
		{
			JOptionPane.showMessageDialog(null, "Internal Error", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
}

class statement
{
	private String datetime;
	private long from,to;
	private double balance,amount;
	
	public statement(String datetime, long from, long to, double balance,double amount)
	{
		this.datetime = datetime;
		this.from = from;
		this.to = to;
		this.amount = amount;
		this.balance = balance;
	}
	
	public String toString() 
	{
		return "Date & Time: " + datetime + ", Sender Account = " + from + ", Reciever Account = " + to + ", Remaining Balance =" + balance + ", Transfer Amount =" + amount;
	}

	public double getAmount() 
	{
		return amount;
	}

	public void setAmount(double amount) 
	{
		this.amount = amount;
	}

	public String getDatetime() 
	{
		return datetime;
	}

	public void setDatetime(String datetime) 
	{
		this.datetime = datetime;
	}

	public long getFrom() 
	{
		return from;
	}

	public void setFrom(long from) 
	{
		this.from = from;
	}

	public long getTo() 
	{
		return to;
	}

	public void setTo(long to) 
	{
		this.to = to;
	}

	public double getBalance() 
	{
		return balance;
	}

	public void setBalance(double balance) 
	{
		this.balance = balance;
	}
}
