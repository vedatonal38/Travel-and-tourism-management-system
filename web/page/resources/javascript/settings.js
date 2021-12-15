// Get the modal
var modal = document.getElementById("myModal");
var j1 = document.getElementById("j1");
var j2 = document.getElementById("j2");
var j3 = document.getElementById("j3");
var j4 = document.getElementById("j4");
var pp = document.getElementById("pp");

// Get the button that opens the modal
var btn = document.getElementById("myBtn");
var btn_val = btn.value;

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal 
btn.onclick = function() {
    modal.style.display = "block";
    var adds = document.getElementById("adds");
    var dels = document.getElementById("dels");
    var dips1 = document.getElementById("dips1");
    var dips2 = document.getElementById("dips2");

    if (btn_val === "cars") {
        pp.innerHTML = "ARAÇ KİRALAMA EKLEME / KALDIRMA";
        j1.style.display = "block";
        adds.onclick = function() {
            dips1.style.display = "block";
            dips2.style.display = "none";
        }
        dels.onclick = function() {
            dips2.style.display = "block";
            dips1.style.display = "none";
        }
    }
    if (btn_val === "buses") {
        pp.innerHTML = "OTOBÜS SEFER EKLEME / KALDIRMA";
        j2.style.display = "block";
        adds.onclick = function() {
            dips1.style.display = "block";
            dips2.style.display = "none";
        }
        dels.onclick = function() {
            dips2.style.display = "block";
            dips1.style.display = "none";
        }
    }

    if (btn_val === "hotels") {
        pp.innerHTML = "OTEL EKLEME / KALDIRMA";
        j3.style.display = "block";
        adds.onclick = function() {
            dips1.style.display = "block";
            dips2.style.display = "none";
        }
        dels.onclick = function() {
            dips2.style.display = "block";
            dips1.style.display = "none";
        }
    }
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

//-----------------------------------------------------------------
$(document).ready(function() {
    $('#country').on('change', function() {
        var id = this.value;
        $.ajax({
            url: "CountryCity",
            type: "POST",
            data: {
                id: id
            },
            cache: false,
            success: function(result) {
                $('#city').html(result);
            }
        });
    });
    $('#from_country').on('change', function() {
        var id = this.value;
        $.ajax({
            url: "CountryCity",
            type: "POST",
            data: {
                id: id
            },
            cache: false,
            success: function(result) {
                $('#from_city').html(result);
            }
        });
    });
    $('#to_country').on('change', function() {
        var id = this.value;
        $.ajax({
            url: "CountryCity",
            type: "POST",
            data: {
                id: id
            },
            cache: false,
            success: function(result) {
                $('#to_city').html(result);
            }
        });
    });
    $('#hotel_country').on('change', function() {
        var id = this.value;
        $.ajax({
            url: "CountryCity",
            type: "POST",
            data: {
                id: id
            },
            cache: false,
            success: function(result) {
                $('#hotel_city').html(result);
            }
        });
    });
});

