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

  let password = {
    "type": "password",
    "validation": false,
    "idInput": "password",
    "idBouton": "bouton",
    "idEltRajout": "poupo",
    "messageErreur": " Entrez un mot de passe voyons !",
    foo(password){
      if (password.length == 0) {
        return false;
      }
    }
  };



  function verif2(obj){

    const input = document.getElementById(obj.idInput);
    const bouton = document.getElementById(obj.idBouton);


    bouton.addEventListener("click", function(event) {
      event.preventDefault();

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
      }

      if (mail.validation == true && password.validation == true) {
        console.log("jedisparait !!");
        var divRouge = document.getElementById("erreur");
        divRouge.style.display="none";
      }

    });

  }

verif2(mail);
verif2(password);
