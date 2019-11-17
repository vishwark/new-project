package com.example.pollutioncontrolboard.data.model;

public class Pollutant {
    private String pollutantName;
    private String pollutantValue;

    public Pollutant(String pollutantName, String pollutantValue) {
        this.pollutantName = pollutantName;
        this.pollutantValue = pollutantValue;
    }

    public String getPollutantName() {
        return pollutantName;
    }

    public void setPollutantName(String pollutantName) {
        this.pollutantName = pollutantName;
    }

    public String getPollutantValue() {
        return pollutantValue;
    }

    public void setPollutantValue(String pollutantValue) {
        this.pollutantValue = pollutantValue;
    }
}