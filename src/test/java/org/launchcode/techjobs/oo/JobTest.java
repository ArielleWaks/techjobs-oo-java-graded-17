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
                "Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence")
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
                "Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence")
        );
        Job second_job_test = new Job(
                "Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence")
        );
        assertTrue(job_test.equals(job_test));
        assertFalse(job_test.equals(second_job_test));
    }

}
