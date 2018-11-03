package services;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.SetOptions;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

public class Firebase {
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
		
		//getting all users
		try {
			// asynchronously retrieve all users
			ApiFuture<QuerySnapshot> query = db.collection("Users").get();
			// ...
			// query.get() blocks on response
			QuerySnapshot querySnapshot = query.get();
			List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
			for (QueryDocumentSnapshot document : documents) {
				System.out.println("Email: " + document.getId());
				System.out.println("Name: " + document.getString("name"));
			}
		}
		catch(ExecutionException e) {
			System.out.println("LOL something went wrong");
			System.out.println(e.getMessage());
		}
		catch(InterruptedException e) {
			System.out.println("LOL something went wrong");
			System.out.println(e.getMessage());
		}
		
		//updating fields of a user and merging with what it already has
		try {
			//asynchronously update doc, create the document if missing
			Map<String, Object> update = new HashMap<>();
			
			ArrayList<String> friends = new ArrayList<>();
			friends.add("Jeffery Miller PHD update");
			
			update.put("friends", friends);

			ApiFuture<WriteResult> writeResult =
			    db
			        .collection("Users")
			        .document("jilliankhoo@gmail.com")
			        .set(update, SetOptions.merge());
			// ...
			System.out.println("Update time : " + writeResult.get().getUpdateTime());
		}
		catch(ExecutionException e) {
			System.out.println("LOL something went wrong");
			System.out.println(e.getMessage());
		}
		catch(InterruptedException e) {
			System.out.println("LOL something went wrong");
			System.out.println(e.getMessage());
		}
		
		//only do this if you want to completely overwrite the entire user. Otherwise use the one above to merge the new info
		/*try {
		DocumentReference docRef = db.collection("Users").document("jilliankhoo@gmail.com");
		// Add document data with an additional field ("middle")
		ArrayList<String> friends = new ArrayList<>();
		friends.add("Jeffery Miller PHD");
		String name = "Jillian Khoo";
		Map<String, Object> data = new HashMap<>();
		data.put("friends", friends);
		data.put("name", name);
		data.put("savedSchedules", new ArrayList<String>());

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
		}*/
		
	}
}
