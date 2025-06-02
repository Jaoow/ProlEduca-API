# Gerenciamento de Escolas - ProlEduca Admin

Este módulo do frontend permite o gerenciamento completo das escolas cadastradas na plataforma ProlEduca. Ele inclui funcionalidades para listar, visualizar, cadastrar e editar informações detalhadas de cada escola.

## Funcionalidades

1.  **Dashboard de Escolas (`/admin/schools`)**
    *   Lista todas as escolas cadastradas em formato de tabela.
    *   Exibe informações chave como Logo, Nome, Bairro, Email e Telefone.
    *   Permite filtrar as escolas por Nome, Bairro ou Slug.
    *   Ações disponíveis para cada escola:
        *   **Editar:** Abre um modal para modificar os dados da escola selecionada.
        *   **(Futuro):** Deletar escola.
    *   Botão para navegar para a tela de cadastro de nova escola.

2.  **Cadastro de Nova Escola (`/admin/register` ou link do Dashboard)**
    *   Formulário detalhado para inserir todas as informações necessárias para uma nova escola, incluindo:
        *   Dados básicos: Nome, Slug (sugestão automática a partir do nome), Descrição.
        *   Endereço completo: Rua, Número, Bairro, Cidade, Estado, CEP.
        *   Contato: Telefone, Email, Website.
        *   Identificação: CNPJ, Tipo (Pública/Privada).
        *   Visual: URL da Logo ou upload de arquivo de imagem.
        *   Segurança: Senha para a conta da escola (se aplicável).
    *   Validações nos campos para garantir a consistência dos dados.
    *   Feedback visual para o usuário durante e após a submissão.
    *   Após o cadastro bem-sucedido, o usuário é redirecionado para o Dashboard de Escolas.

3.  **Edição de Escola (Modal no Dashboard)**
    *   Acessado através do botão "Editar" na tabela do Dashboard de Escolas.
    *   Apresenta um modal pré-preenchido com os dados atuais da escola selecionada.
    *   Permite modificar todos os campos que foram preenchidos no cadastro.
    *   Ao salvar, as alterações são enviadas para o backend e a lista de escolas no dashboard é atualizada.
    *   Campos como CNPJ, Tipo e Senha podem ser alterados (a alteração de senha é opcional, deixando em branco a senha não é modificada).

## Tecnologias Utilizadas (Frontend)

*   **React:** Biblioteca JavaScript para construção de interfaces de usuário.
*   **TypeScript:** Superset do JavaScript que adiciona tipagem estática.
*   **Vite:** Ferramenta de build e servidor de desenvolvimento rápido.
*   **Styled Components:** Para estilização CSS-in-JS (ou outra biblioteca de sua escolha).
*   **Axios:** Cliente HTTP para realizar chamadas à API do backend.
*   **React Router DOM:** Para gerenciamento de rotas na aplicação.

## Pré-requisitos para Execução

1.  **Node.js e npm (ou Yarn):** Necessários para instalar dependências e rodar o servidor de desenvolvimento.
    *   Node.js: [https://nodejs.org/](https://nodejs.org/)
2.  **Backend ProlEduca API Rodando:** As funcionalidades de gerenciamento de escolas dependem da API backend (Spring Boot) para persistência e consulta de dados.
    *   Certifique-se de que o backend esteja em execução (geralmente em `http://localhost:8080`).
    *   Configure a variável de ambiente `VITE_API_BASE_URL` no arquivo `.env.local` do frontend para apontar para a URL correta do backend. Exemplo:
        ```
        VITE_API_BASE_URL=http://localhost:8080
        ```

## Como Rodar (Frontend)

1.  **Clone o repositório** (se ainda não o fez):
    ```bash
    git clone <url-do-seu-repositorio-frontend>
    cd school-page-main
    ```

2.  **Instale as dependências:**
    ```bash
    npm install
    # ou
    # yarn install
    ```

3.  **Configure as variáveis de ambiente:**
    Crie um arquivo `.env.local` na raiz do projeto frontend e adicione a URL base da sua API:
    ```env
    VITE_API_BASE_URL=http://localhost:8080
    ```

4.  **Inicie o servidor de desenvolvimento:**
    ```bash
    npm run dev
    # ou
    # yarn dev
    ```
    A aplicação frontend estará disponível em `http://localhost:5173` (ou a porta indicada no terminal).

5.  **Acesse as telas de administração:**
    *   Dashboard: `http://localhost:5173/admin/schools`
    *   Cadastro: `http://localhost:5173/admin/register` (ou através de um link no dashboard)


## Pontos de Atenção e Melhorias Futuras

*   **Serviço de Upload de Imagens:** A funcionalidade de upload de arquivos para a logo da escola precisa ser completamente implementada (backend e frontend). Atualmente, pode estar usando URLs manuais ou simulações.
*   **Segurança da Senha:** No backend, a senha da escola deve ser armazenada usando hash (ex: BCrypt). O frontend envia a senha em texto plano (sobre HTTPS em produção).
*   **Tratamento de Erros:** Melhorar o feedback visual para erros de API e validação.
*   **Paginação e Ordenação:** Para a tabela de escolas, implementar paginação e ordenação se o número de escolas crescer muito.
*   **Funcionalidade de Deleção:** Adicionar a capacidade de deletar escolas.
*   **Testes:** Escrever testes unitários e de integração.
*   **Controle de Acesso/Autorização:** Implementar autenticação e autorização para garantir que apenas usuários administradores possam acessar estas funcionalidades.
