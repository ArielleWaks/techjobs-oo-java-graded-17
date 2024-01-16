package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private final int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;


    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job job)) return false;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    private String noDataIfEmpty(String fieldValue) {
        if (fieldValue == null || fieldValue.isEmpty()) {
            return "Data not available";
        }
        return fieldValue;
    }

    @Override
    public String toString() {

        if (
                name == null
                && employer == null
                && location == null
                && positionType == null
                && coreCompetency == null
        ) {
            return System.lineSeparator() + "OOPS! This job does not seem to exist." + System.lineSeparator();
        }



        return System.lineSeparator() +
                "ID: " + id + System.lineSeparator() +
                "Name: " + noDataIfEmpty(name) + System.lineSeparator() +
                "Employer: " + noDataIfEmpty(employer.getValue()) + System.lineSeparator() +
                "Location: " + noDataIfEmpty(location.getValue()) + System.lineSeparator() +
                "Position Type: " + noDataIfEmpty(positionType.getValue()) + System.lineSeparator() +
                "Core Competency: " + noDataIfEmpty(coreCompetency.getValue()) + System.lineSeparator()
                ;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
