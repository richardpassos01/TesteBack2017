# TesteBack2017

  --Arquivo de conexão com o banco de dados oracle
--src/connection/connectionFactory.Java

  --Pasta com imagens do projeto
 src/imagens/

  --Arquivo cliente contendo a modelagem, criação de atributos que serão cadastrados, com getters e setters
src/modelo/bean/Cliente.java

 --Arquivo cliente contendo as interações que serão feitas no banco de dados
src/modelo/dao/ClienteDao.java

--1-Tela de inicialização, 2-Menu de opção, ação(somente cadastro funcional), 3 - Layout de cadastro(funcional)
src/view/ Menu.java
        --Menu2.Java
        --Cadastro.java


# Create Table 

-     create table tb_customer_account(
-     id_customer integer primary key,
-     cpf_cnpj number(14),
-     nm_customer varchar2(60),
-     is_active  char(4),
-     vl_total  number(10,2)
-     );



