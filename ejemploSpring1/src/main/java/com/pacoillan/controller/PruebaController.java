package com.pacoillan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pacoillan.objetos.Categoria;
import com.pacoillan.repository.CategoriaRepository;

@Controller
public class PruebaController {
	
	@Autowired
	CategoriaRepository cr;
	
	@RequestMapping("/inicio")
	public String inicio(Model modelo) {
		
		System.out.println("INICIO");
		
		
		List<Categoria> lista = cr.buscaTodas();
		for (Categoria c: lista) {
			System.out.println("Categoria "+ c.getNombreCategoria());
		}
		
		modelo.addAttribute("listaCategorias",lista);
		
		return "inicio";
		
	}

}
