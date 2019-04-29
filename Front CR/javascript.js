class Ajax {

    constructor (uri){
this.uri = uri;

    }
    get(path){ 
     return  fetch(this.uri+path)
        .then(response => response.json())
        
    }
    post(path, data){
       return fetch(this.uri+path, {  
            method: 'POST',
            body: JSON.stringify(data),
            headers: {
              "Content-type": "application/json; charset=UTF-8"
            }
        })
        .then(response => response.json())
    }
    delete(path) {
       return fetch(this.uri+path, {
            method: 'DELETE'
          })
     }
}




//Créer une classe ajax dans un fichier différent 
//que l'on ommera ajax.js qui nous permet d'intéragir 
//avec une api 


/*
const inputValue = document.getElementById('username').nodeValue;
const submitButton = docue.getElementById('submitButton');


submitButton.addEventListener('click', event => {
    fetch('https://jsonplaceholder.typicode.com/posts', {
method: 'POST',
body: JSON.stringify(dataAEnvoyer),
headers: {
        "Content-Type": "application/json"
}
})
});    

















/*
.then(response => response.json()) // declatation de fonction anonyme/ ici le traitement est une seule action, on peut se passer des accolades
    .then(json => {
        console.log(json);
    })


    /* équivaut à : 
    .then((function(response) {
        then est un callback
    }))

// fonction anonyme :
(fonction(e) {
    // traitement
})
// peut s'écrire aussi  en nouveauté ES6 - fonction anonyme: 
e => {
}
*/








