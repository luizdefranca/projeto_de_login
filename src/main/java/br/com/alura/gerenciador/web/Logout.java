package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Usuario;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = Login.USUARIOS_LOGADOS.get(request.getSession().getAttribute("usuario.logado"));
		String emailUsuario = "<deslogado>";
		if (usuario != null) usuario.getEmail();
		
		request.getSession().removeAttribute("usuarioLogado");  //	SÃO POSSÍVEIS AS DUAS OPCOES PARA
	//  request.getSession().invalidate();						// TERMINAR UMA SESSAO DE UM USUARIO
																// A PRIMEIRA GUARDA ALGUMAS INFORMAÇOES
																//A SEGUNDA APAGA TODAS
		
		/*Cookie cookie = new Cookies(request.getCookies()).buscaUsuarioLogado();
		Usuario usuario = Login.USUARIOS_LOGADOS.get(cookie.getValue());
		PrintWriter writer = response.getWriter();
		if(cookie == null) 	writer.println("<html><body>Usuario não estava logado</body></html>");
		else{
			cookie.setMaxAge(0);
			response.addCookie(cookie);
			writer.println("<html><body>Deslogado com sucesso</body></html>");
		}*/
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/paginas/logout.html");
	    dispatcher.forward(request, response);
	}

}
