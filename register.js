const togglePassword = document.querySelector('#togglePassword');
const password = document.querySelector('#password');
togglePassword.addEventListener('click', function (e) {
    // toggle the type attribute
    const type = password.getAttribute('type') === 'password' ? 'text' : 'password';
    password.setAttribute('type', type);
    // toggle the eye slash icon
    this.classList.toggle('fa-eye-slash');
});

// Select all text input fields
var formText = document.querySelectorAll('[data-js=form-text]');

// For each field...
[].forEach.call(formText, function (el, i) {
  // Cache the field label
  var thisLabel = el.parentNode.querySelector('label');

  // Add an 'active' class if text present
  el.onkeyup = function () {

    if (el.value.length > 0) {
      thisLabel.classList.add('active');
    } else {
      thisLabel.classList.remove('active');
    }

  };

});
