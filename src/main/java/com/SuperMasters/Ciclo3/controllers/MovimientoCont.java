package com.SuperMasters.Ciclo3.controllers;

import com.SuperMasters.Ciclo3.entities.Empleado;
import com.SuperMasters.Ciclo3.entities.Movimiento;
import com.SuperMasters.Ciclo3.services.EmpleadoServ;
import com.SuperMasters.Ciclo3.services.MovimientoServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MovimientoCont {

	@Autowired
	MovimientoServ movimientoServ;
	@Autowired
	EmpleadoServ empleadoServ;

	//Mostar todos los movimientos en HTML
	@GetMapping("/movimientos")
	public String getAll(Model model, @ModelAttribute("message") String message) {
		model.addAttribute("movimientos", movimientoServ.getAll());
		model.addAttribute("message", message);
		return "movimientos";
	}

	//Ir a la pagina para crear un movimiento
	@GetMapping("/movimientos/new")
	public String newMovimiento(Model model, @ModelAttribute("message") String message) {
		Movimiento movimiento = new Movimiento();
		model.addAttribute("message", message);
		model.addAttribute("movimiento", movimiento);
		List<Empleado> empleados = empleadoServ.getAll();
		model.addAttribute("empleados", empleados);
		return "new_movimiento";
	}

	//Guardar un movimiento en la base de datos y volver a la pagina de movimientos
	@PostMapping("/movimientos/save")
	public String saveMovimiento(Movimiento movimiento, RedirectAttributes redirectAttributes) {
		if (movimientoServ.saveOrUpdate(movimiento)){
			redirectAttributes.addFlashAttribute("message", "saveOK");
			return "redirect:/movimientos";
		}
		redirectAttributes.addFlashAttribute("message", "saveError");
		return "redirect:/movimientos/new";
	}

	//Mostrar un movimiento en especifico
	@GetMapping("/movimientos/edit/{id}")
	public String editMovimiento(Model model, @ModelAttribute("message") String message, @PathVariable Long id) {
		Movimiento movimiento = movimientoServ.getById(id);
		model.addAttribute("message", message);
		model.addAttribute("movimiento", movimiento);
		List<Empleado> empleados = empleadoServ.getAll();
		model.addAttribute("empleados", empleados);
		return "edit_movimiento";
	}

	//Editar un movimiento en especifico
	@PostMapping("/movimientos/update")
	public String updateMovimiento(@ModelAttribute("movimiento") Movimiento movimiento, RedirectAttributes redirectAttributes) {
		if (movimientoServ.saveOrUpdate(movimiento)){
			redirectAttributes.addFlashAttribute("message", "updateOK");
			return "redirect:/movimientos";
		}
		redirectAttributes.addFlashAttribute("message", "updateError");
		return "redirect:/movimientos/edit/" + movimiento.getId();
	}

	//Eliminar un movimiento de la base de datos y volver a la pagina de movimientos
	@GetMapping("/movimientos/delete/{id}")
	public String deleteMovimiento(@PathVariable Long id, RedirectAttributes redirectAttributes) {
		if (movimientoServ.delete(id)){
			redirectAttributes.addFlashAttribute("message", "deleteOK");
			return "redirect:/movimientos";
		}
		redirectAttributes.addFlashAttribute("message", "deleteError");
		return "redirect:/movimientos";
	}

	//Mostrar todos los movimientos de un empleado en especifico
	@GetMapping("/movimientos/empleado/{id}")
	public String getMovimientosByEmpleado(Model model, @ModelAttribute("message") String message, @PathVariable Long id) {
		List<Movimiento> movimientos = movimientoServ.getByEmpleado(id);
		model.addAttribute("movimientos", movimientos);
		model.addAttribute("message", message);
		return "movimientos";//Llama a la pagina movimientos.html en la carpeta templates de resources
	}

	//Mostrar todos los movimientos de una empresa en especifico
	@GetMapping("/movimientos/empresa/{id}")
	public String getMovimientosByEmpresa(Model model, @ModelAttribute("message") String message, @PathVariable Long id) {
		List<Movimiento> movimientos = movimientoServ.getByEmpresa(id);
		model.addAttribute("movimientos", movimientos);
		model.addAttribute("message", message);
		return "movimientos";//Llama a la pagina movimientos.html en la carpeta templates de resources
	}
}
