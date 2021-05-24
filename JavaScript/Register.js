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
    }
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

    if (password) {
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
                        loadUser(userName);
                        // window.location = 'Login.html';
                    }
                })
                .catch(err => {
                    console.log(err)
                })
        } else {
            alert("Password Confirmation does not match Password. Please try again.");
        }
    } else {
        alert("Your password cannot be empty. Please try again.");
    }
}

function loadUser(userName) {
    // var userName = document.getElementById("userName").value;
    fetch('http://localhost:8080/user/'.concat(userName))
        // fetch('http://localhost:8080/user/billhoang11')
        .then(response => response.json())
        .then(json => {
            console.log(json)
            if (json.message == "Access Denied") {
                sessionStorage.clear();
                alert("There are no accounts with this username. Please try again.");
                // window.location = 'Login.html';
            } else {
                var userId = json.id
                createFirstCart(userId);
            }
        })
        .catch(err => {
            console.log(err)
        })
}

function createFirstCart(userId) {

    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth() + 1;
    var yyyy = today.getFullYear();
    if (dd < 10) {
        dd = '0' + dd;
    }

    if (mm < 10) {
        mm = '0' + mm;
    }
    today = yyyy + '-' + mm + '-' + dd;

    fetch('http://localhost:8080/cart', {
        method: 'POST',
        headers: {
            'content-type': 'application/json',
        },
        body: JSON.stringify(
            {
                "date": today,
                "user": {
                    "id": userId
                }
            }
        )
    })
        // .then(response => response.json())
        // .then(data => {
        //     console.log('Success:', data);
        //     window.location = 'Login.html';
        //     // alert(data.message);
        //     // if (data.message === "Account successfully created. Please check your email to verify and activate your account.") {
        //     //     loadUser(userName);
        //     //     window.location = 'Login.html';
        //     // }
        // })
        .then(window.location = 'Login.html')
        .catch(err => {
            console.log(err)
        })
}
