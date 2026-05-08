# Agenda de Aulas e Eventos
O software desenvolvido tem por objetivo auxiliar o projeto de extensão "Meninas digitais" (UTFPR-CP) a organizar aulas, palestras, e quaisquer tipos de eventos, servindo também como lembrete

## Ferramentas utilizadas
- Apache NetBeans IDE 25: https://netbeans.apache.org/front/main/download/nb25/index.html
- MySQL Workbench 8.0 CE: https://dev.mysql.com/downloads/workbench/8.0.html
- JDK 21: https://www.oracle.com/java/technologies/downloads/#java21

## Como executar
- Clone o repositório em sua máquina;
- Abra o projeto na IDE de sua preferência;
- Na primeira execução, utilize a opção Build;
- Após isso, o projeto pode ser executado com a opção Run.

## Uso do sistema
A primeira tela apresentada é utilizada para conectar-se ao banco. Para preencher a caixa de texto da URL, siga as instruções:
- No workbench, clique com o botão direito na conexão MySQL desejada e selecione a opção "Copy JDBC Connection String to Clipboard";
- Cole a URL copiada na caixa de texto da tela inicial do sistema;
- Após preencher os demais campos, clique em "Confirmar" para criar o banco.

Após criar o banco pela primeira vez, é necessário retornar à tela de conexão e especificá-lo na URL. Seguem dois exemplos de como a URL pode ficar:
- `jdbc:mysql://localhost:3306/agenda`
- `jdbc:mysql://127.0.0.1:3306/agenda`

Também é possível especificar as credenciais de conexão em um arquivo, a fim de não precisar reescrevê-las ao reiniciar o sistema. Para isso:
- Crie uma cópia do arquivo `database.example.properties` na pasta `config`;
- Renomeie a cópia para `database.properties`;
- Edite o arquivo e preencha suas credenciais nos campos terminados com sinal de igual (`=`).

Após isso, certifique-se de que a extensão do arquivo seja `.properties`.
