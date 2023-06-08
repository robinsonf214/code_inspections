package labcodeinspection;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
*
*
* @author Robinson Flores
*/
public class Email {
	/**
	* log comment 
	*/
    private static final Logger log = Logger.getLogger(Email.class.getName());
    /**
	* Parameters 
	*/
    private final String firstName;
    private final String lastName; //NOPMD 
    private String password = null; //NOPMD 
    private String department; //NOPMD 
    private int defaultPasswordLength = 8; //NOPMD 
    private String email; //NOPMD  

    public Email(String firstName, String lastName) { //NOPMD 
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void showInfo() { //NOPMD 
        if (log.isLoggable(Level.INFO)) {
            log.info("\nFIRST NAME: " + firstName + "\nLAST NAME: " + lastName);
            log.info("DEPARTMENT: " + department + "\nEMAIL: " + email + "\nPASSWORD: " + password);
        }
    }

    public void setDepartment(final int depChoice) { 
        switch (depChoice) {
            case 1:
                this.department = "sales";
                break;
            case 2:
                this.department = "dev";
                break;
            case 3:
                this.department = "acct";
                break;
            default:
                if (log.isLoggable(Level.WARNING)) {
                    log.warning("Invalid department code. Setting department to 'unknown'.");
                }
                this.department = "unknown";
        }
    }

    private String generateRandomPassword(final int length) {
        final String set = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890#$&@*";
        final StringBuilder passwordBuilder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            final int rand = (int) (Math.random() * set.length());
            passwordBuilder.append(set.charAt(rand));
        }

        return passwordBuilder.toString();
    }

    public void generateEmail() { //NOPMD 
        this.password = generateRandomPassword(defaultPasswordLength);
        this.email = firstName.toLowerCase() + lastName.toLowerCase() + "@" + department + ".espol.edu.ec"; // NOPMD by Administrador on 7/6/23 22:10
    }
}

