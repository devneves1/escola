# Sistema de Gerenciamento de Eventos Escolares

## Integrantes:
Daniel Batista Queiroz das neves 04198142
Otávio Vinicius Feio Figueiredo 04182659

## Descrição do Sistema

Sistema desenvolvido para gerenciar eventos realizados em uma comunidade escolar. A aplicação permite o cadastro e gerenciamento de eventos, usuários, categorias, comentários, avaliações, inscrições, locais, organizadores, notificações e patrocinadores. O sistema foi construído como uma API REST utilizando **Java com Spring Boot** e banco de dados **NoSQL MongoDB Atlas**.

---

## Tecnologias Utilizadas

- Java 17
- Spring Boot 3.5.14
- Spring Data MongoDB
- MongoDB Atlas (nuvem)
- Maven

---

## Estrutura das Coleções

### 1. `usuarios`
Armazena os usuários do sistema. O campo `tipo` define o papel do usuário e determina quais campos extras ele possui.

```json
{
  "_id": "ObjectId",
  "nome": "João Silva",
  "email": "joao@escola.com",
  "senha": "123456",
  "tipo": "aluno",
  "matricula": "2025001",
  "turma": "3A",
  "dataCadastro": "2025-01-10",
  "ativo": true
}
```

---

### 2. `categorias`
Armazena as categorias dos eventos para classificação e agrupamento.

```json
{
  "_id": "ObjectId",
  "nome": "Pedagógico",
  "descricao": "Eventos voltados para atividades de ensino e aprendizagem",
  "ativo": true
}
```

---

### 3. `locais`
Armazena os locais disponíveis para a realização dos eventos.

```json
{
  "_id": "ObjectId",
  "nome": "Auditório",
  "capacidade": 200,
  "descricao": "Espaço coberto para eventos culturais e palestras",
  "disponivel": true
}
```

---

### 4. `organizadores`
Armazena os responsáveis pela organização dos eventos.

```json
{
  "_id": "ObjectId",
  "nome": "Ana Paula Lima",
  "email": "ana@escola.com",
  "cargo": "Coordenadora",
  "telefone": "91999990001",
  "ativo": true
}
```

---

### 5. `eventos`
Coleção principal do sistema. Referencia categorias, locais e organizadores pelos seus IDs.

```json
{
  "_id": "ObjectId",
  "nome": "Feira de Ciências 2025",
  "descricao": "Exposição de projetos científicos dos alunos do ensino médio",
  "data": "2025-09-15",
  "horario": "08:00",
  "categoriaId": "ObjectId",
  "localId": "ObjectId",
  "organizadorId": "ObjectId",
  "vagas": 100,
  "status": "planejado"
}
```

---

### 6. `inscricoes`
Registra as inscrições dos usuários nos eventos.

```json
{
  "_id": "ObjectId",
  "usuarioId": "ObjectId",
  "eventoId": "ObjectId",
  "dataInscricao": "2025-08-01",
  "status": "confirmado"
}
```

---

### 7. `avaliacoes`
Registra as notas atribuídas pelos usuários aos eventos.

```json
{
  "_id": "ObjectId",
  "usuarioId": "ObjectId",
  "eventoId": "ObjectId",
  "nota": 5,
  "dataAvaliacao": "2025-09-16"
}
```

---

### 8. `comentarios`
Registra os feedbacks escritos dos usuários sobre os eventos.

```json
{
  "_id": "ObjectId",
  "usuarioId": "ObjectId",
  "eventoId": "ObjectId",
  "texto": "O evento foi muito bem organizado, parabéns a todos!",
  "dataComentario": "2025-09-16"
}
```

---

### 9. `notificacoes`
Registra os avisos enviados aos usuários sobre os eventos.

```json
{
  "_id": "ObjectId",
  "usuarioId": "ObjectId",
  "eventoId": "ObjectId",
  "mensagem": "Lembrete: A Feira de Ciências acontece amanhã às 08h no Auditório!",
  "dataEnvio": "2025-09-14",
  "lida": false
}
```

---

### 10. `patrocinadores`
Registra empresas ou pessoas que apoiam os eventos da escola.

```json
{
  "_id": "ObjectId",
  "nome": "Papelaria Central",
  "contato": "papelaria@email.com",
  "eventoId": "ObjectId",
  "contribuicao": "Doação de materiais escolares para a Feira de Ciências",
  "ativo": true
}
```

---

## Justificativa das Decisões de Modelagem

### Uso do MongoDB (NoSQL)
O MongoDB foi escolhido por sua flexibilidade de esquema, permitindo que documentos da mesma coleção possuam campos diferentes. Isso é especialmente útil na coleção `usuarios`, onde alunos possuem campos como `matricula` e `turma` que não fazem sentido para professores ou responsáveis.

### Referências entre coleções
Optou-se por usar referências (IDs) entre coleções ao invés de embutir documentos. Por exemplo, `eventos` referencia `categorias`, `locais` e `organizadores` pelos seus `_id`. Essa decisão evita duplicação de dados e facilita a atualização — se o nome de uma categoria mudar, basta atualizar em um único lugar.

### Coleções separadas para organizadores e usuários
Embora um organizador possa ser um professor, optou-se por manter coleções separadas pois organizadores possuem responsabilidades específicas sobre os eventos e podem ter dados distintos dos usuários comuns do sistema.

### Coleções de relacionamento
As coleções `inscricoes`, `avaliacoes` e `comentarios` funcionam como tabelas de relacionamento, conectando usuários a eventos. Isso permite consultas e agregações eficientes como contagem de participantes por evento e média de avaliações.

---

## Operações CRUD

O sistema implementa as operações de **Inserção, Leitura, Atualização e Exclusão** em todas as 10 coleções via API REST.

### Rotas disponíveis (exemplo para cada coleção)

| Método | Rota | Descrição |
|--------|------|-----------|
| GET | `/categorias` | Lista todas as categorias |
| GET | `/categorias/{id}` | Busca categoria por ID |
| POST | `/categorias` | Cria nova categoria |
| PUT | `/categorias/{id}` | Atualiza categoria |
| DELETE | `/categorias/{id}` | Remove categoria |

O mesmo padrão se aplica para: `/usuarios`, `/locais`, `/organizadores`, `/eventos`, `/inscricoes`, `/avaliacoes`, `/comentarios`, `/notificacoes`, `/patrocinadores`.

---

## Pipelines de Agregação

### 1. Comentários por Evento
**Rota:** `GET /estatisticas/comentarios-dos-eventos`

Agrupa os comentários pelo `eventoId` e conta o total de comentários por evento.

### 2. Média das Avaliações por Evento
**Rota:** `GET /estatisticas/media-das-avaliacoes`

Agrupa as avaliações pelo `eventoId` e calcula a média das notas recebidas.

### 3. Eventos com Categorias (Lookup)
**Rota:** `GET /estatisticas/evento-com-categorias`

Realiza um `$lookup` entre a coleção `eventos` e `categorias`, retornando cada evento com os dados completos da sua categoria.

---

## Como Executar Localmente

### Pré-requisitos

- Java 17 ou superior instalado
- Maven instalado
- Conta no MongoDB Atlas (gratuita)

### Passo a passo

**1. Clone o repositório**
```bash
git clone https://github.com/devneves1/escola
cd eventos
```

**2. Configure o MongoDB Atlas**

Abra o arquivo `src/main/resources/application.yaml` e substitua a connection string pela sua:

```yaml
spring:
  application:
    name: eventos
  data:
    mongodb:
      uri: mongodb+srv://SEU_USUARIO:SUA_SENHA@seu-cluster.mongodb.net/?appName=seu-app
      database: Escola
```

**3. Execute o projeto**
```bash
./mvnw spring-boot:run
```

**4. Acesse a API**

A API estará disponível em: `http://localhost:8080`

### Testando com Postman

Importe as rotas no Postman e utilize a URL base `http://localhost:8080`. Para requisições POST e PUT, envie o corpo em formato JSON com o header `Content-Type: application/json`.
