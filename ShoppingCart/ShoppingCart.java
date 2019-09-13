public class ShoppingCart{
	public CartItem first = null;
	public CartItem last = null;
	public int i = 0;
	public boolean add(String productId, String name, double price, int quantity){
		try{
			if(first == null && last == null){
				CartItem p = new CartItem(productId,name,price,quantity);
				this.first = p;
				this.last = p;
				return true;
			}
			else{
				CartItem q = first;
				while(q!=null){
					if(q.getProductId().equals(productId)){
						this.i = 1;
						return false;
					}
					q = q.next;
				}
				CartItem p = new CartItem(productId,name,price,quantity);
				this.last.next = p;
				this.last = p;
				return true;
			}
		}catch(Exception e){
			return false;
		}
	}
	public boolean add(String productId, String name, double price){
		try{
			if(first == null && last == null){
				CartItem p = new CartItem(productId,name,price);
				this.first = p;
				this.last = p;
				return true;
			}
			else{
				CartItem q = first;
				while(q!=null){
					if(q.getProductId().equals(productId)){
						return false;
					}
					q = q.next;
				}
				CartItem p = new CartItem(productId,name,price);
				this.last.next = p;
				this.last = p;
				return true;
			}
		}catch(Exception e){
			return false;
		}
	}
	public boolean update(String productId, int quantity){
		try{
			CartItem p = first;
			while(!p.getProductId().equals(productId)){
				p = p.next;
			}
			p.setQuantity(quantity);
			return true;
		}catch (Exception e){
			return false;
		}
	}
	public void display(){
		try{
			CartItem p = first;
			while(p!=null){
				System.out.println(Pattern.interrupt(("Product ID :"+p.getProductId()+" Product Name : "+p.getProductName()+" Product Price : "+p.getProductPrice()+" Product Quantity : "+p.getProductQuantity())));
				p = p.next;
			}
		}catch (Exception e){
			return ;
		}
	}
	public boolean remove(String productId){
		try{
			CartItem p = first;
			if(p.getProductId().equals(productId)){
				first = first.next;
				return true;
			}
			while(!p.next.getProductId().equals(productId)){
				p = p.next;
			}
			p.next = p.next.next;
			return true;
		}catch (Exception e){
			return false;
		}
	}
}
