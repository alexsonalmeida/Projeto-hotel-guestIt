public enum TipoDeQuarto {
    QUARTO_FAMILIA("familia"), QUARTO_CASAL("casal"), 
    QUARTO_SOLTEIRO_DUPLO("solteiroDuplo"), QUARTO_UNICO("unico");
    private String tpQuarto;

    private TipoDeQuarto(String tpQuarto) {
        this.tpQuarto = tpQuarto;
    }

    public String getTpQuarto() {
        return this.tpQuarto;
    }
    
    @Override
    public String toString() {
        String msg = "";
        switch (this.tpQuarto) {
            case "unico":
            msg += "Quarto único";
            break;
            
            case "solteiroDuplo":
            msg += "Quarto de solteiro duplo";
            break;

            case "casal":
            msg += "Quarto casal";
            break;

            case "familia":
            msg += "Quarto família";
            break;

            default:
            msg += "Tipo de quarto não especificado ";
            break;
        }

        return msg;
    }
}