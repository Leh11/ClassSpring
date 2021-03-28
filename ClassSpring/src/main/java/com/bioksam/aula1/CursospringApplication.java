package com.bioksam.aula1;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import com.bioksam.aula1.model.dominio.PagamentoCartao;
import com.bioksam.aula1.model.dominio.Categoria;
import com.bioksam.aula1.model.dominio.Cidade;
import com.bioksam.aula1.model.dominio.Cliente;
import com.bioksam.aula1.model.dominio.Endereco;
import com.bioksam.aula1.model.dominio.Estado;
import com.bioksam.aula1.model.dominio.ItemPedido;
import com.bioksam.aula1.model.dominio.Pagamento;
import com.bioksam.aula1.model.dominio.PagamentoBoleto;
import com.bioksam.aula1.model.dominio.Pedido;
import com.bioksam.aula1.model.dominio.Produto;
import com.bioksam.aula1.model.dominio.enums.EstadoPagamento;
import com.bioksam.aula1.model.dominio.enums.TipoCliente;
import com.bioksam.aula1.model.repositories.CategoriaRepository;
import com.bioksam.aula1.model.repositories.CidadeRepository;
import com.bioksam.aula1.model.repositories.ClienteRepository;
import com.bioksam.aula1.model.repositories.EnderecoRepository;
import com.bioksam.aula1.model.repositories.EstadoRepository;
import com.bioksam.aula1.model.repositories.ItemPedidoRepository;
import com.bioksam.aula1.model.repositories.PagamentoRepository;
import com.bioksam.aula1.model.repositories.PedidoRepository;
import com.bioksam.aula1.model.repositories.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class CursospringApplication implements CommandLineRunner{

	@Autowired
	CategoriaRepository categoriaRepository;
	@Autowired
	ProdutoRepository produtoRepository;
	@Autowired
	EstadoRepository estadoRepository;
	@Autowired
	CidadeRepository cidadeRepository;
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	EnderecoRepository enderecoRepository;
	@Autowired
	PedidoRepository pedidoRepository;
	@Autowired
	PagamentoRepository pagamentoRepository;
	@Autowired
	ItemPedidoRepository itemPedidoRepository;
	public static void main(String[] args) {
		SpringApplication.run(CursospringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 500.00);

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "Sao Paulo");

		Cidade cid1 = new Cidade(null, "Uberlandia", est1);
		Cidade cid2 = new Cidade(null, "Cidade Paulo", est2);
		Cidade cid3 = new Cidade(null, "Campina", est2);

		Cliente cli1 = new Cliente(null, "Maria Si", "36363", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("5555", "66666"));

		Endereco end1 = new Endereco(null, "Flores 1", "300", "Apt 201", "Jardim", "2121", cli1, cid1);
		Endereco end2 = new Endereco(null, "Maros 1", "303", "Apt 101", "Centro", "3131", cli1, cid2);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		est1.getCidades().addAll(Arrays.asList(cid1));
		est2.getCidades().addAll(Arrays.asList(cid2, cid3));

		cli1.getEnderecos().addAll(Arrays.asList(end1, end2));
	
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));

		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(end1, end2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:MM");
		Pedido pedido1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, end1);
		Pedido pedido2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, end2);

		Pagamento pagamento1 = new PagamentoCartao(null, EstadoPagamento.QUITADO, pedido1, 6);
		pedido1.setPagamento(pagamento1);
		Pagamento pagamento2 = new PagamentoBoleto(null, EstadoPagamento.PENDENTE, pedido2, sdf.parse("20/10/2017 12:20"), null);
		pedido2.setPagamento(pagamento2);

		cli1.getPedidos().addAll(Arrays.asList(pedido1, pedido2));

		pedidoRepository.saveAll(Arrays.asList(pedido1, pedido2));
		pagamentoRepository.saveAll(Arrays.asList(pagamento1, pagamento2));

		ItemPedido itemPedido1 = new ItemPedido(0.00, 1, 2000.00, pedido1, p1);
		ItemPedido itemPedido2 = new ItemPedido(0.00, 2, 80.00, pedido2, p3);
		ItemPedido itemPedido3 = new ItemPedido(100.00, 1, 800.00, pedido2, p2);

		pedido1.getItens().addAll(Arrays.asList(itemPedido1, itemPedido2));
		pedido2.getItens().addAll(Arrays.asList(itemPedido3)); 

		p1.getItens().addAll(Arrays.asList(itemPedido1));
		p2.getItens().addAll(Arrays.asList(itemPedido3));
		p3.getItens().addAll(Arrays.asList(itemPedido2));

		itemPedidoRepository.saveAll(Arrays.asList(itemPedido1, itemPedido2, itemPedido3));
	}
}
