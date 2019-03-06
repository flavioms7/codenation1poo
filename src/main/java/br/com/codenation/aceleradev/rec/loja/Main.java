package br.com.codenation.aceleradev.rec.loja;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import br.com.codenation.aceleradev.rec.loja.beans.Usuario;
import br.com.codenation.aceleradev.rec.loja.dao.UsuarioDAO;


public class Main {
	
	public static Scanner READER = new Scanner(System.in);

	public static void main(String[] args) {
		try {
			loopPrincipal();
		} finally {
			READER.close();
		}
	}
	
	private static void loopPrincipal() {
		Boolean cpfValido = pedirCpf();
		while (!cpfValido) {
			cpfValido = pedirCpf();
		}
		exibirHome();
		ArrayList<String> listaOpcoes = new ArrayList<String>(Arrays.asList("0", "1", "2"));
		String inputDoUsuario = pedirOpcaoDoUsuario("placeholder para pedir input");
		while (!inputValido(inputDoUsuario, listaOpcoes)) {
			exibirHome();
			inputDoUsuario = pedirOpcaoDoUsuario("placeholder para pedir input");
		}
		switch (inputDoUsuario) {
		case "X": return;
		default: exibeOpcao(inputDoUsuario);
		}
	}
	
	private static Boolean pedirCpf() {
		String cpf = pedirOpcaoDoUsuario("Bem vindo! Por favor digite seu CPF para logar:");
		UsuarioDAO usuarioDao = new UsuarioDAO();
		Usuario usuario = usuarioDao.verificarCpf(cpf);
		if (usuario != null) {
			System.out.println("Bem vindo, " + usuario.getNome());
			return true;
		} else {
			System.out.println("Desculpe, vamos tentar novamente...");
			return false;
		}
	}
	
	private static void exibirHome() {
		System.out.println("Suas op��es s�o:");
		System.out.println("0 - Shows");
		System.out.println("1 - Filmes");
		System.out.println("2 - Softwares");
	}
	
	private static String pedirOpcaoDoUsuario(String mensagem) {
		System.out.println(mensagem);
		String in = READER.next().toUpperCase();
		return in;
	}
	
	private static Boolean inputValido(String inputDoUsuario, List<String> listaInputs) {
		return listaInputs.contains(inputDoUsuario);
	}
	
	private static void exibeOpcao(String inputDoUsuario) {
		switch (inputDoUsuario) {
		default: System.out.println("Opcao foi: " + inputDoUsuario);
		}
	}
}