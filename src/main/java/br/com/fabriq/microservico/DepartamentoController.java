package br.com.fabriq.microservico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.fabriq.microservico.dao.DepartamentoDAO;
import br.com.fabriq.microservico.model.Departamento;

@Controller
@RequestMapping("/departamento")
public class DepartamentoController {

	@Autowired
	private DepartamentoDAO dao;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Departamento> listar() {
		System.out.println("Lista Departamento");
		return dao.listar();
	}
}
