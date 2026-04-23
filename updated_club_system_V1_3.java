//AYAW PANSINA ANG MGA COMMENTS KAY LIMTANON KAY KO FR
import java.util.*;

public class updated_club_system_V1_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
//--------------------------------------BUTANG TANAN DATA DIRI---------------------------------
        
        final String DEFAULT_STUDENT_PASSWORD = "1234";
        final String DEFAULT_DEPARTMENT = "CITE";
        
        String[] admin = {"admin", "prof", "teach"};
        String[] adminPassword = {"admin123", "prof123", "teach123"};
        String[] schoolClub = {"Basketball", "Volleyball", "Chess", "Badminton", "Billiards"};
        
        ArrayList<String> studentIds = new ArrayList<>(); 
        ArrayList<String> studentStatus = new ArrayList<>();  
        ArrayList<String> studentJoinedClub = new ArrayList<>(); 
        ArrayList<String> studentRequestedClub = new ArrayList<>(); 
        ArrayList<String> studentLeaveReason = new ArrayList<>();
        ArrayList<String> studentNames = new ArrayList<>();
        ArrayList<String> studentYears = new ArrayList<>();
        ArrayList<String> studentDepartments = new ArrayList<>();
        
        String schoolAnnouncement = "No upcoming activities yet."; 

        boolean menuRunning = true;
        boolean userRunning = true;
        boolean adminRunning = true;
        boolean isStudent = false;

        int currentUserIndex = -1; 
        String currentLoggedInName = ""; 
        
        final int validIdLength = 11;
//--------------------------------------------------------------------------------


//---------------------LOGIN AREA-------------------------------------------------
System.out.println("---CLUB VERIFICATION SYSTEM---");
System.out.println("---PHINMA COC STUDENT CLUB SYSTEM---\n");
        while (menuRunning) {

            boolean adminLoginRunning = true;
            boolean userLoginRunning = true;
            boolean loginSuccess = false;
            userRunning = true;
            adminRunning = true;
            isStudent = false;
            currentUserIndex = -1;
            currentLoggedInName = "";

            System.out.println("---CHOOSE WHAT TYPE OF USER DO YOU WANT TO LOG IN---");
            System.out.println("1. ADMIN \n2. USER \n0. Exit");
            System.out.print("Enter Choice: ");
            
            int chooseLogIn = 0;

            try {
                chooseLogIn = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid input. Please enter a number.\n");
                scanner.nextLine(); 
                continue;
            }

            scanner.nextLine();

            switch (chooseLogIn) {
                case 0:
                    System.out.println("\nBye Bye!\n");
                    menuRunning = false;
                    break;
                    
                case 1:
                    while (adminLoginRunning) {
                        System.out.println("\n---Login Admin Menu---");
                        System.out.print("Enter Username: ");
                        String inputAdminUsername = scanner.nextLine();

                        if (inputAdminUsername.equalsIgnoreCase("exit")) {
                            System.out.println("Bye Bye!");
                            menuRunning = false;
                            adminLoginRunning = false;
                            break;
                        }
                        
                        if (inputAdminUsername.equalsIgnoreCase("back")) {
                            break;
                        }

                        if (inputAdminUsername.trim().isEmpty()) {
                            System.out.println("\nUsername cannot be empty.\n");
                            continue;
                        }
                        
                        System.out.print("Enter password: ");
                        String inputAdminPassword = scanner.nextLine();

                        if (inputAdminPassword.trim().isEmpty()) {
                            System.out.println("\nPassword cannot be empty.\n");
                            continue;
                        }
                        
                        boolean validAdmin = false;

                        for (int i = 0; i < admin.length; i++) {
                            if (admin[i].equalsIgnoreCase(inputAdminUsername) &&
                                adminPassword[i].equals(inputAdminPassword)) {
                                    loginSuccess = true;
                                    currentLoggedInName = inputAdminUsername;
                                    isStudent = false;
                                    adminLoginRunning = false;
                                    validAdmin = true;
                                    break;
                                }
                        }
                        if (!validAdmin) {
                            System.out.println("\nInvalid Username or Password.\n");
                        }
                    }
                    
                    break;

                case 2:
                   while (userLoginRunning) {
                    System.out.println("\n---STUDENT INFORMATION---");
                    System.out.println("(Please enter your details to access the system)\n");
                    
                    String inputUsername = "";
                    boolean validId = false;
                    while (!validId) {
                        System.out.print("Enter your Student ID (11 digits): ");
                        inputUsername = scanner.nextLine().trim();
                                
                        if (inputUsername.equalsIgnoreCase("exit")) {
                            System.out.println("Bye Bye!");
                            menuRunning = false;
                            break;
                        }
                    
                        if (inputUsername.equalsIgnoreCase("back")) {
                            break;
                        }
                
                        if (inputUsername.isEmpty()) {
                            System.out.println("ID cannot be empty. Please try again.\n");
                            continue;
                        }
                
                        if (inputUsername.length() != validIdLength) {
                            System.out.println("ID must be exactly " + validIdLength + " digits! You entered: " + inputUsername.length() + " character(s).\n");
                            continue;
                        }
                
                        boolean isNumeric = true;
                        for (char c : inputUsername.toCharArray()) {
                            if (!Character.isDigit(c)) {
                                isNumeric = false;
                                break;
                            }
                        }
                
                        if (!isNumeric) {
                            System.out.println("ID must contain ONLY numbers (no letters/symbols).\n");
                            continue;
                        }
                        
                        validId = true;
                    }

                    if (inputUsername.equalsIgnoreCase("back") || inputUsername.equalsIgnoreCase("exit")) {
                        if (!menuRunning) {
                            continue;
                        }
                        break;
                    }
                    

                    String fullName = "";
                    boolean validName = false;
                    while (!validName) {
                        System.out.print("Enter your Full Name: ");
                        fullName = scanner.nextLine().trim();
                        
                        if (fullName.isEmpty()) {
                            System.out.println("Name cannot be empty. Please try again.\n");
                            continue;
                        }
                        
                        if (fullName.length() < 2) {
                            System.out.println("Name is too short! Please enter your complete name.\n");
                            continue;
                        }
                        
                        boolean nameHasNumbers = false;
                        for (char c : fullName.toCharArray()) {
                            if (Character.isDigit(c)) {
                                nameHasNumbers = true;
                                break;
                            }
                        }
                        if (nameHasNumbers) {
                            System.out.println("Name must contain ONLY letters (numbers are NOT allowed).\n");
                            continue;
                        }
                        
                        boolean nameHasInvalidChars = false;
                        for (char c : fullName.toCharArray()) {
                            if (!Character.isLetter(c) && !Character.isWhitespace(c) && c != '-' && c != '\'' && c != '.') {
                                nameHasInvalidChars = true;
                                break;
                            }
                        }
                        if (nameHasInvalidChars) {
                            System.out.println("Special characters (except - ' .) are not allowed.\n");
                            continue;
                        }
                        
                        validName = true;
                    }
                    

                    int yearLevel = 0;
                    boolean validYear = false;
                    while (!validYear) {
                        System.out.println("\nSelect your Year Level:");
                        System.out.println("1. 1st Year");
                        System.out.println("2. 2nd Year");
                        System.out.println("3. 3rd Year");
                        System.out.println("4. 4th Year");
                        System.out.println("0. Go Back");
                        System.out.print("Enter Year Level (1-4): ");
                        
                        try {
                            yearLevel = scanner.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input! Please enter a number between 1-4.\n");
                            scanner.nextLine();
                            continue;
                        }
                        scanner.nextLine();
                        
                        if (yearLevel == 0) {
                            System.out.println("\nGoing back to user type selection...\n");
                            userLoginRunning = false;
                            break;
                        }
                        
                        if (yearLevel < 1 || yearLevel > 4) {
                            System.out.println("Invalid year level! Please enter a number between 1 and 4.\n");
                            continue;
                        }
                        
                        validYear = true;
                    }
                    
                    if (!validYear) {
                        break;
                    }
                    
                    String yearSuffix;
                    switch(yearLevel) {
                        case 1: yearSuffix = "st"; break;
                        case 2: yearSuffix = "nd"; break;
                        case 3: yearSuffix = "rd"; break;
                        default: yearSuffix = "th"; break;
                    }
                    String yearStr = yearLevel + yearSuffix + " Year";
                    
                    int foundIndex = -1;
                    for (int i = 0; i < studentIds.size(); i++) {
                        if (studentIds.get(i).equals(inputUsername)) {
                            foundIndex = i;
                            break;
                        }
                    }
                    
                    if (foundIndex == -1) {
                        loginSuccess = true;
                        isStudent = true;
                        currentLoggedInName = fullName;
                        
                        studentIds.add(inputUsername);
                        studentStatus.add("No Club");
                        studentJoinedClub.add(null);
                        studentRequestedClub.add(null);
                        studentLeaveReason.add(null);
                        studentNames.add(fullName);
                        studentYears.add(yearStr);
                        studentDepartments.add(DEFAULT_DEPARTMENT);
                        currentUserIndex = studentIds.size() - 1;
                        
                        userLoginRunning = false;
                        System.out.println("\nAccount created successfully!");
                        System.out.println("Welcome, " + fullName + "!");
                        System.out.println("Accessing your dashboard...\n");
                        
                    } else {
                        String storedName = studentNames.get(foundIndex);
                        
                        if (!storedName.equalsIgnoreCase(fullName)) {
                            System.out.println("\nName does not match our records!");
                            System.out.println("Registered Name: " + storedName);
                            System.out.println("Entered Name: " + fullName);
                            System.out.println("\nLogin denied. Please re-enter using your registered name.");
                            
                            userLoginRunning = false;
                            loginSuccess = false;
                            
                        } else {
                            loginSuccess = true;
                            isStudent = true;
                            currentLoggedInName = storedName;
                            currentUserIndex = foundIndex;
                            studentYears.set(currentUserIndex, yearStr);
                            
                            userLoginRunning = false;
                            System.out.println("\nWelcome back, " + storedName + "!");
                            System.out.println("Accessing your dashboard...\n");
                        }
                    }
                }
                break;

                default:
                    System.out.println("\nInvalid choice.\n");
            }
//-----------------------------------------------------------------------------------

//----------||MAIN LOGIC NI||--------------------------------------------USER'S AND INPUTS PARA MAKA PILI OG CLUB-----------------------------------------------------------------
            if (loginSuccess) {
                if (isStudent && (currentUserIndex < 0 || currentUserIndex >= studentIds.size())) {
                    System.out.println("Error: Session corrupted. Please log in again.\n");
                    continue;
                }
                
                // ---------------USER MENU/DASHBOARD----------------
                if (isStudent) {

                    while (userRunning) {
                        System.out.println("---WELCOME " + currentLoggedInName.toUpperCase() + "!---");
                        System.out.println("Student ID: " + studentIds.get(currentUserIndex));
                        System.out.println("Year Level: " + (studentYears.get(currentUserIndex) != null ? studentYears.get(currentUserIndex) : "Not Set"));
                        System.out.println("Department: " + studentDepartments.get(currentUserIndex));
                        System.out.println("----------------------------------------");
                        System.out.println("1. Register to a Club \n2. Check Verification Status \n3. View Activities/Events \n0. Log out");
                        System.out.print("Enter choice: ");
                        
                        int choice = 0;
                        try {
                            choice = scanner.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("\nInvalid input. Please enter a number.\n");
                            scanner.nextLine(); 
                            continue;
                        }
                        scanner.nextLine();

                        switch (choice) {
                            case 0:
                                System.out.println("\nLogging out... Goodbye, " + currentLoggedInName + "!\n");
                                userRunning = false;
                                break;
                                
                            case 1:
                                String status = studentStatus.get(currentUserIndex);
                                String joinedClub = studentJoinedClub.get(currentUserIndex);
                                String requestedClub = studentRequestedClub.get(currentUserIndex);
                                String leaveReason = studentLeaveReason.get(currentUserIndex);

                                if (status != null && status.equals("Pending Leave")) {
                                    System.out.println("\nYou currently have a pending leave request.\nPlease wait for the admin to approve it.\n");
                                    System.out.println("Current Club: " + (joinedClub != null ? joinedClub : "N/A"));
                                    System.out.print("Do you want to cancel this request? (1=Yes, 2=No, 0=Go Back): ");
                                    
                                    int cancelChoice = 0;
                                    try {
                                        cancelChoice = scanner.nextInt();
                                    } catch (InputMismatchException e) {
                                        System.out.println("\nInvalid input.\n");
                                        scanner.nextLine();
                                        break;
                                    }
                                    scanner.nextLine();

                                    if (cancelChoice == 0) {
                                        System.out.println("\nGoing back to dashboard...\n");
                                    } else if (cancelChoice == 1) {
                                        studentStatus.set(currentUserIndex, "Active");
                                        studentLeaveReason.set(currentUserIndex, null);
                                        System.out.println("Leave request cancelled. You remain in " + (joinedClub != null ? joinedClub : "your club") + ".\n");
                                    } else if (cancelChoice == 2) {
                                        System.out.println("Please wait for admin approval.\n");
                                    } else {
                                        System.out.println("Invalid choice.\n");
                                    }
                                } 

                                else if (status != null && status.equals("Active")) {
                                    System.out.println("\nYou are already verified in: " + (joinedClub != null ? joinedClub : "a club") + "\n");
                                    System.out.print("Do you wish to Leave the Club? (1. Yes 2. No 0. Go Back): ");
                                    
                                    int leaveClub = 0;
                                    try {
                                        leaveClub = scanner.nextInt();
                                    } catch (InputMismatchException e) {
                                        System.out.println("\nInvalid input.\n");
                                        scanner.nextLine();
                                        break;
                                    }
                                    scanner.nextLine();

                                    if (leaveClub == 0) {
                                        System.out.println("\nGoing back to dashboard...\n");
                                    } else if (leaveClub == 1) {
                                        System.out.print("Is there any reason why you want to leave the Club?: ");
                                        String reason = scanner.nextLine().trim();
                                        
                                        while (reason.isEmpty()) {
                                            System.out.print("Reason cannot be empty. Please enter a reason: ");
                                            reason = scanner.nextLine().trim();
                                        }
                                        
                                        studentLeaveReason.set(currentUserIndex, reason);
                                        studentStatus.set(currentUserIndex, "Pending Leave");
                                        System.out.println("Your request to leave has been sent to the admin.\n");
                                    } else if (leaveClub == 2) {
                                        System.out.println("\nOkay!\n");
                                    } else {
                                        System.out.println("\nInvalid choice.\n");
                                    }
                                } 

                                else if (status != null && status.equals("Pending")) {
                                    System.out.println("\nYou already have a pending request for: " + (requestedClub != null ? requestedClub : "a club"));
                                    System.out.print("Do you wish to change CLUB or CANCEL request? (1. Change Club 2. Cancel Request 0. Go Back): ");
                                    
                                    int changeClubChoice = 0;
                                    try {
                                        changeClubChoice = scanner.nextInt();
                                    } catch (InputMismatchException e) {
                                        System.out.println("\nInvalid input.\n");
                                        scanner.nextLine();
                                        break;
                                    }
                                    scanner.nextLine();

                                    if (changeClubChoice == 0) {
                                        System.out.println("\nGoing back to dashboard...\n");
                                    } else if (changeClubChoice == 1) {
                                        System.out.println("\n=== AVAILABLE CLUBS ===");
                                        for (int i = 0; i < schoolClub.length; i++) {
                                            System.out.println((i + 1) + ". " + schoolClub[i]);
                                        }
                                        System.out.print("\nEnter the NUMBER of the club you want to join (0=Go Back): ");
                                        
                                        int clubChoiceNum = 0;
                                        try {
                                            clubChoiceNum = scanner.nextInt();
                                        } catch (InputMismatchException e) {
                                            System.out.println("\nInvalid input.\n");
                                            scanner.nextLine();
                                            break;
                                        }
                                        scanner.nextLine();
                                        
                                        if (clubChoiceNum == 0) {
                                            System.out.println("\nGoing back to dashboard...\n");
                                            break;
                                        }
                                        
                                        if (clubChoiceNum < 1 || clubChoiceNum > schoolClub.length) {
                                            System.out.println("\nInvalid choice. Please enter a valid number.\n");
                                            break;
                                        }
                                        
                                        String selectedClub = schoolClub[clubChoiceNum - 1];
                                        
                                        studentRequestedClub.set(currentUserIndex, selectedClub);
                                        System.out.println("\nYou've changed your club request to " + selectedClub);
                                        System.out.println("Current Details:");
                                        System.out.println("- ID: " + studentIds.get(currentUserIndex));
                                        System.out.println("- Name: " + studentNames.get(currentUserIndex));
                                        System.out.println("- Year: " + studentYears.get(currentUserIndex));
                                        System.out.println("- Department: " + studentDepartments.get(currentUserIndex));
                                        System.out.println("- Requested Club: " + selectedClub + "\n");
                                        
                                    } else if (changeClubChoice == 2) {
                                        studentStatus.set(currentUserIndex, "No Club");
                                        studentRequestedClub.set(currentUserIndex, null);
                                        System.out.println("\nYour club request has been cancelled.\n");
                                    } else {
                                        System.out.println("Invalid Choice. Please Enter a Number");
                                    }
                                } 

                                else {
                                    System.out.println("\n=== AVAILABLE CLUBS ===");
                                    for (int i = 0; i < schoolClub.length; i++) {
                                        System.out.println((i + 1) + ". " + schoolClub[i]);
                                    }
                                    System.out.print("\nEnter the NUMBER of the club you want to join (0=Go Back): ");
                                    
                                    int clubChoiceNum = 0;
                                    try {
                                        clubChoiceNum = scanner.nextInt();
                                    } catch (InputMismatchException e) {
                                        System.out.println("\nInvalid input.\n");
                                        scanner.nextLine();
                                        break;
                                    }
                                    scanner.nextLine();
                                    
                                    if (clubChoiceNum == 0) {
                                        System.out.println("\nGoing back to dashboard...\n");
                                        break;
                                    }
                                    
                                    if (clubChoiceNum < 1 || clubChoiceNum > schoolClub.length) {
                                        System.out.println("\nInvalid choice. Please enter a valid number.\n");
                                        break;
                                    }
                                    
                                    String selectedClub = schoolClub[clubChoiceNum - 1];
                                    
                                    studentRequestedClub.set(currentUserIndex, selectedClub);
                                    studentStatus.set(currentUserIndex, "Pending");
                                    
                                    System.out.println("\nRequest sent for " + selectedClub + "!");
                                    System.out.println("Your Details:");
                                    System.out.println("- ID: " + studentIds.get(currentUserIndex));
                                    System.out.println("- Name: " + studentNames.get(currentUserIndex));
                                    System.out.println("- Year: " + studentYears.get(currentUserIndex));
                                    System.out.println("- Department: " + studentDepartments.get(currentUserIndex));
                                    System.out.println("- Requested Club: " + selectedClub);
                                    System.out.println("\nWaiting for admin verification...\n");
                                }
                                break;

                            case 2:
                                System.out.println("\n---YOUR STATUS---");
                                String checkStatus = studentStatus.get(currentUserIndex);
                                String checkJoined = studentJoinedClub.get(currentUserIndex);
                                String checkRequested = studentRequestedClub.get(currentUserIndex);
                                String checkLeaveReason = studentLeaveReason.get(currentUserIndex);

                                System.out.println("Student ID: " + studentIds.get(currentUserIndex));
                                System.out.println("Name: " + (studentNames.get(currentUserIndex) != null ? studentNames.get(currentUserIndex) : "Not Set"));
                                System.out.println("Year: " + (studentYears.get(currentUserIndex) != null ? studentYears.get(currentUserIndex) : "Not Set"));
                                System.out.println("Department: " + studentDepartments.get(currentUserIndex));
                                System.out.println("----------------------------------------");

                                if (checkStatus != null && "Active".equals(checkStatus)) {
                                    System.out.println("Status: Active Member");
                                    System.out.println("Club: " + (checkJoined != null ? checkJoined : "N/A") + "\n");

                                } else if (checkStatus != null && checkStatus.equals("Pending Leave")) {
                                    System.out.println("Status: Pending Leave Request\n");
                                    System.out.println("Current Club: " + (checkJoined != null ? checkJoined : "N/A"));
                                    System.out.println("Reason: " + (checkLeaveReason != null ? checkLeaveReason : "No reason provided"));
                                    System.out.println("Waiting for Admin Approval...\n");

                                } else if (checkStatus != null && checkStatus.equals("Pending")) {
                                    System.out.println("Status: Pending Verification\n");
                                    System.out.println("Requested Club: " + (checkRequested != null ? checkRequested : "N/A"));
                                    System.out.println("Waiting for Admin Verification...\n");

                                } else {
                                    System.out.println("Status: No Club\n");

                                }
                                System.out.print("\nPress Enter to go back...");
                                scanner.nextLine();
                                break;
                            
                            case 3:
                                System.out.println("\n---SCHOOL ACTIVITIES---");
                                System.out.println(schoolAnnouncement + "\n");
                                System.out.print("Press Enter to go back...");
                                scanner.nextLine();
                                break;

                            default:
                                System.out.println("\nInvalid Choice.\n");
                        }
                    }
                } 
                
                // -----------ADMIN MENU/DASHBOARD-------------------
                else {

                    while (adminRunning) {
                        System.out.println("---WELCOME: " + currentLoggedInName.toUpperCase() + "!---");
                        System.out.println("1. Verify JOIN Requests \n2. Verify LEAVE Requests \n3. View Members \n4. Post Activity/Event \n0. Log out");
                        System.out.print("Enter choice: ");
                        
                        int adminChoice = 0;
                        try {
                            adminChoice = scanner.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("\nInvalid input. Please enter a number.\n");
                            scanner.nextLine();
                            continue;
                        }
                        scanner.nextLine();
                    
                        switch (adminChoice) {
                            case 0:
                                System.out.println("\nLogging out...\n");
                                adminRunning = false;
                                break;
                                
                            case 1:
                                System.out.println("\n---PENDING JOIN REQUESTS---");
                                boolean hasPending = false;
                                
                                for (int i = 0; i < studentIds.size(); i++) {
                                    if (studentStatus.get(i) != null && studentStatus.get(i).equals("Pending")) {
                                        System.out.println("ID: " + studentIds.get(i));
                                        System.out.println("Name: " + (studentNames.get(i) != null ? studentNames.get(i) : "N/A"));
                                        System.out.println("Year: " + (studentYears.get(i) != null ? studentYears.get(i) : "N/A"));
                                        System.out.println("Department: " + studentDepartments.get(i));
                                        System.out.println("Requesting: " + (studentRequestedClub.get(i) != null ? studentRequestedClub.get(i) : "N/A"));
                                        System.out.println("----------------------------------------");
                                        hasPending = true;
                                    }
                                }
                            
                                if(hasPending) {
                                    System.out.print("\nEnter Student ID to VERIFY JOIN (or press Enter/0 to go back): ");
                                    String idToApprove = scanner.nextLine().trim();
                                    
                                    if(idToApprove.equals("0") || idToApprove.isEmpty()) {
                                        System.out.println("\nGoing back to dashboard...\n");
                                    } else {
                                        boolean foundId = false;
                                        for (int i = 0; i < studentIds.size(); i++) {
                                            if (studentIds.get(i).equals(idToApprove) && 
                                                studentStatus.get(i) != null && 
                                                studentStatus.get(i).equals("Pending")) {
                                                
                                                System.out.print("Approve this student? (1=Yes, 2=No, 0=Go Back): ");
                                                
                                                int approveChoice = 0;

                                                try {
                                                    approveChoice = scanner.nextInt();

                                                } catch (InputMismatchException e) {
                                                    System.out.println("\nInvalid input.\n");
                                                    scanner.nextLine();
                                                    break;

                                                }
                                                scanner.nextLine();
                                            
                                                if(approveChoice == 0){
                                                    System.out.println("\nGoing back to dashboard...\n");
                                                } else if(approveChoice == 1){
                                                    studentStatus.set(i, "Active");
                                                    studentJoinedClub.set(i, studentRequestedClub.get(i));
                                                    studentRequestedClub.set(i, null);
                                                    System.out.println("\nSUCCESS: Student " + studentNames.get(i) + " (" + studentIds.get(i) + ") is now a member of " + 
                                                        (studentJoinedClub.get(i) != null ? studentJoinedClub.get(i) : "the club") + "\n");

                                                } else if (approveChoice == 2) {
                                                    System.out.println("\nRequest Rejected.\n");
                                                    studentStatus.set(i, "No Club");
                                                    studentRequestedClub.set(i, null);

                                                } else {
                                                    System.out.println("\nInvalid choice. Request remains pending.\n");

                                                }
                                                foundId = true;
                                                break;
                                            }
                                        }
                                        if(!foundId) {
                                            System.out.println("\nID not found or no pending join request.\n");
                                        }
                                    }
                                } else {
                                    System.out.println("No pending join requests.");
                                    System.out.print("Press Enter to go back...");
                                    scanner.nextLine();
                                    System.out.println();
                                }
                                break;
                            
                            case 2:
                                System.out.println("\n---PENDING LEAVE REQUESTS---");
                                boolean hasLeaveReq = false;
                                
                                for (int i = 0; i < studentIds.size(); i++) {
                                    if (studentStatus.get(i) != null && studentStatus.get(i).equals("Pending Leave")) {
                                        System.out.println("ID: " + studentIds.get(i));
                                        System.out.println("Name: " + (studentNames.get(i) != null ? studentNames.get(i) : "N/A"));
                                        System.out.println("Wants to leave: " + (studentJoinedClub.get(i) != null ? studentJoinedClub.get(i) : "N/A"));
                                        System.out.println("Reason: " + (studentLeaveReason.get(i) != null ? studentLeaveReason.get(i) : "No reason provided"));
                                        System.out.println("----------------------------------------");
                                        hasLeaveReq = true;
                                    }
                                }
                            
                                if(hasLeaveReq) {
                                    System.out.print("\nEnter Student ID to PROCESS LEAVE (or press Enter/0 to go back): ");
                                    String idToLeave = scanner.nextLine().trim();
                                    
                                    if(idToLeave.equals("0") || idToLeave.isEmpty()) {
                                        System.out.println("\nGoing back to dashboard...\n");
                                    } else {
                                        boolean foundLeaveId = false;
                                        for (int i = 0; i < studentIds.size(); i++) {
                                            if (studentIds.get(i).equals(idToLeave) && 
                                                studentStatus.get(i) != null && 
                                                studentStatus.get(i).equals("Pending Leave")) {
                                                
                                                System.out.print("Allow this student to leave? (1=Yes, 2=No, 0=Go Back): ");
                                                
                                                int leaveChoice = 0;
                                                try {
                                                    leaveChoice = scanner.nextInt();
                                                } catch (InputMismatchException e) {
                                                    System.out.println("\nInvalid input.\n");
                                                    scanner.nextLine();
                                                    break;
                                                }
                                                scanner.nextLine();
                                            
                                                if(leaveChoice == 0){
                                                    System.out.println("\nGoing back to dashboard...\n");
                                                } else if(leaveChoice == 1){
                                                    System.out.println("\nStudent " + studentNames.get(i) + " (" + studentIds.get(i) + ") has left " + 
                                                        (studentJoinedClub.get(i) != null ? studentJoinedClub.get(i) : "the club") + ".\n");
                                                    studentStatus.set(i, "No Club");
                                                    studentJoinedClub.set(i, null);
                                                    studentLeaveReason.set(i, null);
                                                } else if (leaveChoice == 2) {
                                                    System.out.println("\nLeave request denied. Student " + studentNames.get(i) + " (" + studentIds.get(i) + ") remains in " + 
                                                        (studentJoinedClub.get(i) != null ? studentJoinedClub.get(i) : "the club") + ".\n");
                                                    studentStatus.set(i, "Active");
                                                    studentLeaveReason.set(i, null);
                                                } else {
                                                    System.out.println("\nInvalid choice. Request remains pending.\n");
                                                }
                                                foundLeaveId = true;
                                                break;
                                            }
                                        }
                                        if(!foundLeaveId) {
                                            System.out.println("\nID not found or no pending leave request.\n");
                                        }
                                    }
                                } else {
                                    System.out.println("No pending leave requests.");
                                    System.out.print("Press Enter to go back...");
                                    scanner.nextLine();
                                    System.out.println();
                                }
                                break;
                            
                            case 3:
                                System.out.println("\n---MEMBERSHIP REPORT---");
                                boolean hasMembers = false;
                                for (int i = 0; i < studentIds.size(); i++) {
                                    if (studentStatus.get(i) != null && studentStatus.get(i).equals("Active")) {
                                        System.out.println("ID: " + studentIds.get(i));
                                        System.out.println("Name: " + (studentNames.get(i) != null ? studentNames.get(i) : "N/A"));
                                        System.out.println("Year: " + (studentYears.get(i) != null ? studentYears.get(i) : "N/A"));
                                        System.out.println("Department: " + studentDepartments.get(i));
                                        System.out.println("Club: " + (studentJoinedClub.get(i) != null ? studentJoinedClub.get(i) : "N/A"));
                                        System.out.println("----------------------------------------");
                                        hasMembers = true;
                                    }
                                }
                                if(!hasMembers) System.out.println("No active members found.\n");
                                System.out.print("Press Enter to go back...");
                                scanner.nextLine();
                                System.out.println();
                                break;
                            
                            case 4:
                                System.out.println("\n---POST ANNOUNCEMENT---");
                                System.out.print("Current Announcement: " + schoolAnnouncement +"\nEnter new announcement/activity (0=Go Back): ");
                                String newEvent = scanner.nextLine();
                                
                                if(newEvent.trim().equals("0")) {
                                    System.out.println("\nGoing back to dashboard...\n");
                                    break;
                                }
                                
                                while(newEvent.trim().isEmpty()) {
                                    System.out.print("Announcement cannot be empty. Please enter announcement (0=Go Back): ");
                                    newEvent = scanner.nextLine();
                                    if(newEvent.trim().equals("0")) {
                                        System.out.println("\nGoing back to dashboard...\n");
                                        break;
                                    }
                                }
                                if(newEvent.trim().equals("0")) break;
                                
                                schoolAnnouncement = newEvent;
                                System.out.println("\nAnnouncement Updated!\n");
                                break;
                                
                            default:
                                System.out.println("\nInvalid Choice.\n");
                        }
                    }
                }
            }
        }
    }
}