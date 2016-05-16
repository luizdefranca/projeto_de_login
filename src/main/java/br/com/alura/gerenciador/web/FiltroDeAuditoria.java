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


//@WebFilter(urlPatterns ="/*")
public class FiltroDeAuditoria implements Filter {

	@Override
	public void destroy() {
		

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
			HttpServletRequest req = (HttpServletRequest) request;
//Olha o Código aqui
			Cookie cookie = getUsuario(req);
			String usuario = "<deslogado>";
			String uri = req.getRequestURI();
			if (cookie != null)
	            usuario = cookie.getValue();
			System.out.println("Usuario acessando a URI: " + uri );
			chain.doFilter(request, response);
			
	}

	private Cookie getUsuario(HttpServletRequest req) {
		//String usuario = "<deslogado>";
		
		Cookie[] cookies = req.getCookies();
		
		for(Cookie cookie: cookies){
			if(cookie.getName().equals("usuario.logado")) {
				return cookie;
			}
		}
		return null;
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		

	}

}
