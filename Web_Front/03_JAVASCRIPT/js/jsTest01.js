function answer01() {

    var text = document.getElementById("q01_num").value;
    console.log(typeof(text));
    if(!isNaN(text)) {
        alert('숫자입니다.');
    } else {
        alert('숫자가 아닙니다.');
    }
}

function answer02() {
    var ar1 = '홍길동';
    var ar2 = '이순신';
    var ar3 = '김선달';
    var ar4 = '유재석';
    var ar5 = '강호동';
    var nameList = ar1.concat(ar2,ar3,ar4,ar5);

    var text = document.getElementById("2").value
    var index = nameList.indexOf(text);

    if(index >= 0) {
        alert("이름이 있습니다.");
    } else {
        alert("이름이 없습니다.");
    }
}

function answer03() {
    if(document.getElementsByName("rdo")[0].checked == true) {
        window.open("http://www.naver.com");
    } else if(document.getElementsByName("rdo")[1].checked == true) {
        window.open("http://www.google.com");
    } else {
        window.open("http://www.w3schools.com");
    }
}

function answer04(element) {

    if(element == true) {
        (document.getElementsByName("subject"))[0].checked = true;
        (document.getElementsByName("subject"))[1].checked = true;
        (document.getElementsByName("subject"))[2].checked = true;
    } else {
        (document.getElementsByName("subject"))[0].checked = false;
        (document.getElementsByName("subject"))[1].checked = false;
        (document.getElementsByName("subject"))[2].checked = false;
    }
}

function answer05() {
    var random = Math.floor((Math.random() * 20 + 1));

    document.getElementById("randomInput").value = random;
}

function answer06() {
    if(document.getElementById("locationSelect")[1].selected == true){
        window.open("http://www.naver.com");
    } else if(document.getElementById("locationSelect")[2].selected == true) {
        location.href = "http://www.google.com";
    } else if(document.getElementById("locationSelect")[3].selected == true) {
        window.open("http://www.w3scools.com");
    }
    
}

function answer07() {
    var num = document.getElementById("numVal").innerHTML.split(",");

    alert(num.sort(function(left,right){
                        return left - right;
                    }));
}

function answer08() {
    var start = document.getElementById("startDate").valueAsDate
    var now = new Date();

    var interval = now.getTime() - start.getTime();
    interval = Math.floor(interval/(1000 * 60 * 60 * 24));

    alert(interval);
}

function answer09() {
    var name = document.getElementsByName("name")[0].value;
    var age = document.getElementsByName("age")[0].value;
    var gender = document.getElementsByName("gender")[0].value;

    document.getElementById("createTable").innerHTML += "<tr><th>" + name + "</th><th>" + age + "</th><th>" + gender + "</th></tr>";
}

function answer10() {
    var dan = document.getElementById("gugudan").value;

    var result = "";

    for(var i = 1; i < 10; i++) {

        result += dan + "*" + i + " = " + (dan*i) + "\n";

    }

    alert(result);
}