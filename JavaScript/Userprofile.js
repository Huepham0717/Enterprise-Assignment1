function openSearch() {
    document.getElementById("myOverlay").style.display = "block";
}

function closeSearch() {
    document.getElementById("myOverlay").style.display = "none";
}

function checkIfLoggedIn() {
    if (sessionStorage.getItem("currentlyLoggedIn") !== "1") {
        alert("You are not signed in. Please sign in first.");
        window.location = '/HTML/Login.html';
    } else {
        loadUser(sessionStorage.getItem("currentUsername"))
    }
}

function loadUser(userName) {
    fetch('http://localhost:8080/user/'.concat(userName))
        // fetch('http://localhost:8080/user/billhoang11')
        .then(response => response.json())
        .then(json => {
            console.log(json)
            if (json.message == "Access Denied") {
                sessionStorage.clear();
                alert("An error has occured. Please sign in again.");
                window.location = 'Login.html';
            } else {
                userId = json.id

                sessionStorage.setItem("currentUserId", userId)

                var firstName = json.firstName
                document.getElementById("firstName").value = firstName;

                var lastName = json.lastName
                document.getElementById("lastName").value = lastName;

                var userName = json.userName
                document.getElementById("userName").value = userName;

                var birthDay = json.birthDay
                document.getElementById("birthDay").value = birthDay;
                console.log(birthDay)
                console.log(typeof birthDay)

                var email = json.email
                document.getElementById("email").value = email;

                var phoneNumber = json.phoneNumber
                document.getElementById("phoneNumber").value = phoneNumber;

                // var password = json.password
                // document.getElementById("password").value = password;

                var address = json.address
                document.getElementById("address").value = address;
            }
        })
}

function sendRequest() {

    var firstName = document.getElementById("firstName").value;
    var lastName = document.getElementById("lastName").value;
    var userName = document.getElementById("userName").value;
    var password = document.getElementById("password").value;
    var passwordConfirm = document.getElementById("passwordConfirm").value;
    var birthDay = document.getElementById("birthDay").value;
    var phoneNumber = document.getElementById("phoneNumber").value;
    var address = document.getElementById("address").value;
    var email = document.getElementById("email").value;

    var requestURL = new URL("http://localhost:8080/user/".concat(sessionStorage.getItem("currentUserId")));

    requestURL.searchParams.append("firstName", firstName);
    requestURL.searchParams.append("lastName", lastName);
    requestURL.searchParams.append("userName", userName);
    requestURL.searchParams.append("password", password);
    requestURL.searchParams.append("phoneNumber", phoneNumber);
    requestURL.searchParams.append("address", address);
    requestURL.searchParams.append("email", email);
    requestURL.searchParams.append("birthDay", birthDay);

    if (password) {
        if (password === passwordConfirm) {
            fetch(requestURL, {
                method: 'PUT',
            })
                .then(response => response.json())
                .then(data => {
                    console.log('Success:', data);
                    // document.cookie = "username=".concat(userName);
                    sessionStorage.setItem('currentUsername', userName);
                    alert(data.message);
                    // console.log(requestURL)
                    window.location = 'Userprofile.html';

                })
                .catch(err => {
                    console.log(err);
                    console.log(requestURL)
                })
        }
        else {
            alert("Password Confirmation does not match Password. Please try again.");
        }
    } else {
        alert("Your password cannot be empty. Please try again.");
    }
}