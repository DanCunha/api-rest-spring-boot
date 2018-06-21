package br.com.fabriq.microservico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.fabriq.microservico.dao.ColaboradorDAO;
import br.com.fabriq.microservico.model.Colaborador;
import br.com.fabriq.microservico.model.Departamento;
import br.com.fabriq.microservico.model.Grafico;

@Controller
@RequestMapping("/colaborador")
public class ColaboradorController {
	
	@Autowired
	private ColaboradorDAO dao;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Colaborador> listar() {
		System.out.println("Lista Colaboradores");
		return dao.listar();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Colaborador> update(@RequestBody Colaborador colaborador) {
		Departamento dep = new Departamento();
		dep.setId(colaborador.getIddepartamento());
		colaborador.setDepartamento(dep);
		dao.salvar(colaborador);
	    return new ResponseEntity<Colaborador>(colaborador, HttpStatus.OK);
	}
	
	@RequestMapping("/{id}")
	@ResponseBody
	public Colaborador buscarPorId(@PathVariable("id") Integer id) {		
		return dao.find(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Integer id) {
		System.out.println("Delete ------------------------------");
		dao.excluir(dao.find(id));
	}	
	
	@RequestMapping(value = "/grafico", method = RequestMethod.GET)
	@ResponseBody
	public List<Grafico> grafico() {
		return dao.grafico();
	}

}
