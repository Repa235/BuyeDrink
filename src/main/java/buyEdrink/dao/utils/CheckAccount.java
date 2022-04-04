package buyEdrink.dao.utils;

import javax.servlet.http.HttpSession;

public class CheckAccount {

	
	public static final String PAGINA_LOGIN = "PreLogin";
	public static final String PAGINA_SESSIONE_NON_VALIDA = "PreLogin";
	public static final String PAGINA_LOGIN_ERRATA = "PreLogin?errore";
	
	public static boolean clienteAutenticato (HttpSession session) {
		
		if (session.getAttribute("autenticato") != null)
			return true;
	    return false;
}
}