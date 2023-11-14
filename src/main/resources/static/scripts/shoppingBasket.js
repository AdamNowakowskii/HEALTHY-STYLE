const productQuantities = document.querySelectorAll('.product-quantity');
const productPrices = document.querySelectorAll('.product-price');
const productTotals = document.querySelectorAll('.product-total');
const cartTotal = document.querySelector('.cart-total');

function updateTotals() {
    let total = 0;
    for (let i = 0; i < productQuantities.length; i++) {
        const quantity = parseInt(productQuantities[i].value);
        const price = parseFloat(productPrices[i].textContent.replace('$', ''));
        const totalProductPrice = quantity * price;
        productTotals[i].textContent = `$${totalProductPrice.toFixed(2)}`;
        total += totalProductPrice;
    }
    cartTotal.textContent = `$${total.toFixed(2)}`;
}

function changeQuantity(button, change) {
    const input = button.parentElement.querySelector('.product-quantity');
    let newQuantity = parseInt(input.value) + change;
    if (newQuantity < 1) {
        newQuantity = 1;
    }
    input.value = newQuantity;
    updateTotals();
}

productQuantities.forEach(input => {
    input.addEventListener('input', updateTotals);
});

updateTotals();