$(document).ready(function() {
    $("input[type=radio][name='gender-282-0']").change(function() {
        var val = $(this).val();
        var selects = document.querySelectorAll(".selected");
        for (sl = 0; sl < selects.length; sl++) {
            var s = selects[sl];
            if (val === "1") { // bayan
                // https://biletall-cdn.mncdn.com/img-v7/ortak/female_selected.svg
                s.childNodes[1].src = "https://biletall-cdn.mncdn.com/img-v7/ortak/female_selected.svg";
            } else if (val === "2") { // bay
                // https://biletall-cdn.mncdn.com/img-v7/ortak/male_selected.svg
                s.childNodes[1].src = "https://biletall-cdn.mncdn.com/img-v7/ortak/male_selected.svg";
            }
        }
        var list_seat = document.querySelectorAll(".gird-seat-list");
        for (ch = 0; ch < list_seat.length; ch++) {
            var child = list_seat[ch];
            if (child.childElementCount !== 0) {
                var imgTag = child.childNodes[0];
                var iTag = child.childNodes[1].childNodes[1];
                if (val === "1") { // bayan
                    // https://biletall-cdn.mncdn.com/img-v7/ortak/female_selected.svg
                    imgTag.src = "https://biletall-cdn.mncdn.com/img-v7/ortak/female_selected.svg";
                    iTag.innerHTML = "Kadın";
                } else if (val === "2") { // bay
                    // https://biletall-cdn.mncdn.com/img-v7/ortak/male_selected.svg
                    imgTag.src = "https://biletall-cdn.mncdn.com/img-v7/ortak/male_selected.svg";
                    iTag.innerHTML = "Erkek";
                }
            }
        }
    });
});

function kontrolluKoltukSec(object, koltuk_id) {
    var bool = false, val = 0;

    var gender = document.getElementsByName("gender-282-0");
    for (i = 0; i < gender.length; i++) {
        if (gender[i].checked) {
            bool = true;
            val = gender[i].value;
        }
    }
    var seat_selected = true;
    if (object.classList.contains("selected")) {
        seat_selected = false;
    }

    var selects = document.querySelectorAll(".selected");

    if (bool & selects.length < 5 & seat_selected) {// en fazla 5 koltuk
        object.className += " selected";
        if (val === "1") { // bayan
            // https://biletall-cdn.mncdn.com/img-v7/ortak/female_selected.svg
            object.childNodes[1].src = "https://biletall-cdn.mncdn.com/img-v7/ortak/female_selected.svg";
        } else if (val === "2") { // bay
            // https://biletall-cdn.mncdn.com/img-v7/ortak/male_selected.svg
            object.childNodes[1].src = "https://biletall-cdn.mncdn.com/img-v7/ortak/male_selected.svg";
        }

        var selectMsg = document.getElementsByClassName("not-select-msg")[0];
        var selectSeat = document.getElementsByClassName("selected-seat")[0];
        selectMsg.style.display = "none";
        selectSeat.style.display = "";

        var list_seat = document.querySelectorAll(".gird-seat-list");

        for (ch = 0; ch < list_seat.length; ch++) {
            var child = list_seat[ch];
            if (child.childElementCount === 0) {
                var imgTag = document.createElement("img");
                var spanTag = document.createElement("span");
                var strongTag = document.createElement("strong");
                var iTag = document.createElement("i");
                if (val === "1") { // bayan
                    // https://biletall-cdn.mncdn.com/img-v7/ortak/female_selected.svg
                    imgTag.src = "https://biletall-cdn.mncdn.com/img-v7/ortak/female_selected.svg";
                    strongTag.innerHTML = koltuk_id;
                    iTag.innerHTML = "Kadın";
                } else if (val === "2") { // bay
                    // https://biletall-cdn.mncdn.com/img-v7/ortak/male_selected.svg
                    imgTag.src = "https://biletall-cdn.mncdn.com/img-v7/ortak/male_selected.svg";
                    strongTag.innerHTML = koltuk_id;
                    iTag.innerHTML = "Erkek";
                }
                child.appendChild(imgTag);
                spanTag.appendChild(strongTag);
                spanTag.appendChild(iTag);
                child.appendChild(spanTag);
                sort(list_seat)
                break;
            }
        }
        //
        var price = object.getAttribute("koltukfiyat");
        price = parseInt(price);

        var pr = document.getElementById("totalPrice");
        var price_ = parseInt(pr.childNodes[0].textContent);
        price_ += price;

        pr.childNodes[0].textContent = price_;

        var aIleri = document.getElementById("ileri2");
        var classList = aIleri.classList;
        for (c = 0; c < classList.length; c++) {
            var item = classList[c];
            if (item === "grey") {
                aIleri.classList.remove("grey");
                aIleri.setAttribute("value", "1");
            }
        }

    } // if -1

    if (!seat_selected) { //
        object.classList.remove("selected");
        // koltuklu boşat
        object.childNodes[1].src = "https://biletall-cdn.mncdn.com/img-v7/ortak/ikonlar/bos_koltuk.svg";

        var select = document.querySelectorAll(".selected");

        var object_seat_no = object.childNodes[0].textContent;
        var list_seat = document.querySelectorAll(".gird-seat-list");
        for (ch = 0; ch < list_seat.length; ch++) {
            var child = list_seat[ch];
            if (child.childElementCount !== 0) {
                var sel = child.childNodes[1].childNodes[0];
                if (object_seat_no === sel.textContent) {
                    removeAllChildNodes(child);
                    sort(list_seat);
                }
            }
        }
        var selectMsg = document.getElementsByClassName("not-select-msg")[0];
        var selectSeat = document.getElementsByClassName("selected-seat")[0];

        // mesaj temizle
        if (select.length === 0) {
            selectMsg.style.display = "";
            selectSeat.style.display = "none";
        } else {
            selectMsg.style.display = "none";
            selectSeat.style.display = "";
        }


        var price = object.getAttribute("koltukfiyat");
        price = parseInt(price);

        var pr = document.getElementById("totalPrice");
        var price_ = parseInt(pr.childNodes[0].textContent);
        price_ -= price;

        pr.childNodes[0].textContent = price_;

        var aIleri = document.getElementById("ileri2");

        if (price_ === 0) {
            aIleri.className += " grey";
            aIleri.setAttribute("value", "0");
        }

    }// if -2
}

function removeAllChildNodes(parent) {
    while (parent.firstChild) {
        parent.removeChild(parent.firstChild);
    }
}

function createChildNodes(person, delPerson) {
    var imgTag = document.createElement("img");
    var spanTag = document.createElement("span");
    var strongTag = document.createElement("strong");
    var iTag = document.createElement("i");

    var delP = delPerson.childNodes; // 0-> no 1-> gender
    imgTag.src = delP[0].src;
    strongTag.innerHTML = delP[1].childNodes[0].textContent;// No
    iTag.innerHTML = delP[1].childNodes[1].textContent;// gender

    person.appendChild(imgTag);
    spanTag.appendChild(strongTag);
    spanTag.appendChild(iTag);
    person.appendChild(spanTag)
}

//if (child.childElementCount !== 0) {
//var sel = child.childNodes[1].childNodes[0];

function sort(list_seat) {
    for (v = 0; v < list_seat.length; v++) {
        var index = v;
        for (j = v + 1; j < list_seat.length; j++) {
            var p0 = list_seat[index];
            var p1 = list_seat[j];
            if (p0.childNodes[1] === undefined & p1.childNodes[1] !== undefined) {
                createChildNodes(p0, p1);
                removeAllChildNodes(p1)
            }
            if (p1.childNodes[1] !== undefined) {
//console.log(p0.childNodes[1].childNodes[0].textContent)
                var iP = parseInt(p0.childNodes[1].childNodes[0].textContent)
                var i0P = parseInt(p1.childNodes[1].childNodes[0].textContent)
                if (iP > i0P) {
                    var temp = p0.childNodes[1].childNodes[0].innerHTML;
                    p0.childNodes[1].childNodes[0].innerHTML = p1.childNodes[1].childNodes[0].innerHTML;
                    p1.childNodes[1].childNodes[0].innerHTML = temp;
                }
            }

        }
    }
}