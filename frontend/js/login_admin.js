const form_adm = document.getElementById('form_adm');
const inputs = document.querySelectorAll('#form_adm input');

const expresiones = {
  usuario: /^[a-zA-Z0-9\_\-]{4,16}$/, // Letras, numeros, guion y guion_bajo
  password: /^.{4,12}$/, // 4 a 12 digitos.
};

const campos = {
  usuario: false,
  password: false,
};

const validarFormulario = (e) => {
  switch (e.target.name) {
    case 'usuario':
      validarCampo(expresiones.usuario, e.target, 'usuario');
      break;
    case 'password':
      validarCampo(expresiones.password, e.target, 'password');
      break;
  }
};

const validarCampo = (expresion, input, campo) => {
  if (expresion.test(input.value)) {
    document
      .getElementById(`grupo__${campo}`)
      .classList.remove('formulario__grupo-incorrecto');
    document
      .getElementById(`grupo__${campo}`)
      .classList.add('formulario__grupo-correcto');
    document
      .querySelector(`#grupo__${campo} i`)
      .classList.add('fa-check-circle');
    document
      .querySelector(`#grupo__${campo} i`)
      .classList.remove('fa-times-circle');
    document
      .querySelector(`#grupo__${campo} .formulario__input-error`)
      .classList.remove('formulario__input-error-activo');
    campos[campo] = true;
  } else {
    document
      .getElementById(`grupo__${campo}`)
      .classList.add('formulario__grupo-incorrecto');
    document
      .getElementById(`grupo__${campo}`)
      .classList.remove('formulario__grupo-correcto');
    document
      .querySelector(`#grupo__${campo} i`)
      .classList.add('fa-times-circle');
    document
      .querySelector(`#grupo__${campo} i`)
      .classList.remove('fa-check-circle');
    document
      .querySelector(`#grupo__${campo} .formulario__input-error`)
      .classList.add('formulario__input-error-activo');
    campos[campo] = false;
  }
};

inputs.forEach((input) => {
  input.addEventListener('keyup', validarFormulario);
  input.addEventListener('blur', validarFormulario);
});

formulario.addEventListener('submit', (e) => {
  e.preventDefault();

  if (campos.usuario && campos.password) {
    form_adm.reset();

    document
      .getElementById('formulario__mensaje-exito')
      .classList.add('formulario__mensaje-exito-activo');
    setTimeout(() => {
      document
        .getElementById('formulario__mensaje-exito')
        .classList.remove('formulario__mensaje-exito-activo');
    }, 5000);

    document
      .querySelectorAll('.formulario__grupo-correcto')
      .forEach((icono) => {
        icono.classList.remove('formulario__grupo-correcto');
      });
  } else {
    document
      .getElementById('formulario__mensaje')
      .classList.add('formulario__mensaje-activo');
  }
});
