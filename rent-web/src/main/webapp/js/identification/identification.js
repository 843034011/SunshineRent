images = document.getElementsByClassName("img-head");
for (var i = 0; i < images.length; i++) {
    images[i].onclick = function (e) {
        var btn_info = document.getElementsByClassName("btn-default")
        btn_info[0].innerHTML = e.target.alt
        var headimage = document.getElementById("headimage")
        headimage.src = e.target.src
    }
}