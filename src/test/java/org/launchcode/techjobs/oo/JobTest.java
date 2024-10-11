package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here

//JOB TESTS

    //1)
    //Each Job object should have a unique ID that is an integer

    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();

        assertNotEquals("Error: The Job IDs should be unique!", job1.getId(), job2.getId());
    }

    //2)
    //Each Job object should contain five fields (other than id) — name, employer, location, positionType, and coreCompetency.
    // The data types for these five fields are String, Employer, Location, PositionType, and CoreCompetency, respectively.

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job = new Job(
                "Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence")
        );

        // Check that the class is correct
        //name
        assertTrue("Error: Name is not a String!", job.getName() instanceof String);
        assertEquals("Error: Name value is incorrect!", "Product tester", job.getName());

        //employer
        assertTrue("Error: Employer is not an Employer object!", job.getEmployer() instanceof Employer);
        assertEquals("Error: Employer value is incorrect!", "ACME", job.getEmployer().getValue());

        //location
        assertTrue("Error: Location is not a Location object!", job.getLocation() instanceof Location);
        assertEquals("Error: Location value is incorrect!", "Desert", job.getLocation().getValue());

        //positionType
        assertTrue("Error: PositionType is not a PositionType object!", job.getPositionType() instanceof PositionType);
        assertEquals("Error: PositionType value is incorrect!", "Quality control", job.getPositionType().getValue());

        //coreCompetency
        assertTrue("Error: CoreCompetency is not a CoreCompetency object!", job.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Error: CoreCompetency value is incorrect!", "Persistence", job.getCoreCompetency().getValue());
    }

    //3)
    //Two Job objects are considered equal if they have the same id value, even if one or more of the other fields differ.
    // Similarly, the two objects are NOT equal if their id values differ, even if all the other fields are identical.

    @Test
    public void testJobsForEquality() {
        //create two Job objects with identical field values but different IDs
        Job job1 = new Job(
                "Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence")
        );

        Job job2 = new Job(
                "Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence")
        );

        assertFalse("Error: Two jobs with different IDs should not be equal!", job1.equals(job2));
    }






}
