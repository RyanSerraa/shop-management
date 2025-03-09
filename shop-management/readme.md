# Bem-vindo a aplicação shop-management

# Overview da aplicação  
Esta é uma aplicação que vai simular um sistema de compras onde a pesssoa ela vai comprar um determinado produto e a aplicação irá realizar o serviço de verficar se o produto selecionado pelo cliente ainda existe em estoque em algumas das lojas disponivei. O processo ocorre da seguinte maneira:
    1. Consulta de Estoque (GET): O cliente faz uma requisição GET para verificar a disponibilidade do produto em estoque em várias lojas cadastradas.

    2. Realização de Pedido (POST): Após verificar a disponibilidade, o cliente pode fazer uma requisição POST para registrar o pedido. Nesse momento, a aplicação verifica se o produto selecionado ainda está disponível na loja e, se estiver, reduz a quantidade em estoque da loja correspondente ou redistribui a quantidade entre as lojas, caso necessário.

# Tecnologias utilizadas
    Postgresql
    SpringBoot
    JPA
    GIT
# Modelagem Do Banco de dados     
![Diagrama do banco](image.png)