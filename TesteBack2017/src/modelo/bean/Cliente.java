package modelo.bean;

public class Cliente {
    
    private int id_customer;
    private int cpf_cnpj;
    private String nm_customer;
    private String  is_active;
    private double vl_total;
    private double media;
    private String clientes;
    private double MediaFinal;

    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public int getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(int cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public String getNm_customer() {
        return nm_customer;
    }

    public void setNm_customer(String nm_customer) {
        this.nm_customer = nm_customer;
    }

    public String getIs_active() {
        return is_active;
    }

    public void setIs_active(String is_active) {
        this.is_active = is_active;
    }

    public double getVl_total() {
        return vl_total;
    }

    public void setVl_total(double vl_total) {
        this.vl_total = vl_total;
    }

   public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }
 
    public String getClientes() {
        return clientes;
    }

    public void setClientes(String clientes) {
        this.clientes = clientes;
    }
    
    public double getMediaFinal() {
        return MediaFinal;
    }

    public void setMediaFinal(double MediaFinal) {
        this.MediaFinal = MediaFinal;
    }
    
    
    
}
