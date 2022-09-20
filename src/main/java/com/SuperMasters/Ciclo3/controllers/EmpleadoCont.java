package com.SuperMasters.Ciclo3.controllers;


import com.SuperMasters.Ciclo3.entities.Empleado;
import com.SuperMasters.Ciclo3.entities.Empresa;
import com.SuperMasters.Ciclo3.services.EmpleadoServ;
import com.SuperMasters.Ciclo3.services.EmpresaServ;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.authentication.PasswordEncoderParser;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.Console;
import java.util.List;

@Controller
@DynamicInsert
@DynamicUpdate
public class EmpleadoCont {

	@Autowired
	EmpleadoServ empleadoServ;
	@Autowired
	EmpresaServ empresaServ;

	//Mostrar todos los empleados en HTML
	@GetMapping("/empleados")
	public String viewEmpleados(Model model, @ModelAttribute("message") String message) {
		List<Empleado> empleados = empleadoServ.getAll();
		model.addAttribute("empleados", empleados);
		model.addAttribute("message", message);
		return "empleados"; //Llamamos al archivo empleados.html en la carpeta templates (resources/templates)
	}

	//Ir a la pagina para crear un empleado
	@GetMapping("/empleados/new")
	public String newEmpleado(Model model, @ModelAttribute("message") String message) {
		Empleado empleado = new Empleado();
		model.addAttribute("message", message);
		model.addAttribute("empleado", empleado);
		List<Empresa> empresas = empresaServ.getAll();
		model.addAttribute("empresas", empresas);
		return "new_empleado";//Llamamos al archivo new_empleado.html en la carpeta templates (resources/templates)
	}

	//Guardar un empleado en la base de datos y volver a la pagina de empleados
	@PostMapping("/empleados/save")
	public String saveEmpleado(Empleado empleado, RedirectAttributes redirectAttributes) {
		String encryptedPassword = passwordEncoder().encode(empleado.getPassword());
		empleado.setPassword(encryptedPassword);
		if (empleadoServ.saveOrUpdate(empleado)){
			redirectAttributes.addFlashAttribute("message", "saveOK");
			return "redirect:/empleados";
		}
		redirectAttributes.addFlashAttribute("message", "saveError");
		return "redirect:/empleados/new";
	}

	//Ir a la pagina para editar un empleado
	@GetMapping("/empleados/edit/{id}")
	public String editEmpleado(Model model, @ModelAttribute("message") String message, @PathVariable() Long id) {
		Empleado empleado = empleadoServ.getById(id);
		model.addAttribute("message", message);
		model.addAttribute("empleado", empleado);
		List<Empresa> empresas = empresaServ.getAll();
		model.addAttribute("empresas", empresas);
		return "edit_empleado";//Llamamos al archivo edit_empleado.html en la carpeta templates (resources/templates)
	}

	//Actualizar un empleado en la base de datos y volver a la pagina de empleados
	@PostMapping("/empleados/update")
	public String updateEmpleado(@ModelAttribute("empleado") Empleado empleado, RedirectAttributes redirectAttributes) {
		Long id = empleado.getId();
		String dataBasePass = empleadoServ.getById(id).getPassword();
		System.out.println(dataBasePass);
		System.out.println(empleado.getPassword());
		if (!empleado.getPassword().equals(dataBasePass)){
			String encryptedPassword = passwordEncoder().encode(empleado.getPassword());
			empleado.setPassword(encryptedPassword);
		}
		if (empleadoServ.saveOrUpdate(empleado)){
			redirectAttributes.addFlashAttribute("message", "updateOK");
			return "redirect:/empleados";
		}
		redirectAttributes.addFlashAttribute("message", "updateError");
		return "redirect:/empleados/edit/"+empleado.getId();
	}

	//Eliminar un empleado en la base de datos y volver a la pagina de empleados
	@GetMapping("/empleados/delete/{id}")
	public String deleteEmpleado(@PathVariable() Long id, RedirectAttributes redirectAttributes) {
		if (empleadoServ.delete(id)){
			redirectAttributes.addFlashAttribute("message", "deleteOK");
			return "redirect:/empleados";
		}
		redirectAttributes.addFlashAttribute("message", "deleteError");
		return "redirect:/empleados";
	}

	//Mostrar todos los empleados de una empresa en HTML
	@GetMapping("/empleados/empresa/{id}")
	public String viewEmpleadosEmpresa(Model model, @ModelAttribute("message") String message, @PathVariable() Long id) {
		List<Empleado> empleados = empleadoServ.getByEmpresa(id);
		model.addAttribute("empleados", empleados);
		model.addAttribute("message", message);
		return "empleados"; //Llamamos al archivo empleados.html en la carpeta templates (resources/templates)
	}

	//Encriptar contraseña de un empleado
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
