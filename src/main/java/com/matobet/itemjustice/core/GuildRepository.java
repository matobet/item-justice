package com.matobet.itemjustice.core;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GuildRepository extends JpaRepository<Guild, Integer> {
    Guild findByName(String name);
}
