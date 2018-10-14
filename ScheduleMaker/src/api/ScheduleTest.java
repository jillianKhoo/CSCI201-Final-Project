package api;

public class ScheduleTest {

	public static void main(String[] args) {
		// Schedule test
		ScheduleTest test = new ScheduleTest();
		
		// test1
		test.test1();
		
		// test2
		System.out.println("");
		test.conflictTest();
		
	}
	
	public void test1() {
		// Create schedule object
		Schedule schedule = new Schedule();
		
		// Create course session group
		schedule.createSessionGroup("CSCI 104L", "Lecture");
		schedule.createSessionGroup("CSCI 104L", "Lab");
		schedule.createSessionGroup("CSCI 104L", "Quiz");
		schedule.createSessionGroup("CSCI 170", "Lecture");
		schedule.createSessionGroup("CSCI 170", "Discussion");
		schedule.createSessionGroup("CSCI 170", "Quiz");
		
		// Add session to each group
		//  adding sessions to CSCI 104L
		schedule.addSession(0, "29903R", "11:00", "12:20", new boolean[] {false, true, false, true, false}, "GFS101");
		schedule.addSession(0, "29910R", "14:00", "15:20", new boolean[] {false, true, false, true, false}, "GFS101");
		schedule.addSession(0, "29931R", "12:30", "13:50", new boolean[] {false, true, false, true, false}, "ZHS352");
		schedule.addSession(0, "30397R", "09:30", "10:50", new boolean[] {false, true, false, true, false}, "GFS163");
		schedule.addSession(1, "29905R", "14:00", "15:50", new boolean[] {false, true, false, false, false}, "SAL109");
		schedule.addSession(1, "29907R", "16:00", "17:50", new boolean[] {false, true, false, false, false}, "SAL109");
		schedule.addSession(1, "29932R", "12:00", "13:50", new boolean[] {false, true, false, false, false}, "SAL109");
		schedule.addSession(2, "30025R", "19:00", "20:50", new boolean[] {false, false, false, false, true}, "SAL109");
		schedule.addSession(3, "29947D", "10:00", "11:50", new boolean[] {true, false, true, false, false}, "VPD105");
		schedule.addSession(3, "29953D", "14:00", "15:20", new boolean[] {true, false, true, false, false}, "ZHS152");
		schedule.addSession(3, "30273D", "12:00", "13:50", new boolean[] {true, false, true, false, false}, "SLH102");
		schedule.addSession(4, "29929R", "16:00", "17:50", new boolean[] {false, false, false, false, true}, "GFS116");
		schedule.addSession(5, "30027R", "19:00", "20:50", new boolean[] {false, false, true, false, false}, "GFS116");

		// Getting a default random schedule
		for (Session session : schedule) {
			System.out.println("Course name: " + session.getSessionCourseName()
							   + " Session type: " + session.getSessionType()
							   + " Session ID: " + session.getSessionID()
							   + " Start time: " + session.getStartTime()
							   + " End time: " + session.getEndTime()
							   + " On day: " + session.getOnDay()
							   + " location: " + session.getLocation());
		}
	}
	
	public void conflictTest() {
		// Create two session
		Session session1;
		Session session2;
		
		session1 = new Session("CSCI 104L", "Lecture", "29903R", "12:50", "13:55", new boolean[] {true, true, false, true, false}, "GFS101");
		session2 = new Session("CSCI 170", "Lecture", "29905R", "12:10", "12:30", new boolean[] {false, false, true, true, false}, "SAL109");

		System.out.println("Is in Conflict? " + Session.isConflict(session1, session2));
	}

}
