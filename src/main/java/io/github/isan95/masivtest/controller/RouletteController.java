package io.github.isan95.masivtest.controller;

import java.util.List;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.github.isan95.masivtest.db.tables.pojos.Roulette;
import io.github.isan95.masivtest.service.RouletteServiceImpl;
import io.github.isan95.masivtest.payload.response.MessageResponse;
@CrossOrigin(origins="*", maxAge=3600)
@RestController
@RequestMapping("/api/roulette")
public class RouletteController {
	@Autowired
	private RouletteServiceImpl rouletteService;
	@PostMapping("/create")
	public ResponseEntity<?> createRoulette(){
		Roulette roulette = rouletteService.create();
		return ResponseEntity.ok().body(new MessageResponse("Ruleta creada con exito id: " + roulette.getId()));
	}
	@GetMapping("/list")
	public ResponseEntity<List<Roulette>> listRoulette(){
		List<Roulette> listRoulette = rouletteService.findAll();
		listRoulette.stream().forEach(System.out::println);
		return ResponseEntity.ok().body(listRoulette);
	}
	@PutMapping("/open/{id}")
	public ResponseEntity<?> openRoulette(@PathVariable Long id){
		Roulette roulette = rouletteService.findById(id);
		System.out.println(roulette);
		roulette.setState("Abierta");
		System.out.println(roulette);
		rouletteService.update(roulette);
		return ResponseEntity.ok(new MessageResponse("Ruleta con id: "+roulette.getId()+" fue abierta con exito"));
	}
	@PutMapping("/bet/{idRoulette}")
	public ResponseEntity<?> bet(@PathVariable @Min(value=1) Long idRoulette,
			@RequestParam(value="numberColor") String betNumberOrColor, 
			@RequestParam(value="betAmount") 
			@Max(value=10000, message = "El monto de la apuesta es demasiado alto")
			@Min(value=1, message="Debe apostar al menos 1") Double betAmount,
			@RequestParam(value="customer") @Min(value=1, message="No existe Id menor 1") Integer idCustomer){
		Roulette roulette = rouletteService.findById(idRoulette);
		roulette.setBetNumberOrColor(betNumberOrColor);
		roulette.setBetAmount(betAmount);
		roulette.setCustomer(idCustomer);
		if(rouletteService.createBet(roulette)) {
			return ResponseEntity.ok(new MessageResponse("Apuesta hecha con exito"));
		}
		return ResponseEntity.badRequest().body(new MessageResponse("Datos de apuesta invalidos"));
	}
	@PutMapping("bet/close/{idRoulette}")
	public ResponseEntity<?> closeBet(@PathVariable Long idRoulette){
		if(rouletteService.closeBet(idRoulette)) {
			Roulette roulette = rouletteService.findById(idRoulette);
			return new ResponseEntity<>(roulette,HttpStatus.OK);
		}
		return ResponseEntity.badRequest().body(new MessageResponse("Esta apuesta no se puede cerrar"));
	}
}
