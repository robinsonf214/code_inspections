package labcodeinspection;

import java.util.Scanner;
import java.util.logging.Logger;
/**
*
*
* @author Robinson Flores
*/
@SuppressWarnings("PMD.UseUtilityClass")
public class EmailApp {

    private static final Logger log = Logger.getLogger(EmailApp.class.getName()); //NOPMD
    /**
    * @author Robinson Flores
    */
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in); //NOPMD

        log.info("Enter your first name: ");
        final String firstName = sc.nextLine();

        log.info("Enter your last name: ");
        final String lastName = sc.nextLine();

        log.info("\nDEPARTMENT CODE\n1. for sales\n2. for Development\n3. for accounting\nEnter code: ");
        final int depChoice = sc.nextInt();
        sc.close();

        final Email email = new Email(firstName, lastName);
        email.setDepartment(depChoice);
        email.generateEmail();
        email.showInfo();
    }
}
