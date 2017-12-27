package socket1;

public class OMeuProtocolo {
	
	private int passo = 1;
	
	public String processInput(String entrada) {
		String saida=null;
		
		if (passo ==1) {
			saida="Ola. Identifica-te!";
			passo=2;
			
		}else if (passo==2) {
			if (entrada.equalsIgnoreCase("Eu sou o Pedro.")) {
				saida = "A senha é: \"Azul\". Qual é a contrasenha?";
				passo=3;
			}else {
				saida ="Voce deveria dizer \"Eu sou o Pedro.\"!"+"Tente outra vez";
			}
		}else if(passo==3) {
				if(entrada.equalsIgnoreCase("Amarelo.")) {
					saida="Autenticação Valida! Olá Pedro. O Código de hoje é: 7811";
					passo=4;
				}else {
					saida = "Voce errou na contra senha"+"Tente mais uma vez";
				}
		}else if(passo == 4) {
					if (entrada.equalsIgnoreCase("Adeus.")) {
						saida = "Adeus Pedro!";
						passo=1;
					}else {
						saida="Erro.";
					}
				}
				return saida;
			}
	}
	
