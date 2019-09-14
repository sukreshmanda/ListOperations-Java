/*
	Author : M.Sukresh
	Description : class used for Laptop where all data about Laptop and all possible operations are stored
	Company : Dumb Minds
	website : https://dumbmindsblog.blogspot.com/
	Youtube : https://youtube.com/c/Dumbminds/
	Date : 14-09-2019 4:30
	Country : India
	copyrights: None
*/

public class Laptop{

	/* all private attributes like modelname, serialno, price and public attribute next for linking*/
	private String modelName;
	private String serialNo;
	private double price;
	public Laptop next;

	/* constructor used to assign values to latop */
	public Laptop(String modelName, String serialNo, double price){
		this.modelName = modelName;
		this.serialNo = serialNo;
		this.price = price;
	}

	/* metohod used for getting laptop details indirectly by Explain class */
	public Explain getLaptop(){
		Explain ex = new Explain(this.modelName,this.serialNo,this.price);
		return ex;
	}
	
	/* method used for updating Laptop details and returning result as boolean */
	public boolean update(String modelName,double price){
		this.modelName = modelName;
		this.price = price;
		return true;
	}
	
	/* public toString method for printing objects data without any external methods */
	public String toString(){
		return " Model Name : "+this.modelName+" Serial No : "+serialNo+" Price : "+this.price;
	}
}
