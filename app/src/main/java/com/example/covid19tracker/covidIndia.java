package com.example.covid19tracker;

public class covidIndia {
    String stateName;
    String totalCases;
    String activeCases;
    String recovered;
    String totalDeaths;

    public covidIndia(String stateName, String totalCases, String activeCases, String recovered, String totalDeaths) {
        this.stateName = stateName;
        this.totalCases = totalCases;
        this.activeCases = activeCases;
        this.recovered = recovered;
        this.totalDeaths = totalDeaths;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getTotalCases() {
        return totalCases;
    }

    public void setTotalCases(String totalCases) {
        this.totalCases = totalCases;
    }

    public String getActiveCases() {
        return activeCases;
    }

    public void setActiveCases(String activeCases) {
        this.activeCases = activeCases;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getTotalDeaths() {
        return totalDeaths;
    }

    public void setTotalDeaths(String totalDeaths) {
        this.totalDeaths = totalDeaths;
    }
}
