public class CartItem{
	private String productId;
	private String name;
	private double price;
	private int quantity;
	public CartItem next;
	public CartItem(String productId, String name, double price, int quantity){
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.next = null;
	}
	public CartItem(String productId, String name, double price){
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.quantity = 0;
		this.next = null;
	}
	public String toString(){
		return "Product ID : "+productId+" Product Name : "+name+" Product Price : "+price+" Product Quantity : "+quantity;
	}
	public void setQuantity(int quantity){
		this.quantity = quantity;
	}
	public String getProductName(){
		return this.name;
	}
	public String getProductId(){
		return this.productId;
	}
	public int getProductQuantity(){
		return this.quantity;
	}
	public CartItem nextItem(){
		return this.next;
	}
	public double getProductPrice(){
		return this.price;
	}
}
