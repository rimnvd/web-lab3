//digit validation
function isNumeric(n) {
    return !isNaN(parseFloat(n)) && isFinite(n);
}

function isInRange(n, min, max) {
    return parseFloat(n) > parseFloat(min) && parseFloat(n) < parseFloat(max);
}

function checkX() {
    return true;
}

function checkY() {
    try {
        let y = parseFloat(document.querySelector(".form-coordinate-y__input").value.replace(",", "."));
        document.querySelector(".form-coordinate-y__input").value = y;
        return isNumeric(y) ? isInRange(y, -3, 3) : false;
    } catch (err) {
        return false;
    }
}

function checkR() {
    return true;
}

// form validation
function checkData() {
    let bool = checkX() && checkY() && checkR();
    if (!bool) {
        alert("Entered data is invalid.");
    }
    return bool;
}
