package br.com.devinhouse.projeto4.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.devinhouse.projeto4.dto.ProcessoDTO;
import br.com.devinhouse.projeto4.service.ProcessoService;

@RestController
@RequestMapping(value = "/processos")
public class ProcessosController {

	@Autowired
	private ProcessoService service;

	// 1 - Deverá haver um endpoint para criação de um processo;
	@RequestMapping(headers = "api-version=v1", value = "/v1"
			+ "/cadastro/processo", method = POST, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<ProcessoDTO> cadastrarProcesso(@RequestBody ProcessoDTO processo) {
		return service.cadastrarProcesso(processo);
	}

//2 - Deverá haver um endpoint para listagem de todos os processos, retornando todos os atributos de cada processo; 
	@RequestMapping(headers = "api-version=v1", value = "/v1"
			+ "/consulta", method = GET, produces = APPLICATION_JSON_VALUE)

	@ResponseBody
	@ResponseStatus(code = HttpStatus.OK)
	public List<ProcessoDTO> recuperarListaProcessos() {
		return service.recuperarProcessosMockados();
	}

//3 - Deverá haver um endpoint para buscar um processo baseado na sua identificação única (id);	
	@RequestMapping(headers = "api-version=v1", value = "/v1"
			+ "/consulta/id/{id}", method = GET, produces = APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<ProcessoDTO> recuperarListaProcessosPath(@PathVariable Integer id) {
		return service.recuperarProcessosMockados(id);
	}

	// 4 - Deverá haver um endpoint para buscar um processo baseado no seu número de
	// processo (chaveProcesso);
	@RequestMapping(headers = "api-version=v1", value = "/v1"
			+ "/consulta/chave", method = GET, produces = APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<ProcessoDTO> recuperarListaProcessosPath(@RequestParam String chaveProcesso) {
		return service.recuperarProcessosMockados(chaveProcesso);
	}

	// 5 - Deverá haver um endpoint para atualização de todos os atributos de um
	// processo baseado na sua identificação única (id);
	@RequestMapping(headers = "api-version=v1", value = "/v1"
			+ "/atualizar/processo/{id}", method = PUT, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<ProcessoDTO> atualizarInfoProcesso(@PathVariable Integer id, @RequestBody ProcessoDTO newProcesso) {

		return service.atualizarProcesso(id, newProcesso);
	}

//6 - Deverá haver um endpoint para exclusão de um processo baseado na sua identificação única (id);
	@RequestMapping(headers = "api-version=v1", value = "/v1"
			+ "/deletar/id/{id}", method = DELETE, produces = APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(code = HttpStatus.OK)
	public List<ProcessoDTO> deletaProcesso(@PathVariable Integer id) {
		return service.deletaProcesso(id);

	}

}
