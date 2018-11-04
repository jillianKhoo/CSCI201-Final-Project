package services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import org.apache.commons.logging.Log;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.SetOptions;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

public class UploadClasses {

	public static void main(String[] args) {
		// Use a service account to connect to firebase
		Firestore db = null;
		try {
		InputStream serviceAccount = new FileInputStream("cs201-final-project-firebase-adminsdk-mobr9-2f3704063b.json");
		GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
		FirebaseOptions options = new FirebaseOptions.Builder()
		    .setCredentials(credentials)
		    .build();
		FirebaseApp.initializeApp(options);

		db = FirestoreClient.getFirestore();
		}
		catch(FileNotFoundException e) {
			System.out.println("LOL something went wrong");
			System.out.println(e.getMessage());
		}
		catch(IOException e) {
			System.out.println("LOL something went wrong");
			System.out.println(e.getMessage());
		}
		System.out.println("Connected to firebase");
		
			
			        Scanner scanner = null;
					try {
						scanner = new Scanner(new File("/Users/jj/Downloads/TestingData.csv"));
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			        scanner.useDelimiter(",|\n");
			        //scanner.useDelimiter("\n");
			    	
			    	int i=0;
			        String Coursename = "";
			        String Coursetitle= "";
			        String ClassType="";
			        String SectionNumber="";
			        String ClassTime="";
			        String ClassDays="";
			        String Instructor="";
			        String Location = "";
			        String ClassTimeStart="";
				    String ClassTimeEnd="";
			        
			        while(scanner.hasNext()){
			        	
			        	
			        	String temp = scanner.next(); //replace \n that is
			        	

			        	String tempNext = temp.replaceAll("\n", "");
			        	tempNext = tempNext.replaceAll("\\r\\n|\\r|\\n", " ");

			        	
			        	//System.out.println(tempNext);
			        	if (i==0) {
			        		if (tempNext.equals("")) {
			        			//We Know its an old course name
			        			
			        		}
			        		else {
			        			Coursetitle = tempNext;	
			        			
			        		}
			        		//System.out.print(Coursetitle +"|");
			        		
			        	}
			        	else if (i==1) {
			        		if (tempNext.equals("")) {
			        			//We Know its an old course name
			        			
			        		}
			        		else {
			        			Coursename = tempNext;
			        			
			        		}
			        		//System.out.print(Coursename + "|");
			        		
			        	}
			        	
			        	else if (i==4) {
			        		ClassType = tempNext; 
			        		//System.out.print(tempNext +"|");
			        		
			        		
			        	}
			        	else if (i==5) {
			        		SectionNumber = tempNext;
			        		//System.out.print(tempNext +"|");
			        	}
			        	else if (i==7) {
				    		ClassTime = tempNext;
				    		
				    	    if (ClassTime.equals("")) {
				    			ClassTime = "TBA";
				    		
				    		}
				    		
				    		if (ClassTime.equals("TBA")){
				    			
				    			
				    		}
				    
				    		else {
				    			String array2[]= ClassTime.split("-");
					    		
					    		ClassTimeStart = array2[0];
					    		ClassTimeEnd = array2[1];
					    		
					    		DateFormat readFormat = new SimpleDateFormat( "hh:mm");
					    		DateFormat writeFormat = new SimpleDateFormat( "hh:mm");
					    		
					    		Date date = null;
					    	    try {
					    	       date = readFormat.parse( ClassTimeStart );
					    	    } catch ( ParseException e ) {
					    	        e.printStackTrace();
					    	    }

					    	    String formattedDate = "";
					    	    if( date != null ) {
					    	    formattedDate = writeFormat.format( date );
					    	    }
					    	    
					    	    ClassTimeStart = formattedDate;
					    		

					    	
					    		String split1[] = ClassTimeStart.split(":");
					    		String split2[] = ClassTimeEnd.split(":");
					    		
					    		int startTime = Integer.parseInt(split1[0]);
					    		int endTime = Integer.parseInt(split2[0]);
					    		
					    		String ampm = ClassTimeEnd.substring(ClassTimeEnd.length() - 2);
					    		if (ampm.equals("pm")) {
					    			
					    			if (12 > startTime && 12 <= endTime) {
						    			System.out.println("Class Occurs during time Switch" );
						    			if (endTime == 12) {
						    				//do nothing
						    			}
						    			else {
						    				endTime +=12; 
						    			}
						    			String array3[] = ClassTimeEnd.split(":");
						    			ClassTimeEnd = String.valueOf(endTime) + ":" + array3[1].substring(0, 2);
						    		}
					    			else {
					    				//both occuring during the pm 
					    				if (endTime == 12) {
					    					
					    				}
					    				else {
					    					endTime +=12; 
					    				}
					    				
						    			String array3[] = ClassTimeEnd.split(":");
						    			ClassTimeEnd = String.valueOf(endTime) + ":" + array3[1].substring(0, 2);
						    			startTime +=12; 
						    			String array4[] = ClassTimeStart.split(":");
						    			ClassTimeStart = String.valueOf(endTime) + ":" + array4[1].substring(0, 2);
					    			}
					    			
					    		}
					    		else {
					    			DateFormat read2Format = new SimpleDateFormat( "hh:mmaa");
						    		DateFormat write2Format = new SimpleDateFormat( "hh:mm");
						    		
						    		 date = null;
						    	    try {
						    	       date = read2Format.parse( ClassTimeEnd );
						    	    } catch ( ParseException e ) {
						    	        e.printStackTrace();
						    	    }

						    	     formattedDate = "";
						    	    if( date != null ) {
						    	    formattedDate = write2Format.format( date );
						    	    }
						    	    
						    	    ClassTimeEnd = formattedDate;
						    		
						    	   
						    		
					    			
					    		}
				    		}
				    		
				    		
			        	}
			        	else if (i==8) {
			        		ClassDays = tempNext;
			        		
			        		//System.out.print(tempNext +"|");
			        	}
			        	else if (i==12) {
			        		if (tempNext.equals("")) {
			        			Instructor = "No Information";
			        			//System.out.print("No Information" +"|" );
			        		}
			        		else {
			        			Instructor = tempNext;
			        			//System.out.print(tempNext +"|");
			        		}
			        		

			        	}
			        	else if (i==13) {
			        		   		
			        		Location = tempNext; 
			        		//System.out.print(tempNext +"|");
			        		
			        	}
			      
			        	
			         	i++;
			         	
			         
			         	
			         	
			         	
			         	//Reset for next column
			         	
			         	if (i==14) {
			         		i =0; 
			         		
			         		System.out.println("Hit" + Coursename);
			         		DocumentReference docRef = db.collection("CoursesV2").document(Coursename);
			        		// Add document data with an additional field ("middle")
			        	
			        		Map<String, Object> data = new HashMap<>();
			        		
			            	try {
			            		
			            		
			            		
			            		data.put("Course Name", Coursename);
				            	//System.out.println(Coursename);
				            	data.put("Class Type", ClassType);
				            	//System.out.println(ClassType);
				            	data.put("Section Number", SectionNumber);
				            	//System.out.println(SectionNumber);
				            	data.put("Class Time", ClassTime);
				            	//System.out.println(ClassTime);
				            	data.put("Class Time Start", ClassTimeStart);
				            	//System.out.println(ClassTime);
				            	data.put("Class Time End", ClassTimeEnd);
				            	
				            	data.put("Class Days", ClassDays);
				            	//System.out.println(ClassDays);
				            	data.put("Instructor", Instructor);
				            	data.put("Location", Location);
				        
				            	ApiFuture<WriteResult> result = docRef.set(data);
								System.out.println("Update time : " + result.get().getUpdateTime());
							}
			            	
							catch(ExecutionException e) {
								System.out.println("LOL something went wrong");
								System.out.println(e.getMessage());
							}
							catch(InterruptedException e) {
								System.out.println("LOL something went wrong");
								System.out.println(e.getMessage());
							}
			         	}
			         	

			            
			        }
			        scanner.close();
			        
			
			
} }
