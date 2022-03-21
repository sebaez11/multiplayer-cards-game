const gamesContainer = document.getElementById('games-container-user');
const listRoomsContainer = document.getElementById('list-rooms-container');
const infoRoomCreate = document.getElementById('info-room-create');
const createRoomButton = document.getElementById('create-room-button');
const formCreateRoom = document.getElementById('form-create-room');

createRoomButton.addEventListener('click', createRoom);

function cleanCreateRoomModal() {
  formCreateRoom.reset();
  infoRoomCreate.classList.add('d-none');
}
async function createRoom(evt) {
  evt.preventDefault();

  const formDataGame = new FormData(formCreateRoom);
  const data = {
    roomName: formDataGame.get('room-name'),
    idGame: 1,
    idOwner: 2,
  };
  if (Object.values(data).includes('')) {
    infoRoomCreate.classList.remove('d-none');
    infoRoomCreate.classList.remove('alert-success');
    infoRoomCreate.classList.add('alert-danger');
    infoRoomCreate.textContent = 'Debe rellenar todos los campos';
    return;
  }
  const url = 'crearsala';
  try {
    const createRoomResponse = await fetch(url, {
      method: 'POST',
      body: data,
    });
    infoRoomCreate.classList.remove('d-none');
    infoRoomCreate.classList.remove('alert-danger');
    infoRoomCreate.classList.add('alert-success');
    infoRoomCreate.textContent = 'Se ha creado la sala exitosamente';
    formCreateRoom.reset();
  } catch (error) {
    infoRoomCreate.classList.remove('d-none');
    infoRoomCreate.classList.remove('alert-success');
    infoRoomCreate.classList.add('alert-danger');
    infoRoomCreate.textContent = 'Ha ocurrido un error al crear la sala';
    formCreateRoom.reset();
  }
}

async function getListGames() {
  const listGames = [
    {
      id: 1,
      name: 'Uno',
      image: './images/card2.jpg',
    },
    {
      id: 2,
      name: 'Time',
      image: './images/card2.jpg',
    },
    {
      id: 3,
      name: 'Poker',
      image: './images/card2.jpg',
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
    fragment += createTemplateListGames(game);
  });
  gamesContainer.innerHTML = fragment;
}

async function getListRooms(id) {
  const listRooms = [
    {
      id: 1,
      name: 'Divierte jugando uno',
      numPlayers: 2,
    },
    {
      id: 2,
      name: 'Divierte jugando Poker',
      numPlayers: 3,
    },
    {
      id: 3,
      name: 'Divierte jugando Trakc',
      numPlayers: 5,
    },
  ];
  //   url = '';
  //   try {
  //     const listRoomsResponse = await fetch(url, {
  //       method: 'GET',
  //     });
  //   } catch (error) {
  //     console.log(error);
  //   }
  //   const listRooms = listRoomsResponse.json();
  let fragment = '';
  listRooms.map((room) => {
    fragment += createTemplateListRooms(room);
  });
  listRoomsContainer.innerHTML = fragment;
}

function createTemplateListGames({ name, id, image }) {
  return `<div class="col-3 p-0">
        <div class="card">
            <img src="${image}" class="card-img-top" alt="...">
            <div class="card-body d-flex justify-content-between align-items-center pt-0">
                <h5 class="card-title">${name}</h5>
                <div>
                    <a href="createRoomModal" data-bs-toggle="modal" data-bs-target="#listRoomsModal" class="btn btn-primary button-card" onclick="getListRooms(${id})">Jugar Ahora</a>
                    <a href="#"  data-bs-toggle="modal" data-bs-target="#createRoomModal" class="btn btn-warning button-card" id="button-create-room-modal" onclick="cleanCreateRoomModal()">Crear Sala</a>
                </div>
            </div>
        </div>
    </div>
`;
}

function createTemplateListRooms({ name, id, numPlayers }) {
  return `  <li class="list-group-item d-flex justify-content-between align-items-center">
            ${name}
            <div>
                <span class="badge bg-secondary"><i class="fa fa-users" aria-hidden="true"></i>
                    ${numPlayers}</span>
                <span class="badge bg-primary"><i class="fa fa-globe" aria-hidden="true"></i>
                    Publica</span>
                <a href="game.html?session=1" type="submit" class="btn btn-success"
                    id="create-game-button">Ingresar</a>
            </div>
        </li>
`;
}

getListGames();
