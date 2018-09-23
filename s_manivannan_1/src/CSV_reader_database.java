import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.io.File;

public class CSV_reader_database {
	 static int count=0;
	 static int count_1=0;
	 static int count_2=0;
    public void walk( String path ) throws IOException {

        File root = new File( path );
        File[] list = root.listFiles();
        String str_filename = null;
        String File_name_input="C:\\temp_java\\output\\test_2.csv";
        String File_name_input_1="C:\\temp_java\\output\\test_2.csv";
        
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd-HH:mm:ss");
        
        SimpleDateFormat sdf_1 = new SimpleDateFormat("yyyy-mm-dd_HH_mm");
        
        String add_in=sdf_1.format(cal.getTime());
        
        PrintStream out = new PrintStream(new FileOutputStream("C:\\temp_java\\output\\"+add_in.toString()+".log", true),true);
        System.setOut(out);
        System.out.println( sdf.format(cal.getTime()) );
       
        
        System.out.println("Creating a Log file "+sdf.format(cal.getTime()));
       
        
        File inputFile_1 = new File(File_name_input_1);
        inputFile_1.delete();
        
        File inputFile = new File(File_name_input);
        //inputFile.delete();
        
        System.out.println("Creating/Appending the File "+sdf.format(cal.getTime()));
        
        FileWriter pw = new FileWriter(File_name_input,true);
//        pw.append("First Name");
//        pw.append(",");
//        pw.append("Last Name");
//        pw.append(",");
//        pw.append("Street No");
//        pw.append(",");
//        pw.append("Street Name");
//        pw.append(",");
//        pw.append("City");
//        pw.append(",");
//        pw.append("Province");
//        pw.append(",");
//        pw.append("Postal Code");
//        pw.append(",");
//        pw.append("Country");
//        pw.append(",");
//        pw.append("Phone Number");
//        pw.append(",");
//        pw.append("Email Address");
//        pw.append(",");
//        pw.append("Date");
//        pw.append("\n");
        
        if (list == null) return;

        for ( File f : list ) {
        	
        	
        	
            if ( f.isDirectory() ) {
            	
            	System.out.println("Directory found--> "+f.getAbsolutePath());
            	System.out.println(sdf.format(cal.getTime()));
            	
                walk( f.getAbsolutePath() );
            }
            else {
            	System.out.println("File found--> "+f.getAbsolutePath());
            	System.out.println(sdf.format(cal.getTime()));
//            	
//
//            	Logic starts
//            	
//            	
            	try {
            	count++;
				str_filename = f.getAbsoluteFile().toString();
//            	System.out.println(str_filename);
            	str_filename=str_filename.substring(0, str_filename.length() - 4);
//            			System.out.println(str_filename);
            			
            			if (null != str_filename && str_filename.length() > 0 )
            			{
            			    int endIndex = str_filename.lastIndexOf("\\");
            			    if (endIndex != -1)  
            			    {
            			        String newstr = str_filename.substring(0, endIndex); // not forgot to put check if(endIndex != -1)
//            			        System.out.println(newstr);
            			        str_filename=newstr+"\\";
            			    }
            			}  
            			
            			
//            			str_filename=str_filename.substring(str_filename.lastIndexOf('\\')+1);
//            			System.out.println(str_filename);
            			String date_display=str_filename.substring(str_filename.length() - 9);
            			
            			String date_to_insert;
            			
            			if (date_display.startsWith("20"))
            			{
            				date_to_insert=date_display;
            			}else if(date_display.startsWith("0"))
            			{
            				date_to_insert="2"+date_display;
            			}else
            			{
            				date_to_insert="20"+date_display;
            			}
            			date_to_insert=date_to_insert.substring(0, date_to_insert.length() - 1);
            			date_to_insert=date_to_insert.replace('\\','/');
            			
//            			System.out.println(date_to_insert);
            			
            			
            			String init_file=f.getAbsolutePath().substring(f.getAbsolutePath().lastIndexOf("\\")+1);
//    					System.out.println(init_file);
    					
    					init_file=init_file.substring(0, init_file.length() - 4);
//    					System.out.println(init_file);
					// Load the driver.
					Class.forName("org.relique.jdbc.csv.CsvDriver");

					String CSVDir = str_filename;

					// Create a connection. The first command line parameter is
					// the directory containing the .csv files.
					// A single connection is thread-safe for use by several threads.
					Connection conn = DriverManager.getConnection("jdbc:relique:csv:" + CSVDir);

					// Create a Statement object to execute the query with.
					// A Statement is not thread-safe.
					Statement stmt = conn.createStatement();
					
					// Select the ID and NAME columns from sample.csv
					
				ResultSet results = stmt.executeQuery("SELECT * FROM "+init_file);
				
				System.out.println("Executing Query--> SELECT * FROM "+init_file);
            	System.out.println(sdf.format(cal.getTime()));
				
				while (results.next()) {
					
					String first_name = results.getString("First Name");
					String last_name = results.getString("Last Name");
					String street_number = results.getString("Street Number");
					String street = results.getString("Street");
					String city = results.getString("City");
					String province = results.getString("Province");
					String country = results.getString("Country");
					String postal_code = results.getString("Postal Code");
					String phone = results.getString("Phone Number");
					String email = results.getString("email Address");
					
					System.out.println(first_name+","+last_name+","+street_number+","+street+","+city+","+province+","+country+","+postal_code+","+phone+","+email);
	            	System.out.println(sdf.format(cal.getTime()));
					
					if((first_name=="") || (last_name=="") || (street_number=="") || (street=="") || (city=="") || (province=="") || (country=="") || (postal_code=="") || (phone=="") || (email==""))
					{
						System.out.println("The Above row is Skipped coz of Empty Rows");
						++count_1;
						continue;
						
					}else {
						
						System.out.println("Appending the above Row");
						System.out.println(sdf.format(cal.getTime()));
					++count_2;
				pw.append(first_name);
				pw.append(",");
				pw.append(last_name);
				pw.append(",");
				pw.append(street_number);
				pw.append(",");
			//	street.replace("Alm-../../view.php?place=Alm-# Ramp",";");
				if(street.startsWith("Alm-"))
				{
					street="Ramp";
				}
				pw.append(street.replace(',', ';'));
				pw.append(",");
				pw.append(city);
				pw.append(",");
				pw.append(province);
				pw.append(",");
				pw.append(country);
				pw.append(",");
				pw.append(postal_code);
				pw.append(",");
				pw.append(phone);
				pw.append(",");
				pw.append(email);
				pw.append(",");
				pw.append(date_to_insert.toString());
				
			 	pw.append("\n");
					}
				
				}
			 	
			 	// Clean up
					conn.close();
				} catch (Exception e) {
//					e.printStackTrace();
				}
				
				

				 }
        }
        pw.flush();
        pw.close();
    }

    public static void main(String[] args) throws IOException {
    	final long startTime = System.currentTimeMillis();
    	CSV_reader_database fw = new CSV_reader_database();
    	fw.walk("C:\\Users\\Mani Santhamohan\\Documents\\GitHub\\MCDA5510_Assignments\\Sample_Data" );
    	final long endTime = System.currentTimeMillis();
    	System.out.println("Total execution time: " + (endTime - startTime) +" ms");
    	System.out.println("Total Number of Valid Rows: "+count_2);
    	System.out.println("Total Number of Skipped Rows: "+count_1);
    }

}
