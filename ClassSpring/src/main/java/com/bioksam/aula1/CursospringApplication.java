package com.bioksam.aula1;

import java.util.Arrays;

import com.bioksam.aula1.model.dominio.Categoria;
import com.bioksam.aula1.model.dominio.Cidade;
import com.bioksam.aula1.model.dominio.Cliente;
import com.bioksam.aula1.model.dominio.Endereco;
import com.bioksam.aula1.model.dominio.Estado;
import com.bioksam.aula1.model.dominio.Produto;
import com.bioksam.aula1.model.dominio.enums.TipoCliente;
import com.bioksam.aula1.model.repositories.CategoriaRepository;
import com.bioksam.aula1.model.repositories.CidadeRepository;
import com.bioksam.aula1.model.repositories.ClienteRepository;
import com.bioksam.aula1.model.repositories.EnderecoRepository;
import com.bioksam.aula1.model.repositories.EstadoRepository;
import com.bioksam.aula1.model.repositories.ProdutoRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ch.qos.logback.core.net.server.Client;

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
	}
}
