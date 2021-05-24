function openSearch() {
    document.getElementById("myOverlay").style.display = "block";
}

function closeSearch() {
    document.getElementById("myOverlay").style.display = "none";
}
// Modal
var modal = document.getElementById("myModal");
var btn = document.getElementById("cart");
var close = document.getElementsByClassName("close")[0];


var close_footer = document.getElementsByClassName("close-footer")[0];
var order = document.getElementsByClassName("order")[0];
btn.onclick = function () {
    // modal.style.display = "block";
    checkIfLoggedInForCart();
}
close.onclick = function () {
    modal.style.display = "none";
}
close_footer.onclick = function () {
    modal.style.display = "none";
}

window.onclick = function (event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
// delete cart
var remove_cart = document.getElementsByClassName("btn-danger");
for (var i = 0; i < remove_cart.length; i++) {
    var button = remove_cart[i]
    button.addEventListener("click", function () {
        var button_remove = event.target
        button_remove.parentElement.parentElement.remove()
        updatecart()
    })
}
// change quantity 
var quantity_input = document.getElementsByClassName("cart-quantity-input");
for (var i = 0; i < quantity_input.length; i++) {
    var input = quantity_input[i];
    input.addEventListener("change", function (event) {
        var input = event.target
        if (isNaN(input.value) || input.value <= 0) {
            input.value = 1;
        }
        updatecart()
    })
}

// add product to cart
var add_cart = document.getElementsByClassName("btn-cart");
for (var i = 0; i < add_cart.length; i++) {
    var add = add_cart[i];
    add.addEventListener("click", function (event) {

        var button = event.target;
        var product = button.parentElement.parentElement;
        var img = product.parentElement.getElementsByClassName("img-responsive")[0].src
        var title = product.getElementsByClassName("content-product-h3")[0].innerText
        var price = product.getElementsByClassName("price")[0].innerText
        addItemToCart(title, price, img)
        // when adding product to the the cart, it will show modal
        modal.style.display = "block";

        updatecart()
    })
}

function addItemToCart(title, price, img) {
    var cartRow = document.createElement('div')
    cartRow.classList.add('cart-row')
    var cartItems = document.getElementsByClassName('cart-items')[0]
    var cart_title = cartItems.getElementsByClassName('cart-item-title')
    for (var i = 0; i < cart_title.length; i++) {
        if (cart_title[i].innerText == title) {
            alert('This product is alrady in cart')
            return
        }
    }

    var cartRowContents = `
<div class="cart-item cart-column">
  <img class="cart-item-image" src="${img}" width="150" height="110">
  <span class="cart-item-title">${title}</span>
</div>
<span class="cart-price cart-column">${price}</span>
<div class="cart-quantity cart-column">
  <input class="cart-quantity-input" type="number" value="1">
  <button class="btn btn-danger" type="button">Remove</button>
</div>`
    cartRow.innerHTML = cartRowContents
    cartItems.append(cartRow)
    cartRow.getElementsByClassName('btn-danger')[0].addEventListener('click', function () {
        var button_remove = event.target
        button_remove.parentElement.parentElement.remove()
        updatecart()
    })
    cartRow.getElementsByClassName('cart-quantity-input')[0].addEventListener('change', function (event) {
        var input = event.target
        if (isNaN(input.value) || input.value <= 0) {
            input.value = 1;
        }
        updatecart()
    })
}
// update cart 
function updatecart() {
    var cart_item = document.getElementsByClassName("cart-items")[0];
    var cart_rows = cart_item.getElementsByClassName("cart-row");
    var total = 0;
    for (var i = 0; i < cart_rows.length; i++) {
        var cart_row = cart_rows[i]
        var price_item = cart_row.getElementsByClassName("cart-price ")[0]
        var quantity_item = cart_row.getElementsByClassName("cart-quantity-input")[0]
        var price = parseFloat(price_item.innerText)
        var quantity = quantity_item.value
        total = total + (price * quantity)
    }
    document.getElementsByClassName("cart-total-price")[0].innerText = total + 'USD'
}

// menu mobile
var btn_menu = document.getElementById("btnmenu");
btn_menu.addEventListener("click", function () {
    var item_menu = document.getElementById("menutop");
    if (item_menu.style.display === "block") {
        item_menu.style.display = "none";
    } else {
        item_menu.style.display = "block";
    }
})

function getProducts(productType) {

    var requestURL = new URL('http://localhost:8080/product/search?keyword='.concat(productType));

    fetch('http://localhost:8080/product/search?keyword='.concat(productType))
        // fetch('https://reqres.in/api/users')
        // fetch('http://localhost:8080/user/billhoang11')
        .then(response => response.json())
        .then(json => {
            console.log(json)

            for (let i = 0; i < json.length; i++) {

                var productName = json[i].productName
                var description = json[i].description
                var brand = json[i].brand
                var imgURL = json[i].imgURL

                var price = json[i].price.toString()
                for (let j = price.length; j >= 0; j -= 3) {
                    if (j !== price.length) {
                        price = price.substring(0, j) + "." + price.substring(j, price.length);
                        console.log(j)
                    }
                }

                document.querySelector(".row").innerHTML += `
                    <div class="col-sm-6 col-md-4">
                        <div class="thumbnail">
                            <h4 class="text-center">
                                <span class="label label-info">${brand}</span>
                            </h4>
                            <img src="${imgURL}" class="img-responsive" />
                            <div class="caption">
                                <div class="row" style="display: flex; align-items: center;justify-content: center;">
                                    <div class="col-md-6 col-xs-6" style="font-size: 30px; color:#4682B4; font-weight: bold;">
                                        <h3 class="content-product-h3">${productName}</h3>
                                    </div>
                                    <div class="col-md-6 col-xs-6 price">
                                        <div class="price" style="font-size: 20px; color: #FF4500; font-weight: bold;">
                                            <span class="money">${price}₫</span>
                                        </div>
                                    </div>
                                </div>
                                <p class="content-pr">${description}</p>
                                <div class="row" style="display: flex; align-items: center;justify-content: center;">
                                    <button onclick="checkIfLoggedInForCart()" type="button" class="btn btn-cart "><span class="glyphicon glyphicon-shopping-cart"></span>Add to cart</button>
                                </div>

                                <p></p>
                            </div>
                        </div>
                    </div>
                `

                // if (i%3 === 0) {
                //     document.querySelector(".container").innerHTML += '<div class="row"></div>'
                // } else {
                //     document.querySelector(".row").innerHTML += '<div class="col-sm-6 col-md-4"></div>'

                // }
                // document.write(name)
            }


            // userID = json.id

            // var firstName = json.firstName
            // document.getElementById("firstName").value = firstName;

            // var lastName = json.lastName
            // document.getElementById("lastName").value = lastName;

            // var userName = json.userName
            // document.getElementById("userName").value = userName;

            // var email = json.email
            // document.getElementById("email").value = email;

            // var password = json.password
            // document.getElementById("password").value = password;

            // var address = json.address
            // document.getElementById("address").value = address;

            // var phoneNumber = json.phoneNumber
            // document.getElementById("phoneNumber").value = phoneNumber;



        })
}

function checkIfLoggedInForUser() {
    if (sessionStorage.getItem("currentlyLoggedIn") === "1") {
        window.location = '/HTML/Userprofile.html';
    } else {
        window.location = '/HTML/Login.html';
    }
}

function checkIfLoggedInForCart() {
    if (sessionStorage.getItem("currentlyLoggedIn") === "1") {
        window.location = '/HTML/FinalCart.html';

    } else {
        alert("You are not signed in. Please sign in first.")
        window.location = '/HTML/Login.html';
    }
}