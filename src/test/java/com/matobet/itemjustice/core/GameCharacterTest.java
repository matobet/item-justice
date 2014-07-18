package com.matobet.itemjustice.core;

import com.matobet.itemjustice.App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import javax.transaction.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@Transactional
public class GameCharacterTest {

    @Inject
    GameCharacterRepository gameCharacterRepository;

    @Inject
    GuildRepository guildRepository;

    @Test
    public void testCreate() {
        GameCharacter character = new GameCharacter("Killer", 47);
        gameCharacterRepository.save(character);

        GameCharacter persisted = gameCharacterRepository.findOne(character.getId());
        assertEquals(character, persisted);
    }

    @Test
    public void testCreateWithGuild() {
        Guild guild = new Guild("My Guild");
        guildRepository.save(guild);

        GameCharacter character = new GameCharacter("Haxxor", 13);
        character.setGuild(guild);
        gameCharacterRepository.save(character);

        GameCharacter persisted = gameCharacterRepository.findByName("Haxxor");
        assertEquals(guild, persisted.getGuild());
    }
}