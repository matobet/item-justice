package com.matobet.itemjustice.core;

import com.matobet.itemjustice.App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@Transactional
public class GuildTest {

    @Inject
    GuildRepository guildRepository;

    @Inject
    GameCharacterRepository gameCharacterRepository;

    @Test
    public void testCreate() {
        Guild guild = new Guild("My Fancy Guild");

        guildRepository.save(guild);

        assertEquals(guild, guildRepository.findOne(guild.getId()));
    }

    @Test
    public void testCreateWithMaster() {
        Guild guild = new Guild("My Fancy Guild");

        GameCharacter character = new GameCharacter("Charz", 99);
        gameCharacterRepository.save(character);

        guild.setMaster(character);

        guildRepository.save(guild);

        assertEquals(character, guildRepository.findByName("My Fancy Guild").getMaster());
    }

    @Inject
    EntityManager entityManager;

    @Test
    public void testCreateWithMembers() {
        Guild guild = new Guild("Multi Guild");

        GameCharacter master = new GameCharacter("Charz", 99);
        master.setGuild(guild);

        guild.setMaster(master);

        gameCharacterRepository.save(master);
        entityManager.persist(guild);
        entityManager.persist(master);

        for (int i = 0; i < 7; i++) {
            GameCharacter character = new GameCharacter("Player #" + i, i);
            character.setGuild(guild);
            gameCharacterRepository.save(character);

            assertEquals(guild, character.getGuild());
        }

        guildRepository.save(guild);

        Guild persisted = guildRepository.findOne(guild.getId());
        assertEquals(8, gameCharacterRepository.count());
        entityManager.refresh(persisted);
        assertEquals("Multi Guild", persisted.getName());
        assertEquals(8, persisted.getMembers().size());
    }
}