package io.github.isan95.masivtest.dao;
import io.github.isan95.masivtest.db.tables.pojos.Roulette;
import io.github.isan95.masivtest.exception.ResourceNotFoundException;

import org.jooq.*;
import org.jooq.Record;
import org.jooq.impl.*;
import static io.github.isan95.masivtest.db.tables.Roulette.ROULETTE;

import java.util.List;

import org.jooq.DSLContext;
public class RouletteDaoImpl implements RouletteDao{
	private DSLContext context;
	public RouletteDaoImpl(DSLContext context) {
		this.context = context;
	}
	@Override
	public Roulette insert() {
	
		return context.insertInto(ROULETTE).columns(ROULETTE.STATE)
				.values("Cerrada").returning().fetchOne().into(Roulette.class);		
	}
	@Override
	public List<Roulette> findAll() {
		return context.select(ROULETTE.ID, (ROULETTE.STATE).as("Estado")).from(ROULETTE).fetch().into(Roulette.class);
	}

}
