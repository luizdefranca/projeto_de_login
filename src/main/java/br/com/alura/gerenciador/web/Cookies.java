package br.com.alura.gerenciador.web;


import javax.servlet.http.Cookie;

public class Cookies {
	
	private final Cookie[] cookies;
	public Cookies(Cookie[] cookies){
		this.cookies = cookies;
	}
	
	public Cookie buscaUsuarioLogado(){
		Cookie usuarioLogado = null;
		
		if(cookies == null) return usuarioLogado;
		for (Cookie cookie : cookies) {
			if(cookie.getName().equals("usuario.logado.comCookie")){
				return cookie;
			}
		}
		
		return usuarioLogado;
	}

}
