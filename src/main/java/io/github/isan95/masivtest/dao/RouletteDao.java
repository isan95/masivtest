package io.github.isan95.masivtest.dao;

import java.util.List;
import io.github.isan95.masivtest.db.tables.pojos.Roulette;

public interface RouletteDao {
	Roulette insert();
	List<Roulette> findAll();
}
