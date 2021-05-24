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
    if (sessionStorage.getItem("currentlyLoggedIn") == "1") {
        window.location = '/HTML/Userprofile.html';
    }
}

function loadUser() {
    var userName = document.getElementById("userName").value;
    fetch('http://localhost:8080/user/'.concat(userName))
        // fetch('http://localhost:8080/user/billhoang11')
        .then(response => response.json())
        .then(json => {
            console.log(json)
            if (json.message == "Access Denied") {
                sessionStorage.clear();
                alert("There are no accounts with this username. Please try again.");
            } else {
                sendRequest();
            }
        })
}

function sendRequest() {

    var userName = document.getElementById("userName").value;
    var passWord = document.getElementById("password").value;

    fetch('http://localhost:8080/login', {
        method: 'POST',
        headers: {
            'content-type': 'application/json',
        },
        body: JSON.stringify({
            userName: userName,
            password: passWord
        })
    })

        .then(response => response.json())
        .then(data => {
            console.log('Success:', data);
            if (data.message == "Access Denied") {
                alert("Password is incorrect. Please try again.");
            } else {
                sessionStorage.setItem('currentlyLoggedIn', '1');
                sessionStorage.setItem('currentUsername', userName);
                alert(data.message);
                window.location = '/HTML/Userprofile.html';
            }
        })

        .catch(err => {
            alert("Username or Password incorrect. Please try again.");
            console.log(err);

        })
}
