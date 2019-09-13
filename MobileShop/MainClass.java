import java.io.*;
import java.util.*;
public class MainClass{
	public static void clearScreen(){  
    	System.out.print("\033[H\033[2J");  
    	System.out.flush();  
	}
	public static void add(StringTokenizer st,int count,MobileShop db,BufferedReader br)throws IOException{
		Explain ex;
		if(count-1==0){
			System.out.print(Pattern.print(" %@(ADD)> ","green"));
			String s = br.readLine();
			StringTokenizer tt = new StringTokenizer(s);
			if(tt.countTokens()== 3){
				try{
					String company = tt.nextToken();
					String model = tt.nextToken();
					double p = Double.parseDouble(tt.nextToken());
					ex = db.insert(company,model,p);
					System.out.print(Pattern.print(" "+ex.result)+" "+Pattern.print(ex.reason,"blue")+"\n");
				}catch(Exception e){
					System.out.println(Pattern.print("{TypeMissMatch Error} please enter valid types as ")+Pattern.print("String String Double(number)","magneta"));
				}
			}
			else if(tt.countTokens()== 1){
				String stat = tt.nextToken();
				if(stat.equals("back")){
					return ;
				}
				else if(stat.equals("help")){
					System.out.println(Pattern.print(" Available keywords are ")+Pattern.print(" back help","magneta"));
				}
				else{
					System.out.println(Pattern.print("Use framat as {String String number} or available keywords are ")+Pattern.print(" back help","magneta"));
				}
			}
			else{
				System.out.println(Pattern.print("{UnSupportedInput Error} please enter valid number of input i.e.3"));
			}
		}
		else if(count-1 == 3){
			try{
				String companyName = st.nextToken();
				String modelName = st.nextToken();
				double price = Double.parseDouble(st.nextToken());
				ex = db.insert(companyName,modelName,price);
				System.out.print(Pattern.print(" "+ex.result+" ")+Pattern.print(ex.reason,"blue")+"\n");
			}catch(Exception e){
				System.out.println(Pattern.print("{TypeMissMatch Error} please enter valid types as ")+Pattern.print("String String Double(number)","magneta"));
			}
		}
		else{
			System.out.println(Pattern.print("{UnSupportedInput Error} please enter valid number of input"));
		}
		add(st,1,db,br);
	}
	public static void remove(StringTokenizer st, int count , MobileShop db, BufferedReader br)throws IOException{
		Explain ex ;
		if(count-1==0){
			System.out.print(Pattern.print(" %@(REMOVE)> ","green"));
			String s = br.readLine();
			StringTokenizer tt = new StringTokenizer(s);
			if(tt.countTokens()==2){
				ex = db.remove(tt.nextToken(),tt.nextToken());
				System.out.print(Pattern.print(""+ex.result)+" "+Pattern.print(ex.reason,"blue")+"\n");
			}
			else if(tt.countTokens()==1){
				String temp = tt.nextToken();
				if(temp.equals("back")) return;	
				else if(temp.equals("help")){
					System.out.println(Pattern.print(" Available keywords are ")+Pattern.print(" back help","magneta"));
				}
				else{
					System.out.println(Pattern.print("Use framat as {String String number} or available keywords are ")+Pattern.print(" back help","magneta"));
				}
			}
			else{
				System.out.println(Pattern.print("{UnSupportedInput Error} please enter valid number of input i.e.3"));
			}
		}
		else if(count-1 == 2){
			String ss = st.nextToken();
			String sss = st.nextToken();
			ex = db.remove(ss,sss);
			System.out.print(Pattern.print(""+ex.result)+" "+Pattern.print(ex.reason,"blue")+"\n");
		}
		else{
			System.out.println(Pattern.print("{UnSupportedInput Error} please enter valid number of input i.e.3"));
		}
		remove(null,1,db,br);
	}
	public static void update(StringTokenizer st, int count, MobileShop db, BufferedReader br)throws IOException{
		Explain ex;
		if(count-1==0){
			System.out.print(Pattern.print(" %@(UPDATE)> ","green"));
			String s = br.readLine();
			StringTokenizer ss = new StringTokenizer(s);
			if(ss.countTokens() == 3){
				try{
					String company = st.nextToken();
					String model = st.nextToken();
					Double price = Double.parseDouble(st.nextToken());
					ex = db.update(company,model,price);
					System.out.print(Pattern.print(" "+ex.result)+" "+Pattern.print(ex.reason,"blue")+"\n");
				}catch(Exception e){
					System.out.println(Pattern.print("{TypeMissMatch Error} please enter valid types as ")+Pattern.print("String String Double(number)","magneta"));
				}
			}
			else if(ss.countTokens() == 1){
				String temp = ss.nextToken();
				if(temp.equals("back")) return;
				else if(temp.equals("help")){
					System.out.println(Pattern.print(" Available keywords are ")+Pattern.print(" back help","magneta"));
				}
				else{
					System.out.println(Pattern.print("Use framat as {String String number} or available keywords are ")+Pattern.print(" back help","magneta"));
				}
			}
			else{
				System.out.println(Pattern.print("{UnSupportedInput Error} please enter valid number of input i.e.2"));
			}
		}
		else if(count-1 == 3){
			try{
				String c = st.nextToken();
				String m = st.nextToken();
				Double p = Double.parseDouble(st.nextToken());
				ex = db.update(c,m,p);
				System.out.print(Pattern.print(" "+ex.result)+" "+Pattern.print(ex.reason,"blue")+"\n");
			}catch(Exception e){
				System.out.println(Pattern.print("{TypeMissMatch Error} please enter valid types as ")+Pattern.print("String String Double(number)","magneta"));
			}
		}
		else{
			System.out.println(Pattern.print("{UnSupportedInput Error} please enter valid number of input i.e.3"));
		}
		update(null,1,db,br);
	}
	public static void main(String args[])throws IOException{
		clearScreen();
		String[] banner = Pattern.banner;
		for(int i=0;i<banner.length;i++){
			System.out.println(banner[i]);
		}
		System.out.println();
		System.out.println(Pattern.print("\tWelcome to Mobile shop of Dumb Minds :) \n\n\n Your options are : ")+Pattern.print("\n add  remove  update  display  back  help(?)  banner  supportus  exit","red")+Pattern.print("\n\n *keywords are not case sensitive*\n\n"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		MobileShop db = new MobileShop();
		while(true){
			System.out.print(Pattern.print(" %@> ","green"));
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			int count = st.countTokens();
			String primary = st.nextToken().toUpperCase();
			if(primary.equals("ADD")){
				add(st,count,db,br);
			}
			else if(primary.equals("REMOVE")){
				remove(st,count,db,br);
			}
			else if(primary.equals("DISPLAY")){
				db.display();
			}
			else if(primary.equals("UPDATE")){
				update(st,count,db,br);
			}
			else if(primary.equals("BACK"))
				continue;
			else if(primary.equals("HELP")||primary.equals("?")){
				System.out.println(Pattern.print("\n add  remove  update  display  back  help(?)  banner   exit","red"));
			}
			else if(primary.equals("BANNER")){
				clearScreen();
				for(int i=0;i<banner.length;i++){
					System.out.println(banner[i]);
				}
				System.out.println();
			}
			else if(primary.equals("EXIT")){
				System.out.println("We really miss you 😓️");
				return;
			}
			else{
				System.out.print(Pattern.print(" Please Enter valid only ! please use help keyword for help","black"));
			}
		}
	}
}
