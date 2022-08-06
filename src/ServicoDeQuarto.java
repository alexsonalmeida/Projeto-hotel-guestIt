public enum ServicoDeQuarto {
    FAXINA("faxina"), BUFE("bufe"), LAVANDERIA("lavanderia");
    String nomeServico;

    private ServicoDeQuarto(String servico) {
        this.nomeServico = servico;
    }

    public static float precoServico(ServicoDeQuarto servico){
        if(servico.equals(FAXINA)){
            return 30;
        }else if(servico.equals(BUFE)){
            return 50;
        }else if(servico.equals(LAVANDERIA)){
            return 25;
        }else{
            return 0;
        }
    }
    public String toString() {
        String nome = "";
        switch (this.nomeServico) {
            case "faxina":
            nome += "faxina";
            break;

            case "bufe":
            nome += "bufe";
            break;

            case "lavanderia":
            nome += "lavanderia";
            break;

            default:
            nome += "Servico nao identificado";
            break;
        }

        return nome;
    }

    public String getNomeServico() {
        return nomeServico;
    }
}
