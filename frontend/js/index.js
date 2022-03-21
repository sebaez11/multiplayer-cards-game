const gamesContainer = document.getElementById('games-container-user');

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
    fragment += createTemplateListGames(game);
  });
  gamesContainer.innerHTML = fragment;
}

function createTemplateListGames({ name, id, image }) {
  return `<div class="col-3 p-0">
        <div class="card">
            <img src="${image}" class="card-img-top" alt="...">
            <div class="card-body d-flex justify-content-between align-items-center pt-0">
                <h5 class="card-title">${name}</h5>
                <div>
                    <a href="createRoomModal" data-bs-toggle="modal" data-bs-target="#listRoomsModal" class="btn btn-primary button-card">Jugar Ahora</a>
                    <a href="#"  data-bs-toggle="modal" data-bs-target="#createRoomModal" class="btn btn-warning button-card ">Crear Sala</a>
                </div>
            </div>
        </div>
    </div>
`;
}

getListGames();
