# Verificador de CPF

Projeto com Java 23, Spring Framework 3.4.3 e Docker criado para resolver a atividade proposta na disciplina de Sistemas Distribuídos:

Implementação de duas versões (TCP e UDP) de um sistema cliente-servidor para validar um cpf.  
A aplicação cliente enviará um número de CPF e o servidor validará ou não respondendo ao cliente.

---

Grupo:

- ARNALDO LUCAS SANTOS DUARTE 
- JAIRON JOSE TAVARES DOS SANTOS 
- JOCKSON MATEUS DA SILVA DUARTE

---

# Estrutura do projeto

- Validação do CPF: [CPFValidator](src/main/java/com/spring/cpf_validator_back/core/CPFValidator.java)
- Servidor TCP: [TCPServer](src/main/java/com/spring/cpf_validator_back/server/TCPServer.java)
- Servidor UDP: [UDPServer](src/main/java/com/spring/cpf_validator_back/server/UDPServer.java)
- Cliente TCP: [TCPClient](src/main/java/com/spring/cpf_validator_back/client/TCPClient.java)
- Cliente UDP: [UDPClient](src/main/java/com/spring/cpf_validator_back/client/UDPClient.java)

---

# Instruções

### Para executar a aplicação localmente:

- Clone este projeto: `git clone https://github.com/luc-gh/CPF-Validator-Back.git`
- Execute o Docker em seu sistema (ele precisa estar em execução para a aplicação ser inicializada)
- No terminal, com o projeto aberto, execute `mvn spring-boot:run` (é preciso ter o Java e Maven instalados, e a porta 8080 livre)

### Para ver a execução externa:

O projeto tem uma página no Github Pages, que se comunica com esta aplicação. A aplicação backend por sua vez, está em execução no Render.  
Quando uma requisição é realizada, o servidor do backend é inicializado, e fica ativo por um tempo esperando por requisições. Caso não ocorram requisições, ele é pausado.  
Se uma nova requisição for feita, demoram aproximadamente 30 segundos para haver uma resposta na página web (do frontend).  
Após a primeira requisição, novas requisições demoram aproximadamente 2 segundos para terem uma resposta.

- Para ver a interface desenvolvida, acesse: https://luc-gh.github.io/CPF-Validator-Front/

O servidor é mantido pelo Render a partir de uma imagem do projeto backend que está salva no DockerHub.