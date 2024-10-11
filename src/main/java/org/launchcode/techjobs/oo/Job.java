package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    //CONSTRUCTORS
        // Constructor to initialize a unique ID
        public Job() {
            this.id = nextId;
            nextId++;
        }

        // Constructor to add ID and finish initializing the other fields
        public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
            this();
            this.name = name;
            this.employer = employer;
            this.location = location;
            this.positionType = positionType;
            this.coreCompetency = coreCompetency;
        }

     //METHODS
        // Custom equals method
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Job job = (Job) o;
            return id == job.id;
        }
        //Custom hashCode method
        @Override
        public int hashCode() {
            return Objects.hashCode(id);
        }

        // toString method
        @Override
        public String toString() {
            String output = System.lineSeparator();

            // If the job only has an ID, return error message.
            if ((name == null || name.isEmpty()) &&
                    (employer == null || employer.getValue().isEmpty()) &&
                    (location == null || location.getValue().isEmpty()) &&
                    (positionType == null || positionType.getValue().isEmpty()) &&
                    (coreCompetency == null || coreCompetency.getValue().isEmpty())) {
                return "OOPS! This job does not seem to exist.";
            }

            // Adding field labels and values with formatting
            output += "ID: " + id + System.lineSeparator();
            output += "Name: " + (name == null || name.isEmpty() ? "Data not available" : name) + System.lineSeparator();
            output += "Employer: " + (employer == null || employer.getValue().isEmpty() ? "Data not available" : employer.getValue()) + System.lineSeparator();
            output += "Location: " + (location == null || location.getValue().isEmpty() ? "Data not available" : location.getValue()) + System.lineSeparator();
            output += "Position Type: " + (positionType == null || positionType.getValue().isEmpty() ? "Data not available" : positionType.getValue()) + System.lineSeparator();
            output += "Core Competency: " + (coreCompetency == null || coreCompetency.getValue().isEmpty() ? "Data not available" : coreCompetency.getValue()) + System.lineSeparator();

            return output;
        }


    // Getters
        public String getName() {
            return name;
        }

        public Employer getEmployer() {
            return employer;
        }

        public Location getLocation() {
            return location;
        }

        public PositionType getPositionType() {
            return positionType;
        }

        public CoreCompetency getCoreCompetency() {
            return coreCompetency;
        }

    public int getId() {
        return id;
    }

    // Setters
        public void setName(String name) {
            this.name = name;
        }

        public void setEmployer(Employer employer) {
            this.employer = employer;
        }

        public void setLocation(Location location) {
            this.location = location;
        }

        public void setPositionType(PositionType positionType) {
            this.positionType = positionType;
        }

        public void setCoreCompetency(CoreCompetency coreCompetency) {
            this.coreCompetency = coreCompetency;
        }
    }

