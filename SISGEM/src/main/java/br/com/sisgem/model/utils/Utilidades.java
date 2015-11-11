package br.com.sisgem.model.utils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.el.MethodExpression;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.Id;
import javax.servlet.http.HttpSession;

//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellStyle;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Workbook;

/**
 * 
 * @author Adiel dos Santos de Araujo
 */
public class Utilidades {

	public static String formataData(Date data) {
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		return formatador.format(data);
	} 

	public static String formataDataHora(Date data) {
		SimpleDateFormat formatador = new SimpleDateFormat(
				"dd/MM/yyyy HH:mm:ss");
		return formatador.format(data);
	}

	public static String formataDataAmerica(Date data) {
		SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
		return formatador.format(data);
	}

	public static Date hoje() throws ParseException {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Calendar hoje = Calendar.getInstance();
		String dataHojeString = formataData(hoje.getTime());
		hoje.setTime(formato.parse(dataHojeString));
		return hoje.getTime();
	}

	public static Calendar hojeCalendar() throws ParseException {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Calendar hoje = Calendar.getInstance();
		String dataHojeString = formataData(hoje.getTime());
		hoje.setTime(formato.parse(dataHojeString));
		return hoje;
	}

	public static Integer Compare_Hoje_Com_Data1(Date data1)
			throws ParseException {
		Date hoje = hoje();
		Integer aux = hoje.compareTo(data1);
		return aux;
	}

	public static Integer Compare_data1_Com_Data2(Date data1, Date data2) {
		Integer aux = data1.compareTo(data2);

		return aux;
	}

	public static Calendar dataHora() throws ParseException {
		// SimpleDateFormat formato = new
		// SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		Calendar hoje = Calendar.getInstance();
		// String dataHojeString = formataData(hoje.getTime());
		// hoje.setTime(formato.parse(dataHojeString));
		return hoje;
	}

	public static String bigDecimalToReal(BigDecimal v1) {
		// DecimalFormat decFormat = new DecimalFormat("###,##0.00##");
		// DecimalFormat decFormat = new DecimalFormat ("#,##0.00", new
		// DecimalFormatSymbols (new Locale ("pt", "BR")));
		NumberFormat decFormat = new DecimalFormat("#,##0.00",
				new DecimalFormatSymbols(new Locale("pt", "BR")));
		if (v1 == null) {
			return decFormat.format(new BigDecimal(0.0));
		}
		return decFormat.format(v1);
	}

	public static Double bigDecimalToDouble(BigDecimal v1) {
		if (v1 == null) {
			return new Double(0.0);
		}
		return v1.doubleValue();
	}

	public static BigDecimal objectToBigDecimal(Object value) {
		BigDecimal ret = null;
		if (value != null) {
			if (value instanceof BigDecimal) {
				ret = (BigDecimal) value;
			} else if (value instanceof String) {
				ret = new BigDecimal((String) value);
			} else if (value instanceof BigInteger) {
				ret = new BigDecimal((BigInteger) value);
			} else if (value instanceof Number) {
				ret = new BigDecimal(((Number) value).doubleValue());
			} else {
				throw new ClassCastException("Not possible to coerce [" + value
						+ "] from class " + value.getClass()
						+ " into a BigDecimal.");
			}
		}
		return ret;
	}

	public static Date ajustaHorario(Date data, int h, int m) {
		SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
		int ano = Integer.parseInt(formatador.format(data).substring(0, 4));
		int mes = Integer.parseInt(formatador.format(data).substring(5, 7)) - 1;
		int dia = Integer.parseInt(formatador.format(data).substring(8, 10));
		Calendar dataHoraAjustada = Calendar.getInstance();
		// ano, mês, dia, hora, minuto, segundo
		// mês começa a partir de 0
		dataHoraAjustada.set(ano, mes, dia, h, m, 00);
		return dataHoraAjustada.getTime();
	}

	public static Date amanha() {
		Date hoje = new Date();
		int dias = 1;
		Date amanha = addDias(hoje, dias);
		// SimpleDateFormat df = new
		// SimpleDateFormat("dd/MM/yyyy HH:mm:ss:SSS");
		return amanha;
	}

	public static Date addDias(Date date, int dias) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, dias);
		return calendar.getTime();
	}

	public static String preencheCom(String linha_a_preencher, String letra,
			int tamanho, int direcao) {

		// Checa se Linha a preencher é nula ou branco

		if (linha_a_preencher == null || linha_a_preencher.trim() == "") {
			linha_a_preencher = "";
		}

		// Enquanto Linha a preencher possuir 2 espaços em branco seguidos,
		// substitui por 1 espaço apenas

		while (linha_a_preencher.contains("  ")) {
			linha_a_preencher = linha_a_preencher.replaceAll("  ", " ").trim();
		}

		// Retira caracteres estranhos

		linha_a_preencher = linha_a_preencher.replaceAll("[./-]", "");

		StringBuffer sb = new StringBuffer(linha_a_preencher);

		if (direcao == 1) { // a Esquerda

			for (int i = sb.length(); i < tamanho; i++) {

				sb.insert(0, letra);

			}

		} else if (direcao == 2) {// a Direita

			for (int i = sb.length(); i < tamanho; i++) {

				sb.append(letra);

			}

		}

		return sb.toString();

	}

	/**
	 * 
	 * @param texto
	 *            Texto da mensagem a ser exibida
	 * @param tipo
	 *            1: Erro | 2: Info | 3: Aviso | 4: Fatal
	 */
	public static void showFacesMessage(String texto, int tipo) {
		switch (tipo) {
		case 1:
			FacesContext.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR,
									texto, "Erro"));
			break;
		case 2:
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, texto,
							"Informação"));
			break;
		case 3:
			FacesContext.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_WARN, texto,
									"Aviso"));
			break;
		case 4:
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, texto,
							"Fatal"));
			break;
		}
	}

	public static boolean cpfCnpjisValid(String cpfOrCnpj) {
		if (cpfOrCnpj == null) {
			return false;
		}
		String n = cpfOrCnpj.replaceAll("[^0-9]*", "");
		boolean isCnpj = n.length() == 14;
		boolean isCpf = n.length() == 11;
		if (!isCpf && !isCnpj) {
			return false;
		}
		int i;
		int j; // just count
		int digit; // A number digit
		int coeficient; // A coeficient
		int sum; // The sum of (Digit * Coeficient)
		int[] foundDv = { 0, 0 }; // The found Dv1 and Dv2
		int dv1 = Integer.parseInt(String.valueOf(n.charAt(n.length() - 2)));
		int dv2 = Integer.parseInt(String.valueOf(n.charAt(n.length() - 1)));
		for (j = 0; j < 2; j++) {
			sum = 0;
			coeficient = 2;
			for (i = n.length() - 3 + j; i >= 0; i--) {
				digit = Integer.parseInt(String.valueOf(n.charAt(i)));
				sum += digit * coeficient;
				coeficient++;
				if (coeficient > 9 && isCnpj) {
					coeficient = 2;
				}
			}
			foundDv[j] = 11 - sum % 11;
			if (foundDv[j] >= 10) {
				foundDv[j] = 0;
			}
		}
		return dv1 == foundDv[0] && dv2 == foundDv[1];
	}

	public static String formataCnpjCpf(String cnpjCpf) {
		String p1, p2, p3, p4, p5;
		if (cnpjCpf.length() == 11) {
			p1 = cnpjCpf.substring(0, 3);
			p2 = cnpjCpf.substring(3, 6);
			p3 = cnpjCpf.substring(6, 9);
			p4 = cnpjCpf.substring(9, 11);
			cnpjCpf = p1 + "." + p2 + "." + p3 + "-" + p4;
		} else {
			p1 = cnpjCpf.substring(0, 2);
			p2 = cnpjCpf.substring(2, 5);
			p3 = cnpjCpf.substring(5, 8);
			p4 = cnpjCpf.substring(8, 12);
			p5 = cnpjCpf.substring(12, 14);
			cnpjCpf = p1 + "." + p2 + "." + p3 + "/" + p4 + "-" + p5;
		}

		return cnpjCpf;
	}

	public static String removeChar(String s, char c) {

		String r = "";

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != c) {
				r += s.charAt(i);
			}
		}

		return r;
	}

	public static String hashSHA256(String s) {
		return stringHexa(gerarHash(s, "SHA-256"));

	}

	public static String hashMD5(String s) {
		return stringHexa(gerarHash(s, "MD5"));

	}

	public static String hashSHA1(String s) {
		return stringHexa(gerarHash(s, "SHA-1"));

	}

	public static byte[] gerarHash(String frase, String algoritmo) {
		try {
			MessageDigest md = MessageDigest.getInstance(algoritmo);
			md.update(frase.getBytes());
			return md.digest();
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}

	private static String stringHexa(byte[] bytes) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			int parteAlta = ((bytes[i] >> 4) & 0xf) << 4;
			int parteBaixa = bytes[i] & 0xf;
			if (parteAlta == 0) {
				s.append('0');
			}
			s.append(Integer.toHexString(parteAlta | parteBaixa));
		}
		return s.toString();
	}

	public static String diaDaSemana(Date data) {
		DateFormat df2 = new SimpleDateFormat("EE");
		String semana = df2.format(data);
		return semana;
	}

	public static String diaDaSemanaPortugues(Date data) {

		String resultado = "";
		String diaSemana = diaDaSemana(data);
		if (diaSemana.equals("Seg")) {
			resultado = "segunda";
		}
		if (diaSemana.equals("Ter")) {
			resultado = "terca";
		}
		if (diaSemana.equals("Qua")) {
			resultado = "quarta";
		}
		if (diaSemana.equals("Qui")) {
			resultado = "quinta";
		}
		if (diaSemana.equals("Sex")) {
			resultado = "sexta";
		}
		if (diaSemana.equals("Sáb")) {
			resultado = "Sabado";
		}
		if (diaSemana.equals("Dom")) {
			resultado = "domingo";
		}
		return resultado;
	}

	public static long obterSegundos(String hora1) {
		String[] time = hora1.split(":");

		try {
			long hora = Long.parseLong(time[0]) * 3600;
			long minuto = Long.parseLong(time[1]) * 60;
			long segundo = Long.parseLong(time[2]);

			return hora + minuto + segundo;
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	public static String obterTempoFormatado(long segundos) {
		long segundo = segundos % 60;
		long minutos = segundos / 60;
		long minuto = minutos % 60;
		long hora = minutos / 60;
		String hms = String.format("%02d:%02d:%02d", hora, minuto, segundo);

		return hms;
	}

	public static MethodExpression createMethodExpression(String action) {
		MethodExpression methodExpression = FacesContext
				.getCurrentInstance()
				.getApplication()
				.getExpressionFactory()
				.createMethodExpression(
						FacesContext.getCurrentInstance().getELContext(),
						action, null, new Class<?>[0]);
		return methodExpression;
	}

	//
	// private static Submenu geraSubmenu(Menu menu, List<Menu> menus) {
	// Submenu submenu = new Submenu();
	// if (menu.getUrl().equals("#")) {
	// //caso esse menu seja um submeu vai gerar um novo submenu
	// submenu.setLabel(menu.getDescricao());
	// submenu.setId("menu3" + menu.getId().toString());
	// for (Menu aux : menus) {
	// if (aux.getMenuPai() == menu) {
	// if (aux.getUrl().equals("#")) {
	// submenu.getChildren().add(geraSubmenu(aux, menus));
	// } else {
	// submenu.getChildren().add(geraMenuItem(aux));
	// }
	// }
	// }
	// return submenu;
	// }
	// return submenu;
	// }
	//
	// private static MenuItem geraMenuItem(Menu aux) {
	// MenuItem menuitem = new MenuItem();
	// menuitem.setValue(aux.getDescricao());
	// menuitem.setId("menu1" + aux.getId().toString());
	// menuitem.setActionExpression(Util.createMethodExpression(aux.getUrl()));
	// return menuitem;
	// }
	//
	// public static MenuModel geraModel(List<Menu> menus) {
	// MenuModel model = new DefaultMenuModel();
	// for (Menu aux : menus) {
	// if (aux.getMenuPai() == null) {
	// if (aux.getUrl().equals("#")) {
	// model.addSubmenu(geraSubmenu(aux, menus));
	// } else {
	// model.addMenuItem(geraMenuItem(aux));
	// }
	// }
	// }
	// return model;
	// }

	public static String getId(Class<?> clazz, Object obj)
			throws SecurityException, NoSuchFieldException,
			IllegalArgumentException, IllegalAccessException {
		for (Field field : clazz.getDeclaredFields()) {
			if ((field.getAnnotation(Id.class)) != null) {
				Field privateField = clazz.getDeclaredField(field.getName());
				privateField.setAccessible(true);
				if (privateField.get(clazz.cast(obj)) != null) {
					return (String) field.getType()
							.cast(privateField.get(clazz.cast(obj))).toString();
				} else {
					return null;
				}
			}
		}
		return null;
	}

	public static Object pegarObjetoNaSessao(String objeto) {
		HttpSession session;
		session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);

		return session.getAttribute(objeto);
	}

	public static void colocarObjetoNaSessao(String descricao, Object objeto) {
		HttpSession session;
		session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		session.setAttribute(descricao, objeto);

	}

	public static void limparObjetoNaSessao(String descricao) {
		HttpSession session;
		session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		session.setAttribute(descricao, null);

	}

	//
	// public static void infoClasseFields(Object anterior, Object novo) throws
	// Exception {
	//
	// Class<?> classeAnterior = anterior.getClass();
	// Class<?> classeNova = novo.getClass();
	// // Field[] camposAnterior = classeAnterior.getDeclaredFields();
	// List<Campos> campos = new ArrayList<Campos>();
	//
	// for (Field fA : classeAnterior.getDeclaredFields()) {
	// if (fA.isAnnotationPresent(AnotacaoGravarNoLog.class)) {
	//
	// fA.setAccessible(true);
	// Field fN = classeNova.getDeclaredField(fA.getName());
	// fN.setAccessible(true);
	// Object vNovo = fN.get(novo);
	// Object vAnterior = fA.get(novo);
	// System.out.println(vNovo);
	// System.out.println(vAnterior);
	// if (!vNovo.equals(vAnterior)) {
	// Campos aux = new Campos();
	// aux.setDescricaoCampo(fA.getName());
	// aux.setNovoValor(vNovo.toString());
	// aux.setValorAnterior(vAnterior.toString());
	// campos.add(aux);
	// } else {
	// }
	//
	// }
	// }
	//
	// for (String s : nomeDosCampos) {
	// Field fAnterior;
	// Field fNovo;
	// fAnterior = classeAnterior.getDeclaredField(s);
	// fNovo = classeNova.getDeclaredField(s);
	// fAnterior.setAccessible(true);
	// fNovo.setAccessible(true);
	// Object vAnterior = fAnterior.get(anterior);
	// Object vNovo = fNovo.get(novo);
	//
	// System.out.println(vAnterior);
	// System.out.println(vNovo);
	//
	// if (vAnterior.equals(vNovo)) {
	// System.out.println("São iguaias:");
	// }
	// }

	// System.out.println(nomeDosCampos.size());

	// for (Field f : classeAnterior.getDeclaredFields()) {
	// aux.add(f);
	// f.setAccessible(true);
	// System.out.println(f.getName() + ": " + f.get(anterior));
	// }

	// return "ok";
	// }

	public static Boolean camposIguais(Object objAnt, Object objNovo) {
		String nomeClasseAnterior = objAnt.getClass().getSimpleName();
		String nomeClasseNovo = objNovo.getClass().getSimpleName();

		System.out.println(nomeClasseAnterior);
		System.out.println(nomeClasseNovo);

		return null;

	}

	public static String printLn() {
		String aux1 = "System.out.println(this.getClass().getSimpleName() + \": \" + Thread.currentThread().getStackTrace()[1].getLineNumber() + \":Inicio do getPodeAvançar\");";
		return aux1;

	}

	public static Date convertStringEmData(String data) throws Exception {
		if (data == null || data.equals(""))
			return null;

		Date date = null;
		try {
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			date = (java.util.Date) formatter.parse(data);
		} catch (ParseException e) {
			throw e;
		}
		return date;
	}

//	public static Cell createCell(Workbook wb, Row row, Integer column,
//			short halign, short valign) {
//		Cell cell = row.createCell(column);
//		CellStyle cellStyle = wb.createCellStyle();
//		cellStyle.setAlignment(halign);
//		cellStyle.setVerticalAlignment(valign);
//		cell.setCellStyle(cellStyle);
//		return cell;
//	}

	public static Integer compareBigDecial_N1_N2(BigDecimal n1, BigDecimal n2) {

		if (n1 == null) {
			return null;
		}
		if (n2 == null) {
			return null;
		}
		return n1.compareTo(n2);
	}

	public static Boolean compareBigDecial_N1_maiorQue_N2(BigDecimal n1,
			BigDecimal n2) {
		if (compareBigDecial_N1_N2(n1, n2) == null) {
			return null;
		}

		if (compareBigDecial_N1_N2(n1, n2) == 1) {
			return true;
		}
		return false;

	}

	public static Boolean compareBigDecial_N1_menorQue_N2(BigDecimal n1,
			BigDecimal n2) {

		if (compareBigDecial_N1_N2(n1, n2) == null) {
			return null;
		}

		if (compareBigDecial_N1_N2(n1, n2) == -1) {
			return true;
		}
		return false;

	}

	public static Boolean compareBigDecial_N1_igual_N2(BigDecimal n1,
			BigDecimal n2) {

		if (compareBigDecial_N1_N2(n1, n2) == null) {
			return null;
		}

		if (compareBigDecial_N1_N2(n1, n2) == 0) {
			return true;
		}
		return false;

	}

}
