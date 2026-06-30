# Agenda de Aulas e Eventos

O software desenvolvido tem por objetivo auxiliar o projeto de extensão "Meninas digitais" (UTFPR-CP) a organizar aulas, palestras, e quaisquer tipos de eventos, servindo também como lembrete
O software foi desenvolvido pelo Grupo 2, composto por:

Arthur Henrique Caron
Gabriel Pinheiro Ferrari
João Pedro Trevisan Borghi
Pedro Henrique da Costa e Silva

## Ferramentas utilizadas

* Apache NetBeans IDE 25: https://netbeans.apache.org/front/main/download/nb25/index.html
* MySQL Workbench 8.0 CE: https://dev.mysql.com/downloads/workbench/8.0.html
* JDK 21: https://www.oracle.com/java/technologies/downloads/#java21
* Git 2.54: https://git-scm.com/install/windows
  
## Como compilar

* Clone o repositório em sua máquina;
* Abra o projeto na IDE de sua preferência;
* Na primeira execução, utilize a opção Build;
* Após isso, o projeto pode ser executado com a opção Run.

## Como executar

* Neste repositório, consulte Actions
* Clique na action mais recente, role até o final da página e baixe o jar-files.zip
* Descompacte o jar-files.zip
* Execute sistema-agenda-1.0-SNAPSHOT.jar (no Windows, basta clicar sobre o ícone. No Linux, rode: `sudo java -jar sistema-agenda-1.0-SNAPSHOT.jar`).

### Atenção
É necessário ter MySQL Workbench e JDK nas versões especificadas acima. 

## Uso do sistema

A primeira tela apresentada é utilizada para conectar-se ao banco. Para preencher a caixa de texto da URL, siga as instruções:

* No workbench, clique com o botão direito na conexão MySQL desejada e selecione a opção "Copy JDBC Connection String to Clipboard";
* Cole a URL copiada na caixa de texto da tela inicial do sistema;
* Após preencher os demais campos, clique em "Confirmar" para criar o banco.

Também é possível especificar as credenciais de conexão em um arquivo, a fim de não precisar reescrevê-las ao reiniciar o sistema. Para isso:

* Crie uma cópia do arquivo `database.example.properties` na pasta `config`;
* Renomeie a cópia para `database.properties`;
* Edite o arquivo e preencha suas credenciais nos campos terminados com sinal de igual (`=`).

Após isso, certifique-se de que a extensão do arquivo seja `.properties`.

## Funcionalidades implementadas

* Cadastro de usuário e login
* Cadastro, modificação e exclusão de evento na tela de admin
* Consulta aos usuários inscritos num evento na tela de admin
* Exclusão de usuários na tela de admin
* Inscrição em evento na tela de usuário
* Cancelamento de inscrição em evento na tela de usuário

Certifique-se de cadastrar ao menos um evento e um usuário antes de tentar se inscrever num evento ou consultar participantes nele inscritos.

