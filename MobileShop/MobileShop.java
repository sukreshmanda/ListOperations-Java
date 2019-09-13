public class MobileShop{
	//first and last mobile reference holders
	public Mobile first = null;
	public Mobile last = null;
	
	public Explain insert(String companyName, String modelName, double price){
		Explain ex = new Explain();
		if(first==null && last==null){
			Mobile n = new Mobile(companyName,modelName,price);
			first = n;
			last = n;
			ex.result = true;
			ex.reason = "First Mobile added to the shop";
			return ex;
		}
		else{
			Mobile p = first;
			while(p!=null){
				if(p.getMobile().modelName.equals(modelName) && p.getMobile().companyName.equals(companyName)){
					ex.result = false;
					ex.reason = "Mobile already in the shop";
					return ex;
				}
				p = p.link;
			}
			Mobile k = new Mobile(companyName,modelName,price);
			last.link = k;
			last = k;
			ex.result = true;
			ex.reason = "Mobile successfully added to shop";
			return ex;
		}
	}
	public Explain update(String companyName, String modelName, double price){
		Mobile p = first;
		while(p!=null){
			if(p.getMobile().modelName.equals(modelName) && p.getMobile().companyName.equals(companyName)){
				return p.setPrice(price);
			}
			p = p.link;
		}
		Explain ex = new Explain();
		ex.result = false;
		ex.reason = "Mobile is not in the shop";
		return ex;
	}
	public void display(){
		Mobile p = first;
		while(p!=null){
			System.out.println(p);
			p = p.link;
		}
	}
	public Explain remove(String companyName, String modelName){
		Explain ex = new Explain();
		if(first.getMobile().companyName.equals(companyName) && first.getMobile().modelName.equals(modelName)){
			first = first.link;
			ex.result = true;
			ex.reason = "First Mobile removed from shop";
			return ex;
		}
		Mobile p = first;
		while(p.link!=null){
			if(p.link.getMobile().companyName.equals(companyName) && p.link.getMobile().modelName.equals(modelName)){
				p.link = p.link.link;
				ex.result = true;
				ex.reason = "Mobile removed from the shop";
				return ex;
			}
			p = p.link;
		}
		ex.result = false;
		ex.reason = "Mobile is not in the shop";
		return ex;
	}
}
