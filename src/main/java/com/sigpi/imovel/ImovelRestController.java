package com.sigpi.imovel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value="/imovel")
public class ImovelRestController {
	
	@Autowired
	private ImovelService imovelService;
	
	@GetMapping
	public List<Imovel> buscarTodas() {
		return imovelService.listarTodas();
	}
	
	@GetMapping("/disponiveis")
	public List<Imovel> buscarTodasDisponiveis() {
		return imovelService.listarTodas();
	}
	
	@GetMapping("/{id}")
	public Imovel buscarPorId(@PathVariable("id") Integer id) {
		return imovelService.buscarPorId(id);
	}
	
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Imovel salvar(@RequestBody ImovelRequest req) {
        return imovelService.salvar(req);
    }
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable("id") Integer id) {
		imovelService.deletar(id);
	}
		
}
