# CidadesIBGE
API de leitura e manutenção de listas de cidades.


Links disponibilizados pela API para o consumo com exemplificações:


01 - Ler o arquivo CSV das cidades para a base de dados

02 - Retornar somenta as cidades que são capitais ordenadas por nome:
http://localhost:8080/api/cidade/buscarCapitais

03 - Retornar o nome do estado com o maior e menor quantidade de cidades e
a quantidad ede cidades:
http://localhost:8080/api/cidade/minMaxPorEstado

04 - Retornar a quantidade de cidades por estado:
http://localhost:8080/api/cidade/totalCidadesPorEstado

05 - Obter os dados da cidade informando o id do IBGE:
(Exemplo: 4202404 - Blumenau SC)
http://localhost:8080/api/cidade/buscarCidadePorID/4202404

06 - Retornar o nome das cidades baseado em um estado selecionado: 
(Exemplo: RS - Rio Grande do Sul)
http://localhost:8080/api/cidade/buscarCidadePorUF/rs

07 - Permitir adicionar uma nova cidade
(Exemplo: Cidade de Teste - "Teste Bruno")
<a href="http://localhost:8080/api/cidade/incluirCidade/999999/BM/TESTE BRUNO/true/-26.9187/-49.066/TESTE BRUNO/BMS/MR_BRUNO/MESO_BRUNO">http://localhost:8080/api/cidade/incluirCidade/999999/BM/TESTE BRUNO/true/-26.9187/-49.066/TESTE BRUNO/BMS/MR_BRUNO/MESO_BRUNO</a>

08 - Permitir deletar uma cidade
(Exemplo: Cidade de teste criada anteriormente - 999999)
http://localhost:8080/api/cidade/deletarPorId/999999

09 - Permitir selecionar uma coluna do CSV e através dela entrar com uma string
para filtrar. Retornar assim todos os objetos com tal string:
(Exemplo: Busca por nome - Panambi)
http://localhost:8080/api/cidade/buscarPorColunaEValor/name/panambi

10 - Retornar a quantidade de registro baseado em uma coluna. Não deve contar
itens iguais.
(Exemplo: Busca por cidades no estado do RS)
http://localhost:8080/api/cidade/totalRegistrosPorColuna/uf/rs

11 - Retornar a quantidade de registros totais.
http://localhost:8080/api/cidade/totalRegistros

12 - Dentre todas as cidades, obter as duas cidades mais distantes uma da outra
com base na localização (distância em KM em linha reta):
http://localhost:8080/api/cidade/municipiosMaisDistantes
