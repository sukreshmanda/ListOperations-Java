public class Mobile{

	//all private attributes
	private String companyName;
	private String modelName;
	private double price;

	//public link 
	public Mobile link;

	//constructor for Mobile
	public Mobile(String companyName, String modelName, double price){
		this.companyName = companyName;
		this.modelName = modelName;
		this.price = price;
		this.link = null;
	}
	//getters and setters
	public Explain getMobile(){
		Explain ex = new Explain();
		ex.result = true;
		ex.reason = "Sucessfully get the company";
		ex.companyName = this.companyName;
		ex.modelName = this.modelName;
		ex.price = this.price;
		return ex;
	}
	public String toString(){
		return "Company : "+this.companyName+"\t Model : "+this.modelName+"\t Price : "+this.price;
	}
	public Explain setPrice(double price){
		Explain ex = new Explain();
		if(price>0){
			this.price = price;
			ex.result = true;
			ex.reason = "Successfully modified the price";
		}
		else{
			ex.result = false;
			ex.reason = "Price can't be negative or zero";
		}
		return ex;
	}
}
