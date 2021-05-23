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
        alert("You are already logged in.");
        window.location = '/Home/HomeFinal.html';
    }
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
                alert("Username or Password incorrect. Please try again.");
                // window.location = 'login1.html';
            } else {
                alert(data.message);
                // document.cookie = "username=".concat(userName);
                // console.log(document.cookie);
                // window.location = 'user.html';
                sessionStorage.setItem('currentlyLoggedIn', '1');
                sessionStorage.setItem('currentUsername', userName);
            }
        })

    .catch(err => {
        alert("Username or Password incorrect. Please try again.");
        console.log(err);

    })
}