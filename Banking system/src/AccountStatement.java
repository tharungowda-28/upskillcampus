import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class AccountStatement implements ActionListener
{
	ArrayList<statement> aslist = new ArrayList<>();
	ArrayList<account> lt = new ArrayList<>();
	JFrame asframe = new JFrame();
	DefaultStyledDocument document = new DefaultStyledDocument();
	JTextArea history = new JTextArea();
	JScrollPane sp;
	JLabel malabel,acclabel;
	JButton backbutton;
	JPanel statem = new JPanel();
	Border border = BorderFactory.createLineBorder(Color.BLACK,1);
	long asaccnum;
	String asname;
	double asdeposit;
	
	public void astatement()
	{
		for(account as: lt)
		{
			if(asaccnum==as.getAccnum())
			{
				this.asname = as.getName();
				this.asdeposit = as.getDeposit();
				break;
			}
		}
		
		malabel = new JLabel();
		malabel.setText("----- "+asname+"'s Transaction History -----");//main top heading
		malabel.setFont(new Font("",Font.BOLD,20));
		malabel.setBorder(border);
		malabel.setForeground(Color.WHITE);
		malabel.setBackground(new Color(0xdb6551));
		malabel.setOpaque(true);
		malabel.setVerticalAlignment(JLabel.TOP);
		malabel.setHorizontalAlignment(JLabel.CENTER);
		malabel.setBounds(0, 0, 1000, 30);
		
		acclabel = new JLabel();
		acclabel.setText("Account Balance: Rs."+asdeposit);// sub heading
		acclabel.setFont(new Font("",Font.BOLD,16));
		acclabel.setHorizontalAlignment(JLabel.CENTER);
		acclabel.setAlignmentY(50);
		acclabel.setBounds(0, 30, 1000, 26);
		
		history.setEditable(false);
		history.setFont(new Font("Arial", Font.BOLD, 16));
		history.setForeground(Color.BLACK);

		for(statement asc: aslist)
		{
			if(asaccnum==asc.getFrom() || asaccnum==asc.getTo())
			{
				history.append("Date & Time: " + asc.getDatetime() + " , Sender Account: " + asc.getFrom() + " , Reciever Account: " + asc.getTo() + " , Transfered Amount: " + asc.getAmount()+"\n\n");
			}
		}
		
		sp = new JScrollPane(history);
		sp.setBounds(50,100,900,600);
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		backbutton = new JButton();
		backbutton.setBounds(450, 710, 100, 35);//back button
		backbutton.setText(" BACK ");
		backbutton.setFocusable(false);
		backbutton.addActionListener(this);
		backbutton.setBorder(border);
		
		asframe.setTitle("Account statement");//overall frame for account statement
		asframe.setSize(1000,800);
		asframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		asframe.setResizable(false);
		asframe.getContentPane().setBackground(new Color(0xf9dcc5));
		asframe.setLayout(null);
		ImageIcon icon = new ImageIcon("images.png");
		asframe.setIconImage(icon.getImage());
		asframe.add(malabel);
		asframe.add(acclabel);
		asframe.add(backbutton);
		asframe.add(sp);
		asframe.setVisible(true);
		
	}
	
	public void addstatement(ArrayList<account> list,long accnum)
	{
		this.lt = list;
		this.asaccnum = accnum;
	}
	
	public void addaccstatement(ArrayList<statement> slist)
	{
		this.aslist = slist;
	}

	public void actionPerformed(ActionEvent ae) 
	{
		if(ae.getSource()==backbutton)
		{
			Homepage hobj = new Homepage();
			hobj.addhomelist(lt);
			hobj.addaccnum(asaccnum);
			hobj.addstatementlist(aslist);
			asframe.dispose();
			hobj.Home();
		}
		
	}
}