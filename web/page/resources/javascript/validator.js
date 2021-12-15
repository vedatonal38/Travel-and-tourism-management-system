/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function validatorFormSubmit() {
    var msg = document.getElementById("msg");
    var name = document.getElementById("name").value;
    var surname = document.getElementById("surname").value;
    var email = document.getElementById("email").value;
    var username = document.getElementById("username").value;

    // pass validator
    var len = $("#length").attr("class"), cap = $("#capital").attr("class"),
            num = $("#number").attr("class"), let = $("#letter").attr("class")
    diff_ = $("#diff").attr("class");
    // email validator
    var e_ = document.getElementById("e_");
    
    if (name === "" | surname === "" | email === "" | username === "") {
        msg.innerHTML = "Yıldızı (*) yerleri dolurunuz!!";
        return;
    }

    if (len === "invalid" && cap === "invalid" && num === "invalid" && let === "invalid") {
        msg.innerHTML = "Şifrenizi yandaki kurallara göre oluşturunuz.";
        return;
    }
    if (e_ === "invalid") {
        msg.innerHTML = "Email yandaki kurallara göre oluşturunuz.";
        return;     
    }

    if (diff_ === "invalid") {
        msg.innerHTML = "Şifreniz uyuşmuyor.";
        return;
    }

    msg.innerHTML = "";

    document.submitForm.submit();
}


$(document).ready(function() {
    $("#password")
            .keyup(function() {
                var pswd = $(this).val();

                //validate the length
                if (pswd.length < 8) {
                    $("#length").removeClass("valid").addClass("invalid");
                } else {
                    $("#length").removeClass("invalid").addClass("valid");
                }

                //validate letter
                if (pswd.match(/[a-z]/)) {
                    $("#letter").removeClass("invalid").addClass("valid");
                } else {
                    $("#letter").removeClass("valid").addClass("invalid");
                }

                //validate capital letter
                if (pswd.match(/[A-Z]/)) {
                    $("#capital").removeClass("invalid").addClass("valid");
                } else {
                    $("#capital").removeClass("valid").addClass("invalid");
                }

                //validate number
                if (pswd.match(/\d/)) {
                    $("#number").removeClass("invalid").addClass("valid");
                } else {
                    $("#number").removeClass("valid").addClass("invalid");
                }

                //validate space
                if (pswd.match(/[^a-zA-Z0-9\-\/]/)) {
                    $("#space").removeClass("invalid").addClass("valid");
                } else {
                    $("#space").removeClass("valid").addClass("invalid");
                }

            })
            .focus(function() {
                $("#pswd_info").show();
            })
            .blur(function() {
                $("#pswd_info").hide();
            });

    // PASSWORD CONFİRM
    $("#confirm").keyup(function() {
        var pswd_confirm = $(this).val();
        var pswd = $("#password").val();
        if (pswd === pswd_confirm) {
            $("#diff").removeClass("invalid").addClass("valid");
        } else {
            $("#diff").removeClass("valid").addClass("invalid");
        }
    })
            .focus(function() {
                $("#pswd_diff").show();
            })
            .blur(function() {
                $("#pswd_diff").hide();
            });

    // EMAİL
    $("#email").keyup(function() {
        var email = $(this).val();
        if (isEmail(email)) {
            $("#e_").removeClass("invalid").addClass("valid");
        } else {
            $("#e_").removeClass("valid").addClass("invalid");
        }
    })
            .focus(function() {
                $("#email_").show();
            })
            .blur(function() {
                $("#email_").hide();
            });
});
function isEmail(email) {

    // Regular Expression (Accepts every special
    // character along with @ symbol)
    var regexp = /\S+@\S+\.\S+/;

    // Converting the email to lowercase
    return regexp.test(String(email).toLowerCase());
}
          