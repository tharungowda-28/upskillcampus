import java.util.ArrayList;
class Main
{	
	public static void main(String args[])
	{
		ArrayList <account> clist = new ArrayList<>();
		clist.add(new account("User-1","Bangalore","abc22@gmail.com",1234567891L,50000,"user1"));
		clist.add(new account("User-2","Bangladesh","xyz01@gmail.com",9999999998L,50000,"user2"));
		clist.add(new account("User-3","Himalaya","pqr28@gmail.com",9999999995L,50000,"user3"));
		clist.add(new account("User-4","Bidar","lmno25@gmail.com",7894561230L,50000,"user4"));
		firstpage fobj = new firstpage();//Display window of first page
		fobj.addfirst(clist);
		fobj.Firstpage();
	}
}

class account
{
	private String name,address,email,password;	
	private long phone,accnum;
	private static int naccnum = 1001;
	private double deposit;
	
	public account(String name,String address,String email,long phone,double deposit,String password)
	{
		this.name = name;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.deposit = deposit;
		this.password = password;
		this.accnum = naccnum++;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getAddress() 
	{
		return address;
	}

	public void setAddress(String address) 
	{
		this.address = address;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public long getPhone() 
	{
		return phone;
	}

	public void setPhone(long phone) 
	{
		this.phone = phone;
	}

	public long getAccnum() 
	{
		return accnum;
	}

	public void setAccnum(long accnum) 
	{
		this.accnum = accnum;
	}

	public static int getNaccnum() 
	{
		return naccnum;
	}

	public static void setNaccnum(int naccnum) 
	{
		account.naccnum = naccnum;
	}

	public double getDeposit() 
	{
		return deposit;
	}

	public void setDeposit(double deposit) 
	{
		this.deposit = deposit;
	}
	
	public String toString() 
	{
		return "[name=" + name + ", address=" + address + ", email=" + email + ", password=" + password
				+ ", phone=" + phone + ", accnum=" + accnum + ", deposit=" + deposit + "]";
	}

}