import junit.framework.TestCase;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PersonTest
        extends TestCase {

    public void currentTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
    }

    @BeforeClass
    void beforeClass() {
        System.out.println("Before class");
        currentTime();
    }

    @AfterClass
    void afterClass() {
        System.out.println("After class");
        currentTime();
    }

    @DataProvider(name = "PersonAgeTrue")
    Object[][] PersonAgeTrue() {
        return new Object[][]{
                {13},
                {14},
                {18},
                {19}


        };
    }

    @DataProvider(name = "PersonAgeFalse")
    Object[][] PersonAgeFalse() {
        return new Object[][]{
                {12},
                {20}
        };
    }

    @Test(dataProvider = "PersonAgeTrue")
    public void PersonAgeTrue(int arg1) {
        System.out.println("Below results should be true");
        System.out.println(Person.isTeenager(arg1));
        boolean result = Person.isTeenager(arg1);
        assertEquals(true, result);

    }

    @Test(dataProvider = "PersonAgeFalse")
    public void PersonAgeFalse(int arg1) {
        System.out.println("Below results should be false");
        System.out.println(Person.isTeenager(arg1));
        boolean result = Person.isTeenager(arg1);
        assertEquals(false, result);

    }
}