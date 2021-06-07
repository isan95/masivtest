package io.github.isan95.masivtest.service;
import io.github.isan95.masivtest.dao.RouletteDaoImpl;
import io.github.isan95.masivtest.db.tables.daos.RouletteDao;
import java.util.List;
import java.util.Random;
import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;
import io.github.isan95.masivtest.db.tables.pojos.Roulette;
@Service
public class RouletteServiceImpl implements RouletteService{
	private final static Double WINBYNUMBER = 5.0;
	private final static Double WINBYCOLOR = 1.8;
	private final RouletteDao rouletteDao;
	private final RouletteDaoImpl rouletteDao2;
	private final DSLContext dsl;
	private final TransactionTemplate transactionTemplate;
	public RouletteServiceImpl(DSLContext dsl, Configuration jooqConfiguration,
			TransactionTemplate transactionTemplate) {
		this.rouletteDao = new RouletteDao(jooqConfiguration);
		this.rouletteDao2 = new RouletteDaoImpl(dsl);
		this.dsl = dsl;
		this.transactionTemplate = transactionTemplate;
		  }
	@Override
	public Roulette create() {
		return rouletteDao2.insert();
	}
	@Override
	public void update(Roulette roulette) {
		this.rouletteDao.update(roulette);
	}
	@Override
	public List<Roulette> findAll() {
		return rouletteDao.findAll();
	}
	@Override
	public Roulette findById(Long id) {
		return rouletteDao.findById(id);
	}
	@Override
	public boolean createBet(Roulette roulette) {
		if(isValidNumberColor(roulette.getBetNumberOrColor()) && roulette.getState().equals("Abierta")) {
			rouletteDao.update(roulette);
			return true;
		}
		return false;
	}
	@Override
	public boolean closeBet(Long idRoulette) {
		Roulette roulette = rouletteDao.findById(idRoulette);
		String winningNumber = calculateWinningNumber();
		if(isNumeric(roulette.getBetNumberOrColor())) {
			if(roulette.getBetNumberOrColor().equals(winningNumber)) {
				roulette.setWinningNumberOrColor(winningNumber);
				roulette.setEarnedMoney(roulette.getBetAmount()*WINBYNUMBER);
				roulette.setState("Cerrada");
				rouletteDao.update(roulette);
				return true;
			}
		}
		else {
			if(determinateWinningColor(winningNumber).equals(roulette.getBetNumberOrColor())) {
				roulette.setWinningNumberOrColor(determinateWinningColor(winningNumber));
				roulette.setEarnedMoney(roulette.getBetAmount()*WINBYCOLOR);
				roulette.setState("Cerrada");
				rouletteDao.update(roulette);
				return true;
			}
		}
		return false;
	}
	private String determinateWinningColor(String winningNumber) {
		Integer intWinningNumber = Integer.parseInt(winningNumber);
		if(intWinningNumber%2 == 0) {
			return "rojo";
		}
		return "negro";
	}
	private String calculateWinningNumber() {
		Random rand = new Random();
	      Integer upperbound = 37;
	      int int_random = rand.nextInt(upperbound);
	      return Integer.toString(int_random);
	}
	private boolean isNumeric(String numberOrColor) {
        boolean isNumeric = true;
        for (int i = 0; i < numberOrColor.length(); i++) {
            if (!Character.isDigit(numberOrColor.charAt(i))) {
                isNumeric = false;
            }
        }
        return isNumeric;
	}
	private boolean isValidNumberColor(String numberOrColor) {
		if(isNumeric(numberOrColor)) {
			Integer numberAux = Integer.parseInt(numberOrColor);
			return numberAux>=0 && numberAux<=36;
		}
		else {
			return numberOrColor.toLowerCase().equals("rojo") || numberOrColor.toLowerCase().equals("negro");
		}
	}
}