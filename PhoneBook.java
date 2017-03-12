import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
public class PhoneBook {

    public static void main(String[] args) {
		//hashmap take First name as a key and array include the all details of person
        HashMap<String, String[]> hm = new HashMap<String, String[] >();
        try{
            BufferedReader br = new BufferedReader(new FileReader("contacts.csv"));
            String line = br.readLine(); //read csv file line by line

            while ((line=br.readLine()) != null) {
				//split the line by ","
                String[] item = line.split(",");
                
				//String array to keep the details of person
				String[] arry = new String[6];
                arry[0] = item[0];
                arry[1] = item[1];
                arry[2] = item[2];
                arry[3] = item[3];
                arry[4] = item[4];
				arry[5] = item[5];
				
				String key = item[1];
                hm.put(key, arry);
            }
        }catch(Exception e){
            System.out.println(e);
        }
		
		try{
			Scanner scnnr = new Scanner(System.in); 
			System.out.println("Enter the user name(Enter Clt+c for exit) : ");
			
			//hasNextLine() method to exit search or enter name to search
			while(scnnr.hasNextLine()){
				
				//take first name as string to search details
				String userName = scnnr.nextLine();
			
				//String array to keep output details from hashmap
				String[] usrDetails = new String[6];
			
				//get method to return requested person details array
				usrDetails = hm.get(userName);
			
				System.out.println("First Name : "+ usrDetails[1]);
				System.out.println("Last Name : "+ usrDetails[2]);
				System.out.println("Phone : "+ usrDetails[3]);
				System.out.println("Email : "+ usrDetails[4]);
				System.out.println("Company : "+ usrDetails[5]);
			
				
				System.out.println("Enter the user name(Enter Clt+c for exit) : ");
			
			}
		}catch(NullPointerException nl){
			System.out.println("User Name you enterd does not exist.");
		}

    }
}
