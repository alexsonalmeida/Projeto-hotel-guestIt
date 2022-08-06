public enum Agencia{
    LOCAL("local"), INTERNACIONAL("internacional");
    private String agencia;

    Agencia(String agencia){
        this.agencia = agencia;
    }

    public String getAgencia(){
        return this.agencia;
    }

    @Override
    public String toString() {
        String msg = "";
        switch (this.agencia) {
            case "local":
                msg += "Agencia Local";
                break;
            case "internacional":
                msg += "Agencia Internacional";
                break;
            default:
                msg += "Tipo de agencia não especificado";
                break;
        }
        return msg;
    }
}