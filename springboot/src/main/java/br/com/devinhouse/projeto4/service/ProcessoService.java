package br.com.devinhouse.projeto4.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devinhouse.projeto4.dto.ProcessoDTO;
import br.com.devinhouse.projeto4.repository.ProcessoRepository;
//import ch.qos.logback.core.net.SyslogOutputStream;
//import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;

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

		if (todosProcessos.size() != 0) {
			int id = todosProcessos.size();
			id += 1;
			processo.setId(id);

			todosProcessos.add(processo);
		}
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

		List<ProcessoDTO> todosProcessos = recuperarTodosProcessos();

		for (int i = 0; i < todosProcessos.size(); i++) {
			if (id == todosProcessos.get(i).getId()) {
				todosProcessos.remove(i);

			}
		}

		return todosProcessos;

	}

}
