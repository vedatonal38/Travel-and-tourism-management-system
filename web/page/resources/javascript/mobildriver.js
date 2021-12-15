$(document).ready(function() {
    $('#odeme').click(function(e) {
        e.preventDefault();
        var msj = document.getElementById("errormsj");
        var cardnum = $("#cardnum").val();
        var show = $('.card-type-icon').attr("class").toString().split(" ");
        var monthYear = $(".expiry").val().split(" / ");
        var month = parseInt(monthYear[0]);
        var year = parseInt(monthYear[1]);
        var cvc = $("#cvc").val();
        var yr = parseInt(new Date().getFullYear().toString().substr(2, 3));

        if (show.length > 1) {
            if (cardnum.length > 0 & show[1].toString() === "show") {
                if (year > yr & cvc.length > 0) {
                    var code = Math.floor(Math.random() * 100000) + 900000;
                    $("#msjcode").text("Güvenlik kodunuz : "+code);
                    console.log("Mobil driver javascript file");
                    console.log(code);
                    $('div#card2').toggle('500');
                    $('div#card3').toggle('500');
                    
                } else {
                    msj.innerHTML = "Kutucuklar doğru şekilde dolurunuz.";
                }
            } else {
                msj.innerHTML = "Kart bilgileri HATALIDIR.";
            }
        } else {
            msj.innerHTML = "Kutucuklar doğru şekilde dolurunuz.";
        }

    });

    $("#cd3").click(function(e) {
        e.preventDefault();
        var dri = $("#driver");
        dri.animate({left:"-40px"});
    });
    
    
});

