package com.SuperMasters.Ciclo3.controllers;

import com.SuperMasters.Ciclo3.entities.Empresa;
import com.SuperMasters.Ciclo3.services.EmpresaServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


//Controlador para HTML
@Controller
public class EmpresaCont {

	@Autowired
	EmpresaServ empresaServ;

	//Mostrar todas las empresas en HTML
	@GetMapping({"/", "/empresas"})
	public String viewEmpresas(Model model, @ModelAttribute("message") String message) {
		List<Empresa> empresas = empresaServ.getAll();
		model.addAttribute("empresas", empresas);
		model.addAttribute("message", message);
		return "empresas"; //Llamamos al archivo empresas.html en la carpeta templates (resources/templates)
	}

	//Ir a la pagina para crear una empresa
	@GetMapping("/empresas/new")
	public String newEmpresa(Model model, @ModelAttribute("message") String message) {
		Empresa empresa = new Empresa();
		model.addAttribute("message", message);
		model.addAttribute("empresa", empresa);
		return "new_empresa";//Llamamos al archivo new_empresa.html en la carpeta templates (resources/templates)
	}

	//Guardar una empresa en la base de datos y volver a la pagina de empresas
	@PostMapping("/empresas/save")
	public String saveEmpresa(Empresa empresa, RedirectAttributes redirectAttributes) {
		if (empresaServ.saveOrUpdate(empresa)){
			redirectAttributes.addFlashAttribute("message", "saveOK");
			return "redirect:/empresas";
		}
		redirectAttributes.addFlashAttribute("message", "saveError");
		return "redirect:/empresas/new";
	}

	//Mostrar una empresa en especifico
	@GetMapping("/empresas/edit/{id}")
	public String editEmpresa(Model model, @PathVariable Long id, @ModelAttribute("message") String message) {
		Empresa empresa = empresaServ.getById(id);
		model.addAttribute("message", message);
		model.addAttribute("empresa", empresa);
		return "edit_empresa";//Llamamos al archivo edit_empresa.html en la carpeta templates (resources/templates)
	}

	//Editar una empresa en especifico
	@PatchMapping("/empresas/update")
	public String updateEmpresa(@ModelAttribute("empresa") Empresa empresa, RedirectAttributes redirectAttributes) {
		if (empresaServ.saveOrUpdate(empresa)){
			redirectAttributes.addFlashAttribute("message", "updateOK");
			return "redirect:/empresas";
		}
		redirectAttributes.addFlashAttribute("message", "updateError");
		return "redirect:/empresas/edit/" + empresa.getId();
	}

	//Eliminar una empresa en especifico
	@GetMapping("/empresas/delete/{id}")
	public String deleteEmpresa(@PathVariable Long id, RedirectAttributes redirectAttributes) {
		if (empresaServ.delete(id)){
			redirectAttributes.addFlashAttribute("message", "deleteOK");
			return "redirect:/empresas";
		}
		redirectAttributes.addFlashAttribute("message", "deleteError");
		return "redirect:/empresas";
	}

	@RequestMapping(value = "accessDenied")
	public String accessDenied() {
		return "accessDenied";
	}
}
