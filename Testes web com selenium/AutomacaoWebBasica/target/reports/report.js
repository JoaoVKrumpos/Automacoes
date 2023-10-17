$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("desconto.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "# language: pt"
    }
  ],
  "line": 3,
  "name": "Receber desconto da qazando",
  "description": "Eu como usuario da qazando\r\nQuero receber um cupom de desconto\r\npara comprar um curso para um valor reduzido",
  "id": "receber-desconto-da-qazando",
  "keyword": "Funcionalidade"
});
formatter.scenario({
  "line": 8,
  "name": "Visualizar cupom de desconto",
  "description": "",
  "id": "receber-desconto-da-qazando;visualizar-cupom-de-desconto",
  "type": "scenario",
  "keyword": "Cenario",
  "tags": [
    {
      "line": 7,
      "name": "@gerarcupom"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "que estou no site da qazando",
  "keyword": "Dado "
});
formatter.step({
  "line": 10,
  "name": "preencho meu email",
  "keyword": "Quando "
});
formatter.step({
  "line": 11,
  "name": "clico no ganhar cupom",
  "keyword": "E "
});
formatter.step({
  "line": 12,
  "name": "vejo o codigo de desconto",
  "keyword": "Entao "
});
formatter.match({
  "location": "DescontosSteps.que_estou_no_site_da_qazando()"
});
formatter.result({
  "duration": 5129767600,
  "status": "passed"
});
formatter.match({
  "location": "DescontosSteps.preencho_meu_email()"
});
formatter.result({
  "duration": 2174689400,
  "status": "passed"
});
formatter.match({
  "location": "DescontosSteps.clico_no_ganhar_cupom()"
});
formatter.result({
  "duration": 129981600,
  "status": "passed"
});
formatter.match({
  "location": "DescontosSteps.vejo_o_codigo_de_desconto()"
});
formatter.result({
  "duration": 38669600,
  "status": "passed"
});
});