# ifood-mobile-test
Create an app that given an Twitter username it will list user's tweets. When I tap one of the tweets the app will visualy indicate if it's a happy, neutral or sad tweet.

## Business rules
* Happy Tweet: We want a vibrant yellow color on screen with a 😃 emoji
* Neutral Tweet: We want a grey colour on screen with a 😐 emoji
* Sad Tweet: We want a blue color on screen with a 😔 emoji
* For the first release we will only support english language

### Hints
* You may use Twitter's oficial API (https://developer.twitter.com) to fetch user's tweets 
* Google's Natural Language API (https://cloud.google.com/natural-language/) may help you with sentimental analysis.

## Non functional requirements
* As this app will be a worldwide success, it must be prepared to be fault tolerant, responsive and resilient.
* Use whatever language, tools and frameworks you feel comfortable to.
* Briefly elaborate on your solution, architecture details, choice of patterns and frameworks.
* Fork this repository and submit your code.

## Solução
* Foi utilizado o MVP com modelo de arquitetura do projeto, pois é uma boa maneira de deixar separado principalmente a parte da view controller do aplicativo, o que facilita na escrita dos testes.
* Os arquivos ficaram separados por feature no projeto, o que facilita na hora de modularizar ou extrair um item se for necessário.
* Foi utilizado a lib okhttp para a execução das requests, em conjunto com o GSON para a realização do parser.
* No projeto há também algumas animações e telas de erros amigáveis para o usuário.
* Foi utilizado vetores nos resources, o que reduz o tamanho do APK, pois o mesmo arquivo pode ser redimensionado em diferentes telas, sem perder a qualidade.
