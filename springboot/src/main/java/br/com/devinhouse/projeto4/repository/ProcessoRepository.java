package br.com.devinhouse.projeto4.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.devinhouse.projeto4.dto.ProcessoDTO;
import br.com.devinhouse.projeto4.mock.ProcessoMock;

import java.util.List;



@Repository
public class ProcessoRepository {

	@Autowired
	private ProcessoMock processoMock;

	public List<ProcessoDTO> findAllProcessos() {
		return processoMock.getAllProcessos();
	}
}
