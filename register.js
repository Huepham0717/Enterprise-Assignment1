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