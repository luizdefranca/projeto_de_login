package br.com.alura.gerenciador.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FazTudo
 */
@WebServlet("/FazTudo")
public class FazTudo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FazTudo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String tarefa = request.getParameter("tarefa");
			String nomeDaClasse = "br.com.alura.gerenciador.web." + tarefa;
			Class tipo = Class.forName(nomeDaClasse);
			Tarefa instancia = (Tarefa) tipo.newInstance();
			String pagina = instancia.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			
			throw new ServletException(e);
		}

	}

}
