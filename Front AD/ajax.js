class Ajax {

  constructor(url){
    this.url = url;
  }

  get(id){
    return fetch(this.url+"/"+id).then( response => response.json());
  }

  post(data){
    // POST adds a random id to the object sent
    return fetch(this.url, {
        method: 'POST',
        body: JSON.stringify({
        name: data.username,
        email: data.mail,
        username: data.password
        }),
        headers: {
          "Content-type": "application/json; charset=UTF-8"
        }
      })
      .then(response => response.json())
  }

  delete(id){
    return fetch("/"+id, {
      method: 'DELETE'
    })
  }

}
