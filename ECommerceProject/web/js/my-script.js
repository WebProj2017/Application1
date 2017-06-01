function isEmailValidate(email) {

    if (email.includes("@") === true) {
        var prefix = email.split("@")[1];

        return prefix.includes(".") === true ? true : false;
    }

    return false;
}

function takeQuantity(quantity, priceId) {
    var quantitys = document.getElementById(quantity).value;

    var myPrice = document.getElementById(priceId).value;
    var currentTotalCost = document.getElementById("total-cost-hidden").value;

    var qtityVSprice = quantitys * myPrice;
    var qtityVSpriceId = priceId.substring(0, priceId.length - 1);
    
    var myTotalCost = parseFloat(currentTotalCost) + parseFloat((qtityVSprice - myPrice));
    
    document.getElementById("total-cost-hidden").value = myTotalCost.toString();
    document.getElementById(qtityVSpriceId).innerHTML = qtityVSprice;
    document.getElementById("total-cost").innerHTML = myTotalCost;

}

function initMap() {
        var uluru = {lat: 10.87771, lng: 106.801687};
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 16,
          center: uluru
        });
        var marker = new google.maps.Marker({
          position: uluru,
          map: map
        });
      }