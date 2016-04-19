package br.tur.reservafacil.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe utilit�ria respons�vel por concentrar fun��es de valida��o de formato com Strings.
 *
 * @author mfirmino
 *
 */
public class StringFormatUtils {

	/**
	 * M�todo respons�vel por validar se uma determinada string est� atendendo o formato definido
	 * na express�o regular ou n�o.
	 *
	 * @param expressaoRegular - Express�o regular a ser validada. Ex:[0-9]
	 * @param campo - Campo a ser validado.
	 * @return boolean
	 */
	public static boolean validarFormato(String expressaoRegular, String campo){
		Pattern pattern = Pattern.compile(expressaoRegular);
		Matcher matcher = pattern.matcher(campo);
		return matcher.find();
	}
}
