//🖕

















  let mail = {
    "type": "mail",
    "validation": false,
    "idInput": "email",
    "idBouton": "bouton",
    "idEltRajout": "poupi",
    "messageErreur": " Entrez un mail correct ",
    foo(email) {
        const reg = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        return reg.test(String(email).toLowerCase());
    }
  };

  let username = {
    "type": "username",
    "validation": false,
    "idInput": "username",
    "idBouton": "bouton",
    "idEltRajout": "poupo",
    "messageErreur": " Entrez un username correct ",
    foo(username){
      if (username.length == 0) {
        return false;
      }
    }
  };

  let mdp = {
    "type": "password",
    "validation": false,
    "idInput": "password1",
    "idInput2": "password2",
    "idBouton": "bouton",
    "idEltRajout": "poupu",
    "messageErreur": "",
    foo(mdp1){
      const mdp2 = document.getElementById(this.idInput2).value;
      if (mdp1!=mdp2 || mdp1=="" || mdp2=="") {
        if (mdp1=="" || mdp2=="") {
          this.messageErreur= " Il faut rentrer un mot de passe voyons !";
        }
        if (mdp1!=mdp2) {
          this.messageErreur= " Il faut entrer deux fois le même mot de passe...";
        }
        return false;
      }
      else {
        return true;
      }
    }
  };


  function verif2(obj){

    const input = document.getElementById(obj.idInput);
    const bouton = document.getElementById(obj.idBouton);

    if (obj.type=="password") {
      //alors y'a un deuxième champs a mettre en rouge si erreur:
      const input2 = document.getElementById(obj.idInput2);
    }


    bouton.addEventListener("click", function(event) {
      event.preventDefault();


    //   var rotation = function (){
    //   $(".imgMouton").rotate({
    //     angle:0,
    //     animateTo:360,
    //     callback: rotation
    //   });
    // }
    //   rotation();


      if (obj.foo(input.value) == false) {

        console.log("faux !");
        obj.validation=false;

        if (document.getElementById(obj.idEltRajout)==null) {
          const child = document.createElement("p");
          var parent = document.getElementById("erreur");
          child.id=obj.idEltRajout;
          parent.appendChild(child);
          child.textContent =obj.messageErreur;
          input.style.border="1px solid red";
          parent.style.display="flex";

          if (obj.type == "password") {
            const input2 = document.getElementById(obj.idInput2);
            input2.style.border="1px solid red";
          }

        }

      }

      else{
          console.log("VRAI !");
          obj.validation=true;
          const elt1 = document.getElementById(obj.idEltRajout);
          if (elt1!=null) {
            elt1.remove();
          }
          input.style.border="0px solid black";
          if (obj.type == "password") {
            const input2 = document.getElementById(obj.idInput2);
            input2.style.border="0px solid black";
          }
      }

      if (mail.validation == true && username.validation == true && mdp.validation == true) {
        console.log("jedisparait !!");
        var divRouge = document.getElementById("erreur");
        divRouge.style.display="none";
        $(document).ready(function(){
            $("#chat1").animate({top: '2000px'}, 3000);
            $("#chat2").animate({top: '2000px'}, 3000);
            $("#chat3").animate({top: '2000px'}, 3000);
            $("#chat4").animate({top: '2000px'}, 3000);
          });

        //inscrire le joueur avec ses entrées:
          //Creation de l'objet a insérer:
          let data={
            mail:document.getElementById("email").value,
            login:document.getElementById("username").value,
            password:document.getElementById("password1").value
          }

          const ajax = new Ajax('https://jsonplaceholder.typicode.com/users');
          ajax.post(data).then(json => console.log(json));

          // On affiche le message
          //creation de la div verte:
          const confirmationInscription = document.createElement("div");
          confirmationInscription.classList.add("bg-success", "text-center","mt-1", "mb-1");

          confirmationInscription.innerText = "Bravo, inscription valide !";
          const glyph = document.createElement("span");
          glyph.classList.add("glyphicon", "glyphicon-thumbs-up");
          confirmationInscription.appendChild(glyph);
          //on insère après le header:
          document.getElementById('header').after(confirmationInscription);

          // On l'efface 3 secondes plus tard
          setTimeout(function() {
            confirmationInscription.remove();
            window.location.href = "login2.html";
          },2000);

      }

    });

  }

verif2(mail);
verif2(username);
verif2(mdp);



// if (a==true && b==true && c==true) {
//   console.console.log("oerheoherofijh");

// }

// //AJAX:
// const ajax = new Ajax('https://jsonplaceholder.typicode.com/todos');
// ajax.get(1).then(json => console.log(json));
// let data = {
//   title: "titre",
//   body: "BlaBlaBla",
//   userId: 12
// };
//
// ajax.post(data).then(json => console.log(json));
//
// ajax.delete(1).then(json => console.log(json));
