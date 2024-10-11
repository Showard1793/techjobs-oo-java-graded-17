package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here

//JOB TESTS

    //4.1)
    //Each Job object should have a unique ID that is an integer

    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();

        assertNotEquals("Error: The Job IDs should be unique!", job1.getId(), job2.getId());
    }

    //4.2)
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

    //4.3)
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

        assertNotEquals("Error: Two jobs with different IDs should not be equal!", job1, job2);
    }

    //5.1)
    //toString Method should start and end with new line.

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job(
                "Pooper Scooper",
                new Employer("Poop Scoops Inc."),
                new Location("Detroit"),
                new PositionType("Servant"),
                new CoreCompetency("Attention to detail, must be able to lift 50 pounds of poop, and have PHD in scooping")
        );

        String expectedOutput =
                System.lineSeparator() +
                        "ID: " + job.getId() + System.lineSeparator() +
                        "Name: Pooper Scooper" + System.lineSeparator() +
                        "Employer: Poop Scoops Inc." + System.lineSeparator() +
                        "Location: Detroit" + System.lineSeparator() +
                        "Position Type: Servant" + System.lineSeparator() +
                        "Core Competency: Attention to detail, must be able to lift 50 pounds of poop, and have PHD in scooping" + System.lineSeparator();

        String actualOutput = job.toString();

        assertEquals("Error: toString() should start and end with a new line!", expectedOutput, actualOutput);
    }

    //5.2)
    //toString should format data correctly

    @Test
    public void testToStringContainsCorrectLabelsAndData () {

        Job job = new Job(
                "Tester",
                new Employer("Test USA"),
                new Location("Testville"),
                new PositionType("Test Pro"),
                new CoreCompetency("Testing")
        );

        //Expected string
        String expectedOutput =
                System.lineSeparator() +
                        "ID: " + job.getId() + System.lineSeparator() +
                        "Name: Tester" + System.lineSeparator() +
                        "Employer: Test USA" + System.lineSeparator() +
                        "Location: Testville" + System.lineSeparator() +
                        "Position Type: Test Pro" + System.lineSeparator() +
                        "Core Competency: Testing" + System.lineSeparator();

        //Actual string from toString() method
        String actualOutput = job.toString();

        //Check if correctly formatted
        assertEquals("Error: toString() is not formatted correctly!", expectedOutput, actualOutput);
    }

    //5.3
    //toString should replace empty fields with "Data not available"

    @Test
    public void testToStringHandlesEmptyField() {

        Job job = new Job(
                "",
                new Employer("Intergalactic Pizza Delivery"),
                new Location("Planet of the Naps"),
                new PositionType(""),
                new CoreCompetency("")
        );

        String expectedOutput =
                System.lineSeparator() +
                        "ID: " + job.getId() + System.lineSeparator() +
                        "Name: Data not available" + System.lineSeparator() +
                        "Employer: Intergalactic Pizza Delivery" + System.lineSeparator() +
                        "Location: Planet of the Naps" + System.lineSeparator() +
                        "Position Type: Data not available" + System.lineSeparator() +
                        "Core Competency: Data not available" + System.lineSeparator();


        String actualOutput = job.toString();

        assertEquals("Error: toString() did not handle empty fields correctly!", expectedOutput, actualOutput);
    }

    //5.4
    //toString correctly handles objects with only IDs

    @Test
    public void testToStringHandlesOnlyIdData() {

        Job job = new Job();

        String expectedOutput = "OOPS! This job does not seem to exist.";

        String actualOutput = job.toString();

        assertEquals("Error: toString() did not return correct message!", expectedOutput, actualOutput);
    }


}
