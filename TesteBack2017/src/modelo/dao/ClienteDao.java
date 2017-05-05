package modelo.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.bean.Cliente;

public class ClienteDao {
    
    public void create(Cliente cliente){
        
        //Metodo conecta ao banco e faz o insert dos dados que é inserido na tela de cadastro.
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt=null;
        
        try {
            
            //Cria query de insert
        stmt = con.prepareStatement("insert into tb_customer_account (id_customer, cpf_cnpj, nm_customer, is_active, vl_total) values(?,?,?,?,?)");
            //Pega os valores inseridos no Cadastro
        stmt.setInt(1, cliente.getId_customer());
        stmt.setInt(2, cliente.getCpf_cnpj());
        stmt.setString(3, cliente.getNm_customer());           
        stmt.setString(4, cliente.getIs_active());
        stmt.setDouble(5, cliente.getVl_total());
            //Executa query
        stmt.executeUpdate();
           //Confirma dados salvos 
        JOptionPane.showMessageDialog(null, "Salvo com sucesso");         
           
            //Valida Insert
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir dados"+ex);
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<Cliente> consulta(){
        
            //Conecta ao banco e cria as variaveis para acesso
         Connection con = ConnectionFactory.getConnection();         
         PreparedStatement stmt = null, stmt2 = null, stmt3 = null;
         ResultSet rs = null, rs2 = null, rs3 = null;

            //Cria uma lista para armazenar os dados da query
         List<Cliente> dadosCliente = new ArrayList<>();
         
            //Defini as querys
        try {
            
                //Regra Query: Saldo maior que 560 e o campo id_customer de 1500 a 2700
            stmt=con.prepareStatement("select cast(avg(vl_total) as decimal(10,2)) as Media from tb_customer_account where vl_total>2 and id_customer between 1500 and 2700");            
             rs = stmt.executeQuery();             
                
                //Regra Query: Media final do saldo de todos os clientes
            stmt2=con.prepareStatement("select cast(avg(vl_total) as decimal(10,2)) as MediaFinal from tb_customer_account");
             rs2 = stmt2.executeQuery();
                
                //Regra Query: Nome dos clientes de id de 1500 a 2700 em ordem descrescente
            stmt3=con.prepareStatement("select nm_customer as Clientes from tb_customer_account where id_customer between 1500 and 2700  order by vl_total DESC");
             rs3 = stmt3.executeQuery();
                
                //Insere valores da query 1 no atributo Media do cliente.
              while(rs.next()){
                 Cliente cli=new Cliente();                 
                 cli.setMedia(rs.getDouble("Media"));
                 dadosCliente.add(cli);                 
              }
              
                //Insere valores da query 2 no atributo Media do cliente.
              while(rs2.next()){
                  Cliente cli=new Cliente();                                    
                  cli.setMediaFinal(rs2.getDouble("MediaFinal"));
                  dadosCliente.add(cli);               
              }
             
                //Insere valores da query 3 no atributo Media do cliente.
              while(rs3.next()){
                  Cliente cli=new Cliente();                  
                  cli.setClientes(rs3.getString("Clientes"));
                  dadosCliente.add(cli);                                    
              }
                                                
              //Valida se foi realizado a consulta 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar dados"+ex);
        } finally{
            ConnectionFactory.closeConnection(con, stmt,rs);           
        }     
         return dadosCliente;           
    }   
}
