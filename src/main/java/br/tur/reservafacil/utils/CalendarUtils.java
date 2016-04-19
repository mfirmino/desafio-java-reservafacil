package br.tur.reservafacil.utils;

import java.util.Calendar;

/**
 * Classe utilitária onde fica armazenados todas as funçoes de tratamento de datas com Calendar.
 *
 * @author mfirmino
 *
 */
public class CalendarUtils {
	
	/**
	 * Método responsável por retornar um objeto calendar sem as horas. Somente dia, mes e ano da data passada como parâmetro.
	 *
	 * @param data - Calendar
	 * @return Calendar
	 */
	public static Calendar getDateWithoutHours(Calendar data){
		Calendar dateWithoutHours = Calendar.getInstance();
		
		int year = data.get(Calendar.YEAR);
		int month = data.get(Calendar.MONTH);
		int date = data.get(Calendar.DATE);
		
		dateWithoutHours.set(year, month, date, 0, 0, 0);
		return dateWithoutHours;
	}
	
	/**
	 * Método responsável por verificar se a Data1 é menor que a Data2.
	 *
	 * @param data1 - Calendar
	 * @param data2 - Calendar
	 * @return boolean
	 */
	public static boolean isBefore(Calendar data1, Calendar data2){
		if(data1.compareTo(data2) == -1){
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
	/**
	 * Método responsável por verificar se a Data1 é igual a Data2.
	 *
	 * @param data1 - Calendar
	 * @param data2 - Calendar
	 * @return boolean
	 */
	public static boolean isEquals(Calendar data1, Calendar data2){
		if(data1.compareTo(data2) == 0){
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	/**
	 * Método responsável por verificar se a Data1 é maior que a Data2.
	 *
	 * @param data1 - Calendar
	 * @param data2 - Calendar
	 * @return boolean
	 */
	public static boolean isAfter(Calendar data1, Calendar data2){
		if(data1.compareTo(data2) == 1){
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
	/**
	 * Método responsável por retornar um Calendar com os parâmetros de datas passadas.
	 * 
	 * @param year - Ano desejado
	 * @param month - numero do mês desejado
	 * @param day - dia desejado
	 * @return Calendar
	 */
	public static Calendar newCalendar(int year, int month, int day){
		
		Calendar simpleDate = Calendar.getInstance();
		simpleDate.set(year, month - 1, day, 0, 0, 0);
		
		return simpleDate;
	}
	
	/**
	 * Método responsável por retornar a quantidade de dias que há entre as duas datas passadas como parâmetro.
	 *
	 * @param data1
	 * @param data2
	 * @return int
	 */
	public static int daysBetween(Calendar data1, Calendar data2){
		data1 = CalendarUtils.getDateWithoutHours(data1);
		data2 = CalendarUtils.getDateWithoutHours(data2);
		long d1 = data1.getTimeInMillis();
		long d2 = data2.getTimeInMillis();
		
		return (int)((d2 - d1) / (24*60*60*1000)); 
	}
}
