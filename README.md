# 🏗️ Cais — Hub de Inovação e Pesquisa de Recife

> **Marketplace de conhecimento** entre academia, empresas e governo.
> Um projeto do **Projeto Integrador — Arquitetura de Software** (CST em Análise e Desenvolvimento de Sistemas).

---

## 📌 Sobre o projeto

O **Cais** conecta a produção acadêmica e científica de Recife às demandas de empresas e do setor público, transformando o Hub em uma **rede segmentada de conhecimento e talento** — com inteligência artificial apoiando tradução, categorização, matching, perfil e moderação.

| | |
|---|---|
| **Nome** | Cais (ex-Hub de Inovação e Pesquisa de Recife) |
| **Problema** | A produção acadêmica permanece pouco visível fora das universidades, enquanto empresas e governo têm dificuldade para localizar pesquisas, soluções e talentos aplicáveis a problemas reais. |
| **Objetivo** | Transformar essa lacuna em uma rede segmentada, com IA apoiando tradução, categorização, matching, perfil e moderação. |
| **Entregável atual** | Documentação de requisitos, arquitetura e qualidade (fase de levantamento) |

### 👥 Público-alvo

- Pesquisadores individuais
- Grupos e laboratórios de pesquisa
- Empresas e recrutadores
- Agentes governamentais
- Universidades e instituições

### 🔀 Escopo consolidado

O sistema contempla o fluxo de **oferta acadêmica**, o fluxo de **demanda** de mercado/governo, **busca e filtros inteligentes**, **matching explicável**, **contato com proteção de propriedade intelectual** e camadas futuras de contratação, monetização, impacto institucional e governança.

---

## ✨ Funcionalidades principais

### Núcleo do MVP (Estórias 1–6)

| # | Estória | Resumo |
|---|---------|--------|
| 1 | Criar Perfil do Pesquisador | Currículo vivo, público e com visibilidade campo a campo, vinculado ao Lattes. |
| 2 | Cadastrar Projeto com IA | Resumo acadêmico + tradução mercadológica e categorização (ODS/área) por IA. |
| 3 | Publicar no Feed Segmentado | Seções: Pesquisas, Editais/Vagas, Bolsas e Demandas. |
| 4 | Buscar e Filtrar Conteúdos | Busca inteligente por ODS, área do conhecimento, instituição e tipo de conteúdo. |
| 5 | Cadastrar Demanda | Empresas e governo publicam desafios, problemas públicos, editais, vagas e bolsas. |
| 6 | Encontrar Matches | Motor de matching com **score de compatibilidade** e **justificativa gerada por IA**. |

### Camadas de evolução (Estórias 7–11)

| # | Estória | Fase |
|---|---------|------|
| 7 | Contato e Proteção de Conteúdo Sensível (NDA) | 🟡 Camada de negócio |
| 8 | Candidatura, Convite e Contratação | 🟡 Camada de negócio |
| 9 | Acompanhar Impacto e Indicadores (KPIs) | 🔵 Camada institucional |
| 10 | Moderação, Governança e Compliance | 🔵 Camada institucional |
| 11 | Recursos de Monetização (planos, impulsionamento, B2B) | 🟡 Camada de negócio |

**Pontos transversais:** autenticação com identificação de tipo de conta, LGPD, auditoria de moderação, dashboard de impacto e painel administrativo.

---

## 🗂️ Diagrama de pastas

### Estrutura atual do repositório

O repositório está hoje na **fase de documentação** — os artefatos do projeto Integrador:

```
CaisHUB/
│
├── 📄 README.md
│       └── Este documento: visão geral, stack e roteiro do projeto.
│
├── 📄 Levantamento_de_Requisitos_CaisV3-1.pdf
│       └── Documento de visão, 11 estórias de usuário, modelo de dados,
│           protótipo de telas, RNFs, KPIs, roadmap, riscos e relatório de uso de IA.
│
├── 📄 Frameworks e Diagrama de Classes - Cais.pdf
│       └── Stack tecnológica (Spring Boot, React, PostgreSQL, IA),
│           diagrama de classes e classes Java do núcleo do MVP.
│
├── 📄 Feedback_Cais_Atributos_Qualidade.docx
│       └── Feedback avaliativo sobre atributos de qualidade
│           (arquitetura e modelo de negócio) + pontos de evolução.
│
└── 📄 2ª Atividade_Ferramenta_Analise_Diaria.pdf
        └── Atividade avaliativa: as 5 perguntas da ferramenta
            de análise diária aplicadas ao projeto.
```

### Estrutura proposta (código — a implementar)

Estrutura prevista pela stack definida em *Frameworks e Diagrama de Classes*, seguindo o padrão de um backend Spring Boot + frontend React:

```
CaisHUB/
│
├── README.md
├── docker-compose.yml                 # 🔧 orquestra backend, banco e frontend
├── .env.example                       # 🔧 variáveis de ambiente (JWT, LLM API key…)
│
├── docs/                              # 📚 documentação do projeto
│   ├── requisitos/
│   │   ├── Levantamento_de_Requisitos_CaisV3-1.pdf
│   │   └── ...
│   ├── arquitetura/
│   │   └── Frameworks e Diagrama de Classes - Cais.pdf
│   ├── feedback/
│   │   └── Feedback_Cais_Atributos_Qualidade.docx
│   └── atividades/
│       └── 2ª Atividade_Ferramenta_Analise_Diaria.pdf
│
├── backend/                           # ☕ Spring Boot (Java 17+)
│   ├── pom.xml                        # Maven · springdoc · Bean Validation
│   └── src/
│       ├── main/java/br/edu/recife/cais/
│       │   ├── CaisApplication.java
│       │   ├── config/                # Security, JWT, OpenAPI, CORS
│       │   ├── domain/                # entidades: Usuario, PerfilPesquisador,
│       │   │   ├── enum/              #   Projeto, Demanda, Match, Publicacao…
│       │   │   └── interface/         # Matchable, ServicoIA, MotorDeMatching
│       │   ├── repository/            # Spring Data JPA + Hibernate
│       │   ├── service/               # regras de negócio, matching, IA
│       │   ├── web/                   # controllers REST + DTOs
│       │   └── security/              # Spring Security + JWT
│       ├── main/resources/
│       │   ├── application.yml
│       │   └── db/migration/          # Flyway/Liquibase (DDL PostgreSQL)
│       └── test/java/                 # JUnit 5 + Mockito
│
├── frontend/                          # ⚛️ React + TypeScript + Tailwind CSS
│   ├── package.json
│   └── src/
│       ├── components/                # Cards do feed, filtros, badges…
│       ├── pages/                     # Landing, Dashboard, Perfil, Projeto,
│       │                              #   Feed, Busca, Matches
│       ├── services/                  # cliente HTTP da API
│       ├── hooks/
│       └── types/
│
└── ai-service/                        # 🤖 camada de IA (Spring AI / HTTP client)
    ├── src/
    │   ├── traducao/                  # resumo acadêmico → linguagem de mercado
    │   ├── categorizacao/             # ODS + área do conhecimento
    │   ├── matching/                  # justificativa do score
    │   └── moderacao/                 # moderação assistida
    └── ...
```

> ⚠️ A segunda árvore é **uma proposta de organização**, não um estado existente — o código ainda não foi iniciado. Documentos reais estão na raiz (primeira árvore).

---

## 🛠️ Stack tecnológica

| Camada | Tecnologias |
|--------|-------------|
| **Backend** | Spring Boot (Java 17+), Spring Data JPA + Hibernate, Spring Security + JWT, springdoc-openapi (Swagger), Bean Validation |
| **Banco de dados** | PostgreSQL (suporte a *arrays/tags* como `ods_atuacao`) |
| **Frontend** | React + TypeScript, Tailwind CSS (responsivo) |
| **IA** | Spring AI (ou HTTP client) consumindo LLM API — tradução, categorização, justificativa de match e moderação |
| **Infra e qualidade** | Maven, JUnit 5 + Mockito, Docker |

---

## 🗄️ Modelo de dados (resumo)

Entidades principais do MVP — detalhadas em `Levantamento_de_Requisitos_CaisV3-1.pdf`, seção 4:

```
USUARIO ──1:N──▶ PERFIL_PESQUISADOR ──1:N──▶ PROJETO
   │                    │                       │
   │                    └───────┬───────────────┘
   │                       implements Matchable
   │
   ├──1:N──▶ PUBLICACAO   (tipo: PESQUISA | EDITAL | VAGA | BOLSA | DEMANDA)
   ├──1:N──▶ DEMANDA      (tipo: DESAFIO | PROBLEMA_PUBLICO | EDITAL | VAGA | BOLSA)
   └──1:N──▶ MATCH ──────▶ score_compatibilidade + justificativa_IA

# Fase 2/3 (simplificadas): Contato, Nda, Contratacao,
#                            PlanoAssinatura, Impulsionamento, LogModeracao, Kpi
```

**Enums centrais:** `TipoConta` (PESQUISADOR, EMPRESA, GOVERNO, INSTITUICAO), `StatusPublicacao`, `TipoConteudo`, `StatusModeracao`, `TipoDemanda`, `StatusDemanda`.

**Contrato-chave:** a interface `Matchable` (`getTagsOds()`, `getAreaConhecimento()`) é implementada por `Projeto` e `PerfilPesquisador`, permitindo que o motor de matching compare demandas a soluções de forma uniforme.

---

## 🧭 Roadmap

| Fase | Nome | Entregas |
|------|------|----------|
| **1** | MVP acadêmico | Perfil/currículo vivo · feed segmentado · busca e filtros com categorização por IA · matching com score e justificativa por IA |
| **2** | Camada de negócio | Contratação · plano Plus · impulsionamento patrocinado · plano institucional · plano B2B |
| **3** | Camada institucional | Dashboard de impacto · Comitê Tripartite · grupos/laboratórios · integrações com universidades |

---

## ⚠️ Riscos e pontos em aberto

- **Conflito de incentivo** — garantir tecnicamente que o impulsionamento pago **não altere** o score de match (RF14). *Pendente de mecanismo técnico: serviços separados, filtro de "sponsored" antes do ranking ou auditoria.*
- **LGPD** — modelar desde o início as permissões de acesso por tipo de visitante e nível de visibilidade.
- **Visibilidade seletiva por campo (RF03)** — apontada como "a base técnica mais sensível do novo escopo"; merece tratamento próprio.
- **Moderação** — definir política de conteúdo e fluxo de revisão humana antes do lançamento das seções de rede social.
- **Propriedade intelectual** — detalhar quais campos/documentos aparecem antes e depois do NDA.
- **Serviços de IA** — definir quais APIs cobrem as cinco aplicações previstas.
- **Modelagem de dados** — detalhar entidades, relacionamentos, permissões e auditoria antes da modelagem física.
- **Metas numéricas** — quantificar metas de desempenho (ex.: p95 < 300 ms) e estabelecer a stack real de implementação.

---

## 📊 Requisitos não funcionais

- **Desempenho:** resposta às principais operações em até **2 segundos**.
- **Segurança:** validação de entradas, autenticação e verificação de `tipo_conta`.
- **Privacidade:** alinhamento à **LGPD** para perfis, currículos e visibilidade seletiva.
- **Propriedade intelectual:** níveis de visibilidade impedindo exposição indevida de conteúdo técnico.
- **Auditoria:** registro de conteúdos sinalizados pela IA e decisões humanas de moderação.
- **Arquitetura:** separação clara entre **motor de matching** e **exibição/publicidade paga**.
- **Disponibilidade:** meta de **99% de uptime**.
- **Compatibilidade:** principais navegadores modernos + desktop, tablet e smartphone.
- **Escalabilidade e integridade** de dados; **integração futura** com repositórios das universidades.

### 🎯 KPIs principais

Volume de conexões e pedidos de contato · projetos/perfis/demandas ativos · tráfego por tipo de conta · taxa de conversão *match → contato → negócio fechado* · matches e taxa de interação · assinaturas por plano · receita de impulsionamento · NPS por tipo de usuário · indicadores de impacto social, econômico e ambiental.

---

## ▶️ Como executar *(planejado)*

> O código ainda não existe no repositório — abaixo está o comando previsto para o ambiente de desenvolvimento.

```bash
# 1. subir banco + backend + frontend
docker compose up -d

# 2. backend (Spring Boot) — http://localhost:8080
cd backend && mvn spring-boot:run

# 3. documentação Swagger
open http://localhost:8080/swagger-ui.html

# 4. frontend (React) — http://localhost:5173
cd frontend && npm install && npm run dev

# 5. testes
cd backend && mvn test
```

**Variáveis de ambiente esperadas:** `DATABASE_URL`, `DATABASE_USER`, `DATABASE_PASSWORD`, `JWT_SECRET`, `LLM_API_KEY`.

---

## 🤖 Relatório de uso da IA

- **IA utilizada:** ChatGPT
- **Finalidade:** consolidar requisitos de duas documentações do projeto e adaptá-los ao formato de documento de levantamento de requisitos — mantendo estórias de usuário, campos, regras, validações, comportamentos, protótipo de telas e requisitos não funcionais.
- O relatório completo com o prompt de apoio está em `Levantamento_de_Requisitos_CaisV3-1.pdf`, seção 10.

---

## 📚 Índice de documentos

| Documento | Conteúdo |
|-----------|----------|
| `Levantamento_de_Requisitos_CaisV3-1.pdf` | Visão do sistema, 11 estórias, banco de dados, protótipo de telas, RNFs, KPIs, roadmap, riscos, relatório de IA |
| `Frameworks e Diagrama de Classes - Cais.pdf` | Stack, diagrama de classes e código-fonte das classes Java (MVP e fases futuras) |
| `Feedback_Cais_Atributos_Qualidade.docx` | Feedback de qualidade — pontos fortes, pontos de evolução e recomendações de negócio |
| `2ª Atividade_Ferramenta_Analise_Diaria.pdf` | As 5 perguntas da ferramenta de análise diária aplicadas ao Cais |

---

## 📖 Contexto acadêmico

**Projeto Integrador · Arquitetura de Software**
CST em Análise e Desenvolvimento de Sistemas — Profª Priscilla Mendes dos Santos.

*Cliente institucional em estudo: Porto Digital e Prefeitura do Recife (origem do projeto e âncora do Dashboard de Impacto).*