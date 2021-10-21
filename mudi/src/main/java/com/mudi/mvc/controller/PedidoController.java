package com.mudi.mvc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mudi.mvc.dto.RequisicaoNovoPedido;
import com.mudi.mvc.model.Pedido;
import com.mudi.mvc.repository.PedidoRepository;

@Controller
@RequestMapping("pedido")
public class PedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping("formulario")
	public String formulario(RequisicaoNovoPedido requisicao) {

		return "pedido/formulario";
	}

	@PostMapping("novo")
	public String novo(@Valid RequisicaoNovoPedido requisicao, BindingResult result) {
		if (result.hasErrors()) {
			return "pedido/formulario";
		}

		Pedido pedido = requisicao.toPedido();

		Long id = pedidoRepository.save(pedido).getId();
		System.out.println(id);

		return "redirect:/home";
	}
}