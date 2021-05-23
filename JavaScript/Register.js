function openSearch() {
    document.getElementById("myOverlay").style.display = "block";
}

function closeSearch() {
    document.getElementById("myOverlay").style.display = "none";
}

function myFunctionlogin() {
    alert("Please login or register !");
}

function sendRequest() {
    var firstName = document.getElementById("firstName").value;
    var lastName = document.getElementById("lastName").value;
    var userName = document.getElementById("userName").value;
    var password = document.getElementById("password").value;
    var passwordConfirm = document.getElementById("passwordConfirm").value;
    var birthday = document.getElementById("birthday").value;
    var phoneNumber = document.getElementById("phoneNumber").value;
    var address = document.getElementById("address").value;
    var email = document.getElementById("email").value;

    if (password === passwordConfirm) {
        fetch('http://localhost:8080/registration', {
            method: 'POST',
            headers: {
                'content-type': 'application/json',
            },
            body: JSON.stringify({
                firstName: firstName,
                lastName: lastName,
                userName: userName,
                password: password,
                birthDay: birthday,
                phoneNumber: phoneNumber,
                address: address,
                email: email
            })
        })

        .then(response => response.json())
            .then(data => {
                console.log('Success:', data);
                alert(data.message);
                window.location = 'LoginFinal.html';
            })
            .catch(err => {
                console.log(err)
            })
    } else {
        alert("Password Confirmation does not match Password. Please try again.");
    }
}