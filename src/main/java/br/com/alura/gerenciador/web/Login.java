package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final int TEMPO_EM_MINUTOS = 10; //tempo em minutos do login
	static final Map<String, Usuario> USUARIOS_LOGADOS = new HashMap<>();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email"); //busca a informacao com a caixa de texto de name = "email"
		String senha = request.getParameter("senha"); //busca a informacao com a caixa de texto de name = "senha"
		
		Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);
		
		
		PrintWriter writer = response.getWriter();
		if (usuario == null) {
			writer.println("<html><body> Usuário inválido </body></html>");
		} else {
			//String codigoAleatorio = (System.currentTimeMillis()+ "/"+Math.random()*1000).toString();
			//USUARIOS_LOGADOS.put(codigoAleatorio, email);
			//Cookie cookie = new Cookie("usuario.logado.comCookie", usuario.getEmail());
			//cookie.setMaxAge(60*TEMPO_EM_MINUTOS);
			//response.addCookie(cookie);
			
			HttpSession session = request.getSession();
			session.setAttribute("usuarioLogado", usuario);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/paginas/login.jsp");
			dispatcher.forward(request, response);
			
			

		}
		

	}

}
