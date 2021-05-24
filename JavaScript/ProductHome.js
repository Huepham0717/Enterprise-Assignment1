

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
    checkIfLoggedInForCart();
}

close.onclick = function () {
    modal.style.display = "none";
}
close_footer.onclick = function () {
    modal.style.display = "none";
}
order.onclick = function () {
    alert("Thank you for your order")
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

function checkIfLoggedInForAddToCart() {
    if (sessionStorage.getItem("currentlyLoggedIn") === "1") {
        // window.location = '/HTML/FinalCart.html';
        // modal.style.display = "block";
        // ADD TO CARD HERE
        addToCart(sessionStorage.getItem("selectedProduct"))
    } else {
        alert("You are not signed in. Please sign in first.")
        window.location = '/HTML/Login.html';
    }
}

function addToCart(productId) {
    if (sessionStorage.getItem("currentlyLoggedIn") === "1") {
        if (sessionStorage.getItem("productsInCurrentCart")) {
            if ((sessionStorage.getItem("productsInCurrentCart")).includes(productId)) {
                alert("This product is already in your cart. You can click the cart button to change quantity.");
            } else {
                sessionStorage.setItem("productsInCurrentCart", sessionStorage.getItem("productsInCurrentCart") + ',' + productId);
            }
        } else {
            sessionStorage.setItem("productsInCurrentCart", productId);
        }

    } else {
        alert("You are not signed in. Please sign in first.")
        window.location = '/HTML/Login.html';
    }
}

function getProduct() {
    fetch('http://localhost:8080/product/id/'.concat(sessionStorage.getItem("selectedProduct")))
        .then(response => response.json())
        .then(json => {
            console.log(json)

                var productId = json.productId
                var productName = json.productName
                var description = json.description
                var brand = json.brand
                var imgURL = json.imgURL

                var price = json.price.toString()
                for (let j = price.length; j >= 0; j -= 3) {
                    if (j !== price.length) {
                        price = price.substring(0, j) + "." + price.substring(j, price.length);
                    }
                }

                document.querySelector("#imgURL").src = imgURL;
                document.querySelector("#productName").innerHTML = productName;
                document.querySelector("#description").innerHTML = description;
                document.querySelector("#priceFormatted").innerHTML = price + "₫";
        })
}

function addToCart(productId) {
    if (sessionStorage.getItem("currentlyLoggedIn") === "1") {
        if (sessionStorage.getItem("productsInCurrentCart")) {
            if ((sessionStorage.getItem("productsInCurrentCart")).includes(productId)) {
                alert("This product is already in your cart. You can click the cart button to change quantity.");
            } else {
                sessionStorage.setItem("productsInCurrentCart", sessionStorage.getItem("productsInCurrentCart") + ',' + productId);
            }
        } else {
            sessionStorage.setItem("productsInCurrentCart", productId);
        }

    } else {
        alert("You are not signed in. Please sign in first.")
        window.location = '/HTML/Login.html';
    }
}
