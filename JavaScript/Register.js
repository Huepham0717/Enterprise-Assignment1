function openSearch() {
    document.getElementById("myOverlay").style.display = "block";
}

function closeSearch() {
    document.getElementById("myOverlay").style.display = "none";
}

function myFunctionlogin() {
    alert("Please login or register !");
}

function checkIfLoggedIn() {
    if (sessionStorage.getItem("currentlyLoggedIn") === "1") {
        alert("You are currently signed in. Please open this page in another tab to register a new account.");
        window.location = '/HTML/Userprofile.html';
    }}

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
                    if (data.message === "Account successfully created. Please check your email to verify and activate your account.") {
                    window.location = 'Login.html';
                    }
                })
                .catch(err => {
                    console.log(err)
                })
        } else {
            alert("Password Confirmation does not match Password. Please try again.");
        }
    }
