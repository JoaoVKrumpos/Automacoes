# language: pt

Funcionalidade: Receber desconto da qazando
  Eu como usuario da qazando
  Quero receber um cupom de desconto
  para comprar um curso para um valor reduzido
@gerarcupom
  Cenario: Visualizar cupom de desconto
    Dado que estou no site da qazando
    Quando preencho meu email
    E clico no ganhar cupom
    Entao vejo o codigo de desconto

