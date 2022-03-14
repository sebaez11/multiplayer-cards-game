const modalCreateButton = document.getElementById('create-game-button');
const createModal = document.getElementById('createModal');
const listGamesAdmin = document.getElementById('list-games-admin');
const listCardsAdmin = document.getElementById('list-cards-admin');
const createGameButton = document.getElementById('create-game-button');
const formCreateGame = document.getElementById('form-create-game');
const infoGameCreate = document.getElementById('info-game-create');
const buttonCreateGameModal = document.getElementById(
  'button-create-game-modal'
);

buttonCreateGameModal.addEventListener('click', () => {
  infoGameCreate.classList.add('d-none');
});
createGameButton.addEventListener('click', createGame);

async function createGame(evt) {
  evt.preventDefault();
  const formDataGame = new FormData(formCreateGame);
  const data = {
    image: formDataGame.get('image-game').name,
    name: formDataGame.get('game-name'),
    numCards: formDataGame.get('number-cards'),
  };
  if (Object.values(data).includes('')) {
    infoGameCreate.classList.remove('d-none');
    infoGameCreate.classList.remove('alert-success');
    infoGameCreate.classList.add('alert-danger');
    infoGameCreate.textContent = 'Debe rellenar todos los campos';
    return;
  }
  const url = '';
  try {
    const createGameResponse = await fetch(url, {
      method: 'POST',
      data,
    });
    infoGameCreate.classList.remove('d-none');
    infoGameCreate.classList.remove('alert-danger');
    infoGameCreate.classList.add('alert-success');
    infoGameCreate.textContent = 'Se ha creado el juego exitosamente';
    formCreateGame.reset();
  } catch (error) {
    infoGameCreate.classList.remove('d-none');
    infoGameCreate.classList.remove('alert-success');
    infoGameCreate.classList.add('alert-danger');
    infoGameCreate.textContent = 'Ha ocurrido un error al crear el juego';
    formCreateGame.reset();
  }
}

async function getListGamesAdmin() {
  const listGames = [
    {
      id: 1,
      name: 'Uno',
      image: 'http://127.0.0.1:5500/frontend/images/card2.jpg',
    },
    {
      id: 2,
      name: 'Time',
      image: 'http://127.0.0.1:5500/frontend/images/card2.jpg',
    },
    {
      id: 3,
      name: 'Poker',
      image: 'http://127.0.0.1:5500/frontend/images/card2.jpg',
    },
  ];
  //   url = '';
  //   try {
  //     const listGamesResponse = await fetch(url, {
  //       method: 'GET',
  //     });
  //   } catch (error) {
  //     console.log(error);
  //   }
  //   const listGames = listGamesResponse.json();
  let fragment = '';
  listGames.map((game) => {
    fragment += createTemplateListGamesAdmin(game);
  });
  listGamesAdmin.innerHTML = fragment;
}

async function getListCardsAdmin() {
  const listCards = [
    {
      id: 1,
      name: 'Carta 1',
      image: 'http://127.0.0.1:5500/frontend/images/card2.jpg',
    },
    {
      id: 2,
      name: 'Carta2',
      image: 'http://127.0.0.1:5500/frontend/images/card2.jpg',
    },
    {
      id: 3,
      name: 'Carta 3',
      image: 'http://127.0.0.1:5500/frontend/images/card2.jpg',
    },
  ];
  //   url = '';
  //   try {
  //     const listCardsResponse = await fetch(url, {
  //       method: 'GET',
  //     });
  //   } catch (error) {
  //     console.log(error);
  //   }
  //   const listCards = listCardsResponse.json();
  let fragment = '';
  listCards.map((game) => {
    fragment += createTemplateListCardsAdmin(game);
  });
  listCardsAdmin.innerHTML = fragment;
}

function createTemplateCreateGameForm() {
  return `
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Crear Juego</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <div class="alert alert-success d-none mb-4" id="info-game-create" role="alert">

                        </div>
                        <form class="md-form" id="form-create-game" novalidate>
                            <div class="file-field d-flex flex-column align-items-center mb-4">
                                <div class="mb-4">
                                    <img src="./images/card2.jpg" class="rounded-circle z-depth-1-half avatar-pic"
                                        alt="example placeholder avatar">
                                </div>
                                <label class="btn btn-primary" for="my-file-selector">
                                    <input id="my-file-selector" type="file" class="d-none" name="image-game">
                                    Añadir Imagen
                                </label>
                            </div>
                            <div class="form-row">
                                <div class="col-12 mb-3">
                                    <label for="validationTooltip01">Nombre del juego</label>
                                    <input type="text" class="form-control" id="validationTooltip01"
                                        placeholder="ej. Uno" required name="game-name">

                                </div>
                                <div class="col-12 mb-3">
                                    <label for="validationTooltip02">Numero de Cartas</label>
                                    <input type="number" min="1" class="form-control" id="validationTooltip02"
                                        placeholder="0" value="Otto" required name="number-cards">

                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                                <button type="submit" class="btn btn-success" id="create-game-button">Crear</button>
                            </div>
                        </form>
                    </div>

                </div>
            </div>
  
  `;
}

function createTemplateListGamesAdmin({ name, id, image }) {
  return `<div class="col-2 p-0">
                <div class="card card-admin">
                    <img src="${image}" class="card-img-top" alt="...">
                    <div class="card-body d-flex justify-content-between align-items-center pt-0">
                        <h5 class="card-title">${name}</h5>
                        <div>
                            <a href="#" onclick="getListCardsAdmin()" class="btn btn-primary button-card" data-bs-toggle="modal"
                                    data-bs-target="#editModal"><i class="fa fa-edit"></i></a>
                            <a href="#" class="btn btn-danger button-card" data-bs-toggle="modal"
                                    data-bs-target="#deleteModal"><i class="fa fa-trash" aria-hidden="true"></i>
                            </a>
                        </div>
                    </div>
                </div>
            </div>`;
}
function createTemplateListCardsAdmin({ name, id, image }) {
  return `<div class="col-2 p-0">
            <div class="card card-admin card-admin-list">
              <img src="${image}" class="card-img-top" alt="...">
              <div
                  class="card-body d-flex justify-content-between align-items-center pt-0">
                  <h5 class="card-title">${name}</h5>
                  <div>
                      <button class="btn btn-primary button-card"
                          data-bs-toggle="modal" data-toggle="modal"
                          data-bs-target="#editCard"><i
                              class="fa fa-edit"></i></button>
                      <button class="btn btn-danger button-card"
                          data-bs-target="#deleteCard" data-bs-toggle="modal"
                          data-bs-dismiss="modal"><i class="fa fa-trash"
                              aria-hidden="true"></i>
                      </button>
                  </div>
              </div>
          </div>
      </div>`;
}
getListGamesAdmin();
