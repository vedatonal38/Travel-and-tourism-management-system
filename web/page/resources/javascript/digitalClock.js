$(document).ready(function() {
    var d = new Date();
    var dayStr= "0";
    var day = d.getDate();
    if(day < 10){
        dayStr += day;
    }else{
        dayStr = day;
    }
    $("#start").attr({
        "min": d.getFullYear() + "-" + (d.getMonth() + 1) + "-" + dayStr,
        "value": d.getFullYear() + "-" + (d.getMonth() + 1) + "-" + dayStr
    });
    dayStr= "0";
    if((day + 3) < 10){
        day +=3;
        dayStr += day;
    }else{
        dayStr = day+3;
    }
    $("#stop").attr({
        "min": d.getFullYear() + "-" + (d.getMonth() + 1) + "-" + dayStr,
        "value": d.getFullYear() + "-" + (d.getMonth() + 1) + "-" + dayStr
    });
    dayStr= "0";
    if((day + 1)< 10){
        day +=1 ;
        dayStr += day;
    }else{
        dayStr = day+1;
    }
    $("#stop1").attr({
        "min": d.getFullYear() + "-" + (d.getMonth() + 1) + "-" + dayStr,
        "value": d.getFullYear() + "-" + (d.getMonth() + 1) + "-" + dayStr
    });
});

function convertMiliseconds(miliseconds, format) {
    var days, hours, minutes, seconds, total_hours, total_minutes, total_seconds;

    total_seconds = parseInt(Math.floor(miliseconds / 1000));
    total_minutes = parseInt(Math.floor(total_seconds / 60));
    total_hours = parseInt(Math.floor(total_minutes / 60));
    days = parseInt(Math.floor(total_hours / 24));

    seconds = parseInt(total_seconds % 60);
    minutes = parseInt(total_minutes % 60);
    hours = parseInt(total_hours % 24);

    switch (format) {
        case 's':
            return total_seconds;
        case 'm':
            return total_minutes;
        case 'h':
            return total_hours;
        case 'd':
            return days;
        default:
            return {d: days, h: hours, m: minutes, s: seconds};
    }
}
;

function Time() {
    // Creating object of the Date class
    var date = new Date();
    // Get current hour
    var hour = date.getHours();
    // Get current minute
    var minute = date.getMinutes();
    // if they are less than 10
    minute = update(minute);

    document.getElementById("digital-clock").innerText = hour + " : " + minute;

    setTimeout(Time, 1000);
}

function MonthAndDay() {
    var days = ["Pazar", "Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma", "Cumartesi"]
    var date = new Date();
    var month = date.toLocaleString('tr-TR', {month: 'long'});
    var monthNum = date.getDate();
    var day = days[date.getDay()];
    // monthAndDay
    document.getElementById("monthAndDay").innerText = day + ", " + month + " " + monthNum;
}

function update(t) {
    if (t < 10) {
        return "0" + t;
    }
    else {
        return t;
    }
}
Time();
MonthAndDay();

