package com.matobet.itemjustice.core;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GameCharacterRepository extends JpaRepository<GameCharacter, Integer> {
    GameCharacter findByName(String name);
}
