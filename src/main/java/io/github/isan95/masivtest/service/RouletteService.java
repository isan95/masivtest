package io.github.isan95.masivtest.service;

import java.util.List;
import io.github.isan95.masivtest.db.tables.pojos.Roulette;

public interface RouletteService {
	Roulette create();
	void update(Roulette roulette);
	List<Roulette> findAll();
	Roulette findById(Long id);
	boolean createBet(Roulette roulette);
	boolean closeBet(Long id);
}
