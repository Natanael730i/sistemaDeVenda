// Crie uma instância do objeto XMLHttpRequest
var xhr = new XMLHttpRequest();

// Configure a solicitação GET com a URL desejada
xhr.open('GET', 'https://exemplo.com/api/dados', true);



// Defina a função de callback para tratar a resposta
xhr.onload = function () {
    if (xhr.status >= 200 && xhr.status < 300) {
        // A resposta foi bem-sucedida
        var resposta = xhr.responseText;
        console.log(resposta);
    } else {
        // A resposta contém um erro
        console.error('Erro na requisição: ' + xhr.status + ' ' + xhr.statusText);
    }

    url.createObjectURL(resposta)
};

// Envie a solicitação GET
xhr.send();
