const ajax = new Ajax('https://jsonplaceholder.typicode.com')




function generateUser(user) {
    let random = Math.floor(Math.random() * Math.floor(9));
    //const utilisateurParent = document.getElementById('cartes')

    // je récupère mon élément parent
    let cartes = document.getElementById('cartes');

    //je crée la div carteUtilisateur
    let carteUtilisateur = document.createElement('div');
    carteUtilisateur.classList.add('cartes-utilisateurs');

    //je crée div utilisateur
    let utilisateur = document.createElement('div');
    utilisateur.classList.add('utilisateur');

    // je crée div username
    let username = document.createElement('div');
    username.classList.add('username');
   

    // je crée mon image
    let photo = document.createElement('img');
    photo.classList.add('photo');
    photo.srcset = 'https://randomuser.me/api/portraits/lego/' + random + '.jpg';

    // Je crée le ul / liste
    let infos = document.createElement('ul');
    infos.classList.add('infos-surbrillance');
    // LI
    let nom = document.createElement('li');
    nom.classList.add('name');
    nom.innerText = user.name;
    let mail = document.createElement('li');
    mail.classList.add('email');
    mail.innerText = user.email;

    // ajout des li dan le ul
    infos.append(nom);
    infos.append(mail);

    //on rattache la photo et les infos en surbrillances à l'utilisateur
    utilisateur.append(photo);
    utilisateur.append(infos);

    //Je crée le texte du username
    let pseudo = document.createElement('p');
    pseudo.innerText = user.username;

    // ajout de l'id qui sera le score
    let identifiant = document.createElement('p');
    identifiant.innerText = "Score :  "+user.id;
    // je rattache p à nom
    username.append(pseudo);
    username.append(identifiant);

    //Je rajoute utilisateur et nom dans carte utilisateur
    carteUtilisateur.append(utilisateur);
    carteUtilisateur.append(username);

    //Je rajoute carte utilisateur dans la section cartes
    cartes.append(carteUtilisateur);

}



 ajax.get('/users').then(response => {
    for(let i=0; i<response.length; i++) {
        generateUser(response[i]);
    }
});
 
