function Search() {
    var input = document.getElementById("input");
    var title = input.value;
    if (title != "") {
        window.location.href = "search.do?title=" + title;
    } else {
        alert("请输入搜索内容");
    }
}

window.onload = function () {
    document.onkeydown = function (event) {
        if (event.keyCode == 13) {
            Search();
        }
    }
}