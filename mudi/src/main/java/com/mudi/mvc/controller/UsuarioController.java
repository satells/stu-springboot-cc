package com.mudi.mvc.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mudi.mvc.model.Pedido;
import com.mudi.mvc.model.StatusPedido;
import com.mudi.mvc.repository.PedidoRepository;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping("pedido")
	public String home(Model model, Principal principal) {
		System.out.println(principal.getName());
		List<Pedido> pedidos = pedidoRepository.findAllByUsuario(principal.getName());
		model.addAttribute("pedidos", pedidos);
		return "usuario/home";
	}

	@GetMapping("pedido/{status}")
	public String status(@PathVariable("status") String status, Model model, Principal principal) {
		List<Pedido> pedidos = pedidoRepository.findByStatusEUsuario(StatusPedido.valueOf(status.toUpperCase()), principal.getName());
		model.addAttribute("pedidos", pedidos);
		model.addAttribute("status", status);
		return "usuario/home";
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/usuario/home";
	}

}
//@GetMapping("/aguardando")
//public String aguardando(Model model) {
//	List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.AGUARDANDO);
//	model.addAttribute("pedidos", pedidos);
//	return "home";
//}
//
//@GetMapping("/aprovado")
//public String aprovado(Model model) {
//	List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.APROVADO);
//	model.addAttribute("pedidos", pedidos);
//	return "home";
//}
//
//@GetMapping("/entregue")
//public String entregue(Model model) {
//	List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.ENTREGUE);
//	model.addAttribute("pedidos", pedidos);
//	return "home";
//}
//
//@GetMapping("/todos")
//public String todos(Model model) {
//	List<Pedido> pedidos = pedidoRepository.findAll();
//	model.addAttribute("pedidos", pedidos);
//	return "home";
//}
