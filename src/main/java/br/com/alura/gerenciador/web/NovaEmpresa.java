package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.dao.EmpresaDAO;
import br.com.alura.gerenciador.model.Empresa;

/**
 * Servlet implementation class NovaEmpresa
 */

public class NovaEmpresa  implements Tarefa {
	private static final long serialVersionUID = 1L;
	private String pagina = "/WEB-INF/paginas/novaEmpresa.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		Empresa empresa = new Empresa(nome);
		new EmpresaDAO().adiciona(empresa);
		request.setAttribute("nome", nome);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/paginas/novaEmpresa.jsp");
		dispatcher.forward(request, response);
		
	}

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		
		String nome = request.getParameter("nome");
		Empresa empresa = new Empresa(nome);
		new EmpresaDAO().adiciona(empresa);
		request.setAttribute("nome", nome);
		return pagina;
	}

	
}
