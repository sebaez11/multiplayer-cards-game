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
  formCreateGame.reset();
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
    await getListGamesAdmin(true);
  } catch (error) {
    infoGameCreate.classList.remove('d-none');
    infoGameCreate.classList.remove('alert-success');
    infoGameCreate.classList.add('alert-danger');
    infoGameCreate.textContent = 'Ha ocurrido un error al crear el juego';
    formCreateGame.reset();
  }
}

async function getListGamesAdmin(s) {
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

async function deleteGame(id) {
  let data = {
    id,
  };
  //   url = '';
  //   try {
  //     const listCardsResponse = await fetch(url, {
  //       method: 'DELETE',
  //       data;
  //     });
  //   } catch (error) {
  //     console.log(error);
  //   }
  //   const listCards = listCardsResponse.json();
}

async function updateDeleteModal(id, name) {
  document.getElementById('name-game-delete').textContent = name;
  await deleteGame(id);
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
                            <a href="#" onclick="updateDeleteModal('${id}','${name}')" class="btn btn-danger button-card" data-bs-toggle="modal"
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
                          data-bs-target="#deleteCard"  data-bs-toggle="modal"
                          data-bs-dismiss="modal"><i class="fa fa-trash"
                              aria-hidden="true"></i>
                      </button>
                  </div>
              </div>
          </div>
      </div>`;
}
getListGamesAdmin();
