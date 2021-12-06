package com.mudi.mvc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mudi.mvc.dto.RequisicaoNovoPedidoDTO;
import com.mudi.mvc.model.Pedido;
import com.mudi.mvc.model.User;
import com.mudi.mvc.repository.PedidoRepository;
import com.mudi.mvc.repository.UserRepository;

@Controller
@RequestMapping("pedido")
public class PedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private UserRepository userRepository;

	@GetMapping("formulario")
	public String formulario(RequisicaoNovoPedidoDTO requisicao) {
		return "pedido/formulario";
	}

	@PostMapping("novo")
	public String novo(@Valid RequisicaoNovoPedidoDTO requisicao, BindingResult result) {
		if (result.hasErrors()) {
			return "pedido/formulario";
		}
		String username = SecurityContextHolder.getContext().getAuthentication().getName();

		User user = userRepository.findByUsername(username);

		Pedido pedido = requisicao.toPedido();
		pedido.setUser(user);
		Long id = pedidoRepository.save(pedido).getId();
		System.out.println(id);

		return "redirect:/home";
	}
}