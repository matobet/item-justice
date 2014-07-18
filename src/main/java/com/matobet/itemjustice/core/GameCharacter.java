package com.matobet.itemjustice.core;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class GameCharacter extends AbstractNamedEntity {

    private int level;

    @ManyToOne
    private Guild guild;

    public GameCharacter(String name, int level) {
        super(name);
        this.level = level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public Guild getGuild() {
        return guild;
    }

    public void setGuild(Guild guild) {
        this.guild = guild;
    }

    @Override
    public String toString() {
        return "GameCharacter{" +
                "level=" + level +
                ", guild=" + guild +
                '}';
    }
}
