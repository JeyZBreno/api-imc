package api.controller;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.model.Imc;

@RestController
@RequestMapping("/imc")
public class ImcController {
	
	@GetMapping
	public ResponseEntity<String> gerarImc(@RequestBody Imc params){
		new Imc(params.getPeso(), params.getAltura());
		return ResponseEntity.ok(params.getRetorno());
	}

}
