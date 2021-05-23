$(document).ready(function() {
    update_amounts();
    $('.qty, .price').on('keyup keypress blur change',
        function(e) {
            update_amounts();
        });
});

function update_amounts() {
    var sum = 0.0;
    $('#Table > tbody > tr').each(function() {
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
var incrementQty = plusBtn.click(function() {
    var $n = $(this)
        .parent(".button-container")
        .find(".qty");
    $n.val(Number($n.val()) + 1);
    update_amounts();
});

var decrementQty = minusBtn.click(function() {
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
    button.addEventListener("click", function() {
        var button_remove = event.target
        button_remove.parentElement.parentElement.remove()
        updatecart()
    })
}