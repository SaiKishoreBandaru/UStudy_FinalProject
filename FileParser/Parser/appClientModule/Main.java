import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("enter source file address\n");
		String s;
		Scanner address = new Scanner(System.in);
		s=address.nextLine();
		System.out.println(s);
		BufferedReader reader = new BufferedReader(new FileReader(s));
		String line = reader.readLine();
		System.out.println("enter destination file address\n");
		address = new Scanner(System.in);
		s=address.nextLine();
		System.out.println(s);
		   BufferedWriter writer = new BufferedWriter(new FileWriter(s));
		    
		java.util.List<String> myList = new ArrayList<String>();
		myList.add("univname_s");
		myList.add("state_s");
		myList.add("fee_i");
		myList.add("aid_s");
		myList.add("gre_s");
		myList.add("toefl_s");
		while ((line = reader.readLine()) != null) {
		    // ...
			String[] words = line.split(",");
			String writel="[{\""+"ID"+"\":\"";
			//for (int i = 0; i < myList.size(); i++) {
			  //  String element = myList.get(i);
			   int i=0,j=0;
			   //System.out.println(myList.size());
			for (String word : words) {
				if(i<myList.size())
				writel=writel+word+"\",\""+myList.get(i)+"\":\"";
				else
					writel=writel+word+"\"}]";
				i++;
				
		
			}
		
			writer.write (writel);
			writer.write("\n");
		}
		reader.close();
		writer.close();
	}

	/* (non-Java-doc)
	 * @see java.lang.Object#Object()
	 */
	public Main() {
		super();
	}

}