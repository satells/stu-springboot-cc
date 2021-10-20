package com.mudi.mvc.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mudi.mvc.model.Pedido;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String home(Model model) {

		Pedido pedido = new Pedido();
		pedido.setNomeProduto("Kindle Paperwhite");

		pedido.setUrlProduto("https://www.amazon.com/-/pt/dp/B07F7TLZF4/ref=sr_1_1?dchild=1&keywords=kindle&qid=1634754665&qsid=136-1905245-3812915&sr=8-1&sres=B07F7TLZF4%2CB07746ZX4Y%2CB07HSL23CW%2CB07741S7Y8%2CB07F81WWKP%2CB09FP334NK%2CB07L55RMVF%2CB075QRWPPJ%2CB07L5GDTYY%2CB077448K76%2CB0774DBGT2%2CB09FNJZD68%2CB09FBYNC2J%2CB079BG3LQF%2CB0898T63S8%2CB07HZQBBKL");
		pedido.setUrlImagem("https://m.media-amazon.com/images/I/51+TWOfdtiL._AC_SL1000_.jpg");
		pedido.setDescricao("Kindle Paperwhite – (previous generation - 2018 release) Now Waterproof with 2x the Storage - 8 GB (International Version)");

		List<Pedido> pedidos = Arrays.asList(pedido);

		model.addAttribute("pedidos", pedidos);

		return "home";
	}

}
