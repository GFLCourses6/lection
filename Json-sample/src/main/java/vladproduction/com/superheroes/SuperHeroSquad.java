package vladproduction.com.superheroes;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SuperHeroSquad {
    @JsonProperty("squadName")
    private String squadName;
    @JsonProperty("homeTown")
    private String homeTown;
    @JsonProperty("formed")
    private int formed;
    @JsonProperty("secretBase")
    private String secretBase;
    @JsonProperty("active")
    private boolean active;
    @JsonProperty("members")
    private List<Member> members;

    public String getSquadName() {
        return squadName;
    }

    public void setSquadName(String squadName) {
        this.squadName = squadName;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public int getFormed() {
        return formed;
    }

    public void setFormed(int formed) {
        this.formed = formed;
    }

    public String getSecretBase() {
        return secretBase;
    }

    public void setSecretBase(String secretBase) {
        this.secretBase = secretBase;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "SuperHeroSquad{" +
                "squadName='" + squadName + '\'' +
                ", homeTown='" + homeTown + '\'' +
                ", formed=" + formed +
                ", secretBase='" + secretBase + '\'' +
                ", active=" + active +
                ", members=\n" + members +
                '}';
    }

}
