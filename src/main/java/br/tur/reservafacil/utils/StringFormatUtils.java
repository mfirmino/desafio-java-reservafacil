package br.tur.reservafacil.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe utilitária responsável por concentrar funções de validação de formato com Strings.
 *
 * @author mfirmino
 *
 */
public class StringFormatUtils {

	/**
	 * Método responsável por validar se uma determinada string está atendendo o formato definido
	 * na expressão regular ou não.
	 *
	 * @param expressaoRegular - Expressão regular a ser validada. Ex:[0-9]
	 * @param campo - Campo a ser validado.
	 * @return boolean
	 */
	public static boolean validarFormato(String expressaoRegular, String campo){
		Pattern pattern = Pattern.compile(expressaoRegular);
		Matcher matcher = pattern.matcher(campo);
		return matcher.find();
	}
}
