import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        //given
        String actual = hamletParser.getHamletData();

        //when
        hamletText = hamletParser.replaceHamlet(hamletText);


        //then
        Assert.assertNotEquals(hamletText, actual);

    }

    @Test
    public void testChangeHoratioToTariq() {
        //given
        String actual = hamletParser.getHamletData();

        //when
        hamletText = hamletParser.replaceHoratio(hamletText);

        //then
        Assert.assertNotEquals(hamletText, actual);
    }

    @Test
    public void testFindHoratio() {
        hamletText = hamletParser.replaceHoratio(hamletText);
        Boolean check = hamletText.contains("HORATIO");

        Assert.assertFalse(check);
    }

    @Test
    public void testFindHamlet() {
        hamletText = hamletParser.replaceHamlet(hamletText);
        Boolean check = hamletText.contains("HAMLET");

        Assert.assertFalse(check);
    }
}