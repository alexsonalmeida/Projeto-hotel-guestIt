public enum Instituicao {
    ESCOLA("escola"), UNIVERSIDADE("universidade");
    private String instituicao;

    Instituicao(String instituicao){
        this.instituicao = instituicao;
    }
    
    public String getInstituicao(){
        return this.instituicao;
    }

    @Override
    public String toString() {
        String msg = "";
        switch (this.instituicao) {
            case "escola":
                msg += "Escola";
                break;

            case "universidade":
                msg += "Universidade";
                break;
                
            default:
                msg += "Tipo de instituição não especificado";
                break;
        }
        return msg;
    }
}
