/*
	Author : M.Sukresh
	Description : class used for maintaining Amazon store and providing access levels to user.
	Imported Classes : 
	Company : Dumb Minds
	website : https://dumbmindsblog.blogspot.com/
	Youtube : https://youtube.com/c/Dumbminds/
	Date : 14-09-2019 4:30
	Country : India
	copyrights: None
*/
public class Amazon{

	/*attributes for refering last latop and first laptop*/
	public Laptop first = null;
	public Laptop last = null;

	/* method for adding new laptop to Amazon shop */
	public Result add(String modelName, String serialNo, double price){
		Result r = new Result();
		if(first == null && last == null){
			Laptop p = new Laptop(modelName,serialNo,price);
			first = p;
			last = p;
		}else{
			Laptop q = new Laptop(modelName,serialNo,price);
			last.next = q;
			last = q;
		}
		r.result = true;
		r.reason = "Successfully added first Laptop to Amazon";
		return r;
	}

	/* method for removing Laptop from Amazon store */
	public Result remove(String serialNo){
		Result r = new Result();
		if(first.getLaptop().serialNo.equals(serialNo)){
			first = first.next;
			r.result = true;
			r.reason = "Successfully removed Laptop to Amazon";
			return r;
		}
		Laptop p = first;
		while(p!=null){
			if(p.next.getLaptop().serialNo.equals(serialNo)){
				p.next = p.next.next;
				r.result = true;
				r.reason = "Successfully removed Laptop to Amazon";
				return r;
			}
			p = p.next;
		}
		r.result = false;
		r.reason = "Laptop is not in Amazon";
		return r;
	}

	/* method for updating Laptop info */
	public Result update(String modelName, String serialNo, double price){
		Result r = new Result();
		Laptop p = first;
		while(p!=null){
			if(p.getLaptop().serialNo.equals(serialNo)){
				r.result = p.update(modelName,price);
				r.reason = "Successfully updated the Laptop";
				return r;
			}
			p = p.next;
		}
		r.result = false;
		r.reason = "No laptop found with details Laptop";
		return r;
	}
	
	/* method for displayiing all the Laptops in the shop in the linear order */
	public void display(){
		Laptop p = first;
		while(p!=null){
			System.out.println(p);
			p = p.next;
		}
	}

	/* method for sorting all Laptops based on their prices */
	public Result sort(){
		Result r = new Result();
		Laptop p = first;
		while(p!=null){
			Laptop q = first.next;
			while(q!=null){
				if(p.getLaptop().price > q.getLaptop().price){
					double temp = p.getLaptop().price;
					p.update(p.getLaptop().modelName,q.getLaptop().price);
					q.update(q.getLaptop().modelName,temp);
				}
				q = q.next;
			}
			p = p.next;
		}
		r.result = true;
		r.reason = "Successfully sorted Laptops in Amazon";
		return r;
	}
}
