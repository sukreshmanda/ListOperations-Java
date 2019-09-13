import java.util.*;
import java.io.*;
public class ShoppingCartMenu{
	public static void clearScreen() {  
		System.out.print("\033[H\033[2J");  
		System.out.flush();  
	}  
	public static void main(String[] args)throws IOException{
		Scanner s = new Scanner(System.in);
		Pattern p = new Pattern();
		ShoppingCart cart = new ShoppingCart();
		clearScreen();
		for(int i=0;i<p.banner.length;i++){
			System.out.println(p.banner[i]);
		}
		System.out.println(p.print("\n\nShopping Cart 1.0 >> \ntype 'help' 'add' 'remove' 'update' 'display' 'banner' 'exit' '?'","white"));
		while(true){
			System.out.println();
			System.out.print(p.interrupt("$ "));
			BufferedReader lp = new BufferedReader(new InputStreamReader(System.in));
			String n = lp.readLine();
			n = n.toUpperCase();
			switch(n){
				case "ADD":
					System.out.print(p.interrupt("(add)$ "));
					BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
					String temp = br.readLine();
					String[] m = new String [4];
					int i=0;
					cart.i = 0;
					StringTokenizer st = new StringTokenizer(temp);
					while(st.hasMoreTokens()){m[i++]=st.nextToken();}
					try{
						if(i == 4){
							boolean b = cart.add(m[0],m[1],Double.parseDouble(m[2]),Integer.parseInt(m[3]));
							String ss = cart.i == 1 ? "DuplicateItem Exception":""+b;
							System.out.print(p.interrupt(ss));
								}
						else if(i == 3){
							boolean bb = cart.add(m[0],m[1],Double.parseDouble(m[2]));
							String bB = cart.i == 1 ? "DuplicateItem Exception":""+bb;
							System.out.print(p.interrupt(bB));
						}
						else{
							System.out.print(p.interrupt("UnEqualNumberOfParameters Exception"));
						}
					}catch(Exception e){
						System.out.print(p.interrupt("UnsupportedFormats Exception"));
					}
					System.out.println();
					break;
	
				case "REMOVE":
					System.out.print(p.interrupt("(remove)$ "));
					String tt = s.next();
					boolean b = cart.remove(tt);
					String ll = b ? " "+true: "ItemNotFound Exception"; 
					System.out.print(p.interrupt(ll));
					System.out.println();
					break;
				case "UPDATE":
					System.out.print(p.interrupt("(update)$ "));
					BufferedReader lk = new BufferedReader(new InputStreamReader(System.in));
					String temp1 = lk.readLine();
					String[] m1 = new String [4];
					int j=0;
					StringTokenizer st1 = new StringTokenizer(temp1);
					while(st1.hasMoreTokens()){m1[j++]=st1.nextToken();}
					try{
						if(j == 2){
							System.out.print(p.interrupt(""+cart.update(m1[0],Integer.parseInt(m1[1]))));
						}
						else{
							System.out.print(p.interrupt("UnEqualNumberOfParameters Exception"));
						}
					}catch(Exception e){
						System.out.print(p.interrupt("UnsupportedFormats Exception"));
					}
					System.out.println();
					break;
				case "DISPLAY":
					cart.display();
					break;
				case "BANNER":
					for(int k=0;k<p.banner.length;k++){
						System.out.println(p.banner[k]);
					}
					break;
				case "EXIT":
					System.out.println(p.print("We'll miss you😥️😓️","cyan"));
					return;
				case "HELP":
				case "?":
					System.out.print(p.print(" Available keywords in the present version 1.0","white")+p.print("\n help\n add\n remove\n update\n display\n exit\n banner\n ***Note keywords are not case sensitive ***","cyan"));
					break;
				case "CLEAR":
					clearScreen();
					break;
				default:
					System.out.println(p.interrupt("command not found press '?' for help"));
			}
		}
	}
}
