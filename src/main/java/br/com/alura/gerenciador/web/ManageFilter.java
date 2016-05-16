package br.com.alura.gerenciador.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.model.Usuario;

/**
 * Servlet Filter implementation class ManageFilter
 */
@WebFilter(urlPatterns="/*")
public class ManageFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ManageFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	@Override
    public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		//Cookie cookie = new Cookies(req.getCookies()).buscaUsuarioLogado();
		HttpSession session = req.getSession();
		session.setMaxInactiveInterval(60);
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		String usuario = "<deslogado>";
		if(usuarioLogado != null){ 
			usuario = usuarioLogado.getEmail();
		}
		//if(session != null) usuario = usuarioLogado.getEmail();
		String uri = req.getRequestURI();
		System.out.println("Usuário "+ usuario + "acessando a URI "+ uri);
		
		chain.doFilter(request, response);
	}

	private String getUsuario(HttpServletRequest req) {
		
		/*String usuario;
		Cookie cookie = new Cookies(req.getCookies()).buscaUsuarioLogado();
		if(cookie == null) usuario = "<deslogado>";
		else usuario = cookie.getValue();*/
		
		
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario.login");
		if(usuario == null) return "<deslogado>";
		return usuario.getEmail();
	}

	public Cookie getCookie(HttpServletRequest req) {
		Cookie[] cookies = req.getCookies();
		if (cookies != null){
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("usuario.logado.comCookie")){
					return cookie;
				}
			}
		}
		return null;
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
