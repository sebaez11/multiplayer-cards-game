const buttonPauseGame = document.getElementById('button-pause-game');
const resumeGameButton = document.getElementById('resume-game-button');

buttonPauseGame.addEventListener('click', async () => {
  console.log('reanudar juego');
  const url = '';
  /*try {
    const pauseGameResponse = await fetch(url, {
      method: 'POST',
      data: JSON.stringify({
        idSala: 1,
      }),
    });
  } catch (error) {
    console.log('Ha ocurrido un error al pausar juego');
  }*/
});

resumeGameButton.addEventListener('click', async () => {
  console.log('reanudar juego');
  const url = '';
  /*try {
    const resumeGameResponse = await fetch(url, {
      method: 'POST',
      data: JSON.stringify({
        idSala: 1,
      }),
    });
  } catch (error) {
    console.log('Ha ocurrido un error al reanudar juego');
  }*/
});
