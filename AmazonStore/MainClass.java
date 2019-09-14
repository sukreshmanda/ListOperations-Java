/*
	Author : M.Sukresh
	Description : class used for running whole process and taking user inputs and processing all possibilities.
	Imported Classes : BufferedReader BufferedWriter FileReader FileWriter StringTokenizer
	Company : Dumb Minds
	mail : mandasukresh@gmail.com
	website : https://dumbmindsblog.blogspot.com/
	Youtube : https://youtube.com/c/Dumbminds/
	Date : 14-09-2019 4:30
	Country : India
	copyrights: None
*/

/* Import all prequired classes */
import java.io.*;
import java.util.*;

public class MainClass{

	/* Main function executation starts from here*/
	public static void main(String args[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		/* Read data already exists from "stock.txt" and insert into shop*/
		FileReader data = new FileReader("stock.txt");
		BufferedReader db = new BufferedReader(data);
		Amazon shop = new Amazon();
		String s;
		s = db.readLine();
		while(s!=null){
			StringTokenizer st = new StringTokenizer(s);
			if(st.countTokens()== 3){
				String modelName = st.nextToken();
				String serialNo = st.nextToken();
				Double price = Double.parseDouble(st.nextToken());
				shop.add(modelName,serialNo,price);
			}
			s = db.readLine();
		}
		db.close();
		data.close();

		/*clear screen and print default Dumb Minds banner*/
		System.out.print("\033[H\033[2J");  
    	System.out.flush();
		for(int i=0;i<Pattern.banner.length;i++){
			System.out.println(Pattern.banner[i]);
		}
		System.out.println();
		
		/*Loop for user time access*/
		while(true){
			System.out.print(Pattern.ANSI_GREEN+" &^% "+Pattern.ANSI_RESET);
			String input = br.readLine();
			StringTokenizer ss = new StringTokenizer(input);
			if(ss.countTokens()== 1){
				String token = ss.nextToken().toUpperCase();
				/* Do all possible actions like ADD UPDATE DISPLAY REMOVE SORT BANNER EXIT HELP*/
				switch(token){
					case "ADD":
						add(br,shop);
						break;
					case "UPDATE":
						update(br,shop);
						break;
					case "DISPLAY":
						shop.display();
						break;
					case "REMOVE":
						remove(br,shop);
						break;
					case "SORT":
						Result r = shop.sort();
						System.out.println(" "+r.result+" "+r.reason);
						break;
					case "BANNER":
						System.out.print("\033[H\033[2J");  
    					System.out.flush();
						for(int i=0;i<Pattern.banner.length;i++){
							System.out.println(Pattern.banner[i]);
						}
						System.out.println();
						break;
					case "EXIT":
						FileWriter fw = new FileWriter("stock.txt");
						BufferedWriter bw = new BufferedWriter(fw);
						Laptop p = shop.first;
						while(p!=null){
							bw.write(p.getLaptop().modelName+" "+p.getLaptop().serialNo+" "+p.getLaptop().price+"\n");
							p = p.next;
						}
						bw.close();
						fw.close();
						return;
					case "HELP":
					default:
						help();
				}
			}else{
				help();
			}
		}
	}
	
	/*static method for printing help options*/
	public static void help(){
		System.out.println(Pattern.ANSI_BLUE+" Use proper syntax and available keywords are > add remove update display sort help "+Pattern.ANSI_RESET);
		return ;
	}

	/*static method for providing remove laptop service*/
	public static void remove(BufferedReader br, Amazon shop)throws IOException{
		while(true){
			System.out.print(Pattern.ANSI_GREEN+" &(REMOVE% )"+Pattern.ANSI_RESET);
			String add = br.readLine();
			StringTokenizer st = new StringTokenizer(add);
			if(st.countTokens()== 1){
				if(st.nextToken().equals("back")){
					return;
				}else{
					String serialNo = st.nextToken();
					Result ex = shop.remove(serialNo);
					System.out.println(Pattern.ANSI_MAGNETA+" "+ex.result+" "+ex.reason+Pattern.ANSI_RESET);
				}
			}else{
				System.out.println(Pattern.ANSI_BLUE+" Use proper syntax as > serialNo "+Pattern.ANSI_RESET);
			}
		}
	}
	/* static method used to provide update service Laptop details service */
	public static void update(BufferedReader br, Amazon shop)throws IOException{
		while(true){
			System.out.print(Pattern.ANSI_GREEN+" &(UPDATE)^% "+Pattern.ANSI_RESET);
			String add = br.readLine();
			StringTokenizer st = new StringTokenizer(add);
			if(st.countTokens()== 3){
				try{
					String modelName = st.nextToken();
					String serialNo = st.nextToken();
					Double price = Double.parseDouble(st.nextToken());
					Result ex = shop.update(modelName,serialNo,price);
					System.out.println(Pattern.ANSI_MAGNETA+" "+ex.result+" "+ex.reason+Pattern.ANSI_RESET);
				}catch(Exception e){
					System.out.println(Pattern.ANSI_BLUE+" Use proper syntax as > "+Pattern.ANSI_RED+"modelName serialNo price "+Pattern.ANSI_RESET);
				}
			}else if(st.countTokens()==1){
				if(st.nextToken().equals("back")){
					return;
				}else{
					System.out.println(Pattern.ANSI_BLUE+" Use proper syntax as >"+Pattern.ANSI_RED+" modelName serialNo price\n"+Pattern.ANSI_BLUE+" with serialNo update modelName and Price"+Pattern.ANSI_RESET);
				}
			}else{
				System.out.println(Pattern.ANSI_BLUE+" Use proper syntax as > "+Pattern.ANSI_RED+"modelName serialNo price "+Pattern.ANSI_RESET);
			}
		}
	}

	/* static method used to provide add Laptop service */
	public static void add(BufferedReader br, Amazon shop)throws IOException{
		while(true){
			System.out.print(Pattern.ANSI_GREEN+" &(ADD)^% "+Pattern.ANSI_RESET);
			String add = br.readLine();
			StringTokenizer st = new StringTokenizer(add);
			if(st.countTokens()== 3){
				try{
					String modelName = st.nextToken();
					String serialNo = st.nextToken();
					Double price = Double.parseDouble(st.nextToken());
					Result ex = shop.add(modelName,serialNo,price);
					System.out.println(Pattern.ANSI_MAGNETA+" "+ex.result+" "+ex.reason+Pattern.ANSI_RESET);
				}catch(Exception e){
					System.out.println(Pattern.ANSI_BLUE+" Use proper syntax as > "+Pattern.ANSI_RED+"modelName serialNo price "+Pattern.ANSI_RESET);
				}
			}else if(st.countTokens()==1){
				String temp = st.nextToken().toUpperCase();
				if(temp.equals("BACK")){
					return;
				}else{
					System.out.println(Pattern.ANSI_BLUE+" Use proper syntax as > "+Pattern.ANSI_RED+"modelName serialNo price "+Pattern.ANSI_RESET);
				}
			}else{
				System.out.println(Pattern.ANSI_BLUE+" Use proper syntax as > modelName serialNo price"+Pattern.ANSI_RESET);
			}
		}
	}
}

