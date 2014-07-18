package com.matobet.itemjustice.core;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Set;

@Entity
public class Guild extends AbstractNamedEntity {

    @OneToOne(fetch = FetchType.LAZY)
    private GameCharacter master;

    @OneToOne(fetch = FetchType.LAZY)
    private GameCharacter officer;

    @OneToMany(mappedBy = "guild", cascade = CascadeType.MERGE)
    private Set<GameCharacter> members;

    public Guild(String name) {
        super(name);
    }

    public void setMaster(GameCharacter master) {
        this.master = master;
    }

    public GameCharacter getMaster() {
        return master;
    }

    public GameCharacter getOfficer() {
        return officer;
    }

    public void setOfficer(GameCharacter officer) {
        this.officer = officer;
    }

    public Set<GameCharacter> getMembers() {
        return members;
    }

    @Override
    public String toString() {
        return "Guild{" +
                "master=" + master +
                ", officer=" + officer +
                '}';
    }
}
