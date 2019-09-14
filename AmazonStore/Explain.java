/*
	Author : M.Sukresh
	Description : class used for storing temporary data for securing data in Amazon by not directly giving access
	Company : Dumb Minds
	website : https://dumbmindsblog.blogspot.com/
	Youtube : https://youtube.com/c/Dumbminds/
	Date : 14-09-2019 4:30
	Country : India
	copyrights: None
*/
public class Explain{
	/* all public attributes for storing Laptop data temporarly */
	public String modelName;
	public String serialNo;
	public double price;

	/* constructor for assigning values to class */
	public Explain(String modelName, String serialNo, double price){
		this.modelName = modelName;
		this.serialNo = serialNo;
		this.price = price;
	}
}
