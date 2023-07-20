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
import java.text.SimpleDateFormat;
import java.util.Date;

public class fundtransfer implements ActionListener
{
	ArrayList <account> ftlist = new ArrayList<>();
	ArrayList<statement> slist = new ArrayList<>();
	SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	Date date = new Date();
	JLabel mainlabel,tolabel,amountlabel;
	JTextField totext,amounttext;
	JButton backbutton = new JButton();
	JButton ftbutton = new JButton();
	Border border = BorderFactory.createLineBorder(Color.BLACK,1);
	JFrame ftframe = new JFrame();
	long ftaccnum,am;
	double deposit;
	
	public void transfer()
	{
		for(account dc: ftlist)
		{
			if(ftaccnum==dc.getAccnum())
			{
				this.deposit = dc.getDeposit();
			}
		}
		
		mainlabel = new JLabel();
		mainlabel.setText("----- Fund Transfer -----");//main top heading
		mainlabel.setFont(new Font("",Font.BOLD,20));
		mainlabel.setBorder(border);
		mainlabel.setForeground(Color.WHITE);
		mainlabel.setBackground(new Color(0xdb6551));
		mainlabel.setOpaque(true);
		mainlabel.setVerticalAlignment(JLabel.TOP);
		mainlabel.setHorizontalAlignment(JLabel.CENTER);
		mainlabel.setBounds(0, 0, 600, 30);
		
		tolabel = new JLabel();
		totext = new JTextField();
		tolabel.setText("Recepients Account Number: ");
		tolabel.setFont(new Font("",Font.BOLD,16));
		tolabel.setBounds(10,75,260,30);
		totext.setPreferredSize(new Dimension(50,30));
		totext.setBounds(270, 75, 310, 30);
		
		amountlabel = new JLabel();
		amounttext = new JTextField();
		amountlabel.setText("Enter Amount: ");
		amountlabel.setFont(new Font("",Font.BOLD,16));
		amountlabel.setBounds(10,125,260,30);
		amounttext.setPreferredSize(new Dimension(50,30));
		amounttext.setBounds(270, 125, 310, 30);
		
		ftbutton.setBounds(400, 220, 100, 35);//Deposit button
		ftbutton.setText(" Transfer ");
		ftbutton.setFocusable(false);
		ftbutton.addActionListener(this);
		ftbutton.setBorder(border);
		
		backbutton.setBounds(100, 220, 100, 35);//back button
		backbutton.setText(" BACK ");
		backbutton.setFocusable(false);
		backbutton.addActionListener(this);
		backbutton.setBorder(border);
		
		ftframe.setTitle("Fund Transfer");//overall frame for the fund transfer window
		ftframe.setSize(600,400);
		ftframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ftframe.setResizable(false);
		ftframe.getContentPane().setBackground(new Color(0xf9dcc5));
		ftframe.setLayout(null);
		ImageIcon icon = new ImageIcon("images.png");
		ftframe.setIconImage(icon.getImage());
		ftframe.add(mainlabel);
		ftframe.add(tolabel);
		ftframe.add(totext);
		ftframe.add(amountlabel);
		ftframe.add(amounttext);
		ftframe.add(backbutton);
		ftframe.add(ftbutton);
		ftframe.setVisible(true);
	}
	
	public void addtransfer(ArrayList<account> list,long accnum)
	{
		this.ftlist = list;
		this.ftaccnum = accnum;
	}
	
	public void addtransferstatement(ArrayList <statement> stlist)
	{
		this.slist = stlist;
	}
	
	public void actionPerformed(ActionEvent ft) 
	{
		try
		{
			if(ft.getSource()==ftbutton)
			{
				boolean sfound = false;
				boolean rfound = false;
				boolean state = false;
		        String enternum = totext.getText();
		        long enteraccnum = Long.parseLong(enternum);
		        String phn = amounttext.getText();
		        double ftransfer = Double.parseDouble(phn);
		        for(account rac: ftlist)//1st for loop
		        {
		        	if(rac.getAccnum()==enteraccnum && deposit>=ftransfer && ftaccnum!=enteraccnum)//rac.getAccnum = reciever
		        	{
		        		sfound = true;
		        		rac.setDeposit(rac.getDeposit()+ftransfer);
		        		break;
		        	}
		        }
		        for(account sac: ftlist)//2nd for loop
		        {
		        	if(sac.getAccnum()==ftaccnum && sfound==true)//ftaccnum = sender
		        	{
		        		rfound = true;
		        		sac.setDeposit(deposit-ftransfer);
			        	JOptionPane.showMessageDialog(ftframe, "Your Available Balance: Rs."+sac.getDeposit(), " BALANCE ", JOptionPane.INFORMATION_MESSAGE);
			        	break;
		        	}
		        }
		        if(rfound==true)
		        {
		        	slist.add(new statement(dt.format(date),ftaccnum,enteraccnum,deposit-ftransfer,ftransfer));
		        	Homepage hobj = new Homepage();
					hobj.addhomelist(ftlist);
					hobj.addaccnum(ftaccnum);
					hobj.addstatementlist(slist);
					AccountStatement asobj = new AccountStatement();
					asobj.addaccstatement(slist);
					ftframe.dispose();
					hobj.Home();
		        }
		        if(ftaccnum==enteraccnum)
		        {
		        	JOptionPane.showMessageDialog(ftframe, "Transaction cannot be done to your own account","WARNING",JOptionPane.WARNING_MESSAGE);
		        	state = true;
		        }
		        if(sfound==false && state == false)
		        {
		        	JOptionPane.showMessageDialog(ftframe, "Account Not Found....!\nEnter Account Number Correctly","WARNING",JOptionPane.WARNING_MESSAGE);
		        }
		        if(deposit<ftransfer)
		        {
		        	JOptionPane.showMessageDialog(ftframe, "There is insufficient balance to transfer","WARNING",JOptionPane.WARNING_MESSAGE);
		        }
			}
			if(ft.getSource()==backbutton)
			{
				Homepage hobj = new Homepage();
				hobj.addhomelist(ftlist);
				hobj.addaccnum(ftaccnum);
				hobj.addstatementlist(slist);
				AccountStatement asobj = new AccountStatement();
				asobj.addaccstatement(slist);
				ftframe.dispose();
				hobj.Home();
			}
		}
		catch(NumberFormatException f)
		{
			JOptionPane.showMessageDialog(ftframe, "Alphabets are not allowed in the field\nEnter numeric value", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}
