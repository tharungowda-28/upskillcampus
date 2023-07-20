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
import javax.swing.JPanel;
import javax.swing.border.Border;

public class firstpage implements ActionListener 
{
	JFrame firstpageframe = new JFrame();
	JLabel firstmainhead = new JLabel();
	JLabel firstlab = new JLabel();
	JPanel logpanel = new JPanel();
	JButton logbutton = new JButton();
	JButton createbutton = new JButton();
	Border border = BorderFactory.createLineBorder(Color.black,1);
	ArrayList<account> flist = new ArrayList<>();
	ArrayList<statement> astlist = new ArrayList<>();
	
	public void Firstpage ()
	{				
		firstmainhead.setText("----- Banking System -----");//main top heading
		firstmainhead.setFont(new Font("",Font.BOLD,20));
		firstmainhead.setBorder(border);
		firstmainhead.setVerticalAlignment(JLabel.TOP);
		firstmainhead.setHorizontalAlignment(JLabel.CENTER);
		firstmainhead.setForeground(Color.WHITE);
		firstmainhead.setBackground(new Color(0xdb6551));
		firstmainhead.setOpaque(true);
		firstmainhead.setBounds(0, 0, 500, 30);
		
		firstlab.setText("Select The Options Below");// sub heading
		firstlab.setFont(new Font("",Font.BOLD,16));
		firstlab.setHorizontalAlignment(JLabel.CENTER);
		firstlab.setAlignmentY(50);
		firstlab.setBounds(0, 30, 500, 26);
		
		logpanel.setBounds(90, 170, 300, 60);//login panel
		logpanel.setBorder(border);
		
		logbutton.setBounds(105, 180, 120, 40);//log in button
		logbutton.setText("Log IN");
		logbutton.setFocusable(false);
		logbutton.addActionListener(this);
		logbutton.setBorder(border);
		
		createbutton.setBounds(255, 180, 120, 40);//log in button
		createbutton.setText("New Account");
		createbutton.setFocusable(false);
		createbutton.addActionListener(this);
		createbutton.setBorder(border);
		
		firstpageframe.setTitle("Banking Home Page");//overall frame for the first page window
		firstpageframe.setSize(500,400);
		firstpageframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		firstpageframe.setResizable(false);
		firstpageframe.getContentPane().setBackground(new Color(0xf9dcc5));
		firstpageframe.setLayout(null);
		ImageIcon icon = new ImageIcon("images.png");
		firstpageframe.setIconImage(icon.getImage());
		firstpageframe.add(firstmainhead);
		firstpageframe.add(firstlab);
		firstpageframe.add(logbutton);
		firstpageframe.add(createbutton);
		firstpageframe.add(logpanel);
		firstpageframe.setVisible(true);
		
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==createbutton)
		{
			firstpageframe.dispose();
			CreateAccount cobj = new CreateAccount();
			cobj.addcreate(flist);
			AccountStatement acobj = new AccountStatement();
			acobj.addaccstatement(astlist);
			cobj.Create();
		}
		if(e.getSource()==logbutton)
		{	
			firstpageframe.dispose();
			Loginpage lobj = new Loginpage();
			lobj.addlogin(flist);
			lobj.addloginstatement(astlist);
			AccountStatement acobj = new AccountStatement();
			acobj.addaccstatement(astlist);
			lobj.Login();
			Viewupdate vobj = new Viewupdate();
			vobj.addupdate(flist);
			
		}

	}
	
	public void addfirst(ArrayList<account> list) 
	{
		this.flist=list;
	}
	
	public void addfirststatement(ArrayList<statement> list) 
	{
		this.astlist=list;
	}
	
}
