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
$(document).ready(function () {
    update_amounts();
    $('.qty, .price').on('keyup keypress blur change',
        function (e) {
            update_amounts();
        });
});

function update_amounts() {
    var sum = 0.0;
    $('#Table > tbody > tr').each(function () {
        var qty = $(this).find('.qty').val();
        var price = $(this).find('.price').val();
        var amount = (qty * price)
        sum += amount;
        $(this).find('.amount').text('' + amount);
    });
    $('.total').text(sum);
}

var incrementQty;
var decrementQty;
var plusBtn = $(".cart-qty-plus");
var minusBtn = $(".cart-qty-minus");
var incrementQty = plusBtn.click(function () {
    var $n = $(this)
        .parent(".button-container")
        .find(".qty");
    $n.val(Number($n.val()) + 1);
    update_amounts();
});

var decrementQty = minusBtn.click(function () {
    var $n = $(this)
        .parent(".button-container")
        .find(".qty");
    var QtyVal = Number($n.val());
    if (QtyVal > 0) {
        $n.val(QtyVal - 1);
    }
    update_amounts();
})

var remove_cart = document.getElementsByClassName("btn-danger");
for (var i = 0; i < remove_cart.length; i++) {
    var button = remove_cart[i]
    button.addEventListener("click", function () {
        var button_remove = event.target
        button_remove.parentElement.parentElement.remove()
        updatecart()
    })
}

function checkIfLoggedIn() {
    if (sessionStorage.getItem("currentlyLoggedIn") === "1") {
        // window.location = '/HTML/Userprofile.html';
        // loadCartItem(sessionStorage.getItem("currentCartId"));
        loadEntireCart();
    } else {
        alert("You are not signed in. Please sign in first.")
        window.location = '/HTML/Login.html';
    }
}

function loadEntireCart() {
    fetch('http://localhost:8080/cartItem/'.concat(sessionStorage.getItem("currentCartId")))
        .then(response => response.json())
        .then(json => {
            // console.log(json.length)
            if (json.length === 0) {
                alert("Your cart is empty.");
                window.location = "Home.html";
            } else {
                for (let i = 0; i < json.length; i++) {

                    var productIdElement = json[i].product.productId;

                    populateCartTable(productIdElement);
                }
            }
        })
}

function populateCartTable(productId) {
    fetch('http://localhost:8080/product/id/'.concat(productId))
        .then(response => response.json())
        .then(json => {
            console.log(json)
            var productId = json.productId
            var productName = json.productName
            var description = json.description
            var brand = json.brand
            var imgURL = json.imgURL

            var priceRaw = json.price
            var price = priceRaw.toString()
            for (let j = price.length; j > 0; j -= 3) {
                if (j !== price.length) {
                    price = price.substring(0, j) + "." + price.substring(j, price.length);
                    // console.log(j)
                }
            }
            var priceFormatted = price + "₫"

            document.querySelector("#tableBody").innerHTML += `
    <tr>
        <td>
            <div class="product-img">
                <div class="img-product">
                    <img src="${imgURL}" class="w-50">
                </div>
            </div>
        </td>
        <td>
            <p>${productName}</p>
        </td>
        <td>
            <div class="button-container">
                <input id="quantity" onchange="calculateTotal(${priceRaw})" type="number" name="quantity" min="0" class="qty form-control" value="1" />
            </div>
        </td>
        <td>
            <input type="text" value="${priceFormatted}" class="price form-control" disabled>
        </td>
        <td onload="calculateTotal(${priceRaw})" name="productTotal" id="productTotal" align="right">${priceFormatted}</td>
        <td><button onclick="removeFromCart(${sessionStorage.getItem(`currentCartId`)},${productId})" class="btn btn-danger" type="button">Remove</button></td>
    </tr>
    `
        })
}

function removeFromCart(cid, pid) {
    var requestURL = 'http://localhost:8080/cartItem/remove/' + cid + '/' + pid
    // console.log(requestURL)
    fetch(requestURL, {
        method: 'POST'
    })
        .then(window.location.reload())
        // .then(document.querySelector("#tableBody").innerHTML = "")
        // .then(loadEntireCart())
        .catch(err => {
            console.log(err)
        })
}

// // change quantity 
// var quantity_input = document.getElementsByClassName("qty form-control");
// console.log(quantity_input)
// for (var i = 0; i < quantity_input.length; i++) {
//     var input = quantity_input[i];
//     input.addEventListener("change", function (event) {
//         var input = event.target
//         if (isNaN(input.value) || input.value <= 0) {
//             input.value = 1;
//         }
//         calculateTotal()
//     })
// }

function calculateTotal(priceRaw) {
    var quantity = document.querySelector("#quantity").value;
    productTotal = quantity*priceRaw
    productTotal = productTotal.toString()

    for (let x = productTotal.length; x > 0; x -= 3) {
        if (x !== productTotal.length) {
            productTotal = productTotal.substring(0, x) + "." + productTotal.substring(x, productTotal.length);
            // console.log(j)
        }
    }
    var productTotalFormatted = productTotal + "₫"
    document.querySelector("#productTotal").innerHTML = productTotal+"₫"
    // console.log(quantity)
}
