package io.github.isan95.masivtest.db.tables.daos;
import io.github.isan95.masivtest.db.tables.Roulette;
import io.github.isan95.masivtest.db.tables.records.RouletteRecord;
import java.util.List;
import javax.annotation.Generated;
import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RouletteDao extends DAOImpl<RouletteRecord, io.github.isan95.masivtest.db.tables.pojos.Roulette, Long> {
    public RouletteDao() {
        super(Roulette.ROULETTE, io.github.isan95.masivtest.db.tables.pojos.Roulette.class);
    }
    public RouletteDao(Configuration configuration) {
        super(Roulette.ROULETTE, io.github.isan95.masivtest.db.tables.pojos.Roulette.class, configuration);
    }
    @Override
    public Long getId(io.github.isan95.masivtest.db.tables.pojos.Roulette object) {
        return object.getId();
    }
    public List<io.github.isan95.masivtest.db.tables.pojos.Roulette> fetchRangeOfId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(Roulette.ROULETTE.ID, lowerInclusive, upperInclusive);
    }
    public List<io.github.isan95.masivtest.db.tables.pojos.Roulette> fetchById(Long... values) {
        return fetch(Roulette.ROULETTE.ID, values);
    }
    public io.github.isan95.masivtest.db.tables.pojos.Roulette fetchOneById(Long value) {
        return fetchOne(Roulette.ROULETTE.ID, value);
    }
    public List<io.github.isan95.masivtest.db.tables.pojos.Roulette> fetchRangeOfState(String lowerInclusive, String upperInclusive) {
        return fetchRange(Roulette.ROULETTE.STATE, lowerInclusive, upperInclusive);
    }
    public List<io.github.isan95.masivtest.db.tables.pojos.Roulette> fetchByState(String... values) {
        return fetch(Roulette.ROULETTE.STATE, values);
    }
    public List<io.github.isan95.masivtest.db.tables.pojos.Roulette> fetchRangeOfCustomer(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Roulette.ROULETTE.CUSTOMER, lowerInclusive, upperInclusive);
    }
    public List<io.github.isan95.masivtest.db.tables.pojos.Roulette> fetchByCustomer(Integer... values) {
        return fetch(Roulette.ROULETTE.CUSTOMER, values);
    }
    public List<io.github.isan95.masivtest.db.tables.pojos.Roulette> fetchRangeOfBetAmount(Double lowerInclusive, Double upperInclusive) {
        return fetchRange(Roulette.ROULETTE.BET_AMOUNT, lowerInclusive, upperInclusive);
    }
    public List<io.github.isan95.masivtest.db.tables.pojos.Roulette> fetchByBetAmount(Double... values) {
        return fetch(Roulette.ROULETTE.BET_AMOUNT, values);
    }
    public List<io.github.isan95.masivtest.db.tables.pojos.Roulette> fetchRangeOfBetNumberOrColor(String lowerInclusive, String upperInclusive) {
        return fetchRange(Roulette.ROULETTE.BET_NUMBER_OR_COLOR, lowerInclusive, upperInclusive);
    }
    public List<io.github.isan95.masivtest.db.tables.pojos.Roulette> fetchByBetNumberOrColor(String... values) {
        return fetch(Roulette.ROULETTE.BET_NUMBER_OR_COLOR, values);
    }
    public List<io.github.isan95.masivtest.db.tables.pojos.Roulette> fetchRangeOfWinningNumberOrColor(String lowerInclusive, String upperInclusive) {
        return fetchRange(Roulette.ROULETTE.WINNING_NUMBER_OR_COLOR, lowerInclusive, upperInclusive);
    }
    public List<io.github.isan95.masivtest.db.tables.pojos.Roulette> fetchByWinningNumberOrColor(String... values) {
        return fetch(Roulette.ROULETTE.WINNING_NUMBER_OR_COLOR, values);
    }
    public List<io.github.isan95.masivtest.db.tables.pojos.Roulette> fetchRangeOfEarnedMoney(Double lowerInclusive, Double upperInclusive) {
        return fetchRange(Roulette.ROULETTE.EARNED_MONEY, lowerInclusive, upperInclusive);
    }
    public List<io.github.isan95.masivtest.db.tables.pojos.Roulette> fetchByEarnedMoney(Double... values) {
        return fetch(Roulette.ROULETTE.EARNED_MONEY, values);
    }
}
