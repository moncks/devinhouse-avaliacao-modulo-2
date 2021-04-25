package br.com.devinhouse.projeto4.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devinhouse.projeto4.dto.ProcessoDTO;
import br.com.devinhouse.projeto4.repository.ProcessoRepository;

@Service
public class ProcessoService {

	@Autowired
	private ProcessoRepository repository;

	private List<ProcessoDTO> recuperarTodosProcessos() {
		return repository.findAllProcessos();
	}

	public List<ProcessoDTO> recuperarProcessosMockados() {

		return recuperarTodosProcessos();
	}

	public List<ProcessoDTO> recuperarProcessosMockados(Integer id) {

		List<ProcessoDTO> todosProcessos = recuperarTodosProcessos();
		List<ProcessoDTO> listProcessoFiltrados = new ArrayList<ProcessoDTO>();
		System.out.println(listProcessoFiltrados);

		for (ProcessoDTO processoDTO : todosProcessos) {

			if (id == (processoDTO.getId())) {
				listProcessoFiltrados.add(processoDTO);
			}

		}

		return listProcessoFiltrados;
	}

	public List<ProcessoDTO> recuperarProcessosMockados(String chaveProcesso) {

		List<ProcessoDTO> todosProcessos = recuperarTodosProcessos();
		List<ProcessoDTO> listProcessoFiltrados = new ArrayList<ProcessoDTO>();

		for (ProcessoDTO processoDTO : todosProcessos) {

			if (chaveProcesso.equals(processoDTO.getChaveProcesso())) {
				listProcessoFiltrados.add(processoDTO);
			}

		}

		return listProcessoFiltrados;
	}

	public List<ProcessoDTO> cadastrarProcesso(ProcessoDTO processo) {

		List<ProcessoDTO> todosProcessos = recuperarTodosProcessos();

		todosProcessos.add(processo);

		return todosProcessos;
	}

	public List<ProcessoDTO> atualizarProcesso(Integer id, ProcessoDTO newProcesso) {

		List<ProcessoDTO> todosProcessos = recuperarTodosProcessos();

		for (ProcessoDTO processoDTO : todosProcessos) {

			if (id == processoDTO.getId()) {
				if (processoDTO.getChaveProcesso() != null) {
					processoDTO.setChaveProcesso(newProcesso.getChaveProcesso());
				}

				if (processoDTO.getSgOrgaoProcesso() != null) {
					processoDTO.setSgOrgaoProcesso(newProcesso.getSgOrgaoProcesso());
				}
				if (processoDTO.getNuProcesso() != null) {
					processoDTO.setNuProcesso(newProcesso.getNuProcesso());
				}
				if (processoDTO.getNuAnoProcesso() != null) {
					processoDTO.setNuAnoProcesso(newProcesso.getNuAnoProcesso());
				}
				if (processoDTO.getCdAssunto() != null) {
					processoDTO.setCdAssunto(newProcesso.getCdAssunto());
				}
				if (processoDTO.getDescricaoAssunto() != null) {
					processoDTO.setDescricaoAssunto(newProcesso.getDescricaoAssunto());
				}
				if (processoDTO.getDescricao() != null) {
					processoDTO.setDescricao(newProcesso.getDescricao());
				}
				if (processoDTO.getCdInteressado() != null) {
					processoDTO.setCdInteressado(newProcesso.getCdInteressado());
				}
				if (processoDTO.getNmInteressado() != null) {
					processoDTO.setNmInteressado(newProcesso.getNmInteressado());
				}

			}

		}
		return todosProcessos;
	}

	public List<ProcessoDTO> deletaProcesso(Integer id) {
		System.out.println(id);
		List<ProcessoDTO> todosProcessos = recuperarTodosProcessos();
			
		for(int i = 0; i < todosProcessos.size(); i++) {
			if(id == todosProcessos.get(i).getId()) {
				todosProcessos.remove(i);
				
			}
		}
/*
		for (ProcessoDTO processoDTO : todosProcessos) {
			System.out.println(processoDTO.getId());
			if (id == (processoDTO.getId())) {
				System.out.println(processoDTO.getId());
				System.out.println(todosProcessos);
				todosProcessos.remove(processoDTO);
				System.out.println(todosProcessos);

			}

		}
		*/
		
		return todosProcessos;

	}

}
/*
 * "id": 1, "chaveProcesso": "SOFT 1/2020", "sgOrgaoProcesso": "SOFT",
 * "nuProcesso": 1, "nuAnoProcesso": "2020", "cdAssunto": 1, "descricaoAssunto":
 * "Assunto 1 de testes DEV In House ", "descricao": "TESTE PUT ",
 * "cdInteressado": 1, "nmInteressado": "Jão Antonio ::: 0"
 */