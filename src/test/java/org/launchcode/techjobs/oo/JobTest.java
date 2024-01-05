package org.launchcode.techjobs.oo;


import org.junit.Test;
import static org.junit.Assert.*;

public class JobTest {
    //Create your unit tests here
    @Test
    public void testSettingJobId() {
        Job job_test = new Job();
        Job second_job_test = new Job();
        assertNotEquals(job_test.getId(), second_job_test.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job_test = new Job(
                "Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence")
        );
        assertEquals(job_test.getName(), "Product tester");

        assertTrue(job_test.getEmployer() instanceof Employer);
        assertEquals(job_test.getEmployer().getValue(), "ACME");

        assertTrue(job_test.getLocation() instanceof Location);
        assertEquals(job_test.getLocation().getValue(), "Desert");

        assertTrue(job_test.getPositionType() instanceof PositionType);
        assertEquals(job_test.getPositionType().getValue(), "Quality control");

        assertTrue(job_test.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(job_test.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        Job job_test = new Job(
                "Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence")
        );
        Job second_job_test = new Job(
                "Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence")
        );
        assertTrue(job_test.equals(job_test));
        assertFalse(job_test.equals(second_job_test));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job_test = new Job();
        assertTrue(job_test.toString().startsWith(System.lineSeparator()));
        assertTrue(job_test.toString().endsWith(System.lineSeparator()));
    }


    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        String aName = "Product tester";
        String aEmployer = "ACME";
        String aLocation = "Desert";
        String aPositionType = "Quality control";
        String aCoreCompetency = "Persistence";
        Job job_test = new Job(
                aName,
                new Employer(aEmployer),
                new Location(aLocation),
                new PositionType(aPositionType),
                new CoreCompetency(aCoreCompetency)
        );
        assertEquals(
                System.lineSeparator() + "ID: " + job_test.getId()
                + System.lineSeparator() + "Name: " + aName
                + System.lineSeparator() + "Employer: " + aEmployer
                + System.lineSeparator() + "Location: " + aLocation
                + System.lineSeparator() + "Position Type: " + aPositionType
                + System.lineSeparator() + "Core Competency: " + aCoreCompetency
                + System.lineSeparator()
                , job_test.toString()
        );
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job_test = new Job(
                "Product tester", new Employer("ACME"), new Location(), new PositionType(), new CoreCompetency()
        );
        assertEquals(
                System.lineSeparator() + "ID: " + job_test.getId() + System.lineSeparator() +
                """
                Name: Product tester
                Employer: ACME
                Location: Data not available
                Position Type: Data not available
                Core Competency: Data not available
                """
                , job_test.toString()
        );
    }

    @Test
    public void testJobToStringMethodReturnsMessageGivenAllEmptyFields() {
        assertEquals(
                System.lineSeparator() + "OOPS! This job does not seem to exist." + System.lineSeparator()
                , new Job().toString()
        );
    }

}
