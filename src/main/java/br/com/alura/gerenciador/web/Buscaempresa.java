package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

@SuppressWarnings("serial")
@WebServlet(asyncSupported = true, urlPatterns = { "/busca" })
public class Buscaempresa extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String filtro = request.getParameter("filtro");
		Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(filtro); 
		request.setAttribute("empresas", empresas);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/paginas/empresas.jsp");
		dispatcher.forward(request, response); 
		
		
	}
	
	
	

}
